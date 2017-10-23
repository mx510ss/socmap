package entities;


import enums.POITypes;

public class POI {


	private long id;
	
	private String name;

	private double x;
	
	private double y;

	private POITypes objectType;

	public POI(){}

	public POI(long id, String name, double X, double Y, POITypes objectType){
		this.setId(id);
		this.setName(name);
		this.setX(X);
		this.setY(Y);
		this.setObjectType(objectType);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public POITypes getObjectType() {
		return objectType;
	}

	public void setObjectType(POITypes objectType) {
		this.objectType = objectType;
	}


}
