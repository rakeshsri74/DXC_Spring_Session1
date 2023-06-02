package com.dxc.bo;

public class Triangle {
	
	private String type;
	private int height;
	
	
	
	public Triangle() {
		super();
		// TODO Auto-generated constructor stub
	}

		
	public Triangle(String type, int height) {
		super();
		this.type = type;
		this.height = height;
	}



	public String getType() {
		return type;
	}


	public int getHeight() {
		return height;
	}

	public void draw() {
		System.out.println(getType()  + " Triangle Drawn of "+getHeight());
	}
}
