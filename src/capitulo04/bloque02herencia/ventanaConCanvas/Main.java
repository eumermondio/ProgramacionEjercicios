package capitulo04.bloque02herencia.ventanaConCanvas;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		MiCanvas canvas = new MiCanvas();
		JFrame ventana = new JFrame("Titulo");
		ventana.setBounds(0, 0, 800, 600);
		ventana.getContentPane().setLayout(new BorderLayout());
		ventana.getContentPane().add(canvas, BorderLayout.CENTER);
		ventana.setVisible(true);

	}

}
