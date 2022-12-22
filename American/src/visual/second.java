package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.*;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class second extends JFrame {

	private JPanel contentPane;
	private JTextField txtNum;
	private JTextField txtProd;
	private JTextField txtNumMax;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					second frame = new second();
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
	public second() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 446);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtAreaLista = new JTextArea();
		txtAreaLista.setAutoscrolls(false);
		txtAreaLista.setText("7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450");
		txtAreaLista.setBounds(10, 27, 686, 228);
		txtAreaLista.setLineWrap(true);
		contentPane.add(txtAreaLista);
		
		JLabel lblTitulo = new JLabel("Datos:");
		lblTitulo.setBounds(10, 2, 46, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("Cantidad de n\u00FAmeros adyacentes");
		lblNewLabel.setBounds(10, 278, 167, 14);
		contentPane.add(lblNewLabel);
		
		txtNum = new JTextField();
		txtNum.setBounds(198, 275, 86, 20);
		contentPane.add(txtNum);
		txtNum.setColumns(10);
		
		txtProd = new JTextField();
		txtProd.setBounds(496, 331, 200, 20);
		contentPane.add(txtProd);
		txtProd.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Resultado de la multiplicaci\u00F3n:");
		lblNewLabel_1.setBounds(355, 334, 144, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mayor n\u00FAmero encontrado:");
		lblNewLabel_2.setBounds(362, 278, 137, 14);
		contentPane.add(lblNewLabel_2);
		
		txtNumMax = new JTextField();
		txtNumMax.setBounds(496, 275, 200, 20);
		contentPane.add(txtNumMax);
		txtNumMax.setColumns(10);
		
		JButton btnLanzar = new JButton("Calcular");
		btnLanzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = txtAreaLista.getText();
				int max = 0;
				String number = "";
				int digitos = Integer.parseInt(txtNum.getText());
				int primero = 0;
				List<Integer> milista = new ArrayList<>();
				for (char ch : s.toCharArray()) {					
		            milista.add(Character.getNumericValue(ch));
		        }
				while (primero < s.length()-(digitos-1)) {
					int ultimo = primero + digitos;
					int t = 1;
					int[] num = new int[ultimo - primero];
					Object[] objects = milista.toArray();
					for (int i = 0; i < num.length; i++){
						num[i] = (int) objects[primero + i];
						t *= num[i];
					}
					if (t > max){
						max = t;
						number = Arrays.toString(num);
					}
					primero += 1;

				}
				System.out.println(max);
				System.out.println(number);
				txtNumMax.setText(number);
				txtProd.setText(String.valueOf(max));
				
				
			}
		});
		btnLanzar.setBounds(607, 373, 89, 23);
		contentPane.add(btnLanzar);
		
		
	}
}
