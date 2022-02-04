package Controlador;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelo.Modelo;
import modelo.VotosComunidades;

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
	
	
	public Controlador (vista.Vista vista) {
		this.frame = vista;
		this.frame.btnIniciarVotacion.addActionListener(this);
		this.frame.btnBuscar.addActionListener(this);
		this.frame.comboBoxComunidad.addActionListener(this);
		this.frame.botonGeneral.addActionListener(this);
		this.frame.botonComunidad.addActionListener(this);
		this.frame.botonRango.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Modelo modelo = new Modelo();
    	SessionFactory sessionFactory = null;

    	Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
		
		if(e.getSource() == frame.btnIniciarVotacion) {
			try {
				modelo.listarDatos();
				frame.btnIniciarVotacion.setVisible(false);
			} catch (Exception exception) {
				// TODO: handle exception
				exception.printStackTrace();
				
				
			}
		}
		
		if(e.getSource() == frame.botonGeneral) {
			
		}
		
		if(e.getSource() == frame.botonComunidad) {
			
			try {
			
				frame.btnBuscar.setVisible(true);
				frame.comboBoxComunidad.setVisible(true);
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
		
		if(e.getSource() == frame.btnBuscar) {
			
			
			ArrayList<VotosComunidades> votosComunidades = new ArrayList<VotosComunidades>();
			
			/*if(frame.comboBoxComunidad.getSelectedItem().equals("Andalucia")) {
				datosComunidadControlador(sessionFactory, "Andalucia");
				

			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Aragon")) {
				datosComunidadControlador(sessionFactory, "Aragon");

			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Asturias")) {
				datosComunidadControlador(sessionFactory, "Asturias");

			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Baleares")) {
				datosComunidadControlador(sessionFactory, "Baleares");

			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Canarias")) {
				datosComunidadControlador(sessionFactory, "Canarias");

			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Cantabria")) {
				datosComunidadControlador(sessionFactory, "Cantabria");

			}else*/ if(frame.comboBoxComunidad.getSelectedItem().equals("Castilla La Mancha")) {
				datosComunidadControlador(sessionFactory, "Castilla La Mancha", frame.labelCastillaLaMancha);
				frame.labelCastillaLaMancha.setIcon(new ImageIcon("C:\\Users\\david\\git\\elecciones2023\\Elecciones_DavidMonteroBellon\\galeria\\mapaPP.png"));

			}/*else if(frame.comboBoxComunidad.getSelectedItem().equals("Castilla y Leon")) {
				datosComunidadControlador(sessionFactory, "Castilla y Leon");

			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Catalunia")) {
				datosComunidadControlador(sessionFactory, "Catalunia");

			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Comunidad Valenciana")) {
				datosComunidadControlador(sessionFactory, "Comunidad Valenciana");

			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Extremadura")) {
				datosComunidadControlador(sessionFactory, "Extremadura");

			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Galicia")) {
				datosComunidadControlador(sessionFactory, "Galicia");

			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Madrid")) {
				datosComunidadControlador(sessionFactory, "Madrid");

			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Murcia")) {
				datosComunidadControlador(sessionFactory, "Murcia");

			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Navarra")) {
				datosComunidadControlador(sessionFactory, "Navarra");

			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Pais Vasco")) {
				datosComunidadControlador(sessionFactory, "Pais Vasco");

			}else if(frame.comboBoxComunidad.getSelectedItem().equals("La Rioja")) {
				datosComunidadControlador(sessionFactory, "La Rioja");

			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Ceuta")) {
				datosComunidadControlador(sessionFactory, "Ceuta");

			}else if(frame.comboBoxComunidad.getSelectedItem().equals("Melilla")) {
				datosComunidadControlador(sessionFactory, "Melilla");

			}*/
		}
		
		
		
	}
	
	
	public void datosComunidadControlador (SessionFactory sessionFactory, String comunidad, JLabel labelComunidad) {
		
		ArrayList<VotosComunidades> votosComunidad = new ArrayList<VotosComunidades>();
		
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

			frame.labelVotosPP.setText("");
			frame.labelVotosPP.setText("");
			frame.labelVotosPP.setText("");
			frame.labelVotosPP.setText("");
			
			frame.labelVotosPP.setText("" + votosPP);
			frame.labelVotosPSOE.setText("" + votosPSOE);
			frame.labelVotosVOX.setText("" + votosVOX);
			frame.labelVotosCIUDADANOS.setText("" + votosCiudadanos);
			
			
			
			labelComunidad.setIcon(new ImageIcon("src/galeria/PP.png"));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	
	
}

