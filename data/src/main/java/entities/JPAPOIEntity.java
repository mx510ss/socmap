package entities;

import enums.POITypes;

import javax.persistence.*;


@Entity
@Table(name = "Object")
public class JPAPOIEntity {

    @Id
    @Column(name = "id", length = 15, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "X-crd")
    private double X;

    @Column(name = "Y-crd")
    private double Y;

    @Column(name = "Type")
    @Enumerated(EnumType.STRING)
    private POITypes type;

    @Column(name = "Discription")
    private String disctription;


    protected JPAPOIEntity(){}

    public JPAPOIEntity (POI poi){
        this.id = poi.getId();
        this.name = poi.getName();
        this.X = poi.getX();
        this.Y = poi.getY();
        this.type = poi.getObjectType();
    }

    public POI toModel() {
       POI poi = new POI();
       poi.setId(id);
       poi.setName(name);
       poi.setX(X);
       poi.setY(Y);
       poi.setObjectType(type);
       return poi;
    }
}
