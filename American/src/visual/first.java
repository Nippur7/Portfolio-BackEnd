package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class first extends JFrame {

	private JPanel contentPane;
	private JTextField txtArray;
	private JTextField txtK;
	private JTextField txtResultado;
	private JTextField txtArr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					first frame = new first();
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
	public first() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 264, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtK = new JTextField();
		txtK.setColumns(10);
		txtK.setBounds(151, 39, 86, 20);
		contentPane.add(txtK);
	

		txtArray = new JTextField();
		txtArray.setBounds(150, 11, 86, 20);
		contentPane.add(txtArray);
		txtArray.setColumns(10);
		
		JLabel lblArray = new JLabel("Elementos en el array:");
		lblArray.setBounds(20, 14, 120, 14);
		contentPane.add(lblArray);
		
		JLabel lblNewLabel_2 = new JLabel("Entero K:");
		lblNewLabel_2.setBounds(20, 39, 46, 14);
		contentPane.add(lblNewLabel_2);
		

		
		JLabel lblNewLabel_1 = new JLabel("Resultado:");
		lblNewLabel_1.setBounds(69, 155, 71, 14);
		contentPane.add(lblNewLabel_1);
		
		txtResultado = new JTextField();
		txtResultado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtResultado.setColumns(10);
		txtResultado.setBounds(151, 155, 86, 39);
		contentPane.add(txtResultado);
		
		JLabel lblArray1 = new JLabel("Arreglo:");
		lblArray1.setBounds(20, 83, 46, 14);
		contentPane.add(lblArray1);
		
		txtArr = new JTextField();
		txtArr.setBounds(69, 80, 168, 20);
		contentPane.add(txtArr);
		txtArr.setColumns(10);
		
		JButton btnProbar = new JButton("Probar");
		btnProbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int elementos = Integer.parseInt(txtArray.getText());
				//int valores[];
				//valores = new int[elementos];
				//Este es un array aleatorio
				//for (int x=0;x<valores.length;x++)
				//	  valores[x] = (int) (Math.random()*10)+1;
				int[] valores = {1,5,7,1}; 
				System.out.println(Arrays.toString(valores));
				int k = Integer.parseInt(txtK.getText());
				int cuenta = 0;
				for (int i = 0; i < valores.length; i++)
		            for (int j = i + 1; j < valores.length; j++)
		                if ((valores[i] + valores[j]) == k)
		                    cuenta++;
		 
		        System.out.printf("La cuenta de pares es: %d", cuenta);
		        txtArr.setText(Arrays.toString(valores));
		        txtResultado.setText(String.valueOf(cuenta));
			}
			
		});
		btnProbar.setBounds(151, 208, 89, 23);
		contentPane.add(btnProbar);
	}

}
