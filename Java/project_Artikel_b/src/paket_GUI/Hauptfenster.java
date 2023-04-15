package paket_GUI;
import paket_Fachklassen.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hauptfenster extends JFrame {

	private JPanel contentPane;
	private JTextField txtArtikelnummer;
	private JTextField txtBezeichnung;
	private JTextField txtPreis;
	private JTextField txtBestand;
	private JTextField txtBestandsbewegung;
	
	
	private Artikel artikel1; 

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
		
		JLabel lblArtikelnummer = new JLabel("Artikelnummer:");
		lblArtikelnummer.setBounds(32, 31, 72, 29);
		contentPane.add(lblArtikelnummer);
		
		JLabel lblBezeichnung = new JLabel("Bezeichnung:");
		lblBezeichnung.setBounds(32, 68, 72, 20);
		contentPane.add(lblBezeichnung);
		
		txtArtikelnummer = new JTextField();
		txtArtikelnummer.setBounds(177, 35, 86, 20);
		contentPane.add(txtArtikelnummer);
		txtArtikelnummer.setColumns(10);
		
		JButton btnFelderLeeren = new JButton("Felder leeren");
		btnFelderLeeren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtArtikelnummer.setText("");
				txtBezeichnung.setText("");
				txtBestandsbewegung.setText("");
				txtPreis.setText("");
				txtBestand.setText("");
			}
		});
		btnFelderLeeren.setBounds(32, 265, 107, 29);
		contentPane.add(btnFelderLeeren);
		
		JLabel lblPreis = new JLabel("Preis:");
		lblPreis.setBounds(32, 102, 72, 20);
		contentPane.add(lblPreis);
		
		JLabel lblBestand = new JLabel("Bestand:");
		lblBestand.setBounds(32, 138, 72, 20);
		contentPane.add(lblBestand);
		
		JLabel lblBestandsbewegung = new JLabel("Bestandsbewegung:");
		lblBestandsbewegung.setBounds(32, 197, 107, 29);
		contentPane.add(lblBestandsbewegung);
		
		txtBezeichnung = new JTextField();
		txtBezeichnung.setBounds(177, 68, 86, 20);
		contentPane.add(txtBezeichnung);
		txtBezeichnung.setColumns(10);
		
		txtPreis = new JTextField();
		txtPreis.setBounds(177, 102, 86, 20);
		contentPane.add(txtPreis);
		txtPreis.setColumns(10);
		
		txtBestand = new JTextField();
		txtBestand.setEditable(false);
		txtBestand.setBounds(177, 138, 86, 20);
		contentPane.add(txtBestand);
		txtBestand.setColumns(10);
		
		txtBestandsbewegung = new JTextField();
		txtBestandsbewegung.setBounds(177, 201, 86, 20);
		contentPane.add(txtBestandsbewegung);
		txtBestandsbewegung.setColumns(10);
		
		JButton btnZeigen = new JButton("Zeigen");
		btnZeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtArtikelnummer.setText(artikel1.getArtikelNr());
				txtBezeichnung.setText(artikel1.getBezeichnung());
				txtPreis.setText(String.valueOf(artikel1.getPreis()));
				txtBestand.setText(String.valueOf(artikel1.getBestand()));
			}
		});
		btnZeigen.setBounds(32, 300, 107, 29);
		contentPane.add(btnZeigen);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//selbst eingetragen --> Speichern in einem neuem Objekt
			artikel1= new Artikel(txtArtikelnummer.getText());
			artikel1.setBezeichnung(txtBezeichnung.getText());
			artikel1.setPreis(Double.parseDouble(txtPreis.getText()));

				
			}
		});
		btnSpeichern.setBounds(149, 265, 107, 29);
		contentPane.add(btnSpeichern);
		
		JButton btnBeenden = new JButton("Beenden");
		btnBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnBeenden.setBounds(149, 300, 107, 29);
		contentPane.add(btnBeenden);
		
		JButton btnZugang = new JButton("Zugang");
		btnZugang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				artikel1.mehren(Integer.parseInt(txtBestandsbewegung.getText()));
				txtBestand.setText(String.valueOf(artikel1.getBestand()));
				txtBestandsbewegung.setText("");
				txtBestandsbewegung.requestFocus();
			}
			
		});
		btnZugang.setBounds(273, 184, 89, 23);
		contentPane.add(btnZugang);
		
		JButton btnAbgang = new JButton("Abgang");
		btnAbgang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean mOK;
				mOK = artikel1.mindern(Integer.parseInt(txtBestandsbewegung.getText()));
				if (mOK){
				txtBestand.setText(String.valueOf(artikel1.getBestand()));
				txtBestandsbewegung.setText("");
				txtBestandsbewegung.requestFocus();
				}
				else {
					JOptionPane.showMessageDialog(null, "Der Lagerbestand ist zu klein!");
					txtBestandsbewegung.setText("");
				}
			}
		});
		btnAbgang.setBounds(273, 215, 89, 23);
		contentPane.add(btnAbgang);
		this.setSize(400, 400);
		this.setTitle("Artikelverwaltung");
		
	}
}
