package week02;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * 使用 HttpClient 或 OkHttp 访问 http://localhost:8801
 */
public class HomeWork {

    public static final String URL = "http://localhost:8801";

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        Response response = null;
        try {
            Request request = new Request.Builder().url(URL).build();
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

}
