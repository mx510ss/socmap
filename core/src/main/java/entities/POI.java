package entities;


import enums.Types;

public class POI {


	private long id;
	
	private String name;

	private double X;
	
	private double Y;

	private Types objectType;

	public POI(){}

	public POI(long id, String name, double X, double Y, Types objectType){
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
		return X;
	}

	public void setX(double x) {
		X = x;
	}

	public double getY() {
		return Y;
	}

	public void setY(double y) {
		Y = y;
	}

	public Types getObjectType() {
		return objectType;
	}

	public void setObjectType(Types objectType) {
		this.objectType = objectType;
	}


}
