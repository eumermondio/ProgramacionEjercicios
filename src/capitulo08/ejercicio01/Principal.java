package capitulo08.ejercicio01;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Principal {
	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}

	public static void main(String[] args) {
		ImageIcon img = new ImageIcon("./src/capitulo08/Ejercicio01/res/coche.png");
		JFrame ventana = new JFrame("Gestión general");
		ventana.getContentPane().setLayout(new BorderLayout());
		ventana.getContentPane().add(Tabs.getPanelesTabulados(), BorderLayout.CENTER);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setIconImage(img.getImage());

		ventana.setBounds(0, 0, 800, 600);
		ventana.setVisible(true);

	}

}
