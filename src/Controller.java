import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setCalculateButtonListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String sphereRadius = view.getSphereRadiusText();
            String cylinderRadius = view.getCylinderRadiusText();
            String cylinderHeight = view.getCylinderHeightText();

            validateAndCalculate(sphereRadius, cylinderRadius, cylinderHeight);

            // Calculate values and update GUI
            view.clearTextArea();
            view.appendTextArea(model.calculateSphere(sphereRadius));
            view.appendTextArea(model.calculateCylinder(cylinderRadius, cylinderHeight));

            // Check if the file exists and update file path label in the view
            if (model.checkIfFileExists()) {
                view.setFileNameLabelText(model.getFilePath());
            }
        }

        private void validateAndCalculate(String sphereRadius, String cylinderRadius, String cylinderHeight) {
            view.setSphereRadiusError(validateInput(sphereRadius));
            view.setCylinderRadiusError(validateInput(cylinderRadius));
            view.setCylinderHeightError(validateInput(cylinderHeight));
        }

        private String validateInput(String input) {
            return Model.isNumber(input) ? "" : "Sisesta arv!";
        }
    }
}
