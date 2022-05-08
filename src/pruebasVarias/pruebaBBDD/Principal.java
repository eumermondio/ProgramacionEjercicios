package pruebasVarias.pruebaBBDD;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import pruebasVarias.pruebaBBDD.controladores.Controlador;
import pruebasVarias.pruebaBBDD.entidades.Idioma;
import pruebasVarias.pruebaBBDD.entidades.Pais;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;

public class Principal {

	private JFrame frmGestinDeCentros;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JCheckBox checkBox;
	private JTextField jtfEmail;
	private JTextField jtfUsuario;
	private JTextField jtfPass;
	private JTextField jtfPass2;
	private JComboBox<Pais> comboBoxPais;
	private JComboBox<Idioma> comboBoxIdioma;

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
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frmGestinDeCentros.getContentPane().setLayout(gridBagLayout);

		lblNewLabel = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frmGestinDeCentros.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 0;
		frmGestinDeCentros.getContentPane().add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);

		lblNewLabel_1 = new JLabel("Usuario:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		frmGestinDeCentros.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfUsuario = new JTextField();
		GridBagConstraints gbc_jtfUsuario = new GridBagConstraints();
		gbc_jtfUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUsuario.gridx = 1;
		gbc_jtfUsuario.gridy = 1;
		frmGestinDeCentros.getContentPane().add(jtfUsuario, gbc_jtfUsuario);
		jtfUsuario.setColumns(10);

		lblNewLabel_2 = new JLabel("Password:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		frmGestinDeCentros.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfPass = new JTextField();
		GridBagConstraints gbc_jtfPass = new GridBagConstraints();
		gbc_jtfPass.insets = new Insets(0, 0, 5, 0);
		gbc_jtfPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPass.gridx = 1;
		gbc_jtfPass.gridy = 2;
		frmGestinDeCentros.getContentPane().add(jtfPass, gbc_jtfPass);
		jtfPass.setColumns(10);

		lblNewLabel_3 = new JLabel("Repetición password:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		frmGestinDeCentros.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfPass2 = new JTextField();
		GridBagConstraints gbc_jtfPass2 = new GridBagConstraints();
		gbc_jtfPass2.insets = new Insets(0, 0, 5, 0);
		gbc_jtfPass2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPass2.gridx = 1;
		gbc_jtfPass2.gridy = 3;
		frmGestinDeCentros.getContentPane().add(jtfPass2, gbc_jtfPass2);
		jtfPass2.setColumns(10);

		lblNewLabel_4 = new JLabel("País:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		frmGestinDeCentros.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);

		comboBoxPais = new JComboBox<Pais>();
		comboBoxPais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarIdiomas();
			}
		});
		GridBagConstraints gbc_comboBoxPais = new GridBagConstraints();
		gbc_comboBoxPais.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxPais.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxPais.gridx = 1;
		gbc_comboBoxPais.gridy = 4;
		frmGestinDeCentros.getContentPane().add(comboBoxPais, gbc_comboBoxPais);

		lblNewLabel_5 = new JLabel("Idioma:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		frmGestinDeCentros.getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);

		comboBoxIdioma = new JComboBox<Idioma>();
		comboBoxIdioma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBox.setText(Controlador.traducirCheck(((Idioma) comboBoxIdioma.getSelectedItem())));
			}
		});
		GridBagConstraints gbc_comboBoxIdioma = new GridBagConstraints();
		gbc_comboBoxIdioma.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxIdioma.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxIdioma.gridx = 1;
		gbc_comboBoxIdioma.gridy = 5;
		frmGestinDeCentros.getContentPane().add(comboBoxIdioma, gbc_comboBoxIdioma);

		checkBox = new JCheckBox("New check box");
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.anchor = GridBagConstraints.WEST;
		gbc_checkBox.gridwidth = 2;
		gbc_checkBox.gridx = 0;
		gbc_checkBox.gridy = 6;
		frmGestinDeCentros.getContentPane().add(checkBox, gbc_checkBox);
		cargarPaises();
	}

	/**
	 * 
	 * @param c
	 */
	public void cargarPaises() {
		List<Pais> paises = new ArrayList<Pais>();
		Controlador.listadoPaises(paises);
		for (Pais p : paises) {
			comboBoxPais.addItem(p);
		}
	}

	/**
	 * 
	 * @param c
	 */
	public void cargarIdiomas() {
		List<Idioma> idiomas = new ArrayList<Idioma>();
		Pais p = (Pais) comboBoxPais.getSelectedItem();
		Controlador.listadoIdiomas(p, idiomas);
		comboBoxIdioma.removeAllItems();
		for (Idioma i : idiomas) {
			comboBoxIdioma.addItem(i);
		}
	}

}
