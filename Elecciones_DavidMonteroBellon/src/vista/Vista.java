package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import Controlador.Controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;


public class Vista extends JFrame {

	public JPanel contentPane;
	public JTextField tf1;
	public JTextField tf2;
	public JTextField tf3;
	public JTextField tf4;
	public boolean bandera=false;
	
	public JButton btnGraficar;
	public JButton btnIniciarVotacion;
	public JComboBox comboBoxPrincipal;
	public JButton btnBuscar;
	public JTextArea textArea;
	public JComboBox comboBoxComunidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					Controlador controlador =  new Controlador(frame);
					frame.setVisible(true);
					centreWindow(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1614, 830);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("ELECCIONES ESPAÑA 2023\r\n");
		lblNewLabel.setFont(new Font("Agency FB", Font.ITALIC, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 1520, 71);
		contentPane.add(lblNewLabel);
	
	        
	    btnIniciarVotacion = new JButton("Iniciar Votación");
	        
	        
	    btnIniciarVotacion.setBounds(714, 91, 116, 40);
	    contentPane.add(btnIniciarVotacion);
	        
	    comboBoxPrincipal = new JComboBox();
	    comboBoxPrincipal.setModel(new DefaultComboBoxModel(new String[] {"", "Datos Generales", "Datos Comunidad", "Datos Rango"}));
	    comboBoxPrincipal.setBounds(31, 114, 149, 40);
	    contentPane.add(comboBoxPrincipal);
	    
	    btnBuscar = new JButton("Escrutinio");
	    btnBuscar.setBounds(190, 114, 136, 40);
	    contentPane.add(btnBuscar);
	    
	    textArea = new JTextArea();
	    textArea.setBounds(46, 217, 801, 218);
	    contentPane.add(textArea);
	    
	    comboBoxComunidad = new JComboBox();
	    comboBoxComunidad.setModel(new DefaultComboBoxModel(new String[] {"Andalucia", "Aragon", "Asturias", "Baleares", "Canarias", "Castilla La Mancha", "Castilla y Leon", "Catalunia", "Comunidad Valenciana", "Extremadura", "Galicia", "Madrid", "Murcia", "Navarra", "Pais Vasco", "La Rioja", "Ceuta", "Melilla"}));
	    comboBoxComunidad.setBounds(31, 164, 149, 40);
	    contentPane.add(comboBoxComunidad);
	        
	}
	
	
	
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y - 18);
	}
}
