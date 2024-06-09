public class Sphere {
    private final int radius;

    public Sphere(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public double getVolume() {
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public String sphereValues() {
        return String.format("Kera raadius: %d%nKera pindala: %.2f%nKera ümbermõõt: %.2f%nKera ruumala: %.2f%n",
                getRadius(), getSurfaceArea(), getCircumference(), getVolume());
    }

    public String sphereValuesToTxtFile() {
        return String.format("Kera;%d;%.2f;%.2f;%.2f",
                radius, getSurfaceArea(), getCircumference(), getVolume());
    }
}
