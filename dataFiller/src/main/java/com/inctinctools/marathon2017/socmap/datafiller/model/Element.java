package com.inctinctools.marathon2017.socmap.datafiller.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.inctinctools.marathon2017.socmap.core.entities.POI;
import com.inctinctools.marathon2017.socmap.core.enums.POITypes;

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
    @SerializedName("center")
    private Map<String, String> center;
    @SerializedName("tags")
    private Map<String, String> tags;

    @Expose(serialize = false, deserialize = false)
    private POITypes poiType;

    public POI toModel(){
        POI poi = new POI();
        poi.setId(mId);
        if(!mType.equals("way")) {
            poi.setX(mLat);
            poi.setY(mLon);
        }else{
            poi.setX(Double.parseDouble(center.get("lat")));
            poi.setY(Double.parseDouble(center.get("lon")));
        }
        poi.setName(tags.get("name"));
        poi.setObjectType(poiType);
        return poi;
    }

    public void setPoiTypes(POITypes poiType) {
        this.poiType = poiType;
    }


}
