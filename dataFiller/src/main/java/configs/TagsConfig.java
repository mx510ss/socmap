package configs;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TagsConfig {

    @SerializedName("tags")
    private String[] tags;

    public String[] getTags() {
        return tags;
    }


}
