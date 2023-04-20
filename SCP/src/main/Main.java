package main;

import view.LogInWindow2;
import view.LoginWindow;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {
		
		/*ControladorCochePropietario data = new ControladorCochePropietarioDBImplementation();
		
		VentaPrincipal vMain= new VentaPrincipal(data);
		vMain.setVisible(true);
		//ControladorVista vista= new ControladorVista();
		//vista.menu(datosProp);*/
		
		LogInWindow2 vMain = new LogInWindow2();
		//vMain.pack();
		vMain.setVisible(true);
		
	}
	
}