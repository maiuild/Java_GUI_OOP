public class Cylinder {
    private final int radius;
    private final int height;

    public Cylinder(int radius, int height) {
        this.radius = radius;
        this.height = height;
    }

    public int getRadius() {
        return radius;
    }

    public int getHeight() {
        return height;
    }

    public double getTotalSurfaceArea() {
        double baseArea = 2 * Math.PI * Math.pow(radius, 2);
        double lateralArea = 2 * Math.PI * radius * height;
        return baseArea + lateralArea;
    }

    public double getLateralSurfaceArea() {
        return 2 * Math.PI * radius * height;
    }

    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    public String cylinderValues() {
        return String.format("Silindri raadius: %d%nSilindri kõrgus: %d%nSilindri pindala: %.2f%nSilindri külgpindala: %.2f%nSilindri ruumala: %.2f%n",
                getRadius(), getHeight(), getTotalSurfaceArea(), getLateralSurfaceArea(), getVolume());
    }

    public String cylinderValuesToTxtFile() {
        return String.format("Silinder;%d;%d;%.2f;%.2f;%.2f",
                radius, height, getTotalSurfaceArea(), getLateralSurfaceArea(), getVolume());
    }
}
