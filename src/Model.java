import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Model {
    private static final String FILE_NAME = "JavaKujundid.txt";

    public static boolean isNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String calculateSphere(String sphereRadius) {
        if (isNumber(sphereRadius)) {
            int radius = Integer.parseInt(sphereRadius);
            Sphere sphere = new Sphere(radius);
            appendToFile(sphere.sphereValuesToTxtFile());
            return sphere.sphereValues();
        }
        return null;
    }

    public String calculateCylinder(String cylinderRadius, String cylinderHeight) {
        if (isNumber(cylinderRadius) && isNumber(cylinderHeight)) {
            int radius = Integer.parseInt(cylinderRadius);
            int height = Integer.parseInt(cylinderHeight);
            Cylinder cylinder = new Cylinder(radius, height);
            appendToFile(cylinder.cylinderValuesToTxtFile());
            return cylinder.cylinderValues();
        }
        return null;
    }

    public boolean checkIfFileExists() {
        return new File(FILE_NAME).exists();
    }

    public String getFilePath() {
        return new File(FILE_NAME).getAbsolutePath();
    }

    private void appendToFile(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(text);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
