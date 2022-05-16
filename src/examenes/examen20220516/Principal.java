package examenes.examen20220516;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import examenes.examen20220516.controladores.Controlador;
import examenes.examen20220516.entidades.Artista;
import examenes.examen20220516.entidades.Municipio;
import examenes.examen20220516.entidades.Provincia;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField jtfBuscaArtista;
	private JButton btnBuscar;
	private JLabel lblArtistasEncontrados;
	private JComboBox<Artista> comboBoxArtistas;
	private JButton btnCargarDatos;
	private JButton btnGuardar;
	private JPanel panel;
	private JLabel lblArtistaEncontrado;
	private JLabel lblNombreArtistico;
	private JTextField jtfArtista;
	private JLabel lblDisciplina;
	private JRadioButton rdbtnCantante;
	private JRadioButton rdbtnMagia;
	private JRadioButton rdbtnDanza;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox<Provincia> comboBoxProvincia;
	private JComboBox<Municipio> comboBoxMunicipio;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private List<Artista> lista = new ArrayList<Artista>();
	private List<Municipio> listaMunicipios = new ArrayList<Municipio>();
	private int idActual;
	private PanelJFileChooserFicheroImagen panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Busqueda de artista:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		jtfBuscaArtista = new JTextField();
		GridBagConstraints gbc_jtfBuscaArtista = new GridBagConstraints();
		gbc_jtfBuscaArtista.insets = new Insets(0, 0, 5, 5);
		gbc_jtfBuscaArtista.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfBuscaArtista.gridx = 1;
		gbc_jtfBuscaArtista.gridy = 0;
		contentPane.add(jtfBuscaArtista, gbc_jtfBuscaArtista);
		jtfBuscaArtista.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarListaFiltrada();
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar.gridx = 2;
		gbc_btnBuscar.gridy = 0;
		contentPane.add(btnBuscar, gbc_btnBuscar);

		lblArtistasEncontrados = new JLabel("Artistas encontrados:");
		GridBagConstraints gbc_lblArtistasEncontrados = new GridBagConstraints();
		gbc_lblArtistasEncontrados.anchor = GridBagConstraints.EAST;
		gbc_lblArtistasEncontrados.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtistasEncontrados.gridx = 0;
		gbc_lblArtistasEncontrados.gridy = 1;
		contentPane.add(lblArtistasEncontrados, gbc_lblArtistasEncontrados);

		comboBoxArtistas = new JComboBox<Artista>();
		GridBagConstraints gbc_comboBoxArtistas = new GridBagConstraints();
		gbc_comboBoxArtistas.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxArtistas.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxArtistas.gridx = 1;
		gbc_comboBoxArtistas.gridy = 1;
		contentPane.add(comboBoxArtistas, gbc_comboBoxArtistas);

		btnCargarDatos = new JButton("Cargar datos");
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Artista a = new Artista();
				if (comboBoxArtistas.getSelectedIndex() != -1) {
					a.setId(((Artista) comboBoxArtistas.getSelectedItem()).getId());
					a.setNombre(((Artista) comboBoxArtistas.getSelectedItem()).getNombre());
					a.setIdDisciplina(((Artista) comboBoxArtistas.getSelectedItem()).getIdDisciplina());
					a.setIdMunicipio(((Artista) comboBoxArtistas.getSelectedItem()).getIdMunicipio());
					mostrarProvinciaDeArtista(a);
					mostrarMunicipioDeArtista(a);
					idActual = a.getId();
				} else {
					JOptionPane.showMessageDialog(null, "Fallo al cargar artista");
				}
				mostrarArtista(a);
			}
		});
		GridBagConstraints gbc_btnCargarDatos = new GridBagConstraints();
		gbc_btnCargarDatos.insets = new Insets(0, 0, 5, 0);
		gbc_btnCargarDatos.gridx = 2;
		gbc_btnCargarDatos.gridy = 1;
		contentPane.add(btnCargarDatos, gbc_btnCargarDatos);

		panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblArtistaEncontrado = new JLabel("ARTISTA ENCONTRADO");
		GridBagConstraints gbc_lblArtistaEncontrado = new GridBagConstraints();
		gbc_lblArtistaEncontrado.insets = new Insets(0, 0, 5, 0);
		gbc_lblArtistaEncontrado.gridwidth = 3;
		gbc_lblArtistaEncontrado.gridx = 0;
		gbc_lblArtistaEncontrado.gridy = 0;
		panel.add(lblArtistaEncontrado, gbc_lblArtistaEncontrado);

		lblNombreArtistico = new JLabel("Nombre artistico:");
		GridBagConstraints gbc_lblNombreArtistico = new GridBagConstraints();
		gbc_lblNombreArtistico.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreArtistico.anchor = GridBagConstraints.EAST;
		gbc_lblNombreArtistico.gridx = 0;
		gbc_lblNombreArtistico.gridy = 1;
		panel.add(lblNombreArtistico, gbc_lblNombreArtistico);

		jtfArtista = new JTextField();
		GridBagConstraints gbc_jtfArtista = new GridBagConstraints();
		gbc_jtfArtista.insets = new Insets(0, 0, 5, 5);
		gbc_jtfArtista.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfArtista.gridx = 1;
		gbc_jtfArtista.gridy = 1;
		panel.add(jtfArtista, gbc_jtfArtista);
		jtfArtista.setColumns(10);

		rdbtnCantante = new JRadioButton("Cantante");
		buttonGroup.add(rdbtnCantante);
		GridBagConstraints gbc_rdbtnCantante = new GridBagConstraints();
		gbc_rdbtnCantante.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCantante.anchor = GridBagConstraints.WEST;
		gbc_rdbtnCantante.gridx = 1;
		gbc_rdbtnCantante.gridy = 2;
		panel.add(rdbtnCantante, gbc_rdbtnCantante);

		panel_1 = new PanelJFileChooserFicheroImagen();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 3;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);

		lblDisciplina = new JLabel("Disciplina:");
		GridBagConstraints gbc_lblDisciplina = new GridBagConstraints();
		gbc_lblDisciplina.insets = new Insets(0, 0, 5, 5);
		gbc_lblDisciplina.gridx = 0;
		gbc_lblDisciplina.gridy = 3;
		panel.add(lblDisciplina, gbc_lblDisciplina);

		rdbtnMagia = new JRadioButton("Magia");
		buttonGroup.add(rdbtnMagia);
		GridBagConstraints gbc_rdbtnMagia = new GridBagConstraints();
		gbc_rdbtnMagia.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnMagia.anchor = GridBagConstraints.WEST;
		gbc_rdbtnMagia.gridx = 1;
		gbc_rdbtnMagia.gridy = 3;
		panel.add(rdbtnMagia, gbc_rdbtnMagia);

		rdbtnDanza = new JRadioButton("Danza");
		buttonGroup.add(rdbtnDanza);
		GridBagConstraints gbc_rdbtnDanza = new GridBagConstraints();
		gbc_rdbtnDanza.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDanza.anchor = GridBagConstraints.WEST;
		gbc_rdbtnDanza.gridx = 1;
		gbc_rdbtnDanza.gridy = 4;
		panel.add(rdbtnDanza, gbc_rdbtnDanza);

		lblNewLabel_1 = new JLabel("Provincia");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 5;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		comboBoxProvincia = new JComboBox<Provincia>();
		comboBoxProvincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMunicipios();
			}
		});
		GridBagConstraints gbc_comboBoxProvincia = new GridBagConstraints();
		gbc_comboBoxProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxProvincia.gridx = 1;
		gbc_comboBoxProvincia.gridy = 5;
		panel.add(comboBoxProvincia, gbc_comboBoxProvincia);

		lblNewLabel_2 = new JLabel("Municipio");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 6;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		comboBoxMunicipio = new JComboBox<Municipio>();
		GridBagConstraints gbc_comboBoxMunicipio = new GridBagConstraints();
		gbc_comboBoxMunicipio.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMunicipio.gridx = 1;
		gbc_comboBoxMunicipio.gridy = 6;
		panel.add(comboBoxMunicipio, gbc_comboBoxMunicipio);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Artista a = new Artista();
				a.setId(idActual);
				a.setIdDisciplina(buscarId());
				a.setIdMunicipio(((Municipio) comboBoxMunicipio.getSelectedItem()).getId());
				a.setNombre(jtfArtista.getText());
				a.setImagen(getPanel().getImagenEnArrayDeBytes());
				if (Controlador.actualizar(a) != 0) {
					JOptionPane.showMessageDialog(null, "Guardado correcto");
				} else {
					JOptionPane.showMessageDialog(null, "Guardado incorrecto");
				}
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 3;
		contentPane.add(btnGuardar, gbc_btnGuardar);
		cargarProvincias();
		cargarMunicipios();
	}

	/**
	 * 
	 */
	public void cargarListaFiltrada() {
		comboBoxArtistas.removeAllItems();
		lista.clear();
		Controlador.filtrarArtista(jtfBuscaArtista.getText(), lista);
		for (Artista a : lista) {
			comboBoxArtistas.addItem(a);
		}
	}

	/**
	 * 
	 */
	public void mostrarArtista(Artista a) {
		Controlador.buscarImagen(a);
		mostrarImagen(a);
		rdbtnCantante.setSelected(false);
		rdbtnMagia.setSelected(false);
		rdbtnDanza.setSelected(false);
		jtfArtista.setText(a.getNombre());
		switch (a.getIdDisciplina()) {
		case 1:
			rdbtnCantante.setSelected(true);
			break;
		case 2:
			rdbtnMagia.setSelected(true);
			break;
		case 3:
			rdbtnDanza.setSelected(true);
			break;
		default:
			break;
		}
	}

	/**
	 * @return the panel
	 */
	public PanelJFileChooserFicheroImagen getPanel() {
		return panel_1;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(PanelJFileChooserFicheroImagen panel) {
		this.panel_1 = panel;
	}

	/**
	 * 
	 * @param c
	 */
	public void mostrarImagen(Artista a) {
		getPanel().setImagenEnArrayDeBytes(a.getImagen());
	}

	/**
	 * 
	 */
	public void mostrarProvinciaDeArtista(Artista a) {
		Provincia p = Controlador.cargarProvinciaDeArtista(a);
		for (int i = 0; i < comboBoxProvincia.getItemCount(); i++) {
			if (comboBoxProvincia.getItemAt(i).getId() == p.getId()) {
				comboBoxProvincia.setSelectedIndex(i);
			}
		}
	}

	/**
	 * 
	 */
	public int buscarId() {
		if (rdbtnCantante.isSelected()) {
			return 1;
		}
		if (rdbtnMagia.isSelected()) {
			return 2;
		}
		if (rdbtnDanza.isSelected()) {
			return 3;
		}
		return -1;
	}

	/**
	 * 
	 */
	public void mostrarMunicipioDeArtista(Artista a) {
		Municipio m = Controlador.cargarMunicipioDeArtista(a);
		for (int i = 0; i < comboBoxMunicipio.getItemCount(); i++) {
			if (comboBoxMunicipio.getItemAt(i).getId() == m.getId()) {
				comboBoxMunicipio.setSelectedIndex(i);
			}
		}
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
	public void cargarMunicipios() {
		comboBoxMunicipio.removeAllItems();
		listaMunicipios.clear();
		Controlador.cargarMunicipiosDeProvincia(((Provincia) comboBoxProvincia.getSelectedItem()).getId(),
				listaMunicipios);
		for (Municipio m : listaMunicipios) {
			comboBoxMunicipio.addItem(m);
		}
	}
}
