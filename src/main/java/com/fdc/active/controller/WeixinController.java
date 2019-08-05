/*
package com.fdc.active.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.security.*;
import java.util.*;

*/
/**
 * Created by Administrator on 2018/6/25.
 *//*

@Controller
public class WeixinController {



    private static final Logger log = org.slf4j.LoggerFactory.getLogger(WeixinController.class);

    String appid = "";
    String secret = "";

    //测试公众号
    String appid2 = "wxb6121eb2459b7bfd" ;
    String secret2 ="544f65b9b73cfb588816b79991911853" ;
    String serverId = "gh_bf8fd3271369";

    String token = "b93907e698559668c543e60e953d0d3e" ;

    //亿房网公众号
    String appid3 = "wx9122daf18d97b738" ;
    String secret3 ="c1bdc290286a6373de7b4c1f149dbdbb" ;



    @ResponseBody
    @RequestMapping("activeboot.weixin.getuser")
    public String getOpenId(){
        try {
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                    + appid2 + "&secret=" + secret2;
            JSONObject obj = HttpHelper.httpGet(url);
            String tokenId = obj.getString("access_token");
            String url2 ="https://api.weixin.qq.com/cgi-bin/user/get?access_token="+tokenId+"&next_openid=";
            JSONObject obj2 = HttpHelper.httpGet(url2);
            log.info("obj2:{}" ,obj2.toString());
            JSONObject data = obj2.getJSONObject("data");
            JSONArray array = data.getJSONArray("openid");
            String url3 = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token="+tokenId;
            JSONObject param = new JSONObject();
            List<Map<String,String>> user_list = new ArrayList<>();
            array.stream().forEach(o -> {
                Map<String,String> map = new HashMap<>();
                map.put("openid" ,o.toString());
                map.put( "lang", "zh_CN");
                user_list.add(map);
            });
            param.put("user_list" ,user_list);
            String str = doPost5(url3 ,param);

            log.info(" {} " ,str);
            return str;
        }catch (Exception e){
            log.error("" ,e);
            return "error";
        }
    }


    @RequestMapping(value="/weixin/conn")
    public void weixinAuth2(HttpServletRequest request,HttpServletResponse response){
        try {
            if("GET".equals(request.getMethod().toUpperCase())){
                this.doGet(request, response);
            }
            if("POST".equals(request.getMethod().toUpperCase())){
                this.doPost(request, response);
            }

        }catch (Exception e){
            log.error("" ,e);
        }
    }

    public  void doPost(HttpServletRequest request,HttpServletResponse response){
        try {
            // 消息的接收、处理、响应
            // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            Map<String, String> param = parseXml(request);
            log.info("param：{}" ,param.toString());
            String msgType = param.get("MsgType");
            String event =  param.get("Event");
            String fromUserName =  param.get("FromUserName");//用户openid
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                    + appid2 + "&secret=" + secret2;
            JSONObject obj = HttpHelper.httpGet(url);
            String tokenId = obj.getString("access_token");
            String url2 = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+tokenId+"&openid="+fromUserName+"&lang=zh_CN";
            JSONObject obj2 = HttpHelper.httpGet(url2);
            log.info("obj2:{}", obj2.toString());

            //给用户发送客服消息
            String url4 = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+tokenId;
            JSONObject params = new JSONObject();
            params.put("touser" ,fromUserName) ;
            params.put("msgtype" ,"text") ;
            JSONObject params2 = new JSONObject();
            params2.put("content","这是一条客服消息");
            params.put("text" ,params2) ;
            String str = doPost5(url4,params);
            log.info("str:{}" ,str);
        }catch (Exception e){
            log.error("" ,e);
        }
    }



    //关键词回复
    public void listenKeyWordReply(String openid ,String token ,String content){
        String replyContent = null;
        if("买房".equals(content)){
            replyContent = "<a href='http://www.house.m.fdc.com.cn/fang' data-miniprogram-appid='"+appid2+"' " +
                    "data-miniprogram-path='pages/index/main'>" +
                    "买新房请直接点击进入小程序</a>\n" +
                    "   买二手房请直接点击进入二手房服务http://oldhouse.m.fdc.com.cn";
        }
        else if("卖房".equals(content)){
            replyContent = "您可以直接发布要出售的二手房。请直接点击进入\n" +
                    "http://oldhouse.m.fdc.com.cn/wuhan/chushou.html";
        }
        else if("租房".equals(content)){
            replyContent = "您可以查找适合您的租房房源，也可以直接发布出租信息。\n" +
                    "   请直接点击进入租房服务http://zufang.m.fdc.com.cn";
        }
        else if("装修".equals(content)){
            replyContent = "您可以获取最新装修优惠、在线监理、报价审核等装修服务。\n" +
                    "   请直接点击进入装修服务http://dec.m.fdc.com.cn";
        }else{
            replyContent = "我猜不到您想问什么？\n" +
                    "获取最新看房团信息请回复“看房团”。\n" +
                    "买房请回复“买房”或直接点击菜单栏小亿新房。\n" +
                    "卖房请回复“卖房”或直接点击" +
                    "http://oldhouse.m.fdc.com.cn/wuhan/chushou.html\n" +
                    "租房出租请回复“租房”或直接点击http://zufang.m.fdc.com.cn\n" +
                    "装修服务请回复“装修”或直接点击http://dec.m.fdc.com.cn\n" +
                    "如果您想联系我们，请加小亿微信（NPC19990401）";
        }
        log.info("replyContent:{}" ,replyContent);
        String str = textMsg(openid ,content ,token);
        log.info(" keyword reply :{}" ,str);
    }


    //给用户发送客服消息
    public String textMsg(String openid,String content ,String token){
        String url4 = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + token;
        JSONObject params = new JSONObject();
        params.put("touser", openid);
        params.put("msgtype", "text");
        JSONObject params2 = new JSONObject();
        params2.put("content", content);
        params.put("text", params2);
        return doPost5(url4, params);
    }


    public  void doGet(HttpServletRequest request,HttpServletResponse response)
    {
        PrintWriter out = null;
        try {
            String signature = request.getParameter("signature").trim();
            String nonce = request.getParameter("nonce");
            String timestamp = request.getParameter("timestamp");
            String echostr = request.getParameter("echostr");
            log.info("signature:{} ,nonce:{} ,timestamp:{}" ,signature ,nonce ,timestamp);
            String[] array = new String[]{token, timestamp, nonce};
            StringBuffer sb = new StringBuffer();
            // 字符串排序
            Arrays.sort(array);
            for (int i = 0; i < 3; i++) {
                sb.append(array[i]);
            }
            String str = sb.toString();
            String shaHexSignature = DigestUtils.sha1Hex(str);
            log.info("shaHexSignature:{}" ,shaHexSignature);
            if (signature.equals(shaHexSignature.trim())) {
                log.info("equals true {}" ,echostr);
                out = response.getWriter();
                out.print(echostr);
            }else{
                log.info("equals false");
                out = response.getWriter();
                out.print(echostr);
            }
        }catch (Exception e){
            log.error("" ,e);
        }finally {
            if(out != null){
                out.close();
            }
        }
    }

    public static Map<String, String> parseXml(HttpServletRequest request) throws IOException, DocumentException {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();
        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();
        // 遍历所有子节点
        for (Element e : elementList) {
            //如果是公众号的扫码事件，节点ScanCodeInfo有2个子节点
            Map<String, String> scanCodeInfo = null;
            if(e.getName().equalsIgnoreCase("ScanCodeInfo")){
                scanCodeInfo = new HashMap<>();
                List<Element> childrend = e.elements();
                for(Element child : childrend){
                    map.put(child.getName(), child.getText());
                    scanCodeInfo.put(child.getName(), child.getText());
                }
                map.put(e.getName(), scanCodeInfo.toString());
            }else{
                map.put(e.getName(), e.getText());
            }
        }

        // 释放资源
        inputStream.close();
        return map;
    }











    */
