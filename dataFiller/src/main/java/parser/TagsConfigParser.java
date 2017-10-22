package parser;

import com.google.gson.Gson;
import configs.TagsConfig;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TagsConfigParser {

    private InputStream mInputStream;

    public TagsConfigParser(final InputStream pInputStream) {
        this.mInputStream = pInputStream;
    }

    public TagsConfig parse() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(mInputStream);
        TagsConfig tagsConfig = new Gson().fromJson(inputStreamReader, TagsConfig.class);
        inputStreamReader.close();
        return tagsConfig;
    }
}
