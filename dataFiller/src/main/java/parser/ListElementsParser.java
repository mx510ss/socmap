package parser;
import com.google.gson.Gson;
import model.Element;
import model.ResponseServer;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class ListElementsParser {

    InputStream inputStream;

    public ListElementsParser(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public List<Element> parse() {
        ResponseServer requestServer =  new Gson().fromJson(new InputStreamReader(inputStream), ResponseServer.class);
        return Arrays.asList(requestServer.getElements());
    }
}
