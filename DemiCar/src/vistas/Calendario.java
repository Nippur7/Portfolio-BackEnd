package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Locale;
import com.toedter.components.JSpinField;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Calendario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calendario frame = new Calendario();
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
	public Calendario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 10, 182, 152);
		contentPane.add(calendar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calendar I_Fecha = calendar.getDate();
				System.out.println(calendar.getDate());
			}
		});
		btnAceptar.setBounds(328, 141, 85, 21);
		contentPane.add(btnAceptar);
		
		JList list = new JList();
		list.setBounds(392, 51, -178, -29);
		contentPane.add(list);
		
		JComboBox cmb_Sector = new JComboBox();
		cmb_Sector.setBounds(231, 34, 182, 21);
		contentPane.add(cmb_Sector);
		
		JComboBox cmb_Horario = new JComboBox();
		cmb_Horario.setBounds(231, 83, 183, 21);
		contentPane.add(cmb_Horario);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(233, 141, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Sector");
		lblNewLabel.setBounds(231, 9, 182, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Horarios disponibles");
		lblNewLabel_1.setBounds(231, 60, 183, 13);
		contentPane.add(lblNewLabel_1);
	}
}
