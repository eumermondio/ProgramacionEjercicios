package capitulo04.bloque02herencia.ventanaConCanvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class MiCanvas extends Canvas {
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(20, 20, 200, 100);
		g.setColor(Color.GREEN);
		g.fillOval(200, 200, 100, 100);
		g.setColor(Color.BLUE);
		int[] x = { 700, 400, 500 }; // 500 = punta de arriba // 400 = punta de la izquierda // 700 punta de la derecha
		int[] y = { 300, 300, 100 }; // 100 = punta de arriba // 300 = punta de la izquierda // 300 punta de la derecha
		g.fillPolygon(x, y, 3);
	}
}
