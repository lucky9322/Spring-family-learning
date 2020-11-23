package com.lucky.spring.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpHeaders;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangdd on 2020/11/23
 */
public class RSA2Util {

    public static final String CHARSET = "UTF-8";

    // 密钥算法
    public static final String ALGORITHM_RSA = "RSA";

    //RSA 签名算法
    public static final String ALGORITHM_RSA_SIGN = "SHA256WithRSA";

    public static final int ALGORITHM_RSA_PRIVATE_KEY_LENGTH = 2048;

    /**
     * 初始化RSA算法密钥对
     *
     * @param keysize RSA1024已经不安全了,建议2048
     * @return 经过Base64编码后的公私钥Map, 键名分别为publicKey和privateKey
     */
    public static Map<String, String> initRSAKey(int keysize) {
        if (keysize != ALGORITHM_RSA_PRIVATE_KEY_LENGTH) {
            throw new IllegalArgumentException("RSA1024已经不安全了,请使用" + ALGORITHM_RSA_PRIVATE_KEY_LENGTH + "初始化RSA密钥对");
        }
        //为RSA算法创建一个KeyPairGenerator对象
        KeyPairGenerator kpg;
        try {
            kpg = KeyPairGenerator.getInstance(ALGORITHM_RSA);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("No such algorithm-->[" + ALGORITHM_RSA + "]");
        }
        //初始化KeyPairGenerator对象,不要被initialize()源码表面上欺骗,其实这里声明的size是生效的
        kpg.initialize(ALGORITHM_RSA_PRIVATE_KEY_LENGTH);
        //生成密匙对
        KeyPair keyPair = kpg.generateKeyPair();
        //得到公钥
        Key publicKey = keyPair.getPublic();
        String publicKeyStr = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        //得到私钥
        Key privateKey = keyPair.getPrivate();
        String privateKeyStr = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        Map<String, String> keyPairMap = new HashMap<>();
        keyPairMap.put("publicKey", publicKeyStr);
        keyPairMap.put("privateKey", privateKeyStr);
        return keyPairMap;
    }

    /**
     * RSA算法使用私钥对数据生成数字签名
     *
     * @param data 待签名的明文字符串
     * @param key  RSA私钥字符串
     * @return RSA私钥签名后的经过Base64编码的字符串
     */
    public static String buildRSASignByPrivateKey(String data, String key) {
        try {
            //通过PKCS#8编码的Key指令获得私钥对象
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(key));
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
            Signature signature = Signature.getInstance(ALGORITHM_RSA_SIGN);
            signature.initSign(privateKey);
            signature.update(data.getBytes(CHARSET));
            return Base64.getEncoder().encodeToString(signature.sign());
        } catch (Exception e) {
            throw new RuntimeException("签名字符串[" + data + "]时遇到异常", e);
        }
    }

    /**
     * RSA算法使用公钥校验数字签名
     *
     * @param data 参与签名的明文字符串
     * @param key  RSA公钥字符串
     * @param sign RSA签名得到的经过Base64编码的字符串
     * @return true--验签通过,false--验签未通过
     */
    public static boolean buildRSAVerifyByPublicKey(String data, String key, String sign) {
        try {
            //通过X509编码的Key指令获得公钥对象Base64.getMimeDecoder().decode(key)
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(key));
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
            PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
            Signature signature = Signature.getInstance(ALGORITHM_RSA_SIGN);
            signature.initVerify(publicKey);
            signature.update(data.getBytes(CHARSET));
            return signature.verify(Base64.getDecoder().decode(sign));
        } catch (Exception e) {
            throw new RuntimeException("验签字符串[" + data + "]时遇到异常", e);
        }
    }

    /**
     * 参数拼接
     *
     * @param headers
     * @param method
     * @param param
     * @return
     */
    public static String buildParamStr(HttpHeaders headers, String method, Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        // 拼接请求方法
        sb.append("[").append(method).append("]\n");
        int index = sb.length();
        // 拼接请求参数
        if (!param.isEmpty() && method.equalsIgnoreCase("GET")) {
            param.entrySet().stream().sorted(
                    Comparator.comparing(Map.Entry::getKey)).forEach(entry ->
                    sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&"));
            sb.insert(index, "[").deleteCharAt(sb.length() - 1).append("]\n");
        }
        // 拼接请求报文信息
        sb.append(headers.get("x-timestamp")).append("\n");
        sb.append(headers.get("x-nonce")).append("\n");
        sb.append(headers.get("x-code")).append("\n");
        if (method.equalsIgnoreCase("POST")) {
            sb.append("[").append(JSONObject.toJSONString(param)).append("]");
        }
        // 拼接body
        String paramStr = sb.toString();
        System.out.println("paramStr:\n" + paramStr);
        return paramStr;
    }
}
