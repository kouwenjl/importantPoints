package com.example.springcloudclient;


import a.A;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class D {
    public static void main(String[] args) throws Exception {
        A a =new A();
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpPost httpPost  = new HttpPost("http://localhost:8081/post");
        HttpEntity httpEntity = new StringEntity("{\"dxs\": \"123\", \"d\": \"f\"}", ContentType.APPLICATION_JSON);
        httpPost.setEntity(httpEntity);
        CloseableHttpResponse response =closeableHttpClient.execute(httpPost);
        response.getStatusLine().getStatusCode();
        System.out.println(EntityUtils.toString(response.getEntity()));
      ObjectMapper objectMapper =new ObjectMapper();
//      objectMapper.




    }
}

