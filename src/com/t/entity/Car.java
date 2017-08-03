package com.t.entity;

public class Car {
	private long carId;
	private Double price;
	private String name;
	private String color;
	private Category category;

	public Car(long carId, Double price, String name, String color, Category category) {
		super();
		this.carId = carId;
		this.price = price;
		this.name = name;
		this.color = color;
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Car(Double price, String name, String color) {
		// super();
		this.price = price;
		this.name = name;
		this.color = color;
	}

	public Car() {
		// super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", price=" + price + ", name=" + name + ", color=" + color + ", category="
				+ category + "]";
	}

}
