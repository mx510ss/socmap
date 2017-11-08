package com.inctinctools.marathon2017.socmap.data.repository;

import com.inctinctools.marathon2017.socmap.core.repository.POIRepository;
import com.inctinctools.marathon2017.socmap.data.entities.JPAPOIEntity;
import com.inctinctools.marathon2017.socmap.core.entities.POI;
import com.inctinctools.marathon2017.socmap.core.enums.POITypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class JPAPOIAdapter implements POIRepository {

    private JPAPOIRepository repository;

    @Autowired
    public JPAPOIAdapter(JPAPOIRepository repository){
        this.repository = repository;
    }


    public List<POI> getByBounds(double X1, double Y1, double X2, double Y2, POITypes type) {
        List<JPAPOIEntity> list = repository.getByBounds(X1, Y1, X2, Y2, type);
        List<POI> resultList = new ArrayList<POI>(list.size());
        for(JPAPOIEntity i : list){
            resultList.add(i.toModel());
        }
        return resultList;
    }

    public void save(Collection<POI> poi) {
        List<JPAPOIEntity> list = new ArrayList<JPAPOIEntity>(poi.size());
        for(POI i : poi){
            list.add( new JPAPOIEntity(i));
        }
        repository.save(list);
        repository.flush();
    }
}
