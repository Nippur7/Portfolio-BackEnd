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
import javax.swing.JSeparator;

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
		setBounds(100, 100, 802, 490);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 208, 490);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(68, 311, 120, 1);
		panel.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(68, 262, 120, 1);
		panel.add(separator);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBorder(null);
		btnSalir.setBounds(24, 422, 71, 31);
		panel.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Roboto", Font.BOLD, 13));
		btnSalir.setForeground(new Color(0, 128, 192));
		btnSalir.setBackground(new Color(255, 255, 255));
		

		
		JLabel lblPass = new JLabel("Contrase\u00F1a");
		lblPass.setBounds(10, 298, 71, 14);
		panel.add(lblPass);
		lblPass.setForeground(Color.WHITE);
		
		JLabel lblResponse = new JLabel("Estado:");
		lblResponse.setBounds(10, 357, 178, 14);
		panel.add(lblResponse);
		lblResponse.setBackground(new Color(0, 0, 128));
		lblResponse.setForeground(new Color(255, 255, 255));
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setBounds(10, 249, 46, 14);
		panel.add(lblUser);
		lblUser.setForeground(new Color(255, 255, 255));
		
		txtuser = new JTextField();
		txtuser.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		txtuser.setText("Usuario");
		txtuser.setBounds(83, 246, 105, 17);
		panel.add(txtuser);
		txtuser.setBorder(null);
		txtuser.setBackground(new Color(0, 128, 192));
		txtuser.setForeground(new Color(192, 192, 192));
		txtuser.setColumns(10);
		
		
		
		pwduser = new JPasswordField();
		pwduser.setText("******");
		pwduser.setBounds(83, 295, 105, 17);
		panel.add(pwduser);
		pwduser.setBorder(null);
		pwduser.setBackground(new Color(0, 128, 192));
		pwduser.setForeground(new Color(192, 192, 192));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 178, 198);
		panel.add(lblNewLabel);
		
		JLabel Image2 = new JLabel("");
		Image2.setHorizontalAlignment(SwingConstants.CENTER);
		Image2.setInheritsPopupMenu(false);
		Image2.setIgnoreRepaint(true);
		Image2.setIcon(new ImageIcon(logging.class.getResource("/imagenes/20220921_195639s.png")));
		Image2.setBounds(0, 0, 802, 488);
		getContentPane().add(Image2);
		
		JButton btnIngreso = new JButton("Ingresar");
		btnIngreso.setBorder(null);
		btnIngreso.setBounds(117, 423, 71, 31);
		panel.add(btnIngreso);
		btnIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user1 = txtuser.getText();
				String pass1 = String.valueOf(pwduser.getPassword());
				System.out.println(user1 + " " + pass1);
				String response = user.validar(user1, pass1);
				lblResponse.setText(response);
			}
		});
		btnIngreso.setForeground(new Color(0, 128, 192));
		btnIngreso.setFont(new Font("Roboto", Font.BOLD, 13));
		btnIngreso.setBackground(new Color(255, 255, 255));
	}
}
