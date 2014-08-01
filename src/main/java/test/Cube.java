package test;

public class Cube {

	public class Coordinates {

		public float getX() {
			return x;
		}

		public void setX(float x) {
			this.x = x;
		}

		public float getY() {
			return y;
		}

		public void setY(float y) {
			this.y = y;
		}

		public float getZ() {
			return z;
		}

		public void setZ(float z) {
			this.z = z;
		}

		public Coordinates(float x, float y, float z) {
			setX(x);
			setY(y);
			setZ(z);
		}

		public Coordinates() {
		}

		private float x;
		private float y;
		private float z;

	}

	private float size;
	private Coordinates coordinates;
	private Coordinates minCoordinates;
	private Coordinates maxCoordinates;

	public Cube() {
		size = 0;
		coordinates = new Coordinates();
		minCoordinates = new Coordinates();
		maxCoordinates = new Coordinates();
	}

	public Cube(float size, float x, float y, float z) {
		this.size = size;
		coordinates = new Coordinates(x, y, z);
		minCoordinates = new Coordinates(coordinates.getX() - size / 2,
				coordinates.getY() - size / 2, coordinates.getZ() - size / 2);
		maxCoordinates = new Coordinates(size / 2 + coordinates.getX(), size
				/ 2 + coordinates.getY(), size / 2 + coordinates.getZ());
	}

	public void setSize(float size) {
		this.size = size;
	}

	public float getSize() {
		return size;
	}

	public void setCoordinates(float x, float y, float z) {
		coordinates.x = x;
		coordinates.y = y;
		coordinates.z = z;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public Coordinates getMaxCoordinates() {
		return maxCoordinates;
	}

	public Coordinates getMinCoordinates() {
		return minCoordinates;
	}
}
