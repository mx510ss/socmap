package repository;

import entities.JPAPOIEntity;
import entities.POI;
import enums.POITypes;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JPAPOIAdapter implements POIRepository {

    private JPAPOIRepository repository;

    @Autowired
    public JPAPOIAdapter(JPAPOIRepository repository){
        this.repository = repository;
    }


    public List<POI> getByBounds(double X1, double Y1, double X2, double Y2, POITypes type) {
        List<JPAPOIEntity> list = repository.getByBounds(X1, Y1, X2, Y2, type);
        List<POI> resultList = new ArrayList<POI>();
        for(JPAPOIEntity i : list){
            POI tmp = i.toModel();
            resultList.add(tmp);
        }
        return resultList;
    }

    public void save(Collection<POI> poi) {
        List<JPAPOIEntity> list = new ArrayList<JPAPOIEntity>();
        for(POI i : poi){
            JPAPOIEntity tmp = new JPAPOIEntity(i);
            list.add(tmp);
        }
        repository.save(list);
    }
}