package vistas;
import DataBase.Conectar;
import DataBase.Data_base;
import DataBase.Persona;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Inicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passContras;
	//variables para pasar datos de ingreso
	public static String user1 = "";
	public static String pass1 = "";
	public Persona cli = new Persona();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("Inicio DemiCar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo1 = new JLabel("Inicio de Sesi\u00F3n");
		lblTitulo1.setForeground(Color.WHITE);
		lblTitulo1.setBounds(10, 10, 79, 13);
		contentPane.add(lblTitulo1);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(10, 59, 45, 13);
		contentPane.add(lblUsuario);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a");
		lblPass.setForeground(Color.WHITE);
		lblPass.setBounds(10, 97, 68, 13);
		contentPane.add(lblPass);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(85, 56, 96, 19);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			
			public void actionPerformed(ActionEvent e) {
				 
				user1 = txtUsuario.getText();
				pass1 = passContras.getText();
				System.out.println(user1 + " " + pass1);
				cli.validar(user1, pass1);
				
			}
		});
		btnIngresar.setBounds(105, 155, 85, 21);
		contentPane.add(btnIngresar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSalir.setBounds(10, 155, 85, 21);
		contentPane.add(btnSalir);
		
		passContras = new JPasswordField();
		passContras.setBounds(85, 94, 96, 19);
		contentPane.add(passContras);
	}
	public JTextField getTxtUsuario() {
		return txtUsuario;
	}
	public JPasswordField getPassContras() {
		return passContras;
	}
}
