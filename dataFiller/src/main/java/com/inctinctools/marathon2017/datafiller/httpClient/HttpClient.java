package com.inctinctools.marathon2017.datafiller.httpClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    public void request(String url, ResponseListner responseListner) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) (new URL(url)).openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        responseListner.onResponse(inputStream);
        inputStream.close();
        urlConnection.disconnect();
    }

    public interface ResponseListner{
        void onResponse(InputStream stream);
    }
}
