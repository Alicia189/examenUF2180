package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Centro;
import modelo.Departamento;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMostrarDepartamentos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Controlador controlador;


	/**
	 * Create the frame.
	 */
	public VentanaMostrarDepartamentos() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Listado de Departamentos:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel, "cell 0 0");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo departamento", "C\u00F3digo de centro", "Tipo de direcci\u00F3n", "Presupuesto", "Nombre"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Object.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(121);
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		table.getColumnModel().getColumn(2).setPreferredWidth(106);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnNewButton, "cell 0 2,alignx center");
	}


	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
		
	}


	public void setListaDepartamentos(ArrayList<Departamento> lista) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		for (Departamento dpto : lista) {
			Object fila [] = {
					dpto.getCodDepartamento(),dpto.getCodCentro(), dpto.getTipoDir(),
					dpto.getPresupuesto(), dpto.getNombre()
			};
			modelo.addRow(fila);
		}
		
	}

}
