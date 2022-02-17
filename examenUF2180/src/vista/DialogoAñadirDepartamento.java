package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import modelo.Centro;
import modelo.Departamento;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class DialogoAñadirDepartamento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private Controlador controlador;
	private JComboBox comboBox;
	private JSpinner spinner;
	private JRadioButton rdbFunciones;
	private JRadioButton rdbPropiedad;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	/**
	 * Create the dialog.
	 */
	public DialogoAñadirDepartamento() {
		setTitle("Insertar Departamento");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow]", "[]"));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, "cell 0 0,grow");
			panel.setLayout(new MigLayout("", "[][][][][grow]", "[][][][][][][][][]"));
			{
				JLabel lblNewLabel_6 = new JLabel("");
				lblNewLabel_6.setIcon(new ImageIcon(DialogoAñadirDepartamento.class.getResource("/images/editar32.png")));
				panel.add(lblNewLabel_6, "cell 0 0 1 9");
			}
			{
				JLabel lblNewLabel = new JLabel("C\u00F3digo");
				panel.add(lblNewLabel, "cell 1 0,alignx trailing");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				txtCodigo = new JTextField();
				panel.add(txtCodigo, "cell 2 0 3 1,growx");
				txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtCodigo.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Centro");
				panel.add(lblNewLabel_1, "cell 1 2,alignx trailing");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				comboBox = new JComboBox();
				panel.add(comboBox, "cell 2 2 3 1,growx");
				comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Tipo Direcci\u00F3n");
				panel.add(lblNewLabel_2, "cell 1 4");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				rdbPropiedad = new JRadioButton("Propiedad");
				rdbPropiedad.setSelected(true);
				buttonGroup.add(rdbPropiedad);
				panel.add(rdbPropiedad, "cell 2 4");
				rdbPropiedad.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				 rdbFunciones = new JRadioButton("En funciones");
				 buttonGroup.add(rdbFunciones);
				panel.add(rdbFunciones, "cell 3 4");
				rdbFunciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Presupuesto");
				panel.add(lblNewLabel_3, "cell 1 6");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				spinner = new JSpinner();
				panel.add(spinner, "cell 2 6");
				spinner.setModel(new SpinnerNumberModel(5, 1, 100, 1));
				spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				JLabel lblNewLabel_5 = new JLabel("( en miles de \u20AC)");
				panel.add(lblNewLabel_5, "cell 3 6");
				lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Nombre");
				panel.add(lblNewLabel_4, "cell 1 8,alignx trailing");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				txtNombre = new JTextField();
				panel.add(txtNombre, "cell 2 8 3 1,growx");
				txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtNombre.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						recogerDatos();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}


	protected void recogerDatos() {
		int codDpto = Integer.parseInt(txtCodigo.getText());
		Centro c = (Centro) comboBox.getSelectedItem();
		String tipoDir="P";
		if (rdbFunciones.isSelected()) tipoDir="F";
		int presupuesto = (int) spinner.getValue();
		String nombre = txtNombre.getText();
		
		Departamento d = new Departamento(codDpto, c.getCod_centro(), 
				tipoDir, presupuesto, nombre);
		
		try {
			controlador.insertaDepartamento(d);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al insertar");
		}
		setVisible(false);
	}


	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
	}


	public void setListaCentros(ArrayList<Centro> lista) {
		for (Centro centro : lista) {
			comboBox.addItem(centro);
		}
		
	}

}
