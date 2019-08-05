package com.fdc.active.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fdc.active.domain.SHhouse;
import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018/6/26.
 */
@Controller
public class SHAController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(SHAController.class);


    public static void main(String[] args) throws Exception{

        SHAController contr = new SHAController();
        String url = "http://127.0.0.1:8080/homebaseapi/homebaseapi.restful.inter.house.addbytoken";
        JSONObject obj = contr.getData();
        SHhouse house = JSON.parseObject(JSON.toJSONString(obj),SHhouse.class);
        contr.sendPost(url,house);
    }

    public String sendPost( String url,SHhouse house)throws Exception{
        log.info("house.toString:{}" ,house.toString());
        String str = JSON.toJSONString(house) ;
        log.info(" str:{}" ,str);
        JSONObject obj = JSON.parseObject(str);
        String sign = getSHA1("5b31d547205c8b4dbcb6c9b3",str);
        log.info(" sign:{}" ,sign);
        obj.put("signature" ,sign);
        obj.put("appKey" ,"5b31d547205c8b4dbcb6c9b2");
        String res =  doPost(obj,url);
        return res;
    }

    public String doPost2( JSONObject params,String url){
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            ResponseHandler<?> responseHandler = new BasicResponseHandler();
            HttpPost post = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000).build();
            post.setConfig(requestConfig);
            post.addHeader("Content-Type", "application/json");

            StringEntity e = new StringEntity(JSON.toJSONString(params), "utf-8");
            e.setContentEncoding("UTF-8");
            e.setContentType("application/json");
            post.setEntity(e);

            //发送请求
            String response = (String)client.execute(post, responseHandler);
            log.info("response:{}" ,response);
            return response;
        }catch (Exception e){
            log.error("" ,e);
        }
        return "null";
    }


    public String doPost( JSONObject params,String url){
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            ResponseHandler<?> responseHandler = new BasicResponseHandler();
            HttpPost post = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000).build();
            post.setConfig(requestConfig);

            ArrayList formParams = new ArrayList();
            Iterator requestEntity = params.keySet().iterator();

            while(requestEntity.hasNext()) {
                String e = (String)requestEntity.next();
                String value =  params.getString(e);
                log.info("post name:{} ,value:{}" ,e,value);
                formParams.add(new BasicNameValuePair(e,value));
            }

            UrlEncodedFormEntity requestEntity1 = new UrlEncodedFormEntity(formParams, "UTF-8");
            post.setEntity(requestEntity1);

            //发送请求
            String response = (String)client.execute(post, responseHandler);
            log.info("response:{}" ,response);
            return response;
        }catch (Exception e){
            log.error("" ,e);
        }
        return "null";
    }

    public  String getSHA1(String token ,String stri) throws Exception {
        JSONObject obj = JSON.parseObject(stri);
        obj.put("token" ,token);
        SHhouse sHhouse = new SHhouse();
        Object[] fields = sHhouse.getField();
        StringBuffer sb = new StringBuffer();

        // 字符串排序
        Arrays.sort(fields);
        for (int i = 0; i < fields.length; i++) {
            if(i>3)continue;
            String name = fields[i].toString();
            Object value = obj.get(name);
            log.error("field:{} value:{}" ,name ,value);
            sb.append(value);
        }
        String str = sb.toString();
        log.info("StringBuffer:{}",str);
        // SHA1签名生成
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(str.getBytes("UTF-8"));
        byte[] digest = md.digest();

        StringBuffer hexstr = new StringBuffer();
        String shaHex = "";
        for (int i = 0; i < digest.length; i++) {
            shaHex = Integer.toHexString(digest[i] & 0xFF);
            if (shaHex.length() < 2) {
                hexstr.append(0);
            }
            hexstr.append(shaHex);
        }
        return hexstr.toString();
    }


    public JSONObject getData(){
        try {
            Pattern pattern = Pattern.compile("^[0-9]+");

            JSONObject obj = new JSONObject();
            List<String> list = new ArrayList<>();
            File file = new File(this.getClass().getResource("/data.txt").getPath());
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader br = new BufferedReader(read);//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                list.add(s);
            }

            list.stream().forEach(s1 -> {
                int index =  s1.indexOf(":");
                String key = s1.substring(0,index);
                if(index <s1.length()){
                    String value = s1.substring(index+1 ,s1.length());
                   // log.info("aaaa key:{},   value:{}" ,key ,value);

                    Matcher isNum = pattern.matcher(value);
                    if (!"contactPhone".equals(key) && isNum.matches()) {
                        Object o2 = new Integer(value);
                        Object o = Integer.parseInt(value) ;
                        obj.put(key,o);
                    }else {
                        obj.put(key,value);
                    }
                }
            });
            return obj;
        }catch (Exception e){
            log.error("" ,e);
            return null;
        }

    }


}
