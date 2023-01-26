package temasvistos;

public class MathematicOperations {
	public double x;
	public double y;
	public int z;
	public int w;

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
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

	// Redondendea hacia arriba
	public void NumberCeil() {
		System.out.print(Math.ceil(this.getX()) + "\n");
	}
	
	// Redondendea hacia abajo
	public void NumberFloor() {
		System.out.println(Math.floor(this.getY()));
	}
	
	// Devuelve un numero elevado a otro
	public void NumberPow() {
		System.out.println(Math.pow(this.getW(), this.getZ()));
	}
	
	// Devuelve el mayor
	public void NumberMax() {
		System.out.println(Math.max(this.getW(), this.getY()));
	}
	
	// Devuelve la suma de dos valores
	public void NumExact() {
		System.out.println(Math.addExact(this.getZ(), this.getW()));
	}
	
	// Devuelve la suma de dos valores
	public void NumSubExact() {
		System.out.println(Math.subtractExact(this.getZ(), this.getW()));
	}
}
