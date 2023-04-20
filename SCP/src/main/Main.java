package main;

import view.LoginWindow;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {
		
		/*ControladorCochePropietario data = new ControladorCochePropietarioDBImplementation();
		
		VentaPrincipal vMain= new VentaPrincipal(data);
		vMain.setVisible(true);
		//ControladorVista vista= new ControladorVista();
		//vista.menu(datosProp);*/
		
		MainWindow vMain = new MainWindow();
		//vMain.pack();
		vMain.setVisible(true);
		
	}
	
}