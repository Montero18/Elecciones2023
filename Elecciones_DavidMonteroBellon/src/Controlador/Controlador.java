package Controlador;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import modelo.Modelo;
import modelo.VotosComunidades;
import net.bytebuddy.matcher.ModifierMatcher.Mode;

import javax.swing.border.BevelBorder;

import vista.Vista;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;




public class Controlador implements ActionListener{

	
	Vista frame = new Vista();
	ArrayList<VotosComunidades> votosComunidad;
	ArrayList<Integer> votosRango;
	
	public Controlador (vista.Vista vista) {
		this.frame = vista;
		this.frame.btnIniciarVotacion.addActionListener(this);
		
		this.frame.botonGeneral.addActionListener(this);
		
		this.frame.btnBuscar.addActionListener(this);
		this.frame.comboBoxComunidad.addActionListener(this);	
		this.frame.botonComunidad.addActionListener(this);
		
		this.frame.botonRango.addActionListener(this);
		this.frame.comboBoxRango.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Modelo modelo = new Modelo();
		
		
		
    	SessionFactory sessionFactory = null;

    	Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
		
        
        //Boton Iniciar Votacion
		if(e.getSource() == frame.btnIniciarVotacion) {
			try {
				
				
				if(frame.textField.getText().length()==0){
				    frame.labelError.setVisible(true);
					frame.btnIniciarVotacion.setVisible(true);

				}else {
					int numeroVotos = Integer.parseInt(frame.textField.getText());
					modelo.listarDatos(numeroVotos);
					
					frame.panelNumeroVotos.setVisible(false);
					
					frame.btnIniciarVotacion.setVisible(false);
					frame.botonGeneral.setVisible(true);
					frame.botonComunidad.setVisible(true);
					frame.botonRango.setVisible(true);
				}
				
			} catch (Exception exception) {
				// TODO: handle exception
				exception.printStackTrace();
				
				
			}
		}
		
		//Boton General
		if(e.getSource() == frame.botonGeneral) {
			frame.panelComunidades.setVisible(false);
			frame.panelRango.setVisible(false);
			frame.panelGraficoGeneral.setVisible(true);
			frame.panelGeneral.setVisible(true);
			
			System.out.println("hola");
			
			ArrayList<String> listaDatos = datosGeneral(sessionFactory);
			
			
			int votosPP = Integer.parseInt(listaDatos.get(0));
			int votosPSOE = Integer.parseInt(listaDatos.get(1));
			int votosVOX = Integer.parseInt(listaDatos.get(2));
			int votosCiudadanos = Integer.parseInt(listaDatos.get(3));
			
			frame.votosPPGeneral.setText("" + votosPP);
			frame.votosPSOEGeneral.setText("" + votosPSOE);
			frame.votosVOXGeneral.setText("" + votosVOX);
			frame.votosCIUDADANOSGeneral.setText("" + votosCiudadanos);
			
			obtenerGanadorGeneral(sessionFactory, votosPP, votosPSOE, votosVOX, votosCiudadanos, frame.labelGanadorGeneral);
			
			
			ChartPanel prueba =  grafico("Datos Generales", votosPP, votosPSOE, votosVOX, votosCiudadanos);
			frame.panelGraficoGeneral.add(prueba);
			
			
			
		}
		
		//Boton Comunidad
		if(e.getSource() == frame.botonComunidad) {
			frame.panelGeneral.setVisible(false);
			frame.panelRango.setVisible(false);
	
			frame.panelGraficoComunidades.removeAll();
			
			try {
				frame.panelComunidades.setVisible(true);
				frame.btnBuscar.setVisible(true);
				frame.comboBoxComunidad.setVisible(true);
				frame.labelFotoEspaña.setVisible(true);
			
				datosComunidad(sessionFactory, "Andalucia", frame.labelAndalucia);
				datosComunidad(sessionFactory, "Aragon", frame.labelAragon);
				datosComunidad(sessionFactory, "Asturias", frame.labelAsturias);
				datosComunidad(sessionFactory, "Baleares", frame.labelBaleares);
				datosComunidad(sessionFactory, "Canarias", frame.labelCanarias);
				datosComunidad(sessionFactory, "Cantabria", frame.labelCantabria);
				datosComunidad(sessionFactory, "Castilla La Mancha", frame.labelCastillaLaMancha);
				datosComunidad(sessionFactory, "Castilla y Leon", frame.labelCastillaLeon);				
				datosComunidad(sessionFactory, "Catalunia", frame.labelCatalunia);
				datosComunidad(sessionFactory, "Comunidad Valenciana", frame.labelValenciana);
				datosComunidad(sessionFactory, "Extremadura", frame.labelExtremadura);
				datosComunidad(sessionFactory, "Galicia", frame.labelGalicia);
				datosComunidad(sessionFactory, "Madrid", frame.labelMadrid);
				datosComunidad(sessionFactory, "Murcia", frame.labelMurcia);
				datosComunidad(sessionFactory, "Navarra", frame.labelNavarra);
				datosComunidad(sessionFactory, "Pais Vasco", frame.labelPaisVasco);
				datosComunidad(sessionFactory, "La Rioja", frame.labelLaRioja);
				datosComunidad(sessionFactory, "Ceuta", frame.labelCeuta);
				datosComunidad(sessionFactory, "Melilla", frame.labelMelilla);
				
				
				frame.labelVotosPP.setText("");
				frame.labelVotosPSOE.setText("");
				frame.labelVotosVOX.setText("");
				frame.labelVotosCIUDADANOS.setText("");

				
				frame.labelVotosPP.setVisible(true);
				frame.labelVotosPSOE.setVisible(true);
				frame.labelVotosVOX.setVisible(true);
				frame.labelVotosCIUDADANOS.setVisible(true);
				frame.lblNewLabel_1.setVisible(true);
				frame.lblNewLabel_2.setVisible(true);
				frame.lblNewLabel_3.setVisible(true);
				frame.lblNewLabel_4.setVisible(true);
						
				
			} catch (Exception exception) {
				// TODO: handle exception
				exception.printStackTrace();				
			}	
		}
		
		
		//Boton Buscar Comunidad
		if(e.getSource() == frame.btnBuscar) {
			
			frame.panelGraficoComunidades.removeAll();
			
			if(frame.comboBoxComunidad.getSelectedItem().equals("Andalucia")) {
				datosComunidad(sessionFactory, "Andalucia", frame.labelAndalucia);
				if(votosComunidad.get(0).getComunidad().equals("Andalucia")) {
					ChartPanel prueba =  grafico("Andalucia", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}
				

			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Aragon")) {
				datosComunidad(sessionFactory, "Aragon", frame.labelAragon);
				if(votosComunidad.get(0).getComunidad().equals("Aragon")) {
					ChartPanel prueba =  grafico("Aragon", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}

			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Asturias")) {
				datosComunidad(sessionFactory, "Asturias", frame.labelAsturias);
				if(votosComunidad.get(0).getComunidad().equals("Asturias")) {
					ChartPanel prueba =  grafico("Asturias", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}
				
			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Baleares")) {
				datosComunidad(sessionFactory, "Baleares", frame.labelBaleares);
				if(votosComunidad.get(0).getComunidad().equals("Baleares")) {
					ChartPanel prueba =  grafico("Baleares", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}
			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Canarias")) {
				datosComunidad(sessionFactory, "Canarias", frame.labelCanarias);
				if(votosComunidad.get(0).getComunidad().equals("Canarias")) {
					ChartPanel prueba =  grafico("Canarias", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}
			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Cantabria")) {
				datosComunidad(sessionFactory, "Cantabria", frame.labelCantabria);
				if(votosComunidad.get(0).getComunidad().equals("Cantabria")) {
					ChartPanel prueba =  grafico("Cantabria", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}
			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Castilla La Mancha")) {
				datosComunidad(sessionFactory, "Castilla La Mancha", frame.labelCastillaLaMancha);
				if(votosComunidad.get(0).getComunidad().equals("Castilla La Mancha")) {
					ChartPanel prueba =  grafico("Castilla La Mancha", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}
			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Castilla y Leon")) {
				datosComunidad(sessionFactory, "Castilla y Leon", frame.labelCastillaLeon);
				if(votosComunidad.get(0).getComunidad().equals("Castilla y Leon")) {
					ChartPanel prueba =  grafico("Castilla y Leon", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}
			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Catalunia")) {
				datosComunidad(sessionFactory, "Catalunia", frame.labelCatalunia);
				if(votosComunidad.get(0).getComunidad().equals("Catalunia")) {
					ChartPanel prueba =  grafico("Catalunia", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}
			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Comunidad Valenciana")) {
				datosComunidad(sessionFactory, "Comunidad Valenciana", frame.labelValenciana);
				if(votosComunidad.get(0).getComunidad().equals("Comunidad Valenciana")) {
					ChartPanel prueba =  grafico("Comunidad Valenciana", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}
			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Extremadura")) {
				datosComunidad(sessionFactory, "Extremadura", frame.labelExtremadura);
				if(votosComunidad.get(0).getComunidad().equals("Extremadura")) {
					ChartPanel prueba =  grafico("Extremadura", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}
			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Galicia")) {
				datosComunidad(sessionFactory, "Galicia", frame.labelGalicia);
				if(votosComunidad.get(0).getComunidad().equals("Galicia")) {
					ChartPanel prueba =  grafico("Galicia", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}
			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Madrid")) {
				datosComunidad(sessionFactory, "Madrid", frame.labelMadrid);
				if(votosComunidad.get(0).getComunidad().equals("Madrid")) {
					ChartPanel prueba =  grafico("Madrid", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}
			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Murcia")) {
				datosComunidad(sessionFactory, "Murcia", frame.labelMurcia);
				if(votosComunidad.get(0).getComunidad().equals("Murcia")) {
					ChartPanel prueba =  grafico("Murcia", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}
			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Navarra")) {
				datosComunidad(sessionFactory, "Navarra", frame.labelNavarra);
				if(votosComunidad.get(0).getComunidad().equals("Navarra")) {
					ChartPanel prueba =  grafico("Navarra", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}
			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Pais Vasco")) {
				datosComunidad(sessionFactory, "Pais Vasco", frame.labelPaisVasco);
				if(votosComunidad.get(0).getComunidad().equals("Pais Vasco")) {
					ChartPanel prueba =  grafico("Pais Vasco", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}
			}else if(frame.comboBoxComunidad.getSelectedItem().equals("La Rioja")) {
				datosComunidad(sessionFactory, "La Rioja", frame.labelLaRioja);
				if(votosComunidad.get(0).getComunidad().equals("La Rioja")) {
					ChartPanel prueba =  grafico("La Rioja", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}
			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Ceuta")) {
				datosComunidad(sessionFactory, "Ceuta", frame.labelCeuta);
				if(votosComunidad.get(0).getComunidad().equals("Ceuta")) {
					ChartPanel prueba =  grafico("Ceuta", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}
			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Melilla")) {
				datosComunidad(sessionFactory, "Melilla", frame.labelMelilla);
				if(votosComunidad.get(0).getComunidad().equals("Melilla")) {
					ChartPanel prueba =  grafico("Melilla", votosComunidad.get(0).getVotosPP(), votosComunidad.get(0).getVotosPSOE(), votosComunidad.get(0).getVotosVOX(), votosComunidad.get(0).getVotosCIUDADANOS());
					frame.panelGraficoComunidades.add(prueba);
				}
			}
		}
		
		
		//Boton Rango
		if(e.getSource() == frame.botonRango) {
			frame.panelRango.setVisible(true);
			
			frame.panelComunidades.setVisible(false);
			frame.panelGeneral.setVisible(false);
		}
		
		//ComboBox Rango
		
		if(e.getSource() == frame.comboBoxRango) {
			
			frame.panelGraficoRango.removeAll();
			
			if(frame.comboBoxRango.getSelectedItem().equals("18 - 25 años")) {
				datosRango(sessionFactory, 18, 25);
					
			}else if(frame.comboBoxRango.getSelectedItem().equals("26 - 40 años")) {
				datosRango(sessionFactory, 26, 40);
				
				System.out.println("hola");
			}else if(frame.comboBoxRango.getSelectedItem().equals("41 - 65 años")) {
				datosRango(sessionFactory, 41, 65);
			}else if(frame.comboBoxRango.getSelectedItem().equals("+66 años")) {
				datosRango(sessionFactory, 66, 100);
			}
		}
		
	}
	
	public ArrayList <String> datosGeneral (SessionFactory sessionFactory) {
		
		ArrayList <String> datosGeneral = new ArrayList<String>();
	
		int votosPP = 0;
		int votosPSOE = 0;
		int votosVOX = 0;
		int votosCiudadanos = 0;
		
		try {
			votosPP = Modelo.datosGenerales(sessionFactory, "PP");
			votosPSOE = Modelo.datosGenerales(sessionFactory, "PSOE");
			votosVOX = Modelo.datosGenerales(sessionFactory, "VOX");
			votosCiudadanos = Modelo.datosGenerales(sessionFactory, "CIUDADANOS");
			
			datosGeneral.add("" + votosPP);
			datosGeneral.add("" + votosPSOE);
			datosGeneral.add("" + votosVOX);
			datosGeneral.add("" + votosCiudadanos);
		
								
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return datosGeneral;
	}
	
	public ArrayList<Integer> datosRango (SessionFactory sessionFactory, int edad1, int edad2) {
		 
		votosRango = new ArrayList<Integer>();
		
		
		int votosPP = 0;
		int votosPSOE = 0;
		int votosVOX = 0;
		int votosCiudadanos = 0;
		
		try {
			
			votosPP = Modelo.datosRango(sessionFactory, edad1, edad2, "PP");
			votosPSOE = Modelo.datosRango(sessionFactory, edad1, edad2, "PSOE");
			votosVOX = Modelo.datosRango(sessionFactory, edad1, edad2, "VOX");
			votosCiudadanos = Modelo.datosRango(sessionFactory, edad1, edad2, "CIUDADANOS");
	
			votosRango.add(votosPP);
			votosRango.add(votosPSOE);
			votosRango.add(votosVOX);
			votosRango.add(votosCiudadanos);
			
			ChartPanel prueba =  grafico(edad1 + " - " + edad2 + " años", votosRango.get(0), votosRango.get(1), votosRango.get(2), votosRango.get(3));
			frame.panelGraficoRango.add(prueba);
		
			frame.votosPPRango.setText("" + votosPP);
			frame.votosPSOERango.setText("" + votosPSOE);
			frame.votosVOXRango.setText("" + votosVOX);
			frame.votosCIUDADANOSRango.setText("" + votosCiudadanos);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return votosRango;
	}
	
	public void obtenerGanadorGeneral (SessionFactory sessionFactory, int pp, int psoe, int vox, int ciudadanos, JLabel label) {
		
		//GANADOR SIN EMPATES
		if(pp > psoe && pp > vox && pp > ciudadanos) {
			label.setIcon(new ImageIcon("galeria/PP.png"));
		}else if(psoe > pp && psoe > vox && psoe > ciudadanos) {
			label.setIcon(new ImageIcon("galeria/PSOE.png"));		
		}else if(vox > pp && vox > psoe && vox > ciudadanos) {
			label.setIcon(new ImageIcon("galeria/VOX.png"));		
		}else if(ciudadanos > pp && ciudadanos > vox && ciudadanos > psoe) {
			label.setIcon(new ImageIcon("galeria/CIUDADANOS.png"));		
		}
		
		//GANADOR CON 2 EMPATES
        if((pp==psoe)&&((pp>vox)&&(pp>ciudadanos))) {
        	label.setIcon(new ImageIcon("galeria/PP.png")); 
        }else if((pp==ciudadanos)&&((ciudadanos>psoe)&&(ciudadanos>vox))) { 
        	label.setIcon(new ImageIcon("galeria/PP.png")); 
        }else if((vox==psoe)&&((vox>pp)&&(vox>ciudadanos))) { 
        	label.setIcon(new ImageIcon("galeria/VOX.png"));
        }else if((vox==pp)&&((vox>psoe)&&(vox>ciudadanos))) {
        	label.setIcon(new ImageIcon("galeria/PP.png"));
        }else if((psoe==ciudadanos)&&((ciudadanos>vox)&&(ciudadanos>pp))) { 
        	label.setIcon(new ImageIcon("galeria/PSOE.png"));
        }else if((vox==ciudadanos)&&((ciudadanos>pp)&&(ciudadanos>psoe))) { 
        	label.setIcon(new ImageIcon("galeria/VOX.png")); }
        
        //GANADOR CON 3 EMPATES
        if((pp==psoe)&&(pp==vox)&&(pp>ciudadanos)) { 
        	label.setIcon(new ImageIcon("galeria/PP.png")); 
        }else if((pp==psoe)&&(pp==ciudadanos)&&(pp>vox)) { 
        	label.setIcon(new ImageIcon("galeria/PP.png")); 
        }else if((psoe==vox)&&(psoe==ciudadanos)&&(psoe>pp)) { 
        	label.setIcon(new ImageIcon("galeria/VOX.png"));
        }else if((pp==vox)&&(ciudadanos==vox)&&(pp>psoe)) { 
        	label.setIcon(new ImageIcon("galeria/PP.png"));
        }
        //GANADOR CON 4 EMPATES
        if((pp==psoe)&&(pp==vox)&&(pp==ciudadanos)) { 
        	label.setIcon(new ImageIcon("galeria/PP.png")); 
        }
		
	}
	
	public ArrayList<VotosComunidades> datosComunidad (SessionFactory sessionFactory, String comunidad, JLabel labelComunidad) {
		
		votosComunidad = new ArrayList<VotosComunidades>();
		
		int votosPP = 0;
		int votosPSOE = 0;
		int votosVOX = 0;
		int votosCiudadanos = 0;
		
		try {
			votosPP = Modelo.datosComunidad(sessionFactory, comunidad, "PP");
			votosPSOE = Modelo.datosComunidad(sessionFactory, comunidad, "PSOE");
			votosVOX = Modelo.datosComunidad(sessionFactory, comunidad, "VOX");
			votosCiudadanos = Modelo.datosComunidad(sessionFactory, comunidad, "CIUDADANOS");
		
			votosComunidad.add(new VotosComunidades(comunidad, votosPP, votosPSOE, votosVOX, votosCiudadanos));

			System.out.println(votosComunidad);
			
			frame.labelVotosPP.setText("");
			frame.labelVotosPP.setText("");
			frame.labelVotosPP.setText("");
			frame.labelVotosPP.setText("");
			
			frame.labelVotosPP.setText("" + votosPP);
			frame.labelVotosPSOE.setText("" + votosPSOE);
			frame.labelVotosVOX.setText("" + votosVOX);
			frame.labelVotosCIUDADANOS.setText("" + votosCiudadanos);			
					
			obtenerGanadorMapa(sessionFactory, votosPP, votosPSOE, votosVOX, votosCiudadanos, labelComunidad);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return votosComunidad;
	}
	
	public void obtenerGanadorMapa (SessionFactory sessionFactory, int pp, int psoe, int vox, int ciudadanos, JLabel label) {
		
		//GANADOR SIN EMPATES
		if(pp > psoe && pp > vox && pp > ciudadanos) {
			label.setIcon(new ImageIcon("galeria/mapaPP.png"));
		}else if(psoe > pp && psoe > vox && psoe > ciudadanos) {
			label.setIcon(new ImageIcon("galeria/mapaPSOE.png"));		
		}else if(vox > pp && vox > psoe && vox > ciudadanos) {
			label.setIcon(new ImageIcon("galeria/mapaVOX.png"));		
		}else if(ciudadanos > pp && ciudadanos > vox && ciudadanos > psoe) {
			label.setIcon(new ImageIcon("galeria/mapaCIUDADANOS.png"));		
		}
		
		//GANADOR CON 2 EMPATES
        if((pp==psoe)&&((pp>vox)&&(pp>ciudadanos))) {
        	label.setIcon(new ImageIcon("galeria/mapaPP.png")); 
        }else if((pp==ciudadanos)&&((ciudadanos>psoe)&&(ciudadanos>vox))) { 
        	label.setIcon(new ImageIcon("galeria/mapaPP.png")); 
        }else if((vox==psoe)&&((vox>pp)&&(vox>ciudadanos))) { 
        	label.setIcon(new ImageIcon("galeria/mapaVOX.png"));
        }else if((vox==pp)&&((vox>psoe)&&(vox>ciudadanos))) {
        	label.setIcon(new ImageIcon("galeria/mapaPP.png"));
        }else if((psoe==ciudadanos)&&((ciudadanos>vox)&&(ciudadanos>pp))) { 
        	label.setIcon(new ImageIcon("galeria/mapaPSOE.png"));
        }else if((vox==ciudadanos)&&((ciudadanos>pp)&&(ciudadanos>psoe))) { 
        	label.setIcon(new ImageIcon("galeria/mapaVOX.png")); }
        
        //GANADOR CON 3 EMPATES
        if((pp==psoe)&&(pp==vox)&&(pp>ciudadanos)) { 
        	label.setIcon(new ImageIcon("galeria/mapaPP.png")); 
        }else if((pp==psoe)&&(pp==ciudadanos)&&(pp>vox)) { 
        	label.setIcon(new ImageIcon("galeria/mapaPP.png")); 
        }else if((psoe==vox)&&(psoe==ciudadanos)&&(psoe>pp)) { 
        	label.setIcon(new ImageIcon("galeria/mapaVOX.png"));
        }else if((pp==vox)&&(ciudadanos==vox)&&(pp>psoe)) { 
        	label.setIcon(new ImageIcon("galeria/mapaPP.png"));
        }
        //GANADOR CON 4 EMPATES
        if((pp==psoe)&&(pp==vox)&&(pp==ciudadanos)) { 
        	label.setIcon(new ImageIcon("galeria/mapaPP.png")); 
        }
		
	}
	
	
	
	public ChartPanel grafico (String titulo, int votosPP, int votosPSOE, int votosVOX, int votosCIUDADANOS) {
		
		DefaultPieDataset pieDataSet = new DefaultPieDataset();
		
		pieDataSet.setValue("PP", votosPP);
        pieDataSet.setValue("PSOE", votosPSOE);
        pieDataSet.setValue("VOX", votosVOX);
        pieDataSet.setValue("CIUDADANOS", votosCIUDADANOS);
		
        JFreeChart chart = ChartFactory.createPieChart3D(titulo, pieDataSet, true, true, false);
        
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setOutlinePaint(null);
        plot.setSectionPaint("PSOE", Color.RED);
        plot.setSectionPaint("PP", Color.BLUE);
        plot.setSectionPaint("CIUDADANOS", new Color(250, 117, 0));
        plot.setSectionPaint("VOX", Color.GREEN);
        
        
        
        ChartPanel prueba = new ChartPanel(chart);
        prueba.setBounds(838, 428, 588, 357);

        return prueba;
	}

	
	
	
}

