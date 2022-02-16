package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

public class InsertarDepartamento extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertarDepartamento frame = new InsertarDepartamento();
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
	public InsertarDepartamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][]", "[][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		contentPane.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Centro");
		contentPane.add(lblNewLabel_1, "cell 0 1,alignx right");
		
		JLabel lblNewLabel_2 = new JLabel("Tipo Direccion");
		contentPane.add(lblNewLabel_2, "cell 0 3");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Propiedad");
		contentPane.add(rdbtnNewRadioButton, "cell 1 3");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("En funciones");
		contentPane.add(rdbtnNewRadioButton_1, "cell 2 3");
		
		JLabel lblNewLabel_3 = new JLabel("Presupuesto");
		contentPane.add(lblNewLabel_3, "cell 0 4");
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(5, 1, 100, 1));
		contentPane.add(spinner, "flowx,cell 1 4");
		
		JLabel lblNewLabel_4 = new JLabel("Nombre");
		contentPane.add(lblNewLabel_4, "cell 0 5,alignx trailing");
		
		textNombre = new JTextField();
		contentPane.add(textNombre, "cell 1 5,growx");
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("(en miles de euros)");
		contentPane.add(lblNewLabel_5, "cell 1 4");
		
		JButton btnNewButton = new JButton("ok");
		contentPane.add(btnNewButton, "cell 1 7,alignx right");
		
		JButton btnNewButton_1 = new JButton("Cancel");
		contentPane.add(btnNewButton_1, "cell 2 7");
	}

}
