package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.awt.event.ActionEvent;


public class Mensajero extends JFrame {

	private JPanel contentPane;
	private JTextField txtCelular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mensajero frame = new Mensajero();
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
	public Mensajero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero");
		lblNewLabel.setBounds(47, 24, 45, 13);
		contentPane.add(lblNewLabel);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(110, 21, 96, 19);
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mensaje");
		lblNewLabel_1.setBounds(47, 67, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JTextArea txtMensaje = new JTextArea();
		txtMensaje.setBounds(110, 67, 265, 151);
		contentPane.add(txtMensaje);
		
		JButton BtnEnviar = new JButton("Enviar");
		BtnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ID = "shlL1wbiSUKiJGHYQgu54W5pcHB1cl9kb3RfYXJnZW50b19hdF9nbWFpbF9kb3RfY29t";
				String celular = txtCelular.getSelectedText();
				String mensaje = txtMensaje.getText();
						HttpURLConnection conex = null;
				
				try {
					URL enlace = new URL("https://NiceApi.net/API");
					conex = (HttpURLConnection) enlace.openConnection();
					conex.setRequestMethod("POST");
					conex.setRequestProperty("X-APIId",ID);
					conex.setRequestProperty("X-APIMobile",celular);
					conex.setRequestProperty("Content-Type","application/x-form-urlencoded");
					conex.setUseCaches(false);
					conex.setDoOutput(true);
					
					DataOutputStream salida = new DataOutputStream(conex.getOutputStream());
					salida.writeBytes(mensaje);
					salida.close();
					
					InputStream entrada = conex.getInputStream();
					BufferedReader lectura = new BufferedReader(new InputStreamReader(entrada));
					
					JOptionPane.showMessageDialog(BtnEnviar, "Mensaje Enviado");
					lectura.close();
					
					
					
					
				}catch (Exception e1){
					System.out.println(e1.getMessage());
				}finally {
					if(conex != null) {
						conex.disconnect();
					}
				}
				
			}
		});
		BtnEnviar.setBounds(236, 232, 85, 21);
		contentPane.add(BtnEnviar);
	}
}
