package main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import view.LoginWindow;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {
		
		 UIManager um=new UIManager();
		 um.put("OptionPane.background",Color.black);
		 um.put("OptionPane.messageForeground",Color.white);
		 um.put("Panel.background",Color.black);
		 um.put("OptionPane.messageFont", new FontUIResource(new Font(  
				 "OCR A EXTENDED", Font.BOLD, 16))); 
		 /*JOptionPane.showMessageDialog(null,"Hello","Set Color",
		 JOptionPane.INFORMATION_MESSAGE);*/
		
		LoginWindow vMain = new LoginWindow();
		vMain.setVisible(true);
	}
	
}