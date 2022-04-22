package capitulo08.Ejercicio01;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Tabs {

	/**
	 * 
	 * @return
	 */
	public static JTabbedPane getPanelesTabulados() {

		JTabbedPane tabPanel = new JTabbedPane();
		ImageIcon fab = new ImageIcon("./src/capitulo08/Ejercicio01/res/renault.png");
		ImageIcon coche = new ImageIcon("./src/capitulo08/Ejercicio01/res/coche.png");
		ImageIcon conce = new ImageIcon("./src/capitulo08/Ejercicio01/res/conce.png");
		ImageIcon cli = new ImageIcon("./src/capitulo08/Ejercicio01/res/cliente.png");
		ImageIcon venta = new ImageIcon("./src/capitulo08/Ejercicio01/res/venta.png");

		tabPanel.addTab("Gestión de Fabricantes", fab, GestionFabricante.getInstance(), "Gestión de Fabricantes");
		tabPanel.addTab("Gestión de Coches", coche, GestionCoche.getInstance(), "Gestión de Coches");
		tabPanel.addTab("Gestión de Concesionarios", conce, GestionConcesionario.getInstance(),
				"Gestión de Concesionarios");
		tabPanel.addTab("Gestión de Clientes", cli, GestionCliente.getInstance(), "Gestión de Clientes");
		tabPanel.addTab("Gestión de Ventas", venta, GestionVenta.getInstance(), "Gestión de Ventas");
		tabPanel.setSelectedIndex(0);

		return tabPanel;
	}

}
