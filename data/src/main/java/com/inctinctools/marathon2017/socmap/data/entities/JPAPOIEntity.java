package com.inctinctools.marathon2017.socmap.data.entities;

import com.inctinctools.marathon2017.socmap.core.entities.POI;
import com.inctinctools.marathon2017.socmap.core.enums.POITypes;

import javax.persistence.*;


@Entity
@Table(name = "POI")
public class JPAPOIEntity {

    @Id
    @Column(name = "id", length = 15, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "x")
    private double x;

    @Column(name = "y")
    private double y;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private POITypes type;

    @Column(name = "discription")
    private String disctription;


    protected JPAPOIEntity(){}

    public JPAPOIEntity (POI poi){
        this.id = poi.getId();
        this.name = poi.getName();
        this.x = poi.getX();
        this.y = poi.getY();
        this.type = poi.getObjectType();
    }

    public POI toModel() {
       POI poi = new POI();
       poi.setId(id);
       poi.setName(name);
       poi.setX(x);
       poi.setY(y);
       poi.setObjectType(type);
       return poi;
    }
}
