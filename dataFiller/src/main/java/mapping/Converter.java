package mapping;

import enums.POITypes;

import java.util.*;

public class Converter {
    private static Map<POITypes, List<String>> map = new Hashtable<POITypes, List<String>>();
    static {
        map.put(POITypes.EDUCATION, Arrays.asList("university", "school", "kindergarten"));
        map.put(POITypes.MEDICINE, Arrays.asList("hospital"));
    }
    public static List<String> getListTags(POITypes type){
        return map.get(type);
    }
}
