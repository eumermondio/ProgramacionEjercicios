package capitulo08.Ejercicio01;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Principal {

	public static void main(String[] args) {
		JFrame ventana = new JFrame("Gestión general");

		ventana.getContentPane().setLayout(new BorderLayout());
		ventana.getContentPane().add(Tabs.getPanelesTabulados(), BorderLayout.CENTER);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ventana.setBounds(0, 0, 850, 600);
		ventana.setVisible(true);

	}

}
