package capitulo08.Ejercicio02.parte2;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import capitulo08.Ejercicio02.controladores.ControladorEstudiante;
import capitulo08.Ejercicio02.controladores.ControladorGeneral;
import capitulo08.Ejercicio02.entidades.Estudiante;

import java.awt.Insets;

public class PanelNotas extends JPanel {
	private JLabel lblNewLabel;
	private JTextField textField;
	private int idEstudiante;

	/**
	 * Create the panel.
	 */
	public PanelNotas(Estudiante e) {
		this.idEstudiante = e.getId();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 10);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(5, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);
		lblNewLabel.setText(e.getNombre() + " " + e.getApellido1() + " " + e.getApellido2() + ": ");
	}

	/**
	 * @return the textField
	 */
	public String getNota() {
		return textField.getText();
	}

	/**
	 * @param textField the textField to set
	 */
	public void setNota(String textField) {
		this.textField.setText(textField);
	}

	/**
	 * @return the idEstudiante
	 */
	public int getIdEstudiante() {
		return idEstudiante;
	}

	/**
	 * @param idEstudiante the idEstudiante to set
	 */
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

}
