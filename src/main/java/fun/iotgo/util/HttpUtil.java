package fun.iotgo.util;

import org.springframework.http.HttpHeaders;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

    public static String httpReq(String url, String authorization) {
        try {
            URL serverUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            //必须设置false，否则会自动redirect到重定向后的地址
            conn.setInstanceFollowRedirects(false);
            conn.setRequestProperty(HttpHeaders.AUTHORIZATION, "Bearer " + authorization);
            conn.connect();

            StringBuilder buffer = new StringBuilder();
            //将返回的输入流转换成字符串
            try (InputStream inputStream = conn.getInputStream();
                 InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
                String str;
                while ((str = bufferedReader.readLine()) != null) {
                    buffer.append(str);
                }
                return buffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
