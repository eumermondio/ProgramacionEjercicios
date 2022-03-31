package capitulo08.Ejercicio01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class EjemplosJTabbedPane {

	/**
	 * 
	 * @return
	 */
	public static JTabbedPane getPanelesTabulados() {

		JTabbedPane tabPanel = new JTabbedPane();
		ImageIcon icono = new ImageIcon("./src/capitulo08/Ejercicio01/res/check.png");
		;

		JPanel panelVerde = new JPanel();
		panelVerde.setBackground(Color.GREEN);

		JPanel panelRojo = new JPanel();
		panelRojo.setBackground(Color.RED);

		tabPanel.addTab("Pestaña 01", icono, CRUD_Fabricante.getInstance(), "Panel verde");
		tabPanel.addTab("Pestaña 02", icono, new PanelConCheckBox(), "Panel rojo");
		tabPanel.addTab("Pestaña 02", icono, new PanelConComboBoxDeFabricante(), "Panel rojo");
		tabPanel.setSelectedIndex(0);

		return tabPanel;
	}

}
