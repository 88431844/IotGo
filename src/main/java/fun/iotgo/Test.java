package fun.iotgo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpHeaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {
    public static void main(String[] args) throws Exception {
        String authorization = "90ff800eed2fa845edb30d062fd401a40fb557f8";
        String projectName = "EspDisplay";
        JSONObject jsonObject = getProjectByName(authorization, projectName);
        System.out.println(jsonObject.toJSONString());

    }

    /*请求url获取返回的内容*/
    public static String getReturn(HttpURLConnection connection) throws IOException {
        StringBuffer buffer = new StringBuffer();
        //将返回的输入流转换成字符串
        try (InputStream inputStream = connection.getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            String result = buffer.toString();
            return result;
        }
    }

    public static JSONObject getProjectByName(String authorization, String projectName) {
        try {
            URL serverUrl = new URL("https://api.todoist.com/rest/v1/projects");
            HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            //必须设置false，否则会自动redirect到重定向后的地址
            conn.setInstanceFollowRedirects(false);
            conn.setRequestProperty(HttpHeaders.AUTHORIZATION, "Bearer " + authorization);
            conn.connect();
            String result = getReturn(conn);
            JSONArray jsonArray = JSONArray.parseArray(result);
            for (Object o : jsonArray) {
                if (projectName.equals(JSONObject.parseObject(o.toString()).getString("name"))) {
                    return JSONObject.parseObject(o.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
