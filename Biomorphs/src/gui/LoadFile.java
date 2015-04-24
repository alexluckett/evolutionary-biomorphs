package gui;

import javax.swing.JButton;
import javax.swing.JFileChooser;

/**
 * Load the project into the application 
 * 
 * @author Nouman Mehmood <mehmoodn@aston.ac.uk>
 */

public class LoadFile {

	public LoadFile(){
	
	JButton open = new JButton();
	
	JFileChooser filechooser = new JFileChooser();
	filechooser.setCurrentDirectory	(new java.io.File("."));
	
	filechooser.setDialogTitle("Open your existing Biomorph Project");
	filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	
	if (filechooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION){
		
		//TODO functionality incomplete
		
	}
	
	/** Prints out what the user clicks on */
	System.out.println("You chose : " + filechooser.getSelectedFile().getAbsolutePath());
	
	}	
}