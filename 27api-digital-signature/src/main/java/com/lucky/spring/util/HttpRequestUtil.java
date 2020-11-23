package com.lucky.spring.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhangdd on 2020/11/23
 */
public class HttpRequestUtil {
    /**
     * 发送数据类型为 json 的 post 请求 *
     *
     * @param <T>
     * @param url
     * @param param
     * @return
     */
    public static <T> String executePost(HttpHeaders headers, String url, T param) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<T> httpEntity = new HttpEntity<>(param, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response =
                restTemplate.postForEntity(url, httpEntity, String.class);
        return response.getBody();
    }

    /**
     * 发送get请求 *
     *
     * @param <T>
     * @param url
     * @param param * @return
     */
    public static <T> String executeGet(HttpHeaders headers, String url, T param) {
        HttpEntity<T> httpEntity = new HttpEntity<>(param, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response =
                restTemplate.getForEntity(url, String.class, httpEntity);
        return response.getBody();
    }
}
