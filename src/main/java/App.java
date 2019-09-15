import javax.swing.*;
import java.io.IOException;

public class App {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JPanel manualEntryPanel;
    private JPanel homePanel;
    private JLabel manualEntryLabel;
    private JLabel sourceLabel;
    private JLabel destinationLabel;
    private JButton selectDestinationButton;
    private JComboBox sourceComboBox;
    private JButton createButton;

    private ResultsMaster resultsMaster;

    private App() {
        resultsMaster = new ResultsMaster();

        createButton.addActionListener(e -> {
            switch (e.getActionCommand()) {
                case "Create":
                    System.out.println("Create");
                    try {
                        resultsMaster.gopherStateEvents();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;

                case "Select Destination":
                    System.out.println("Select Destination");
                    break;
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ResultsMaster");
        frame.setContentPane(new App().panel1);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
