package mapping;

import enums.Types;

import java.util.*;

public class Converter {
    private static Map<Types, List<String>> map = new Hashtable<Types, List<String>>();
    static {
        map.put(Types.EDUCATION, Arrays.asList("university", "school", "kindergarten"));
        map.put(Types.MEDICINE, Arrays.asList("hospital"));
    }
    public static List<String> getListTags(Types type){
        return map.get(type);
    }
}
