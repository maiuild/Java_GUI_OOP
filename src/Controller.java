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
            if (model.checkIfFileExists()) {
                view.setFileNameLabel(model.getFilePath());
            }

            view.clearTextArea();
            view.appendTextArea(model.calculateSphere(sphereRadius));
            view.appendTextArea(model.calculateCylinder(cylinderRadius, cylinderHeight));
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
