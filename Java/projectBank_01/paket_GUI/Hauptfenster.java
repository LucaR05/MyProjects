package paket_GUI;
import bank.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Hauptfenster extends JFrame {

	private JPanel contentPane;
	Fenster_Girokonto fenster3 = new Fenster_Girokonto();
    Fenster_Sparkonto fenster2 = new Fenster_Sparkonto();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hauptfenster frame = new Hauptfenster();
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

	public Hauptfenster() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JFK-BANK");
		lblNewLabel.setFont(new Font("Lucida Handwriting", Font.BOLD, 30));
		lblNewLabel.setBounds(117, 11, 203, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnGirokonto = new JButton("Girokonto");
		btnGirokonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fenster3.setVisible(true);
				setVisible(false);
				
			}
		});
		btnGirokonto.setBounds(117, 61, 203, 39);
		contentPane.add(btnGirokonto);
		
		JButton btnSparkonto = new JButton("Sparkonto");
		btnSparkonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fenster2.setVisible(true);
				setVisible(false);
			}
		});
		btnSparkonto.setBounds(117, 118, 203, 39);
		contentPane.add(btnSparkonto);
		
		JButton btnBeenden = new JButton("Beenden");
		btnBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnBeenden.setBounds(117, 175, 203, 39);
		contentPane.add(btnBeenden);
	}
}
