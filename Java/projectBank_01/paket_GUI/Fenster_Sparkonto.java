package paket_GUI;
import bank.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fenster_Sparkonto extends JFrame {

	
	private JPanel contentPane;
	private JTextField txtKontonummer;
	private JTextField txtKontostand;
	private JTextField txtZinssatz;
	private JTextField txtTage;
	private JTextField txtBetrag;
	public Sparkonto sparkonto1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenster_Sparkonto frame = new Fenster_Sparkonto();
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
	public Fenster_Sparkonto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKontonummer = new JLabel("Kontonummer");
		lblKontonummer.setBounds(39, 11, 71, 26);
		contentPane.add(lblKontonummer);
		
		JLabel lblKontostand = new JLabel("Kontostand");
		lblKontostand.setBounds(39, 43, 71, 19);
		contentPane.add(lblKontostand);
		
		JLabel lblZinssatz = new JLabel("Zinssatz");
		lblZinssatz.setBounds(39, 75, 46, 14);
		contentPane.add(lblZinssatz);
		
		JLabel lblTage = new JLabel("Tage");
		lblTage.setBounds(39, 108, 46, 14);
		contentPane.add(lblTage);
		
		txtKontonummer = new JTextField();
		txtKontonummer.setBounds(227, 14, 86, 20);
		contentPane.add(txtKontonummer);
		txtKontonummer.setColumns(10);
		
		txtKontostand = new JTextField();
		txtKontostand.setBounds(227, 42, 86, 20);
		contentPane.add(txtKontostand);
		txtKontostand.setColumns(10);
		
		txtZinssatz = new JTextField();
		txtZinssatz.setBounds(227, 72, 86, 20);
		contentPane.add(txtZinssatz);
		txtZinssatz.setColumns(10);
		
		txtTage = new JTextField();
		txtTage.setBounds(227, 105, 86, 20);
		contentPane.add(txtTage);
		txtTage.setColumns(10);
		
		txtBetrag = new JTextField();
		txtBetrag.setBounds(151, 147, 86, 20);
		contentPane.add(txtBetrag);
		txtBetrag.setColumns(10);
		
		JButton btnEinzahlen = new JButton("Einzahlen");
		btnEinzahlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double betrag = Double.parseDouble(txtBetrag.getText());
				sparkonto1.kontostand = Math.round(sparkonto1.kontostand + betrag);
				txtKontostand.setText(String.valueOf(sparkonto1.getKontostand()));
				txtBetrag.setText("");
				txtBetrag.requestFocus();
			}
		});
		btnEinzahlen.setBounds(292, 135, 89, 23);
		contentPane.add(btnEinzahlen);
		
		JButton btnAuszahlen = new JButton("Auszahlen");
		btnAuszahlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double betrag = Double.parseDouble(txtBetrag.getText());
				if(sparkonto1.kontostand - betrag >= 0){
				sparkonto1.kontostand -= betrag;}
				txtKontostand.setText(String.valueOf(sparkonto1.getKontostand()));
				txtBetrag.setText("");
				txtBetrag.requestFocus();
			}
			}
		);
		btnAuszahlen.setBounds(292, 162, 89, 23);
		contentPane.add(btnAuszahlen);
		
		JButton btnZinsenBerechnen = new JButton("Zinsen berechnen");
		btnZinsenBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Kontostand = Double.parseDouble(txtKontostand.getText());
				double Zinssatz   = Double.parseDouble(txtZinssatz.getText());
				int Tage 		  = Integer.parseInt(txtTage.getText());
				sparkonto1.kontostand = Kontostand + Kontostand * Zinssatz /360/100 * Tage;
				txtKontostand.setText(String.valueOf(sparkonto1.kontostand));
			}
		});
		btnZinsenBerechnen.setBounds(30, 179, 129, 23);
		contentPane.add(btnZinsenBerechnen);
		
		JButton btnFelderLeeren = new JButton("Felder Leeren");
		btnFelderLeeren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtKontonummer.setText("");
				txtKontostand.setText("");
				txtZinssatz.setText("");
				txtTage.setText("");
				txtBetrag.setText("");
			}
		});
		btnFelderLeeren.setBounds(30, 206, 129, 23);
		contentPane.add(btnFelderLeeren);
		
		JButton btnBeenden = new JButton("Beenden");
		btnBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hauptfenster fenster4;
				fenster4 = new Hauptfenster();
				fenster4.setVisible(true);
				setVisible(false);
				
			}
		});
		btnBeenden.setBounds(202, 206, 129, 23);
		contentPane.add(btnBeenden);
		
		JButton btnAnzeigen = new JButton("Anzeigen");
		btnAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtKontonummer.setText(String.valueOf(sparkonto1.getKontonummer()));
				txtKontostand.setText(String.valueOf(sparkonto1.getKontostand()));
				txtZinssatz.setText(String.valueOf(sparkonto1.getSparZinssatz()));
			}
		});
		btnAnzeigen.setBounds(30, 232, 129, 23);
		contentPane.add(btnAnzeigen);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int kontonummer= Integer.parseInt(txtKontonummer.getText());
				double kontostand = Double.parseDouble(txtKontostand.getText());
				double zinssatz = Double.parseDouble(txtZinssatz.getText());
				
				sparkonto1 = new Sparkonto(kontonummer, kontostand, zinssatz);
			}
		});
		btnSpeichern.setBounds(202, 232, 129, 23);
		contentPane.add(btnSpeichern);
	}
}
