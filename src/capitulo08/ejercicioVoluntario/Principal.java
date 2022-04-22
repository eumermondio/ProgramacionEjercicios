package capitulo08.ejercicioVoluntario;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import capitulo08.Ejercicio02.controladores.ControladorMateria;
import capitulo08.Ejercicio02.entidades.Curso;
import capitulo08.Ejercicio02.entidades.Materia;
import capitulo08.Ejercicio02.vista.PanelAInsertarEnJDialog;
import capitulo08.ejercicioVoluntario.controladores.Controlador;
import capitulo08.ejercicioVoluntario.entidades.Municipio;
import capitulo08.ejercicioVoluntario.entidades.Provincia;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;

public class Principal {

	private JFrame frmGestinDeCentros;
	private JTextField jtfFiltro;
	private JTextField jtfMunicipio;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JComboBox<Municipio> comboBoxMunicipio;
	private List<Municipio> lista = new ArrayList<Municipio>();
	private JComboBox<Provincia> comboBoxProvincia;
	private JButton btnNewButton_2;

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
		frmGestinDeCentros.setTitle("Gestión de municipios");
		frmGestinDeCentros.setBounds(100, 100, 450, 300);
		frmGestinDeCentros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		frmGestinDeCentros.getContentPane().setLayout(gridBagLayout);

		jtfFiltro = new JTextField();
		GridBagConstraints gbc_jtfFiltro = new GridBagConstraints();
		gbc_jtfFiltro.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFiltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFiltro.gridx = 0;
		gbc_jtfFiltro.gridy = 0;
		frmGestinDeCentros.getContentPane().add(jtfFiltro, gbc_jtfFiltro);
		jtfFiltro.setColumns(10);

		btnNewButton = new JButton("Filtrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarListaFiltrada();
				comboBoxMunicipio.showPopup();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		frmGestinDeCentros.getContentPane().add(btnNewButton, gbc_btnNewButton);

		comboBoxMunicipio = new JComboBox<Municipio>();
		GridBagConstraints gbc_comboBoxMunicipio = new GridBagConstraints();
		gbc_comboBoxMunicipio.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMunicipio.gridx = 0;
		gbc_comboBoxMunicipio.gridy = 1;
		frmGestinDeCentros.getContentPane().add(comboBoxMunicipio, gbc_comboBoxMunicipio);

		btnNewButton_1 = new JButton("Seleccionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Municipio m = new Municipio();
				if (comboBoxMunicipio.getSelectedIndex() != -1) {
					m.setId(((Municipio) comboBoxMunicipio.getSelectedItem()).getId());
					m.setIdProvincia(((Municipio) comboBoxMunicipio.getSelectedItem()).getIdProvincia());
					m.setCodMunicipio(((Municipio) comboBoxMunicipio.getSelectedItem()).getCodMunicipio());
					m.setNombre(((Municipio) comboBoxMunicipio.getSelectedItem()).getNombre());
					jtfMunicipio.setText(m.getNombre());
				} else {
					jtfMunicipio.setText("");
				}
				mostrarProvinciaDeUnMunicipio(m);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 1;
		frmGestinDeCentros.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Municipio seleccionado");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		frmGestinDeCentros.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		frmGestinDeCentros.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel_1 = new JLabel("Nombre del municipio:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfMunicipio = new JTextField();
		GridBagConstraints gbc_jtfMunicipio = new GridBagConstraints();
		gbc_jtfMunicipio.insets = new Insets(0, 0, 5, 0);
		gbc_jtfMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfMunicipio.gridx = 1;
		gbc_jtfMunicipio.gridy = 0;
		panel.add(jtfMunicipio, gbc_jtfMunicipio);
		jtfMunicipio.setColumns(10);

		JLabel lblProvinciaDelMunicipio = new JLabel("Provincia del municipio:");
		GridBagConstraints gbc_lblProvinciaDelMunicipio = new GridBagConstraints();
		gbc_lblProvinciaDelMunicipio.anchor = GridBagConstraints.EAST;
		gbc_lblProvinciaDelMunicipio.insets = new Insets(0, 0, 5, 5);
		gbc_lblProvinciaDelMunicipio.gridx = 0;
		gbc_lblProvinciaDelMunicipio.gridy = 1;
		panel.add(lblProvinciaDelMunicipio, gbc_lblProvinciaDelMunicipio);

		comboBoxProvincia = new JComboBox<Provincia>();
		GridBagConstraints gbc_comboBoxProvincia = new GridBagConstraints();
		gbc_comboBoxProvincia.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxProvincia.gridx = 1;
		gbc_comboBoxProvincia.gridy = 1;
		panel.add(comboBoxProvincia, gbc_comboBoxProvincia);

		btnNewButton_2 = new JButton("Guardar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Municipio m = new Municipio();
				m.setId(((Municipio) comboBoxMunicipio.getSelectedItem()).getId());
				m.setIdProvincia(((Provincia) comboBoxProvincia.getSelectedItem()).getId());
				m.setCodMunicipio(((Municipio) comboBoxMunicipio.getSelectedItem()).getCodMunicipio());
				m.setNombre(jtfMunicipio.getText());
				guardarDatos(m);
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 2;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		cargarProvincias();
	}

	/**
	 * 
	 */
	public void guardarDatos(Municipio m) {
		if (Controlador.guardarDatos(m) == 1)
			JOptionPane.showMessageDialog(null, "Actualización correcta", "Gestion de municipios",
					JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * 
	 * @param c
	 */
	public void cargarProvincias() {
		List<Provincia> provincias = new ArrayList<Provincia>();
		Controlador.listadoProvincias(provincias);
		for (Provincia p : provincias) {
			comboBoxProvincia.addItem(p);
		}
	}

	/**
	 * 
	 */
	public void cargarListaFiltrada() {
		comboBoxMunicipio.removeAllItems();
		lista.clear();
		Controlador.filtrarMunicipio(jtfFiltro.getText(), lista);
		for (Municipio m : lista) {
			comboBoxMunicipio.addItem(m);
		}
	}

	public void mostrarProvinciaDeUnMunicipio(Municipio m) {
		for (int i = 0; i < comboBoxProvincia.getItemCount(); i++) {
			if (comboBoxProvincia.getItemAt(i).getId() == m.getIdProvincia()) {
				comboBoxProvincia.setSelectedIndex(i);
			}
		}
	}

}
