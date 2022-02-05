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
		    btnBuscar.setBounds(1059, 263, 136, 40);
		    btnBuscar.setVisible(false);
		    contentPane.add(btnBuscar);
		    
		    comboBoxComunidad = new JComboBox();
		    comboBoxComunidad.setBounds(789, 263, 260, 40);
		    comboBoxComunidad.setFont(new Font("Agency FB", Font.PLAIN, 35));
		    comboBoxComunidad.setModel(new DefaultComboBoxModel(new String[] {"Andalucia", "Aragon", "Asturias", "Baleares", "Canarias", "Cantabria", "Castilla La Mancha", "Castilla y Leon", "Catalunia", "Comunidad Valenciana", "Extremadura", "Galicia", "Madrid", "Murcia", "Navarra", "Pais Vasco", "La Rioja", "Ceuta", "Melilla"}));
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
		    labelVotosPP.setBounds(811, 403, 116, 40);
		    labelVotosPP.setFont(new Font("Agency FB", Font.BOLD, 30));
		    labelVotosPP.setBackground(new Color(255, 0, 0));
		    labelVotosPP.setHorizontalAlignment(SwingConstants.CENTER);
		    contentPane.add(labelVotosPP);
		    
		    labelVotosPSOE = new JLabel("");
		    labelVotosPSOE.setBounds(973, 403, 116, 40);
		    labelVotosPSOE.setFont(new Font("Agency FB", Font.BOLD, 30));
		    labelVotosPSOE.setHorizontalAlignment(SwingConstants.CENTER);
		    contentPane.add(labelVotosPSOE);
		    
		    labelVotosVOX = new JLabel("");
		    labelVotosVOX.setBounds(1136, 403, 116, 40);
		    labelVotosVOX.setFont(new Font("Agency FB", Font.BOLD, 30));
		    labelVotosVOX.setHorizontalAlignment(SwingConstants.CENTER);
		    contentPane.add(labelVotosVOX);
		    
		    labelVotosCIUDADANOS = new JLabel("");
		    labelVotosCIUDADANOS.setBounds(1291, 403, 116, 32);
		    labelVotosCIUDADANOS.setFont(new Font("Agency FB", Font.BOLD, 30));
		    labelVotosCIUDADANOS.setHorizontalAlignment(SwingConstants.CENTER);
		    contentPane.add(labelVotosCIUDADANOS);
		    
		    lblNewLabel_1 = new JLabel("");
		    lblNewLabel_1.setBounds(789, 313, 149, 87);
		    lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\PP.png"));
		    lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 35));
		    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_1.setVisible(false);
		    contentPane.add(lblNewLabel_1);
		    
		    lblNewLabel_2 = new JLabel("");
		    lblNewLabel_2.setBounds(948, 324, 149, 71);
		    lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\PSOE.png"));
		    lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_2.setFont(new Font("Agency FB", Font.BOLD, 35));
		    lblNewLabel_2.setVisible(false);
		    contentPane.add(lblNewLabel_2);
		    
		    lblNewLabel_3 = new JLabel("");
		    lblNewLabel_3.setBounds(1115, 324, 149, 80);
		    lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\VOX.png"));
		    lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_3.setFont(new Font("Agency FB", Font.BOLD, 35));
		    lblNewLabel_3.setVisible(false);
		    contentPane.add(lblNewLabel_3);
		    
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
		    
		    JLabel labelFotoEspaña = new JLabel("");
		    labelFotoEspaña.setBounds(88, 244, 691, 525);
		    labelFotoEspaña.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\fotoEspaña.png"));
		    contentPane.add(labelFotoEspaña);
		    
		    labelCastillaLaMancha = new JLabel("");
		    labelCastillaLaMancha.setHorizontalAlignment(SwingConstants.CENTER);
		    labelCastillaLaMancha.setBounds(225, 260, 128, 57);
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
		    labelMelilla.setBounds(240, 500, 50, 50);
		    labelFotoEspaña.add(labelMelilla);
		    
		    
		    
		    
		    
		    pieDataSet = new DefaultPieDataset();
	        
	        pieDataSet.setValue("PSOE", new Integer(31));
	        pieDataSet.setValue("PP", new Integer(12));
	        pieDataSet.setValue("VOX", new Integer(25));
	        pieDataSet.setValue("CIUDADANOS", new Integer(8));
	        
	       
	        JFreeChart chart;
	        chart = ChartFactory.createPieChart3D("Elecciones Generales", pieDataSet, true, true, false);
	        
	        PiePlot plot = (PiePlot) chart.getPlot();
	        plot.setBackgroundPaint(Color.white);
	        plot.setOutlinePaint(null);
	        plot.setSectionPaint("PSOE", Color.RED);
	        plot.setSectionPaint("PP", Color.BLUE);
	        plot.setSectionPaint("CIUDADANOS", new Color(250, 117, 0));
	        plot.setSectionPaint("VOX", Color.GREEN);
	        
	        lblNewLabel_4 = new JLabel("");
	        lblNewLabel_4.setBounds(1291, 299, 100, 101);
	        contentPane.add(lblNewLabel_4);
	        lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\CIUDADANOS.png"));
	        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_4.setFont(new Font("Agency FB", Font.BOLD, 35));
	        
	        ChartPanel prueba = new ChartPanel(chart);
	        prueba.setBounds(838, 428, 588, 357);
	        contentPane.add(prueba);
	        lblNewLabel_4.setVisible(false);
	   

	        

		}
		
		
		
		public static void centreWindow(Window frame) {
		    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		    frame.setLocation(x, y - 18);
		}
}
