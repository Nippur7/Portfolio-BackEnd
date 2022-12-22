package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.GridLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class Principal extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Sistema de Gesti\u00F3n American");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 695);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 219, 656);
		panel.setBackground(new Color(0, 128, 192));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panelAl = new JPanel();
		panelAl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelAl.setBackground(new Color(250, 250, 250));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelAl.setBackground(new Color(240, 240, 240));
			}
		});
		panelAl.setBackground(new Color(240, 240, 240));
		panelAl.setBounds(0, 156, 219, 47);
		panel.add(panelAl);
		panelAl.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Alumnos");
		lblNewLabel_1.setFont(new Font("Roboto Black", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 11, 95, 19);
		panelAl.add(lblNewLabel_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(0, 214, 219, 47);
		panel.add(panel_3_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBounds(0, 272, 219, 47);
		panel.add(panel_3_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/american_1.png")));
		lblNewLabel.setBounds(0, 0, 219, 155);
		panel.add(lblNewLabel);
		
		JPanel panelEnc = new JPanel();
		panelEnc.setBounds(218, 0, 836, 86);
		panelEnc.setBackground(new Color(255, 255, 255));
		getContentPane().add(panelEnc);
		
		JPanel panelBase = new JPanel();
		panelBase.setBackground(new Color(255, 255, 255));
		panelBase.setForeground(new Color(255, 255, 255));
		panelBase.setBounds(218, 84, 836, 572);
		getContentPane().add(panelBase);
	}
}