/**
     *  微信公众号 发消息前的授权
     * @param req
     * @param resp
     * @return
     *//*

    @RequestMapping("/weixinServlet5")
    public void weixinAuth(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        log.info("微信授权开始");
        String form_id =  req.getParameter("form_id");
        // 设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        //PrintWriter writer = resp.getWriter();
        String redirect_uri = URLEncoder.encode(
                "http://house.m.test.fdc.com.cn/activeboot" +"/weixinMsg5", "UTF-8");// 授权后重定向的回调链接地址，请使用urlencode对链接进行处理（文档要求）
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ appid2
                + "&redirect_uri="+ redirect_uri
                + "&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
        log.info("微信授权url {}" , url);
        resp.sendRedirect(url);// 跳转到要访问的地址
    }


    */
/**
     *  微信公众号 发消息
     * @param req
     * @param resp
     * @return
     *//*

    @ResponseBody
    @RequestMapping("/weixinMsg5")
    public Map<String,Object> msg5(HttpServletRequest req, HttpServletResponse resp, Integer a){
        Map<String,Object> res = new HashMap<>();
        try {
            log.info("发微信公众号消息啦");
            String code =  req.getParameter("code");
            String openid =  req.getParameter("openid");
            if(1== a)
                openid = "oELlx0fV3J6IWsiLnBja8lS7-790";
            if(StringUtils.hasText(code)) {
                String url2 = "https://api.weixin.qq.com/sns/oauth2/access_token?"
                        + "appid=" + appid2 + "&secret=" + secret2
                        + "&code=" + code
                        + "&grant_type=authorization_code";
                JSONObject obj = HttpHelper.httpGet(url2);
                log.info("授权信息  obj:{}", obj.toString());
                openid = obj.getString("openid");
            }
            String url3 = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" +
                    appid2 + "&secret=" + secret2;
            JSONObject obj3 = HttpHelper.httpGet(url3);
            String tokenId = obj3.getString("access_token");
            String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+tokenId;
            String str = doPost2(url ,openid);
            log.info(" str:{}" ,str);

            res.put("data", str);
            return res ;

        }catch (Exception e){
            log.error("" ,e);
            return res ;
        }

    }






    @ResponseBody
    @RequestMapping("/getphone")
    public Map<String,Object> getPhone(HttpServletRequest req, HttpServletResponse resp){
        Map<String,Object> res = new HashMap<>();
        try {
            String encryp_data = req.getParameter("encrypData");
            String iv_data = req.getParameter("ivData");
            String session_key = req.getParameter("sessionKey");
            byte[] encrypData = Base64.decodeBase64(encryp_data);
            byte[] ivData = Base64.decodeBase64(iv_data);
            byte[] sessionKey = Base64.decodeBase64(session_key);
            byte[] dat = decrypt(encrypData,sessionKey ,ivData);
            String data = new String(dat,"UTF-8").trim();
            res.put("data" ,data);
            log.info("data:{}" ,data);
            JSONObject obj = JSON.parseObject(data);
            res.put("purePhoneNumber" ,obj.getString("purePhoneNumber"));
            res.put("phoneNumber" ,obj.getString("phoneNumber"));

        }catch (Exception e){
            log.error("" ,e);
            res.put("error" ,"");
        }

        return res ;
    }


    public byte[] decrypt(byte[] content, byte[] keyByte, byte[] ivByte)
    {
        Security.addProvider(new BouncyCastleProvider());
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            Key sKeySpec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
            params.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, sKeySpec, params);
            return cipher.doFinal(content);
        }  catch (Exception e) {
            log.error("" ,e);
            throw  new RuntimeException();
        }
    }

    @ResponseBody
    @RequestMapping("/getopenid")
    public Map<String,Object>  getOpneid(HttpServletRequest req){
        Map<String,Object> res = new HashMap<>();
        try {
            String encryp_data = req.getParameter("encrypData");
            String iv_data = req.getParameter("ivData");
            String code = req.getParameter("code");

            String url="https://api.weixin.qq.com/sns/jscode2session?" +
                    "appid=" +appid
                    +"&secret=" +secret
                    +"&js_code=" +code
                    +"&grant_type=authorization_code";
            JSONObject jsonObject = HttpHelper.httpGet(url);
            String unionid = jsonObject.getString("unionid");
            String session_key = jsonObject.getString("session_key");
            String openid = jsonObject.getString("openid");
            res.put("unionid", unionid);
            res.put("session_key", session_key);
            res.put("openid", openid);
            res.put("data", jsonObject.toString());
            byte[] encrypData = Base64.decodeBase64(encryp_data);
            byte[] ivData = Base64.decodeBase64(iv_data);
            byte[] sessionKey = Base64.decodeBase64(session_key);
            byte[] dat = decrypt(encrypData,sessionKey ,ivData);
            String data = new String(dat,"UTF-8").trim();
            res.put("info", data);
            log.info("小程序授权获取信息  data:{}" ,jsonObject.toString());
            log.info("小程序授权获取信息  info:{}" ,data);

            return res ;
        }catch (Exception e){
            log.error("" ,e);
            return res ;
        }
    }


    */
