package main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import view.LoginWindow;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {
		
		/*UIManager um=new UIManager();
		 um.put("OptionPane.background",Color.black);
		 um.put("OptionPane.messageForeground",Color.white);
		 um.put("Panel.background",Color.black);
		 um.put("OptionPane.messageFont", new FontUIResource(new Font(  
				 "OCR A EXTENDED", Font.BOLD, 16)));
		/* um.put("ComboBox.background", new ColorUIResource(Color.black));
		 um.put("JTextField.background", new ColorUIResource(Color.yellow));
		 um.put("ComboBox.selectionBackground", new ColorUIResource(Color.magenta));
		 um.put("ComboBox.selectionForeground", new ColorUIResource(Color.blue));*/
	   

		
		LoginWindow vMain = new LoginWindow();
		vMain.setVisible(true);
		
	}
	
}