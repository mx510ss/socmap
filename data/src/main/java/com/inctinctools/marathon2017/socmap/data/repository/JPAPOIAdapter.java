package com.inctinctools.marathon2017.socmap.data.repository;

import com.inctinctools.marathon2017.socmap.core.entities.POI;
import com.inctinctools.marathon2017.socmap.core.enums.POITypes;
import com.inctinctools.marathon2017.socmap.core.repository.POIRepository;
import com.inctinctools.marathon2017.socmap.data.entities.JPAPOIEntity;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class JPAPOIAdapter implements POIRepository {

    private final JPAPOIRepository repository;

    @Autowired
    public JPAPOIAdapter(@NotNull final JPAPOIRepository repository) {
        this.repository = repository;
    }

    public List<POI> getByBounds(final double X1, final double Y1, final double X2, final double Y2, @NotNull final POITypes type) {
        final List<JPAPOIEntity> list = repository.getByBounds(X1, Y1, X2, Y2, type);
        final List<POI> resultList = new ArrayList<POI>(list.size());
        for (JPAPOIEntity i : list) {
            resultList.add(i.toModel());
        }
        return resultList;
    }

    public void save(@NotNull Collection<POI> poi) {
        final List<JPAPOIEntity> list = new ArrayList<JPAPOIEntity>(poi.size());
        for (POI i : poi) {
            list.add(new JPAPOIEntity(i));
        }
        repository.save(list);
    }
}
