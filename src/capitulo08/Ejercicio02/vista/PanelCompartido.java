package capitulo08.Ejercicio02.vista;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import capitulo08.Ejercicio02.controladores.ControladorGeneral;
import capitulo08.Ejercicio02.entidades.Estudiante;
import capitulo08.Ejercicio02.entidades.Profesor;
import capitulo08.Ejercicio02.entidades.Sexo;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JColorChooser;

public class PanelCompartido extends JPanel {
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JTextField jtfDni;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTlf;
	private JComboBox<Sexo> comboBox;
	private PanelJFileChooserFicheroImagen panel;
	JPopupMenu popup;
	private JTextField jtfColor;
	JColorChooser jColorChooser;

	/**
	 * Create the panel.
	 */
	public PanelCompartido() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		panel = new PanelJFileChooserFicheroImagen();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridheight = 11;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 1;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Primer Apellido:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfApellido1 = new JTextField();
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 2;
		add(jtfApellido1, gbc_jtfApellido1);
		jtfApellido1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Segundo Apellido:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfApellido2 = new JTextField();
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 3;
		add(jtfApellido2, gbc_jtfApellido2);
		jtfApellido2.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("DNI:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 4;
		add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Dirección:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 5;
		add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 6;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Tlf:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtfTlf = new JTextField();
		GridBagConstraints gbc_jtfTlf = new GridBagConstraints();
		gbc_jtfTlf.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTlf.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTlf.gridx = 1;
		gbc_jtfTlf.gridy = 7;
		add(jtfTlf, gbc_jtfTlf);
		jtfTlf.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Sexo:");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 8;
		add(lblNewLabel_9, gbc_lblNewLabel_9);

		comboBox = new JComboBox<Sexo>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 8;
		add(comboBox, gbc_comboBox);

		JLabel lblNewLabel_8 = new JLabel("         ");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_8.gridx = 2;
		gbc_lblNewLabel_8.gridy = 8;
		add(lblNewLabel_8, gbc_lblNewLabel_8);

		JLabel lblNewLabel_10 = new JLabel("Color:");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 9;
		add(lblNewLabel_10, gbc_lblNewLabel_10);

		jtfColor = new JTextField();
		jtfColor.setColumns(10);
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 5, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 9;
		add(jtfColor, gbc_jtfColor);

		JButton btnColor = new JButton("Cambiar color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaColor();
			}
		});
		GridBagConstraints gbc_btnColor = new GridBagConstraints();
		gbc_btnColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnColor.gridx = 1;
		gbc_btnColor.gridy = 10;
		add(btnColor, gbc_btnColor);

		popup = getPopUpMenu();

		// Evento para mostrar el men� en las coordenadas que correspondan
		panel.getScrollPane().addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				showPopup(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				showPopup(e);
			}

			/**
			 * M�todo llamado cuando se detecta el evento de rat�n, mostrar� el men�
			 * 
			 * @param e
			 */
			private void showPopup(MouseEvent e) {
				popup = getPopUpMenu();
				if (e.isPopupTrigger()) {
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});

		mostrarComboBox();
	}

	/**
	 * 
	 */
	private void seleccionaColor() {
		Color color = jColorChooser.showDialog(null, "Seleccione un Color", Color.GRAY);
		// Si el usuario pulsa sobre aceptar, el color elegido no será nulo
		if (color != null) {
			String strColor = "#" + Integer.toHexString(color.getRGB()).substring(2);
			jtfColor.setText(strColor);
			setBackground(color);
		}
	}

	/**
	 * 
	 * @return
	 */
	private JPopupMenu getPopUpMenu() {
		JPopupMenu menu = new JPopupMenu();

		menu.add(crearNuevoMenuItem("Dimensiones de la imagen: " + panel.getAlto() + " x " + panel.getAncho()));
		menu.addSeparator();
		menu.add(crearNuevoMenuItem("Cambiar imagen"));

		return menu;
	}

	/**
	 * Menú Item para salir de la aplicación
	 * 
	 * @return
	 */
	private JMenuItem crearNuevoMenuItem(String titulo) {
		JMenuItem item = new JMenuItem(titulo);
		if (titulo.equalsIgnoreCase("Cambiar imagen")) {
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					panel.seleccionaImagen();
				}
			});
		}

		return item;
	}

	/**
	 * @return the jtfId
	 */
	public String getJtfId() {
		return jtfId.getText();
	}

	/**
	 * @param jtfId the jtfId to set
	 */
	public void setJtfId(String jtfId) {
		this.jtfId.setText(jtfId);
	}

	/**
	 * @return the jtfNombre
	 */
	public String getJtfNombre() {
		return jtfNombre.getText();
	}

	/**
	 * @param jtfNombre the jtfNombre to set
	 */
	public void setJtfNombre(String jtfNombre) {
		this.jtfNombre.setText(jtfNombre);
	}

	/**
	 * @return the jtfApellido1
	 */
	public String getJtfApellido1() {
		return jtfApellido1.getText();
	}

	/**
	 * @param jtfApellido1 the jtfApellido1 to set
	 */
	public void setJtfApellido1(String jtfApellido1) {
		this.jtfApellido1.setText(jtfApellido1);
	}

	/**
	 * @return the jtfApellido2
	 */
	public String getJtfApellido2() {
		return jtfApellido2.getText();
	}

	/**
	 * @param jtfApellido2 the jtfApellido2 to set
	 */
	public void setJtfApellido2(String jtfApellido2) {
		this.jtfApellido2.setText(jtfApellido2);
	}

	/**
	 * @return the jtfDni
	 */
	public String getJtfDni() {
		return jtfDni.getText();
	}

	/**
	 * @param jtfDni the jtfDni to set
	 */
	public void setJtfDni(String jtfDni) {
		this.jtfDni.setText(jtfDni);
	}

	/**
	 * @return the jtfDireccion
	 */
	public String getJtfDireccion() {
		return jtfDireccion.getText();
	}

	/**
	 * @param jtfDireccion the jtfDireccion to set
	 */
	public void setJtfDireccion(String jtfDireccion) {
		this.jtfDireccion.setText(jtfDireccion);
	}

	/**
	 * @return the jtfEmail
	 */
	public String getJtfEmail() {
		return jtfEmail.getText();
	}

	/**
	 * @param jtfEmail the jtfEmail to set
	 */
	public void setJtfEmail(String jtfEmail) {
		this.jtfEmail.setText(jtfEmail);
	}

	/**
	 * @return the jtfTlf
	 */
	public String getJtfTlf() {
		return jtfTlf.getText();
	}

	/**
	 * @param jtfTlf the jtfTlf to set
	 */
	public void setJtfTlf(String jtfTlf) {
		this.jtfTlf.setText(jtfTlf);
	}

	/**
	 * @return the comboBox
	 */
	public Sexo getSexo() {
		return (Sexo) comboBox.getSelectedItem();
	}

	/**
	 * @param comboBox the comboBox to set
	 */
	public void setSexo(Sexo comboBox) {
		this.comboBox.setSelectedItem(comboBox);
	}

	/**
	 * @return the panel
	 */
	public PanelJFileChooserFicheroImagen getPanel() {
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(PanelJFileChooserFicheroImagen panel) {
		this.panel = panel;
	}

	/**
	 * @return the jtfColor
	 */
	public String getJtfColor() {
		return jtfColor.getText();
	}

	/**
	 * @param jtfColor the jtfColor to set
	 */
	public void setJtfColor(String jtfColor) {
		this.jtfColor.setText(jtfColor);
	}

	/**
	 * 
	 * @param c
	 */
	public void mostrarComboBox() {
		List<Sexo> sexos = new ArrayList<Sexo>();
		ControladorGeneral.listadoSexos(sexos);
		for (Sexo s : sexos) {
			comboBox.addItem(s);
		}
	}

	/**
	 * 
	 * @param c
	 */
	public void mostrarImagen(Profesor p) {
		getPanel().setImagenEnArrayDeBytes(p.getImagen());
	}

	/**
	 * 
	 * @param c
	 */
	public void mostrarImagen(Estudiante e) {
		getPanel().setImagenEnArrayDeBytes(e.getImagen());
	}

	/**
	 * 
	 */
	public void mostrarSexoEstudiante(Estudiante e) {
		for (int i = 0; i < comboBox.getItemCount(); i++) {
			if (comboBox.getItemAt(i).getId() == e.getSexo()) {
				comboBox.setSelectedIndex(i);
			}
		}
	}

	/**
	 * 
	 */
	public void mostrarSexoProfesor(Profesor p) {
		for (int i = 0; i < comboBox.getItemCount(); i++) {
			if (comboBox.getItemAt(i).getId() == p.getSexo()) {
				comboBox.setSelectedIndex(i);
			}
		}
	}

}
