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

public class Fenster_Girokonto extends JFrame {

	private JPanel contentPane;
	private JTextField txtKontonummer;
	private JTextField txtKontostand;
	private JTextField txtGirogebuehr;
	private JTextField txtBetrag;
	private Girokonto girokonto1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenster_Girokonto frame = new Fenster_Girokonto();
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
	public Fenster_Girokonto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKontonummer = new JLabel("Kontonummer");
		lblKontonummer.setBounds(34, 11, 74, 21);
		contentPane.add(lblKontonummer);
		
		JLabel lblKontostand = new JLabel("Kontostand");
		lblKontostand.setBounds(34, 40, 74, 18);
		contentPane.add(lblKontostand);
		
		JLabel lblGirogebuehr = new JLabel("Girogebuehr");
		lblGirogebuehr.setBounds(34, 72, 74, 18);
		contentPane.add(lblGirogebuehr);
		
		txtKontonummer = new JTextField();
		txtKontonummer.setBounds(210, 11, 97, 20);
		contentPane.add(txtKontonummer);
		txtKontonummer.setColumns(10);
		
		txtKontostand = new JTextField();
		txtKontostand.setBounds(210, 39, 97, 20);
		contentPane.add(txtKontostand);
		txtKontostand.setColumns(10);
		
		txtGirogebuehr = new JTextField();
		txtGirogebuehr.setBounds(210, 71, 97, 20);
		contentPane.add(txtGirogebuehr);
		txtGirogebuehr.setColumns(10);
		
		txtBetrag = new JTextField();
		txtBetrag.setBounds(116, 120, 97, 20);
		contentPane.add(txtBetrag);
		txtBetrag.setColumns(10);
		
		JButton btnEinzahlen = new JButton("Einzahlen");
		btnEinzahlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				double betrag = Double.parseDouble(txtBetrag.getText());
				betrag = Math.round(100.0*betrag)/100.0;
				girokonto1.kontostand += betrag;
				txtKontostand.setText(String.valueOf(girokonto1.getKontostand()));}
				catch (NumberFormatException e1){
			        System.out.println("Muss eine zahl sein");}
				txtBetrag.setText("");
				txtBetrag.requestFocus();
			}
		});
		btnEinzahlen.setBounds(238, 106, 89, 23);
		contentPane.add(btnEinzahlen);
		
		JButton btnAuszahlen = new JButton("Auszahlen");
		btnAuszahlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				double betrag = Double.parseDouble(txtBetrag.getText());
				betrag = Math.round(100.0*betrag)/100.0;
				if(girokonto1.kontostand - betrag >= 0){
				girokonto1.kontostand -= betrag;}
				txtKontostand.setText(String.valueOf(girokonto1.getKontostand()));}
				catch (NumberFormatException e1){
			        System.out.println("Muss eine zahl sein");}
				txtBetrag.setText("");
				txtBetrag.requestFocus();
			}
		});
		btnAuszahlen.setBounds(238, 136, 89, 23);
		contentPane.add(btnAuszahlen);
		
		JButton btnGirogebuehrBerechnen = new JButton("Girogebuehr berechnen");
		btnGirogebuehrBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double girogebuehr = Double.parseDouble(txtGirogebuehr.getText());
				girokonto1.berechneGiroGebuehr();
				txtKontostand.setText(String.valueOf(girokonto1.getKontostand()));
			}
		});
		btnGirogebuehrBerechnen.setBounds(54, 171, 159, 23);
		contentPane.add(btnGirogebuehrBerechnen);
		
		JButton btnFelderLeeren = new JButton("Felder Leeren");
		btnFelderLeeren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtKontonummer.setText("");
				txtKontostand.setText("");
				txtBetrag.setText("");
				txtGirogebuehr.setText("");
			}
		});
		btnFelderLeeren.setBounds(54, 198, 159, 23);
		contentPane.add(btnFelderLeeren);
		
		JButton btnAnzeigen = new JButton("Anzeigen");
		btnAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtKontonummer.setText(String.valueOf(girokonto1.getKontonummer()));
				txtKontostand.setText(String.valueOf(girokonto1.getKontostand()));
				txtGirogebuehr.setText(String.valueOf(girokonto1.getGiroGebuehr()));
			}
		});
		btnAnzeigen.setBounds(54, 227, 159, 23);
		contentPane.add(btnAnzeigen);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int kontonummer= Integer.parseInt(txtKontonummer.getText());
				double kontostand = Double.parseDouble(txtKontostand.getText());
				double girogebuehr = Double.parseDouble(txtGirogebuehr.getText());
				
				girokonto1 = new Girokonto(kontonummer, kontostand, girogebuehr);
			}
		});
		btnSpeichern.setBounds(238, 170, 89, 23);
		contentPane.add(btnSpeichern);
		
		JButton btnBeenden = new JButton("Beenden");
		btnBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hauptfenster fenster4;
				fenster4 = new Hauptfenster();
				fenster4.setVisible(true);
				setVisible(false);
			}
		});
		btnBeenden.setBounds(238, 198, 89, 23);
		contentPane.add(btnBeenden);
	}

}
