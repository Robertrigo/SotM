import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class CreateWindow extends JDialog implements 
		ActionListener, ItemListener {
		
	final String [] heroList = {
			"Legacy", "The Wraith", "Haka"
	};
	
	final int [] hpList = {
			32, 26, 34
	};
	
//    final String[] images = {
//	"tolstoy.jpg", "galsworthy.jpg", "balzac.jpg", 
//    "zweig.jpg", "pasternak.jpg", "wolfe.jpg"
//    };

//    private JLabel display = null;  
    private JComboBox combobox = null;
    private JButton button = null;
    private JLabel display = null;  
    private int currentHp1 = 34;
    private int currentHp2 = 0;
    private int currentHp3 = 0;

 //   ImageIcon icon = new ImageIcon(
//		ClassLoader.getSystemResource("balzac.jpg"));

    public CreateWindow() {

    	JPanel mainWindow = new JPanel();
    	mainWindow.setLayout(new BoxLayout(mainWindow, BoxLayout.Y_AXIS));
        add(mainWindow);
         
        mainWindow.add(Box.createRigidArea(new Dimension(0, 20)));

        // Skapar första raden (rowNo1)        
        JPanel rowNo1 = new JPanel();
        rowNo1.setLayout(new BoxLayout(rowNo1, BoxLayout.X_AXIS));
        
        // Skapar drop-downlistan med namn
        combobox = new JComboBox(heroList);
        combobox.setSelectedIndex(-1);
        combobox.setPreferredSize(new Dimension(200, 22));
        combobox.setMaximumSize(new Dimension(140, 22));
        combobox.addItemListener(this);
        rowNo1.add(combobox);
        
        // Ett mellanrum
        rowNo1.add(Box.createRigidArea(new Dimension(5, 0)));

        // Skapar ruta som visar currentHp
        display = new JLabel(String.valueOf(currentHp1), SwingConstants.CENTER);
        display.setPreferredSize(new Dimension(50, 22));
        display.setMaximumSize(new Dimension(50, 22));
        display.setAlignmentX(Component.CENTER_ALIGNMENT);
        display.setBorder(LineBorder.createGrayLineBorder());
        rowNo1.add(display);
        
//        JPanel panel = new JPanel(new BorderLayout());
//        JLabel currentHp = new JLabel();
//        currentHp.setHorizontalAlignment(JLabel.CENTER);
               

//        panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        
//        rowNo1.add(currentHp);
        
        // Ett mellanrum
        rowNo1.add(Box.createRigidArea(new Dimension(5, 0)));
        
        // Skapa plus- och minus-knappar
        button = new JButton("Close");
        button.addActionListener(this);
        rowNo1.add(button);

        mainWindow.add(rowNo1);
        
        setTitle("JComboBox");
        setSize(500, 300);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CreateWindow();
    }


    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public void itemStateChanged(ItemEvent e) {

        if (e.getStateChange() == ItemEvent.SELECTED) {
            JComboBox combo = (JComboBox) e.getSource();
            int index = combo.getSelectedIndex();
            display.setIcon(new ImageIcon(
                ClassLoader.getSystemResource(images[index])));
        }

    }
}