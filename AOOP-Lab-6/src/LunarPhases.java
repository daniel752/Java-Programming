
//v 1.3
import org.w3c.dom.events.EventException;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.*;

public class LunarPhases
{
	// main method
    public static void main(String[] args)
	{

    	// Create a frame and container for the panels.
		myFrame lunarPhasesFrame = new myFrame("Lunar Phases");
	
	    // Exit when the window is closed.
	    lunarPhasesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		// Show the converter.
		lunarPhasesFrame.setSize(300,600);
		lunarPhasesFrame.setVisible(true);
    }
}

class myFrame extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	final static int NUM_IMAGES = 8;
    final static int START_INDEX = 3;
    final static String IMAGES_PATH = "C:/Program Files/"; //TODO insert Path
    final static String IMAGES_SUFIX = ".gif";
    final static String COMBO_BOX_CHANGED_COMMAND = "comboBoxChanged";
    final static String[] PHASES = { "New", "Waxing Crescent", "First Quarter", 
    								 "Waxing Gibbous", "Full", "Waning Gibbous",
    								 "Third Quarter", "Waning Crescent" };
    private Image[] images;
    JPanel mainPanel, selectPanel;
    myPanel displayPanel;
    JComboBox<String> phaseChoices;

    // Constructor
    public myFrame(String title)
	{
    	super(title);
		// Create the main panel to contain the two sub panels.
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2,1));

		// Create the phase selection and display panels.
		phaseChoices = new JComboBox<String>(PHASES);
		selectPanel = new JPanel();
		displayPanel = new myPanel();
		selectPanel.add(phaseChoices);

		// Add the select and display panels to the main panel.
		selectPanel.setSize(200,200);
		displayPanel.setSize(200,200);
		mainPanel.add(selectPanel);
		mainPanel.add(displayPanel);

		// Create combo box with lunar phase choices.

	    // Add border around the select panel.
		selectPanel.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createTitledBorder("Select Phase"),
			BorderFactory.createEmptyBorder(5,5,5,5)));

		// Add moon phases combo box to select panel and image label to displayPanel.
		selectPanel.add(phaseChoices);

		// Listen to events from combo box.
		phaseChoices.addActionListener(this);

		// Load images.
		loadImages();

		// Set the start image
		displayPanel.setImage(images[START_INDEX]);
		this.add(mainPanel);
    }

    // Load images of the phases of the moon.
    private void loadImages()
	{
    	images = new Image[NUM_IMAGES];
    	
		// Get the images and put them into an array of ImageIcon.
		for (int i = 0; i < NUM_IMAGES; i++) {
		    String imageName = IMAGES_PATH + i + IMAGES_SUFIX;
		    	try {
					images[i] = ImageIO.read(new File(imageName));
				} 
		    	catch (IOException e) {
					e.printStackTrace();
				}
		}
    }
    
    // Implementation of ActionListener interface.
    @Override
    public void actionPerformed(ActionEvent event)
	{
		JComboBox jComboBox = (JComboBox)event.getSource();
		int cuurIndex = jComboBox.getSelectedIndex();
		displayPanel.setImage(images[cuurIndex]);
		repaint();
    }
}
    
class myPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Image image;

	public myPanel()
	{
		
		// Add border around the display panel.
		setBorder(BorderFactory.createLoweredBevelBorder());
		
		setBorder(BorderFactory.createCompoundBorder(
			    BorderFactory.createEmptyBorder(10,40,10,40),
			    getBorder()));
		
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Display Phase"),
			    getBorder()));
			
		image = null;
    }
	
	public void setImage(Image img)
	{
		image = img;
	}

	public void paintComponent(Graphics g)
	{
		// TODO
		// to use function drawImage(image, x, y, w, h, this)
		super.paintComponent(g);
		g.drawImage(image,45,30,195,235,this);
	}
}
