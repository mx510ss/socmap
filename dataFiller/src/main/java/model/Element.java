package model;

import com.google.gson.annotations.SerializedName;
import entities.POI;

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
    private Tags tags;

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

    public Tags getTags() {
        return tags;
    }


    public POI toModel(){
        POI poi = new POI();
        poi.setId(mId);
        poi.setX(mLat);
        poi.setY(mLon);
        poi.setName(tags.getName());
        //TODO setType.
        return poi;
    }
}