/***
     * 小程序调用
     * @param req
     * @param resp
     * @return
     *//*

    @ResponseBody
    @RequestMapping("/weixinMsg3")
    public Map<String,Object> msg2(HttpServletRequest req, HttpServletResponse resp){
        Map<String,Object> res = new HashMap<>();
        try {
            String form_id =  req.getParameter("form_id");
            String openid =  req.getParameter("openid");

            String url2 = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                    + appid + "&secret=" + secret;
            JSONObject obj = HttpHelper.httpGet(url2);
            String tokenId = obj.getString("access_token");
            log.info("tokenId:{}" ,tokenId);
            String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=" + tokenId;
            String[] formIds = form_id.split(",");
            int i = new Random().nextInt(100);
            String str = doPost(url ,formIds[0],openid,i);
            log.info("str:{}" ,str);
            res.put("data"+i, str);

            req.setAttribute("openid" , null);
            msg5(req ,resp,1);
            return res ;
        }catch (Exception e){
            log.error("" ,e);
            res.put("msg", "Exception");
            return res ;
        }
    }





    public JSONObject getData(String form_id,String openid,int i){
        JSONObject obj = new JSONObject();
        obj.put("touser" ,openid);// opneid
        //obj.put("template_id" ,"wEAbA3X_3wiQDW1x55eHE2wrjWq77Bp_n0L4WNk0NDk");
        obj.put("template_id" ,"By9C7wnR8WbRI6QsdgjpwCgIZIM2-iJRyBuvPArxXkU");
        obj.put("form_id" ,form_id);// form_id
        //  obj.put("url" ,"http://house.m.fdc.com.cn");// url
        JSONObject data = new JSONObject();
        JSONObject keyword1 = new JSONObject();
        keyword1.put("value" ,"美好长江首玺key"+i) ;
        //keyword1.put("color" ,"#173177");
        JSONObject keyword2 = new JSONObject();
        keyword2.put("value" ,"美好长江价格"+i) ;
        // keyword2.put("color" ,"#173177");
        JSONObject keyword3 = new JSONObject();
        keyword3.put("value" ,"美好长江面积"+i) ;
        // keyword3.put("color" ,"#173177");
        data.put("keyword1" ,keyword1);
        data.put("keyword2" ,keyword2);
        data.put("keyword3" ,keyword3);
        obj.put("data",data);
        //log.info("obj:{}" , obj.toString());
        return obj;
    }

    public String doPost( String url,String form_id,String openid,int i){
        try {
            JSONObject params = getData(form_id,openid,i);
            CloseableHttpClient client = HttpClients.createDefault();
            //  HttpClient client = new DefaultHttpClient();
            ResponseHandler<?> responseHandler = new BasicResponseHandler();
            HttpPost post = new HttpPost(url);
            String msg = params.toJSONString();

            //设置发送消息的参数
            StringEntity entity = new StringEntity(msg,"UTF-8");
            //解决中文乱码的问题
            entity.setContentEncoding("UTF-8");
            //解决中文乱码的问题
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            post.setEntity(entity);
            //发送请求
            String response = (String)client.execute(post, responseHandler);
            //log.info("response:{}" ,response);
            return response;
        }catch (Exception e){
            log.error("" ,e);
        }
        return "null";

    }


    public String doPost2( String url,String openid){
        try {
            JSONObject params = getData2(openid);
            CloseableHttpClient client = HttpClients.createDefault();
            //  HttpClient client = new DefaultHttpClient();
            ResponseHandler<?> responseHandler = new BasicResponseHandler();
            HttpPost post = new HttpPost(url);
            String msg = params.toJSONString();
            //msg = new String(msg.getBytes(), "GBK");
            log.info(" msg:{}" ,msg);
            //设置发送消息的参数
            StringEntity entity = new StringEntity(msg,"UTF-8");
            //解决中文乱码的问题
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            post.setEntity(entity);
            //发送请求
            String response = (String)client.execute(post, responseHandler);
            //log.info("response:{}" ,response);
            return response;
        }catch (Exception e){
            log.error("" ,e);
        }
        return "null";

    }


    public JSONObject getData2(String openid){

        JSONObject obj = new JSONObject();
        obj.put("touser" ,openid);// opneid
        obj.put("template_id" ,"vsqmJxyI6IEkFSxGUYaHFBq6Ux9B8lFkjvaSjOt3tRs");
        //  obj.put("url" ,"http://house.m.fdc.com.cn");// url
        JSONObject data = new JSONObject();
        JSONObject keyword1 = new JSONObject();
        keyword1.put("value" ,"美好长江首玺key1") ;
        //keyword1.put("color" ,"#173177");
        JSONObject keyword2 = new JSONObject();
        keyword2.put("value" ,"美好长江key2") ;
        // keyword2.put("color" ,"#173177");
        JSONObject keyword3 = new JSONObject();
        keyword3.put("value" ,"2018-06-13") ;
        keyword3.put("color" ,"#173177");
        JSONObject keyword4 = new JSONObject();
        keyword4.put("value" ,"2018-06-13") ;

        data.put("keyword1" ,keyword1);
        data.put("keyword2" ,keyword2);
        data.put("keyword3" ,keyword3);
        data.put("keyword4" ,keyword4);
        obj.put("data",data);
        //log.info("obj:{}" , obj.toString());
        return obj;
    }


    public String doPost5( String url,JSONObject params){
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            //  HttpClient client = new DefaultHttpClient();
            ResponseHandler<?> responseHandler = new BasicResponseHandler();
            HttpPost post = new HttpPost(url);
            String msg = params.toJSONString();
            //msg = new String(msg.getBytes(), "GBK");
            log.info(" msg:{}" ,msg);
            //设置发送消息的参数
            StringEntity entity = new StringEntity(msg,"UTF-8");
            //解决中文乱码的问题
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            post.setEntity(entity);
            //发送请求
            String response = (String)client.execute(post, responseHandler);
            //log.info("response:{}" ,response);
            return response;
        }catch (Exception e){
            log.error("" ,e);
        }
        return "null";

    }

}
*/
