package repository.entities;

import entities.POI;

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
        //objects deep copy
    }

    public POI toModel() {
        //TODO - convert to poi and return
        return null;
    }
}
