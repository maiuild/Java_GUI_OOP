import javax.swing.*;

public class App {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();

        if (model.checkIfFileExists()) {
            view.setFileNameLabelText(model.getFilePath());
        }

        new Controller(model, view);

        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
