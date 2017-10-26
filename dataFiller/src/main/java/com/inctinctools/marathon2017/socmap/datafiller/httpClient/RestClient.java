package com.inctinctools.marathon2017.socmap.datafiller.httpClient;

import com.inctinctools.marathon2017.socmap.datafiller.api.Api;
import com.inctinctools.marathon2017.socmap.datafiller.model.ResponseServer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;

public class RestClient {
    private RestTemplate rest;

    public RestClient(){
        this.rest = new RestTemplate();
    }
    public ResponseServer get(String query) throws UnsupportedEncodingException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Api.OVERPASS_API)
                .queryParam("data", query);
        HttpEntity<ResponseServer> response = rest.exchange(
                builder.build().encode("UTF-8").toUri(),
                HttpMethod.GET,
                null,
                ResponseServer.class);
        return response.getBody();
    }
}
