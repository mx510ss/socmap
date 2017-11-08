package com.inctinctools.marathon2017.socmap.datafiller.mapping;

import com.inctinctools.marathon2017.socmap.core.enums.POITypes;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class TagResolver {
    private static Map<POITypes, List<String>> map = new Hashtable<POITypes, List<String>>();
    static {
        map.put(POITypes.EDUCATION, Arrays.asList("university", "school", "kindergarten", "college"));
        map.put(POITypes.MEDICINE, Arrays.asList("hospital", "pharmacy"));
        map.put(POITypes.SHOP, Arrays.asList("supermarket", "mall", "convenience"));
    }
    public static List<String> getListTags(POITypes type){
        return map.get(type);
    }
}
