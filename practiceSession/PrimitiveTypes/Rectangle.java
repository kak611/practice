class Rectangle {
	int x;
	int y;
	int width;
	int height;

	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public static boolean isIntersecting(Rectangle R1, Rectangle R2) {
		return (R1.x + R1.width >= R2.x &&
				R2.x + R2.width >= R1.x &&
				R1.y + R1.height >= R2.y &&
				R2.y + R2.height >= R1.y);
	}

	public static Rectangle getIntersection(Rectangle R1, Rectangle R2) {
		if (!isIntersecting(R1, R2)) return new Rectangle(-1, -1, 0 , 0);

		int x = Math.max(R1.x, R2.x);
		int y = Math.max(R1.y, R2.y);
		int width = Math.min((R1.x + R1.width), (R2.x + R2.width)) - Math.max(R1.x, R2.x);
		int height = Math.min((R1.y + R1.height), (R2.y + R2.height)) - Math.max(R1.y, R2.y);

		return new Rectangle(x, y, width, height);
	}

	public static void printRectangle(Rectangle R) {
		System.out.println("New rectangle co-ordinates: " + R.x + ", " + R.y + ", " + R.width + ", " + R.height);
	}

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(1, 1, 2, 1);
		Rectangle r2 = new Rectangle(2, 2, 1, 1);
		Rectangle r = getIntersection(r1, r2);
		printRectangle(r);
	}
}