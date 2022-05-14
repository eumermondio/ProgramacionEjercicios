package examenes.examen20220516;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JOptionPane;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import examenes.examen20220509.controladores.Controlador;
import examenes.examen20220509.entidades.Idioma;
import examenes.examen20220509.entidades.Pais;
import examenes.examen20220509.entidades.Usuario;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import javax.swing.JCheckBox;

public class PrincipalRelleno {

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
	private JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalRelleno window = new PrincipalRelleno();
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
	public PrincipalRelleno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestinDeCentros = new JFrame();
		frmGestinDeCentros.setTitle("Examen Cristian");
		frmGestinDeCentros.setBounds(100, 100, 450, 300);
		frmGestinDeCentros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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
				checkBox.setText(Controlador.traduccionChkBox((Idioma) comboBoxIdioma.getSelectedItem()));
			}
		});
		GridBagConstraints gbc_comboBoxIdioma = new GridBagConstraints();
		gbc_comboBoxIdioma.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxIdioma.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxIdioma.gridx = 1;
		gbc_comboBoxIdioma.gridy = 5;
		frmGestinDeCentros.getContentPane().add(comboBoxIdioma, gbc_comboBoxIdioma);

		checkBox = new JCheckBox("");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGuardar.setEnabled(!btnGuardar.isEnabled());
			}
		});
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox.anchor = GridBagConstraints.WEST;
		gbc_checkBox.gridwidth = 2;
		gbc_checkBox.gridx = 0;
		gbc_checkBox.gridy = 6;
		frmGestinDeCentros.getContentPane().add(checkBox, gbc_checkBox);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobarEmail() && comprobarUsuario() && comprobarPass() && comprobarPassRepetida()
						&& comprobarUsuarioBBDD()) {
					Usuario u = new Usuario();
					u.setEmail(jtfEmail.getText());
					u.setUsuario(jtfUsuario.getText());
					u.setPassword(jtfPass.getText());
					u.setIdIdioma(((Idioma) comboBoxIdioma.getSelectedItem()).getId());
					if (Controlador.guardar(u) == 1) {
						JOptionPane.showMessageDialog(null, "Guardado correcto");
					}
				}
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 7;
		frmGestinDeCentros.getContentPane().add(btnGuardar, gbc_btnGuardar);
		btnGuardar.setEnabled(false);
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
	public boolean comprobarEmail() {
		int contArroba = 0, contPunto = 0, indiceArroba = 0, indicePunto = 0;
		String str = jtfEmail.getText();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '@') {
				contArroba++;
				indiceArroba = i;
			}
			if (str.charAt(i) == '.') {
				contPunto++;
				indicePunto = i;
			}
		}

		if (contArroba > 0 && contPunto > 0) {
			if (indiceArroba < indicePunto) {
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "El punto no está a la derecha de la arroba");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Falta un punto o una arroba");
		}
		return false;
	}

	/**
	 * 
	 * @param c
	 */
	public boolean comprobarUsuario() {
		if (jtfUsuario.getText().length() >= 8) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "El nombre de usuario no tiene un mínimo de 8 caracteres");
		return false;
	}

	/**
	 * 
	 * @param c
	 */
	public boolean comprobarUsuarioBBDD() {
		return Controlador.comprobarUser(jtfUsuario.getText());
	}

	/**
	 * 
	 * @param c
	 */
	public boolean comprobarPass() {
		int mayus = 0, minus = 0, digito = 0;
		char[] str = jtfPass.getText().toCharArray();
		for (int i = 0; i < str.length; i++) {
			if (Character.isUpperCase(str[i])) {
				mayus++;
			}
			if (Character.isLowerCase(str[i])) {
				minus++;
			}
			if (Character.isDigit(str[i])) {
				digito++;
			}
		}
		if (mayus != 0 && minus != 0 && digito != 0) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "La contraseña no tiene mayus, minus o numeros");
		return false;
	}

	/**
	 * 
	 * @param c
	 */
	public boolean comprobarPassRepetida() {
		if (jtfPass.getText().equalsIgnoreCase(jtfPass2.getText())) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
		return false;
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
