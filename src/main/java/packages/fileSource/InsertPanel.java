/**
 * @author Zoppellaro Filippo            @data 2024_05_13
 * Class that implements the insert panel.
 */
package packages.fileSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InsertPanel extends JPanel implements ActionListener {

    // #########################
    //         ATTRIBUTES
    // #########################
    //Panels declaration
    private JPanel panel;
    private JPanel nameLabelPanel;
    private JPanel nameTextFieldPanel;
    private JPanel ingredientsLabelPanel;
    private JPanel ingredientsPanel;
    private JPanel dishLabelPanel;
    private JPanel dishPanel;
    private JPanel dietLabelPanel;
    private JPanel dietPanel;

    //Label declaration
    private JLabel nameLabel;
    private JLabel ingredientsLabel;
    private JLabel dishLabel;
    private JLabel dietLabel;

    //Component declaration
    private JTextField nameTextField;
    private JComboBox dishComboBox;
    private JRadioButton[] dietRadioButton;
    private ButtonGroup dietGroup;
    private JCheckBox[] ingredientsCheckBox;
    private GridBagConstraints gbc;
    private JButton button;

    //Lists declaration
    private List<String> dish;
    private List<String> ingredientsList;

    //Attributes declaration
    private int line;

    // #########################
    //       CONSTRUCTORS
    // #########################

    /**
     * Constructor
     */
    public InsertPanel() {
        //Set layout
        this.setLayout(new BorderLayout());

        //set panel and gridBagContainers
        this.panel = new JPanel();
        this.panel.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();
        this.gbc.insets = new Insets(5, 5, 5, 5);

        //panel whit label "Name"
        this.nameLabelPanel = new JPanel();
        this.nameLabel = new JLabel("Nome:");
        this.nameLabelPanel.add(nameLabel);
        this.gbc.gridx = 0;
        this.gbc.gridy = 0;
        this.panel.add(nameLabelPanel, gbc);

        //panel with text field for insert name
        this.nameTextFieldPanel = new JPanel();
        this.nameTextField = new JTextField();
        this.nameTextField.setPreferredSize(new Dimension(200, 20));
        this.nameTextFieldPanel.add(nameTextField);
        this.gbc.gridx = 1;
        this.gbc.gridy = 0;
        this.panel.add(nameTextFieldPanel, gbc);

        // panel with label "Ingredients"
        this.ingredientsLabelPanel = new JPanel();
        this.ingredientsLabel = new JLabel("Ingredienti: ");
        this.ingredientsLabelPanel.add(ingredientsLabel);
        this.gbc.gridx = 0;
        this.gbc.gridy = 1;
        this.panel.add(ingredientsLabelPanel, gbc);

        //panel whit checkBox of ingredients + list
        this.ingredientsList = new ArrayList<>();
        try {
            this.line = leggiDaFile("C://Users//ACER//IdeaProjects//FestaZF//ingredienti.txt");
        } catch (IOException e) {}
        this.ingredientsPanel = new JPanel(new GridLayout(line, 1));
        this.ingredientsCheckBox = new JCheckBox[line];
        int i = 0;
        for (String s : ingredientsList) {
            this.ingredientsCheckBox[i] = new JCheckBox(s);
            this.ingredientsPanel.add(ingredientsCheckBox[i]);
            i++;
        }
        this.gbc.gridx = 1;
        this.gbc.gridy = 1;
        this.panel.add(ingredientsPanel, gbc);

        // panel whit label for preferred cousin
        this.dishLabelPanel = new JPanel();
        this.dishLabel = new JLabel("Cucina preferita: ");
        this.dishLabelPanel.add(dishLabel);
        this.gbc.gridx = 0;
        this.gbc.gridy = 2;
        this.panel.add(dishLabelPanel, gbc);

        //panel whit comboBox for choose the preferred cousin + list
        this.dishPanel = new JPanel();
        this.dish = new ArrayList<>();
        add(dish);
        this.dishComboBox = new JComboBox<>(dish.toArray(new String[0]));
        this.dishPanel.add(dishComboBox);
        this.gbc.gridx = 1;
        this.gbc.gridy = 2;
        this.panel.add(dishPanel, gbc);

        // panel with label "diet"
        this.dietLabelPanel = new JPanel();
        this.dietLabel = new JLabel("Dieta: ");
        this.dietLabelPanel.add(dietLabel);
        this.gbc.gridx = 0;
        this.gbc.gridy = 3;
        this.panel.add(dietLabelPanel, gbc);

        //panel with radioButton for choose diet + buttonGroup
        this.dietPanel = new JPanel();
        this.dietRadioButton = new JRadioButton[3];
        addRadio(dietRadioButton);
        this.dietGroup = new ButtonGroup();
        for (JRadioButton r : dietRadioButton) {
            this.dietGroup.add(r);
            this.dietPanel.add(r);
        }
        this.gbc.gridx = 1;
        this.gbc.gridy = 3;
        this.panel.add(dietPanel, gbc);

        //add panel to principal in center
        this.add(panel, BorderLayout.CENTER);

        //button creation and settings
        this.button = new JButton("SALVA");
        this.button.addActionListener(this);
        this.button.setPreferredSize(new Dimension(75,20));

        //add button in south
        this.add(button, BorderLayout.SOUTH);
    }

    // #########################
    //          METHODS
    // #########################

    /**
     * Method that implement interface ActionListener
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        JButton butt = (JButton) e.getSource();
        try {
            save();
        } catch (IOException ex) {}
        resetFields();
    }

        //*****************
        //     PRIVATE
        //*****************

    /**
     * Private method that permit to read the information from a file
     * @param pathName
     * @return numbers of lines that is read
     * @throws IOException
     */
    private int leggiDaFile(String pathName) throws IOException {
        String line;
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {
            while ((line = br.readLine()) != null) {
                if (line.startsWith("I")) {
                    this.ingredientsList.add(line.substring(2));
                    i++;
                }
            }
        }
        return i;
    }

    /**
     * Private method that permit to set the list of preferred cousin
     * @param list
     */
    private void add(List<String> list) {
        list.add("italiana");
        list.add("francese");
        list.add("inglese");
        list.add("spagnola");
        list.add("giapponese");
        list.add("vietnamita");
    }

    /**
     * Private method that permit to set radioButton information
     * @param radioButtons
     */
    private void addRadio(JRadioButton[] radioButtons) {
        radioButtons[0] = new JRadioButton("vegana");
        radioButtons[1] = new JRadioButton("vegetariana");
        radioButtons[2] = new JRadioButton("entrambe");
    }

    /**
     * Private method that permit to save all information into a specific file
     */
    private void save() throws IOException {
        // Ottieni il nome inserito dall'utente
        String name = nameTextField.getText();

        // Ottieni gli ingredienti selezionati dall'utente
        List<String> selectedIngredients = new ArrayList<>();
        for (JCheckBox checkBox : this.ingredientsCheckBox) {
            if (checkBox != null && checkBox.isSelected()) {
                selectedIngredients.add(checkBox.getText());
            }
        }

        // Ottieni la cucina preferita selezionata dall'utente
        String selectedCuisine = (String) dishComboBox.getSelectedItem();

        // Ottieni la dieta selezionata dall'utente
        String selectedDiet = "";
        for (JRadioButton radioButton : dietRadioButton) {
            if (radioButton.isSelected()) {
                selectedDiet = radioButton.getText();
                break;
            }
        }

        // Costruisci la stringa di informazioni
        String info = "Nome: " + name + ", Ingredienti: " + selectedIngredients.toString() + ", Cucina preferita: " + selectedCuisine + ", Dieta: " + selectedDiet;

        // Aggiungi le informazioni alla lista di persone nella classe Data
        Data.persons.add(info);

        scriviSuFile ("file.txt", info);
    }

    /**
     * Method that permit to append in the file the new information
     * @param pathName
     * @param info
     * @throws IOException
     */
    private void scriviSuFile (String pathName, String info) throws IOException {
        try (FileWriter out = new FileWriter(pathName,true)){
            out.write("\n" + info);
            out.flush();
        }
    }

    /**
     * Private method that resets all input fields
     */
    private void resetFields() {
        // Reset the name text field
        nameTextField.setText("");

        // Reset all ingredient check boxes
        for (JCheckBox checkBox : ingredientsCheckBox) {
            if (checkBox != null) {
                checkBox.setSelected(false);
            }
        }

        // Reset the cuisine combo box
        dishComboBox.setSelectedIndex(0);

        // Reset all diet radio buttons
        dietGroup.clearSelection();
    }
}
