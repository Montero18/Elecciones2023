package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.general.DefaultPieDataset;

import Controlador.Controlador;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Vista extends JFrame {

	public JPanel contentPane;

	
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
	
	
	public JLabel labelFotoEspaña;
	public JLabel labelGalicia;
	public JLabel labelAsturias;
	public JLabel labelCantabria;
	public JLabel labelPaisVasco;
	public JLabel labelNavarra;
	public JLabel labelLaRioja;
	public JLabel labelAragon;
	public JLabel labelCatalunia;
	public JLabel labelValenciana;
	public JLabel labelMurcia;
	public JLabel labelBaleares;
	public JLabel labelAndalucia;
	public JLabel labelExtremadura;
	public JLabel labelCastillaLeon;
	public JLabel labelMadrid;
	public JLabel labelCastillaLaMancha;
	public JLabel labelCanarias;
	public JLabel labelCeuta;
	public JLabel labelMelilla;
	public JLabel labelVotosPP;
	public JLabel labelVotosPSOE;
	public JLabel labelVotosVOX;
	public JLabel labelVotosCIUDADANOS;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_3;
	public JLabel lblNewLabel_4;

	
	//Grafico
	public DefaultPieDataset pieDataSet;
	public JPanel panelGraficoComunidades;
	public JPanel panelComunidades;
	private JLabel lblNewLabel_5;
	
	
	
	
	
	//General
	public JPanel panelGeneral;
	public JLabel votosPPGeneral;
	public JLabel votosPSOEGeneral;
	public JLabel votosVOXGeneral;
	public JLabel votosCIUDADANOSGeneral;
	public JPanel panelGraficoGeneral;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	public JLabel labelGanadorGeneral;
	private JLabel lblNewLabel_10;
	private JLabel fotoEspañaBandera;
	private JLabel lblNewLabel_9;
	
	
	//Rango
	public JPanel panelRango;
	public JComboBox comboBoxRango;
	public JLabel votosPPRango;
	public JLabel votosPSOERango;
	public JLabel votosVOXRango;
	public JLabel votosCIUDADANOSRango;
	public JPanel panelGraficoRango;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_12;
	
	
	//Panel Numero Votos
	public JPanel panelNumeroVotos;
	public JTextField textField;
	private JLabel aux1;
	
	
	
	
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
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		 contentPane.setLayout(null);
		
		 
		    
		 	//Panel Numero Votos
		 
		 	panelNumeroVotos = new JPanel();
		    panelNumeroVotos.setBackground(Color.WHITE);
		    panelNumeroVotos.setBounds(0, 137, 1540, 658);
		    panelNumeroVotos.setVisible(true);
		    contentPane.add(panelNumeroVotos);
			panelNumeroVotos.setLayout(null);
		    

			btnIniciarVotacion = new JButton("Iniciar Votación");
			btnIniciarVotacion.setFont(new Font("Agency FB", Font.ITALIC, 55));
			btnIniciarVotacion.setBackground(Color.WHITE);
			btnIniciarVotacion.setBounds(575, 169, 390, 75);
			panelNumeroVotos.add(btnIniciarVotacion);
			
			textField = new JTextField();
			textField.setFont(new Font("Agency FB", Font.PLAIN, 35));
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setBounds(575, 364, 390, 75);
			panelNumeroVotos.add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel_11_0;
			aux1 = new JLabel("Escriba el valor del escrutinio: ");
			aux1.setHorizontalAlignment(SwingConstants.CENTER);
			aux1.setFont(new Font("Agency FB", Font.BOLD, 30));
			aux1.setBounds(575, 269, 390, 69);
			panelNumeroVotos.add(aux1);
			
			JLabel lblNewLabel_14 = new JLabel("");
			lblNewLabel_14.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\sombra.JPG"));
			lblNewLabel_14.setBounds(459, 80, 628, 471);
			panelNumeroVotos.add(lblNewLabel_14);
		    
		 	lblNewLabel = new JLabel("ELECCIONES GENERALES 2023");
		    lblNewLabel.setBounds(10, 20, 1520, 90);
		    lblNewLabel.setFont(new Font("Agency FB", Font.ITALIC, 60));
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
		    
		    
		    botonGeneral = new JButton("GENERAL");
		    botonGeneral.setBounds(0, 147, 513, 87);
		    botonGeneral.setFont(new Font("Agency FB", Font.BOLD, 50));
		    botonGeneral.setBackground(new Color(30, 144, 255));
		    botonGeneral.setVisible(false);
		    botonGeneral.setBorder(null);
		    contentPane.add(botonGeneral);
		    
		    botonComunidad = new JButton("COMUNIDAD");
		    botonComunidad.setBounds(512, 147, 513, 87);
		    botonComunidad.setFont(new Font("Agency FB", Font.BOLD, 50));
		    botonComunidad.setBackground(new Color(30, 144, 255));
		    botonComunidad.setBorder(null);
		    botonComunidad.setVisible(false);
		    contentPane.add(botonComunidad);
		    
		    botonRango = new JButton("RANGO");
		    botonRango.setBounds(1020, 147, 533, 87);
		    botonRango.setFont(new Font("Agency FB", Font.BOLD, 50));
		    botonRango.setBackground(new Color(30, 144, 255));
		    botonRango .setBorder(null);
		    botonRango.setVisible(false);
		    contentPane.add(botonRango);
		    
		  
		    
		    
		    
		    
		    //PANEL COMUNIDADES	    
		    panelComunidades = new JPanel();
		    panelComunidades.setBounds(0, 233, 1540, 562);
		    panelComunidades.setBackground(Color.WHITE);
		    panelComunidades.setVisible(false);
		    contentPane.add(panelComunidades);
		    
		    labelVotosPP = new JLabel("");
		    labelVotosPP.setForeground(Color.BLUE);
		    labelVotosPP.setBounds(828, 102, 100, 100);
		    labelVotosPP.setFont(new Font("Agency FB", Font.BOLD, 30));
		    labelVotosPP.setBackground(new Color(255, 0, 0));
		    labelVotosPP.setVisible(false);
		    panelComunidades.setLayout(null);
		    labelVotosPP.setHorizontalAlignment(SwingConstants.CENTER);
		    panelComunidades.add(labelVotosPP);
		    
		    labelVotosPSOE = new JLabel("");
		    labelVotosPSOE.setForeground(Color.RED);
		    labelVotosPSOE.setBounds(828, 201, 100, 100);
		    labelVotosPSOE.setFont(new Font("Agency FB", Font.BOLD, 30));
		    labelVotosPSOE.setVisible(false);
		    labelVotosPSOE.setHorizontalAlignment(SwingConstants.CENTER);
		    panelComunidades.add(labelVotosPSOE);
		    
		    labelVotosVOX = new JLabel("");
		    labelVotosVOX.setForeground(Color.GREEN);
		    labelVotosVOX.setBounds(828, 301, 100, 100);
		    labelVotosVOX.setFont(new Font("Agency FB", Font.BOLD, 30));
		    labelVotosVOX.setVisible(false);
		    labelVotosVOX.setHorizontalAlignment(SwingConstants.CENTER);
		    panelComunidades.add(labelVotosVOX);
		    
		    labelVotosCIUDADANOS = new JLabel("");
		    labelVotosCIUDADANOS.setForeground(Color.ORANGE);
		    labelVotosCIUDADANOS.setBounds(828, 406, 100, 100);
		    labelVotosCIUDADANOS.setFont(new Font("Agency FB", Font.BOLD, 30));
		    labelVotosCIUDADANOS.setVisible(false);
		    labelVotosCIUDADANOS.setHorizontalAlignment(SwingConstants.CENTER);
		    panelComunidades.add(labelVotosCIUDADANOS);
		    
		    lblNewLabel_1 = new JLabel("");
		    lblNewLabel_1.setBounds(718, 102, 100, 100);
		    lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\PP.png"));
		    lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 35));
		    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_1.setVisible(false);
		    panelComunidades.add(lblNewLabel_1);
		    
		    lblNewLabel_2 = new JLabel("");
		    lblNewLabel_2.setBounds(718, 201, 100, 100);
		    lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\PSOE.png"));
		    lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_2.setFont(new Font("Agency FB", Font.BOLD, 35));
		    lblNewLabel_2.setVisible(false);
		    panelComunidades.add(lblNewLabel_2);
		    
		    lblNewLabel_3 = new JLabel("");
		    lblNewLabel_3.setBounds(718, 301, 100, 100);
		    lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\VOX.png"));
		    lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_3.setFont(new Font("Agency FB", Font.BOLD, 35));
		    lblNewLabel_3.setVisible(false);
		    panelComunidades.add(lblNewLabel_3);
		    
		    lblNewLabel_4 = new JLabel("");
	        lblNewLabel_4.setBounds(718, 406, 100, 100);
	        lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\CIUDADANOS.png"));
	        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_4.setVisible(false);
	        lblNewLabel_4.setFont(new Font("Agency FB", Font.BOLD, 35));
	        panelComunidades.add(lblNewLabel_4);
		    
		    labelFotoEspaña = new JLabel("");
		    labelFotoEspaña.setBounds(10, 10, 650, 531);
		    labelFotoEspaña.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\fotoEspaña.png"));
		    labelFotoEspaña.setVisible(false);
		    panelComunidades.add(labelFotoEspaña);
		    
		    labelCastillaLaMancha = new JLabel("");
		    labelCastillaLaMancha.setHorizontalAlignment(SwingConstants.CENTER);
		    labelCastillaLaMancha.setBounds(260, 255, 50, 50);
		    labelFotoEspaña.add(labelCastillaLaMancha);
		    
		    labelAsturias = new JLabel("");
		    labelAsturias.setHorizontalAlignment(SwingConstants.CENTER);
		    labelAsturias.setBounds(145, 30, 50, 50);
		    labelFotoEspaña.add(labelAsturias);
		    
		    labelGalicia = new JLabel("");
		    labelGalicia.setHorizontalAlignment(SwingConstants.CENTER);
		    labelGalicia.setBounds(50, 60, 50, 50);
		    labelFotoEspaña.add(labelGalicia);
		    
		    labelCantabria = new JLabel("");
		    labelCantabria.setHorizontalAlignment(SwingConstants.CENTER);
		    labelCantabria.setBounds(220, 40, 50, 50);
		    labelFotoEspaña.add(labelCantabria);
		    
		    labelPaisVasco = new JLabel("");
		    labelPaisVasco.setHorizontalAlignment(SwingConstants.CENTER);
		    labelPaisVasco.setBounds(280, 45, 50, 50);
		    labelFotoEspaña.add(labelPaisVasco);
		    
		    labelNavarra = new JLabel("");
		    labelNavarra.setHorizontalAlignment(SwingConstants.CENTER);
		    labelNavarra.setBounds(320, 65, 50, 50);
		    labelFotoEspaña.add(labelNavarra);
		    
		    labelLaRioja = new JLabel("");
		    labelLaRioja.setHorizontalAlignment(SwingConstants.CENTER);
		    labelLaRioja.setBounds(290, 95, 50, 50);
		    labelFotoEspaña.add(labelLaRioja);
		    
		    labelAragon = new JLabel("");
		    labelAragon.setHorizontalAlignment(SwingConstants.CENTER);
		    labelAragon.setBounds(370, 140, 50, 50);
		    labelFotoEspaña.add(labelAragon);
		    
		    labelCatalunia = new JLabel("");
		    labelCatalunia.setHorizontalAlignment(SwingConstants.CENTER);
		    labelCatalunia.setBounds(460, 110, 60, 55);
		    labelFotoEspaña.add(labelCatalunia);
		    
		    labelValenciana = new JLabel("");
		    labelValenciana.setHorizontalAlignment(SwingConstants.CENTER);
		    labelValenciana.setBounds(390, 270, 50, 50);
		    labelFotoEspaña.add(labelValenciana);
		    
		    labelBaleares = new JLabel("");
		    labelBaleares.setBounds(540, 290, 50, 50);
		    labelFotoEspaña.add(labelBaleares);
		    
		    labelMurcia = new JLabel("");
		    labelMurcia.setHorizontalAlignment(SwingConstants.CENTER);
		    labelMurcia.setBounds(340, 350, 50, 50);
		    labelFotoEspaña.add(labelMurcia);
		    
		    labelAndalucia = new JLabel("");
		    labelAndalucia.setHorizontalAlignment(SwingConstants.CENTER);
		    labelAndalucia.setBounds(185, 360, 100, 71);
		    labelFotoEspaña.add(labelAndalucia);
		    
		    labelExtremadura = new JLabel("");
		    labelExtremadura.setHorizontalAlignment(SwingConstants.CENTER);
		    labelExtremadura.setBounds(110, 270, 83, 57);
		    labelFotoEspaña.add(labelExtremadura);
		    
		    labelMadrid = new JLabel("");
		    labelMadrid.setHorizontalAlignment(SwingConstants.CENTER);
		    labelMadrid.setBounds(230, 200, 50, 50);
		    labelFotoEspaña.add(labelMadrid);
		    
		    labelCastillaLeon = new JLabel("");
		    labelCastillaLeon.setHorizontalAlignment(SwingConstants.CENTER);
		    labelCastillaLeon.setBounds(165, 120, 83, 62);
		    labelFotoEspaña.add(labelCastillaLeon);
		    
		    labelCanarias = new JLabel("");
		    labelCanarias.setHorizontalAlignment(SwingConstants.CENTER);
		    labelCanarias.setBounds(510, 390, 50, 50);
		    labelFotoEspaña.add(labelCanarias);
		    
		    labelCeuta = new JLabel("");
		    labelCeuta.setHorizontalAlignment(SwingConstants.CENTER);
		    labelCeuta.setBounds(180, 490, 50, 50);
		    labelFotoEspaña.add(labelCeuta);
		    
		    labelMelilla = new JLabel("");
		    labelMelilla.setHorizontalAlignment(SwingConstants.CENTER);
		    labelMelilla.setBounds(240, 495, 50, 50);
		    labelFotoEspaña.add(labelMelilla);
		    
		    panelGraficoComunidades = new JPanel();
		    panelGraficoComunidades.setBackground(Color.WHITE);
		    panelGraficoComunidades.setBounds(934, 84, 534, 445);
		    panelComunidades.add(panelGraficoComunidades);
		    
		    comboBoxComunidad = new JComboBox();
		    comboBoxComunidad.setBounds(705, 34, 260, 40);
		    panelComunidades.add(comboBoxComunidad);
		    comboBoxComunidad.setFont(new Font("Agency FB", Font.PLAIN, 35));
		    comboBoxComunidad.setModel(new DefaultComboBoxModel(new String[] {"", "Andalucia", "Aragon", "Asturias", "Baleares", "Canarias", "Cantabria", "Castilla La Mancha", "Castilla y Leon", "Catalunia", "Comunidad Valenciana", "Extremadura", "Galicia", "Madrid", "Murcia", "Navarra", "Pais Vasco", "La Rioja", "Ceuta", "Melilla"}));
		    
		    btnBuscar = new JButton("Escrutinio");
		    btnBuscar.setBounds(975, 34, 136, 40);
		    panelComunidades.add(btnBuscar);
		    
		    lblNewLabel_5 = new JLabel("New label");
		    lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\sombra.JPG"));
		    lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_5.setBounds(657, 11, 860, 541);
		    panelComunidades.add(lblNewLabel_5);
		    
		    ImageIcon imagen = new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\sombra.JPG");
		    Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel_5.getWidth(), lblNewLabel_5.getHeight(), Image.SCALE_DEFAULT));
		    lblNewLabel_5.setIcon(icono);
		  
		    
		    //PANEL GENERAL
		    panelGeneral = new JPanel();
		    panelGeneral.setBackground(Color.WHITE);
		    panelGeneral.setBounds(0, 233, 1530, 562);
		    contentPane.add(panelGeneral);
		    panelGeneral.setVisible(false);
		    
		    panelGraficoGeneral = new JPanel();
		    panelGraficoGeneral.setBounds(142, 55, 572, 458);
		    panelGraficoGeneral.setBackground(Color.WHITE);
		    panelGraficoGeneral.setVisible(false);
		    panelGeneral.setLayout(null);
		    panelGeneral.add(panelGraficoGeneral);
		    
		    lblNewLabel_6 = new JLabel("");
		    lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_6.setBounds(110, 10, 637, 542);
		    panelGeneral.add(lblNewLabel_6);
		    	
		    ImageIcon imagenGeneral = new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\sombra.JPG");
		    Icon iconoGeneral = new ImageIcon(imagenGeneral.getImage().getScaledInstance(lblNewLabel_6.getWidth(), lblNewLabel_6.getHeight(), Image.SCALE_DEFAULT));
		    lblNewLabel_6.setIcon(iconoGeneral);
		    
		    JLabel fotoPPGeneral = new JLabel("");
		    fotoPPGeneral.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\PP.png"));
		    fotoPPGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		    fotoPPGeneral.setBounds(893, 55, 100, 100);
		    panelGeneral.add(fotoPPGeneral);
		    
		    JLabel fotoPSOEGeneral = new JLabel("");
		    fotoPSOEGeneral.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\PSOE.png"));
		    fotoPSOEGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		    fotoPSOEGeneral.setBounds(1033, 55, 100, 100);
		    panelGeneral.add(fotoPSOEGeneral);
		    
		    JLabel fotoVOXGeneral = new JLabel("");
		    fotoVOXGeneral.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\VOX.png"));
		    fotoVOXGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		    fotoVOXGeneral.setBounds(1176, 55, 100, 100);
		    panelGeneral.add(fotoVOXGeneral);
		    
		    JLabel fotoCIUDADANOSGeneral = new JLabel("");
		    fotoCIUDADANOSGeneral.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\CIUDADANOS.png"));
		    fotoCIUDADANOSGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		    fotoCIUDADANOSGeneral.setBounds(1317, 55, 100, 100);
		    panelGeneral.add(fotoCIUDADANOSGeneral);
		    
		    votosPPGeneral = new JLabel("");
		    votosPPGeneral.setForeground(Color.BLUE);
		    votosPPGeneral.setFont(new Font("Agency FB", Font.PLAIN, 40));
		    votosPPGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		    votosPPGeneral.setBounds(893, 131, 100, 100);
		    panelGeneral.add(votosPPGeneral);
		    
		    votosPSOEGeneral = new JLabel("");
		    votosPSOEGeneral.setForeground(Color.RED);
		    votosPSOEGeneral.setFont(new Font("Agency FB", Font.PLAIN, 40));
		    votosPSOEGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		    votosPSOEGeneral.setBounds(1033, 131, 100, 100);
		    panelGeneral.add(votosPSOEGeneral);
		    
		    votosVOXGeneral = new JLabel("");
		    votosVOXGeneral.setForeground(Color.GREEN);
		    votosVOXGeneral.setFont(new Font("Agency FB", Font.PLAIN, 40));
		    votosVOXGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		    votosVOXGeneral.setBounds(1176, 131, 100, 100);
		    panelGeneral.add(votosVOXGeneral);
		    
		    votosCIUDADANOSGeneral = new JLabel("");
		    votosCIUDADANOSGeneral.setForeground(Color.ORANGE);
		    votosCIUDADANOSGeneral.setFont(new Font("Agency FB", Font.PLAIN, 40));
		    votosCIUDADANOSGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		    votosCIUDADANOSGeneral.setBounds(1317, 131, 100, 100);
		    panelGeneral.add(votosCIUDADANOSGeneral);
		    
		    lblNewLabel_7 = new JLabel("EL VENCEDOR DE LAS ELECCIONES HA SIDO:");
		    lblNewLabel_7.setBounds(855, 208, 637, 131);
		    panelGeneral.add(lblNewLabel_7);
		    lblNewLabel_7.setFont(new Font("Corbel Light", Font.PLAIN, 30));
		    lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		    
		    lblNewLabel_10 = new JLabel("FELICITACIONES. ROBARÁ HASTA EL 2027");
		    lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_10.setFont(new Font("Corbel Light", Font.PLAIN, 30));
		    lblNewLabel_10.setBounds(855, 410, 637, 131);
		    panelGeneral.add(lblNewLabel_10);
		    
		    lblNewLabel_8 = new JLabel("");
		    lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\sombra.JPG"));
		    lblNewLabel_8.setBounds(832, 183, 660, 358);
		    panelGeneral.add(lblNewLabel_8);
		    
		    ImageIcon imagenPanelGanador = new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\sombra.JPG");
		    Icon iconoPanelGanador = new ImageIcon(imagenPanelGanador.getImage().getScaledInstance(lblNewLabel_8.getWidth(), lblNewLabel_8.getHeight(), Image.SCALE_DEFAULT));
		    lblNewLabel_8.setIcon(iconoPanelGanador);
		    
		    labelGanadorGeneral = new JLabel("");
		    lblNewLabel_8.add(labelGanadorGeneral);
		    labelGanadorGeneral.setBounds(500, 140, 100, 100);
		    
		    fotoEspañaBandera = new JLabel("");
		    fotoEspañaBandera.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\fotoEspañaBandera.png"));
		    fotoEspañaBandera.setBounds(60, 130, 560, 120);
		    lblNewLabel_8.add(fotoEspañaBandera);
		    
		    ImageIcon imagenEspañaGanador = new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\sombra.JPG");
		    Icon iconoEspañaGanador = new ImageIcon(imagenEspañaGanador.getImage().getScaledInstance(lblNewLabel_8.getWidth(), lblNewLabel_8.getHeight(), Image.SCALE_DEFAULT));
		    lblNewLabel_8.setIcon(iconoEspañaGanador);
		    
		    
		    
	        
	     
	        //Panel Rango   
		    panelRango = new JPanel();
		    panelRango.setBackground(Color.WHITE);
		    panelRango.setBounds(0, 233, 1540, 552);
		    contentPane.add(panelRango);
		    panelRango.setVisible(false);
		    panelRango.setLayout(null);
		    
		    comboBoxRango = new JComboBox();
		    comboBoxRango.setBackground(Color.WHITE);
		    comboBoxRango.setFont(new Font("Agency FB", Font.PLAIN, 30));
		    comboBoxRango.setModel(new DefaultComboBoxModel(new String[] {"18 - 25 años", "26 - 40 años", "41 - 65 años", "+66 años"}));
		    comboBoxRango.setBounds(1010, 145, 206, 49);
		    panelRango.add(comboBoxRango);
		    
		    JLabel lblNewLabel_11_01 = new JLabel("");
		    lblNewLabel_11_01.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\PP.png"));
		    lblNewLabel_11_01.setFont(new Font("Agency FB", Font.PLAIN, 40));
		    lblNewLabel_11_01.setBounds(895, 225, 100, 100);
		    panelRango.add(lblNewLabel_11_01);
		    
		    JLabel lblNewLabel_11_1 = new JLabel("");
		    lblNewLabel_11_1.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\PSOE.png"));
		    lblNewLabel_11_1.setFont(new Font("Agency FB", Font.PLAIN, 40));
		    lblNewLabel_11_1.setBounds(895, 335, 100, 100);
		    panelRango.add(lblNewLabel_11_1);
		    
		    JLabel lblNewLabel_11_2 = new JLabel("");
		    lblNewLabel_11_2.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\VOX.png"));
		    lblNewLabel_11_2.setFont(new Font("Agency FB", Font.PLAIN, 40));
		    lblNewLabel_11_2.setBounds(1153, 225, 100, 100);
		    panelRango.add(lblNewLabel_11_2);
		    
		    JLabel lblNewLabel_11_3 = new JLabel("");
		    lblNewLabel_11_3.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\CIUDADANOS.png"));
		    lblNewLabel_11_3.setFont(new Font("Agency FB", Font.PLAIN, 40));
		    lblNewLabel_11_3.setBounds(1153, 335, 100, 100);
		    panelRango.add(lblNewLabel_11_3);
		    
		    votosPPRango = new JLabel("");
		    votosPPRango.setForeground(Color.BLUE);
		    votosPPRango.setFont(new Font("Agency FB", Font.PLAIN, 40));
		    votosPPRango.setBounds(1026, 225, 100, 100);
		    panelRango.add(votosPPRango);
		    
		    votosPSOERango = new JLabel("");
		    votosPSOERango.setForeground(Color.RED);
		    votosPSOERango.setFont(new Font("Agency FB", Font.PLAIN, 40));
		    votosPSOERango.setBounds(1026, 335, 100, 100);
		    panelRango.add(votosPSOERango);
		    
		    votosVOXRango = new JLabel("");
		    votosVOXRango.setForeground(Color.GREEN);
		    votosVOXRango.setFont(new Font("Agency FB", Font.PLAIN, 40));
		    votosVOXRango.setBounds(1284, 225, 100, 100);
		    panelRango.add(votosVOXRango);
		    
		    votosCIUDADANOSRango = new JLabel("");
		    votosCIUDADANOSRango.setForeground(Color.ORANGE);
		    votosCIUDADANOSRango.setFont(new Font("Agency FB", Font.PLAIN, 40));
		    votosCIUDADANOSRango.setBounds(1284, 335, 100, 100);
		    panelRango.add(votosCIUDADANOSRango);
		    
		    panelGraficoRango = new JPanel();
		    panelGraficoRango.setBackground(Color.WHITE);
		    panelGraficoRango.setBounds(148, 46, 570, 453);
		    panelRango.add(panelGraficoRango);
		    
		    lblNewLabel_9 = new JLabel("");
		    lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_9.setBounds(110, 10, 637, 542);
		    panelRango.add(lblNewLabel_9);

		    ImageIcon imagenRango = new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\sombra.JPG");
		    Icon iconoRango = new ImageIcon(imagenRango.getImage().getScaledInstance(lblNewLabel_9.getWidth(), lblNewLabel_9.getHeight(), Image.SCALE_DEFAULT));
		    lblNewLabel_9.setIcon(iconoRango);
		    
		    lblNewLabel_13 = new JLabel("Seleccione\r\n una \r\n edad:");
		    lblNewLabel_13.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		    lblNewLabel_13.setBackground(Color.WHITE);
		    lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_13.setBounds(897, 33, 436, 171);
		    panelRango.add(lblNewLabel_13);
		    
		    lblNewLabel_12 = new JLabel("");
		    lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\sombra.JPG"));
		    lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_12.setBounds(802, 10, 637, 542);
		    panelRango.add(lblNewLabel_12);
		    
		    
		    

		}
		
		
		
		public static void centreWindow(Window frame) {
		    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		    frame.setLocation(x, y - 18);
		}
}
