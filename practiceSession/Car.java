class Car {
	String name;
	String color;
	int vin;
	String model;

	public Car(int vin, String name) {
		this.vin = vin;
		this.name = name;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + "\n" + "Model: " + this.model + "\n";
	}
}