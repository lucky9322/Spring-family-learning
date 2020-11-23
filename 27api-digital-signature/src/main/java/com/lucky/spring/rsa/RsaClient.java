package com.lucky.spring.rsa;

import com.lucky.spring.util.HttpRequestUtil;
import com.lucky.spring.util.RSA2Util;
import com.lucky.spring.util.RandomUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangdd on 2020/11/23
 */
@RestController
public class RsaClient {


    //私钥
    private final static String PRIVATE_KEY = "";
    //api 接口编码
    private String code = "";
    //请求地址
    private String url = "http://localhost:8080/api/demo?a=1&b=1"; //请求方法
    private String method = "POST";

    @GetMapping("/api/test")
    public String run() throws UnsupportedEncodingException { // 请求所需的参数
        Map<String, String> requestParam = new HashMap<>(16);
        requestParam.put("a", "1");
        requestParam.put("b", "1");
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-timestamp",
                String.valueOf(System.currentTimeMillis()));
        headers.set("x-nonce", RandomUtil.getStrRandom32());
        headers.set("x-code", code);
        // 将需要签名的参数内容按参数名的字典顺序进行排序，并拼接为字符串
        String paramStr = RSA2Util.buildParamStr(headers, method,
                requestParam);
        // 使用私钥生成签名字符串
        String sign =
                RSA2Util.buildRSASignByPrivateKey(paramStr, PRIVATE_KEY);
        // 对签名字符串进行 url 编码
        String urlEncodeSign = URLEncoder.encode(sign, "UTF-8"); // 请求报文中需带上签名字符串
        headers.set("x-sign", urlEncodeSign);
        // 发送请求
        return method.equals("POST") ?
                HttpRequestUtil.executePost(headers, url, requestParam) :
                HttpRequestUtil.executeGet(headers, url, requestParam);
    }
}
