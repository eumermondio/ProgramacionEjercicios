package examenes.examen20220516;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PanelJFileChooserFicheroImagen extends JPanel {
	private JScrollPane scrollPane;
	public static byte[] imagenEnArrayDeBytes;
	private int ancho;
	private int alto;

	/**
	 * Create the panel.
	 */
	public PanelJFileChooserFicheroImagen() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);

		JButton btnSeleccionaFichero = new JButton("Selecciona fichero");
		btnSeleccionaFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaImagen();
			}
		});
		GridBagConstraints gbc_btnSeleccionaFichero = new GridBagConstraints();
		gbc_btnSeleccionaFichero.insets = new Insets(0, 0, 0, 5);
		gbc_btnSeleccionaFichero.gridx = 1;
		gbc_btnSeleccionaFichero.gridy = 2;
		add(btnSeleccionaFichero, gbc_btnSeleccionaFichero);

	}

	/**
	 * 
	 */
	public void seleccionaImagen() {
		JFileChooser jfileChooser = new JFileChooser();

		// Configurando el componente

		// Tipo de selección que se hace en el diálogo
		jfileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // Sólo selecciona ficheros

		// Filtro del tipo de ficheros que puede abrir
		jfileChooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png *.gif";
			}

			@Override
			public boolean accept(File f) {
				if (f.isDirectory()
						|| (f.isFile() && (f.getAbsolutePath().endsWith(".jpg") || f.getAbsolutePath().endsWith(".jpeg")
								|| f.getAbsolutePath().endsWith(".png") || f.getAbsolutePath().endsWith(".gif"))))
					return true;
				return false;
			}
		});

		// Abro el diálogo para la elección del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);

		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = jfileChooser.getSelectedFile();

			if (fichero.isFile()) {
				try {
					this.imagenEnArrayDeBytes = Files.readAllBytes(fichero.toPath());
					setImagenEnArrayDeBytes(imagenEnArrayDeBytes);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	/**
	 * @return the scrollPane
	 */
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	/**
	 * @param scrollPane the scrollPane to set
	 */
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	/**
	 * @return the imagenEnArrayDeBytes
	 */
	public byte[] getImagenEnArrayDeBytes() {
		return imagenEnArrayDeBytes;
	}

	/**
	 * @param imagenEnArrayDeBytes the imagenEnArrayDeBytes to set
	 */
	public void setImagenEnArrayDeBytes(byte[] imagenEnArrayDeBytes) {
		this.imagenEnArrayDeBytes = imagenEnArrayDeBytes;
		if (imagenEnArrayDeBytes != null && imagenEnArrayDeBytes.length > 0) {
			ImageIcon icono = new ImageIcon(imagenEnArrayDeBytes);
			setAlto(icono.getIconHeight());
			setAncho(icono.getIconWidth());
			JLabel lblIcono = new JLabel(icono);
			scrollPane.setViewportView(lblIcono);

		} else {
			JLabel lblIcono = new JLabel("Sin imagen");
			scrollPane.setViewportView(lblIcono);
		}
	}

	/**
	 * @return the ancho
	 */
	public int getAncho() {
		return ancho;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	/**
	 * @return the alto
	 */
	public int getAlto() {
		return alto;
	}

	/**
	 * @param alto the alto to set
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}

}
