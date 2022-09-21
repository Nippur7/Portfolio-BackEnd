package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import dbases.Conectar;
import dbases.user;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class logging extends JFrame {
	private JTextField txtuser;
	private JPasswordField pwduser;
	Conectar cc =new Conectar();
	Connection con = cc.Conexion();
	user usuario = new user();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logging frame = new logging();
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
	public logging() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 314);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		txtuser = new JTextField();
		txtuser.setBackground(new Color(0, 0, 128));
		txtuser.setForeground(new Color(255, 255, 255));
		txtuser.setBounds(303, 114, 105, 17);
		getContentPane().add(txtuser);
		txtuser.setColumns(10);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setBounds(230, 117, 46, 14);
		getContentPane().add(lblUser);
		
		JLabel Image2 = new JLabel("");
		Image2.setHorizontalAlignment(SwingConstants.CENTER);
		Image2.setInheritsPopupMenu(false);
		Image2.setIgnoreRepaint(true);
		Image2.setIcon(new ImageIcon(logging.class.getResource("/imagenes/logoaics.png")));
		Image2.setBounds(10, 11, 210, 293);
		getContentPane().add(Image2);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(0, 0, 128));
		btnSalir.setBounds(230, 280, 71, 23);
		getContentPane().add(btnSalir);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a");
		lblPass.setForeground(Color.WHITE);
		lblPass.setBounds(230, 166, 71, 14);
		getContentPane().add(lblPass);
		
		
		
		pwduser = new JPasswordField();
		pwduser.setBackground(new Color(0, 0, 128));
		pwduser.setForeground(new Color(255, 255, 255));
		pwduser.setBounds(303, 163, 105, 17);
		getContentPane().add(pwduser);
		
		JLabel lblResponse = new JLabel("Estado:");
		lblResponse.setBackground(new Color(0, 0, 128));
		lblResponse.setForeground(new Color(255, 255, 255));
		lblResponse.setBounds(230, 225, 178, 14);
		getContentPane().add(lblResponse);
		
		JButton btnIngreso = new JButton("Ingresar");
		btnIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user1 = txtuser.getText();
				String pass1 = String.valueOf(pwduser.getPassword());
				System.out.println(user1 + " " + pass1);
				String response = user.validar(user1, pass1);
				lblResponse.setText(response);
			}
		});
		btnIngreso.setForeground(Color.WHITE);
		btnIngreso.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIngreso.setBackground(new Color(0, 0, 128));
		btnIngreso.setBounds(311, 280, 97, 23);
		getContentPane().add(btnIngreso);
		
		JLabel Image1 = new JLabel("");
		Image1.setIcon(new ImageIcon(logging.class.getResource("/imagenes/fondo.png")));
		Image1.setBounds(0, 0, 418, 314);
		getContentPane().add(Image1);
	}
}
