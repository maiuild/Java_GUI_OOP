import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private final JButton btnCalculate;
    private final JTextField sphereRadius;
    private final JTextField cylinderRadius;
    private final JTextField cylinderHeight;
    private final JTextArea txtArea;
    private final JLabel sphereRadiusError;
    private final JLabel cylinderRadiusError;
    private final JLabel cylinderHeightError;
    private final JLabel fileNameLabel; // Changed to JLabel

    public View() {
        super("OOP Kujundid GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600)); // Increased window size for better visibility

        // Create components
        btnCalculate = new JButton("Arvuta");
        sphereRadius = new JTextField(10);
        cylinderRadius = new JTextField(10);
        cylinderHeight = new JTextField(10);
        txtArea = new JTextArea(20, 60); // Increase text area size
        txtArea.setFont(new Font("Courier", Font.PLAIN, 14));
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.setEditable(false); // Make the text area non-editable
        sphereRadiusError = new JLabel("");
        sphereRadiusError.setForeground(Color.RED);
        cylinderRadiusError = new JLabel("");
        cylinderRadiusError.setForeground(Color.RED);
        cylinderHeightError = new JLabel("");
        cylinderHeightError.setForeground(Color.RED);
        fileNameLabel = new JLabel(""); // Changed to JLabel

        // Top panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS)); // Changed to BoxLayout
        JLabel titleLabel = new JLabel("Kujundite arvutus");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 16));
        JLabel instructionLabel = new JLabel("Sisesta kujundite vajalikud algandmed ning vajuta \"Arvuta\"");
        topPanel.add(titleLabel);
        topPanel.add(instructionLabel);
        topPanel.add(btnCalculate);

        // Center panel with GridLayout
        JPanel centerPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        centerPanel.add(new JLabel("Kera raadius:"));
        centerPanel.add(sphereRadius);
        centerPanel.add(new JLabel(""));
        centerPanel.add(sphereRadiusError);
        centerPanel.add(new JLabel("Silindri raadius:"));
        centerPanel.add(cylinderRadius);
        centerPanel.add(new JLabel(""));
        centerPanel.add(cylinderRadiusError);
        centerPanel.add(new JLabel("Silindri kõrgus:"));
        centerPanel.add(cylinderHeight);
        centerPanel.add(new JLabel(""));
        centerPanel.add(cylinderHeightError);
        centerPanel.add(new JLabel("Faili asukoht:"));
        centerPanel.add(fileNameLabel);

        // Bottom panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JScrollPane scrollPane = new JScrollPane(txtArea);
        scrollPane.setPreferredSize(new Dimension(750, 300)); // Increase scroll pane size
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        // Adding all panels to the frame
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Center the window
    }

    public void setCalculateButtonListener(ActionListener actionListener) {
        btnCalculate.addActionListener(actionListener);
    }

    public String getSphereRadiusText() {
        return sphereRadius.getText();
    }

    public String getCylinderRadiusText() {
        return cylinderRadius.getText();
    }

    public String getCylinderHeightText() {
        return cylinderHeight.getText();
    }

    public void setSphereRadiusError(String error) {
        sphereRadiusError.setText(error);
    }

    public void setCylinderRadiusError(String error) {
        cylinderRadiusError.setText(error);
    }

    public void setCylinderHeightError(String error) {
        cylinderHeightError.setText(error);
    }

    public void setFileNameLabelText(String text) {
        fileNameLabel.setText(text);
    }

    public void clearTextArea() {
        txtArea.setText("");
    }

    public void appendTextArea(String text) {
        txtArea.append(text);
    }
}
