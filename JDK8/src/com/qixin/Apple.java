package com.qixin;

public class Apple {
	private String color;
	private int wigth;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWigth() {
		return wigth;
	}
	public void setWigth(int wigth) {
		this.wigth = wigth;
	}
	@Override
	public String toString() {
		return "Apple [color=" + color + ", wigth=" + wigth + "]";
	}
	public Apple(String color, int wigth) {
		super();
		this.color = color;
		this.wigth = wigth;
	}
	public Apple() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
