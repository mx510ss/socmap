package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


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

    @Column(name = "Discription")
    private String Disctription;


    protected JPAPOIEntity(){}

    public JPAPOIEntity (POI poi){
        this.id = poi.getId();
        this.name = poi.getName();
        this.X = poi.getX();
        this.Y = poi.getY();
    }

    public POI toModel() {
       POI poi = new POI();
       poi.setId(id);
       poi.setName(name);
       poi.setX(X);
       poi.setY(Y);
       return poi;
    }
}
