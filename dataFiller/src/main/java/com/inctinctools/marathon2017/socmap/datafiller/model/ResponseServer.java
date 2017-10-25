package com.inctinctools.marathon2017.socmap.datafiller.model;

import com.google.gson.annotations.SerializedName;

public class ResponseServer {
    @SerializedName("version")
    private String mVersion;
    @SerializedName("elements")
    private Element[] elements;

    public String getmVersion() {
        return mVersion;
    }

    public Element[] getElements() {
        return elements;
    }
}
