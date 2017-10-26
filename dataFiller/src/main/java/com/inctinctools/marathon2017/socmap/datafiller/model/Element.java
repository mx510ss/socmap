package com.inctinctools.marathon2017.socmap.datafiller.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.inctinctools.marathon2017.socmap.data.entities.POI;
import enums.POITypes;

import java.util.Map;

public class Element {
    @SerializedName("type")
    private String mType;
    @SerializedName("id")
    private long mId;
    @SerializedName("lat")
    private double mLat;
    @SerializedName("lon")
    private double mLon;
    @SerializedName("tags")
    private Map<String, String> tags;

    @Expose(serialize = false, deserialize = false)
    private POITypes poiType;

    public String getmType() {
        return mType;
    }

    public long getmId() {
        return mId;
    }

    public double getmLat() {
        return mLat;
    }

    public double getmLon() {
        return mLon;
    }

    public Map<String, String> getTags() {
        return tags;
    }


    public POI toModel(){
        POI poi = new POI();
        poi.setId(mId);
        poi.setX(mLat);
        poi.setY(mLon);
        poi.setName(tags.get("name"));
        poi.setObjectType(poiType);
        return poi;
    }

    public void setPoiTypes(POITypes poiType) {
        this.poiType = poiType;
    }
}
