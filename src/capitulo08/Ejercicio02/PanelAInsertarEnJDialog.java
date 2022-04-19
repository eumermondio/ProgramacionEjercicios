package capitulo08.Ejercicio02;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import capitulo08.Ejercicio01.ControladorCoche;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAInsertarEnJDialog extends JPanel {
	public static JButton btnNewButton;
	public static JButton btnNewButton_1;
	public static JButton btnNewButton_2;
	public static JButton btnNewButton_3;
	public static JButton btnNewButton_4;
	public static JButton btnNewButton_5;
	public static JButton btnNewButton_6;

	/**
	 * Create the panel.
	 */
	public PanelAInsertarEnJDialog() {
		setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		btnNewButton = new JButton("<<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionCurso.mostrarCurso(ControladorCurso.findPrimerCurso());
			}
		});
		// btnNewButton.setIcon(new
		// ImageIcon(PanelAInsertarEnJDialog.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/gotostart.png")));
		toolBar.add(btnNewButton);

		btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionCurso.mostrarCurso(
						ControladorCurso.findAnteriorCurso(Integer.parseInt(GestionCurso.jtfId.getText())));
			}
		});
		// btnNewButton_1.setIcon(new
		// ImageIcon(PanelAInsertarEnJDialog.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/previous.png")));
		toolBar.add(btnNewButton_1);

		btnNewButton_2 = new JButton(">");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionCurso.mostrarCurso(
						ControladorCurso.findSiguienteCurso(Integer.parseInt(GestionCurso.jtfId.getText())));
			}
		});
		// btnNewButton_2.setIcon(new
		// ImageIcon(PanelAInsertarEnJDialog.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/next.png")));
		toolBar.add(btnNewButton_2);

		btnNewButton_3 = new JButton(">>");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionCurso.mostrarCurso(ControladorCurso.findUltimoCurso());
			}
		});
		// btnNewButton_3.setIcon(new
		// ImageIcon(PanelAInsertarEnJDialog.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/gotoend.png")));
		toolBar.add(btnNewButton_3);

		btnNewButton_4 = new JButton("Nuevo");
		// btnNewButton_4.setIcon(new
		// ImageIcon(PanelAInsertarEnJDialog.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/nuevo.png")));
		toolBar.add(btnNewButton_4);

		btnNewButton_5 = new JButton("Guardar");
		// btnNewButton_5.setIcon(new
		// ImageIcon(PanelAInsertarEnJDialog.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/guardar.png")));
		toolBar.add(btnNewButton_5);

		btnNewButton_6 = new JButton("Eliminar");
		// btnNewButton_6.setIcon(new
		// ImageIcon(PanelAInsertarEnJDialog.class.getResource("/tutorialJava/capitulo8_AWT_SWING/res/eliminar.png")));
		toolBar.add(btnNewButton_6);

		add(GestionCurso.getInstance(), BorderLayout.CENTER);

	}

}
