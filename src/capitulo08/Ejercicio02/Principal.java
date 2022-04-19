package capitulo08.Ejercicio02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import javax.swing.JButton;

public class Principal {

	private JFrame frmGestinDeCentros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmGestinDeCentros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestinDeCentros = new JFrame();
		frmGestinDeCentros.setTitle("Gestión de centros educativos");
		frmGestinDeCentros.setBounds(100, 100, 450, 300);
		frmGestinDeCentros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmGestinDeCentros.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Gestión");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cursos");
		mnNewMenu.add(mntmNewMenuItem);
		
		JToolBar toolBar = new JToolBar();
		frmGestinDeCentros.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnCursos = new JButton("Cursos");
		toolBar.add(btnCursos);

	}

}
