package com.inctinctools.marathon2017.socmap.datafiller.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseServer {
    @SerializedName("version")
    private String mVersion;
    @SerializedName("elements")
    private List<Element> elements;

    public String getmVersion() {
        return mVersion;
    }

    public List<Element> getElements() {
        return elements;
    }
}
