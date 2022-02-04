package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista extends JFrame {

	public JPanel contentPane;
	public JTextField tf1;
	public JTextField tf2;
	public JTextField tf3;
	public JTextField tf4;
	public boolean bandera=false;
	
	public JButton btnGraficar;
	public JButton btnIniciarVotacion;
	public JButton btnBuscar;
	public JComboBox comboBoxComunidad;
	public JLabel lblNewLabel;
	public JLabel label;
	private JLabel labelFoto1;
	
	
	public JButton botonGeneral;
	public JButton botonComunidad;
	public JButton botonRango;
	
	
	public JLabel labelCastillaLaMancha;
	
	
	public JLabel labelVotosPP;
	public JLabel labelVotosPSOE;
	public JLabel labelVotosVOX;
	public JLabel labelVotosCIUDADANOS;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_3;
	public JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					Controlador controlador = new Controlador(frame);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1560, 832);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		 contentPane.setLayout(null);
		
		 btnIniciarVotacion = new JButton("Iniciar Votación");
		 btnIniciarVotacion.setBounds(714, 91, 116, 40);
		    contentPane.add(btnIniciarVotacion);
		    
		    btnBuscar = new JButton("Escrutinio");
		    btnBuscar.setBounds(1118, 259, 136, 40);
		    btnBuscar.setVisible(false);
		    contentPane.add(btnBuscar);
		    
		    comboBoxComunidad = new JComboBox();
		    comboBoxComunidad.setBounds(848, 259, 260, 40);
		    comboBoxComunidad.setFont(new Font("Agency FB", Font.PLAIN, 35));
		    comboBoxComunidad.setModel(new DefaultComboBoxModel(new String[] {"Andalucia", "Aragon", "Asturias", "Baleares", "Canarias", "Castilla La Mancha", "Castilla y Leon", "Catalunia", "Comunidad Valenciana", "Extremadura", "Galicia", "Madrid", "Murcia", "Navarra", "Pais Vasco", "La Rioja", "Ceuta", "Melilla"}));
		    comboBoxComunidad.setVisible(false);
		    contentPane.add(comboBoxComunidad);
		 
		    
		    lblNewLabel = new JLabel("ELECCIONES GENERALES 2023");
		    lblNewLabel.setBounds(10, 20, 1520, 71);
		    lblNewLabel.setFont(new Font("Agency FB", Font.ITALIC, 50));
		    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		    contentPane.add(lblNewLabel);
		    
		    label = new JLabel("");
		    label.setBounds(278, 10, 100, 100);
		    label.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\fotoVoto.png"));
		    contentPane.add(label);
		    
		    labelFoto1 = new JLabel("");
		    labelFoto1.setBounds(1136, 20, 100, 100);
		    labelFoto1.setHorizontalAlignment(SwingConstants.CENTER);
		    labelFoto1.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\logo-elecciones.png"));
		    contentPane.add(labelFoto1);
		    
		   
		    
		    labelVotosPP = new JLabel("");
		    labelVotosPP.setBounds(1034, 354, 116, 87);
		    labelVotosPP.setFont(new Font("Agency FB", Font.BOLD, 30));
		    labelVotosPP.setBackground(new Color(255, 0, 0));
		    labelVotosPP.setHorizontalAlignment(SwingConstants.CENTER);
		    contentPane.add(labelVotosPP);
		    
		    labelVotosPSOE = new JLabel("");
		    labelVotosPSOE.setBounds(1034, 451, 116, 71);
		    labelVotosPSOE.setFont(new Font("Agency FB", Font.BOLD, 30));
		    labelVotosPSOE.setHorizontalAlignment(SwingConstants.CENTER);
		    contentPane.add(labelVotosPSOE);
		    
		    labelVotosVOX = new JLabel("");
		    labelVotosVOX.setBounds(1034, 544, 116, 80);
		    labelVotosVOX.setFont(new Font("Agency FB", Font.BOLD, 30));
		    labelVotosVOX.setHorizontalAlignment(SwingConstants.CENTER);
		    contentPane.add(labelVotosVOX);
		    
		    labelVotosCIUDADANOS = new JLabel("");
		    labelVotosCIUDADANOS.setBounds(1034, 634, 116, 100);
		    labelVotosCIUDADANOS.setFont(new Font("Agency FB", Font.BOLD, 30));
		    labelVotosCIUDADANOS.setHorizontalAlignment(SwingConstants.CENTER);
		    contentPane.add(labelVotosCIUDADANOS);
		    
		    lblNewLabel_1 = new JLabel("");
		    lblNewLabel_1.setBounds(886, 354, 149, 87);
		    lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\PP.png"));
		    lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 35));
		    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_1.setVisible(false);
		    contentPane.add(lblNewLabel_1);
		    
		    lblNewLabel_2 = new JLabel("");
		    lblNewLabel_2.setBounds(886, 451, 149, 71);
		    lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\PSOE.png"));
		    lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_2.setFont(new Font("Agency FB", Font.BOLD, 35));
		    lblNewLabel_2.setVisible(false);
		    contentPane.add(lblNewLabel_2);
		    
		    lblNewLabel_3 = new JLabel("");
		    lblNewLabel_3.setBounds(886, 544, 149, 80);
		    lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\VOX.png"));
		    lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_3.setFont(new Font("Agency FB", Font.BOLD, 35));
		    lblNewLabel_3.setVisible(false);
		    contentPane.add(lblNewLabel_3);
		    
		    lblNewLabel_4 = new JLabel("");
		    lblNewLabel_4.setBounds(886, 634, 149, 100);
		    lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\CIUDADANOS.png"));
		    lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_4.setFont(new Font("Agency FB", Font.BOLD, 35));
		    lblNewLabel_4.setVisible(false);
		    contentPane.add(lblNewLabel_4);
		    
		    botonGeneral = new JButton("GENERAL");
		    botonGeneral.setBounds(0, 147, 513, 87);
		    botonGeneral.setFont(new Font("Agency FB", Font.BOLD, 50));
		    botonGeneral.setBackground(new Color(30, 144, 255));
		    botonGeneral.setBorder(null);
		    contentPane.add(botonGeneral);
		    
		    botonComunidad = new JButton("COMUNIDAD");
		    botonComunidad.setBounds(512, 147, 513, 87);
		    botonComunidad.setFont(new Font("Agency FB", Font.BOLD, 50));
		    botonComunidad.setBackground(new Color(30, 144, 255));
		    botonComunidad.setBorder(null);
		    contentPane.add(botonComunidad);
		    
		    botonRango = new JButton("RANGO");
		    botonRango.setBounds(1020, 147, 533, 87);
		    botonRango.setFont(new Font("Agency FB", Font.BOLD, 50));
		    botonRango.setBackground(new Color(30, 144, 255));
		    botonRango .setBorder(null);
		    contentPane.add(botonRango);
		    
		    JLabel lblNewLabel_5 = new JLabel("");
		    lblNewLabel_5.setBounds(85, 244, 691, 525);
		    lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\fotoEspaña.png"));
		    contentPane.add(lblNewLabel_5);
		    
		    labelCastillaLaMancha = new JLabel("New label");
		    labelCastillaLaMancha.setBounds(307, 509, 50, 50);
		    contentPane.add(labelCastillaLaMancha);
		}
		
		
		
		public static void centreWindow(Window frame) {
		    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		    frame.setLocation(x, y - 18);
		}
}
