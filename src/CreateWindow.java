import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class CreateWindow extends JDialog implements 
		ActionListener, ItemListener {
		
	final String [] heroList = {
			"Legacy", "The Wraith", "Haka"
	};
	
	final int [] hpList = {
			32, 26, 34
	};
	
    @SuppressWarnings("rawtypes")
	private JComboBox combobox = null;
    private JLabel display = null;  
    int currentHp1 = 0;
    int currentHp2 = 0;
    int currentHp3 = 0;

    public CreateWindow() {

    	//Skapar fönstret
    	JPanel mainWindow = new JPanel();
    	mainWindow.setLayout(new BoxLayout(mainWindow, BoxLayout.Y_AXIS));
        add(mainWindow);
        
        // Ett mellanrum
        mainWindow.add(Box.createRigidArea(new Dimension(0, 20)));

        // Skapar första raden (rowNo1)        
        JPanel rowNo1 = new JPanel();
        rowNo1.setLayout(new BoxLayout(rowNo1, BoxLayout.X_AXIS));
        
        // Skapar drop-downlistan med namn
        combobox = new JComboBox(heroList);
        combobox.setSelectedIndex(-1);
        combobox.setPreferredSize(new Dimension(200, 22));
        combobox.setMaximumSize(new Dimension(200, 22));
        combobox.addItemListener(this);
        rowNo1.add(combobox);
        
        // Ett mellanrum
        rowNo1.add(Box.createRigidArea(new Dimension(5, 0)));

        // Skapar ruta som visar currentHp
        display = new JLabel(String.valueOf(currentHp1), SwingConstants.CENTER);
        display.setPreferredSize(new Dimension(50, 22));
        display.setMaximumSize(new Dimension(50, 22));
        display.setBorder(BorderFactory.createCompoundBorder(
        		BorderFactory.createLineBorder(Color.black),
        		BorderFactory.createEmptyBorder(5,5,5,5)
        		));
        
        rowNo1.add(display);
      
        // Ett mellanrum
        rowNo1.add(Box.createRigidArea(new Dimension(5, 0)));
        
        // Skapa plus- och minus-knappar
        JButton addLife = new JButton("+");
        addLife.addActionListener(this);
        addLife.setActionCommand("plus");
        
        JButton looseLife = new JButton("-");
        looseLife.addActionListener(this);
        looseLife.setActionCommand("minus");
        
        rowNo1.add(addLife);
        rowNo1.add(Box.createRigidArea(new Dimension(5, 0)));
        rowNo1.add(looseLife);
                
        mainWindow.add(rowNo1);
        
        setTitle("SotM");
        setSize(500, 300);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CreateWindow();
    }

    // Lyssnar på + och - knapparna
    public void actionPerformed(ActionEvent e) {
    	 
    	 if (e.getActionCommand().equals("plus")) {
             currentHp1++;
             display.setText(String.valueOf(currentHp1));
             };
             
         if (e.getActionCommand().equals("minus")) {
             currentHp1--;
             display.setText(String.valueOf(currentHp1));
             };
         
     }

    public void itemStateChanged(ItemEvent e) {

        if (e.getStateChange() == ItemEvent.SELECTED) {
            JComboBox chosenHero = (JComboBox) e.getSource();
            int heroIndex = chosenHero.getSelectedIndex();
            currentHp1 = hpList[heroIndex];
            display.setText(String.valueOf(currentHp1));
        }

    }
}