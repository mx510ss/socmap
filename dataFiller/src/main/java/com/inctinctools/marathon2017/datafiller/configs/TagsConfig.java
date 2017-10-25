package com.inctinctools.marathon2017.datafiller.configs;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TagsConfig {

    public static final String URL_TAGS_JSON = "../tags.json";

    @SerializedName("tags")
    private String[] tags;

    public String[] getTags() {
        return tags;
    }


}
