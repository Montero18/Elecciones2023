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
		this.frame.comboBoxPrincipal.addActionListener(this);
		this.frame.btnBuscar.addActionListener(this);
		
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
		
		if(e.getSource() == frame.btnBuscar) {
			
			try {
				if(frame.comboBoxPrincipal.getSelectedItem().equals("Datos Comunidad")) {
					
					ArrayList<VotosComunidades> votosComunidades = new ArrayList<VotosComunidades>();
					
					datosComunidadControlador(sessionFactory, "Andalucia");
					datosComunidadControlador(sessionFactory, "Aragon");
					datosComunidadControlador(sessionFactory, "Asturias");
					datosComunidadControlador(sessionFactory, "Baleares");
					datosComunidadControlador(sessionFactory, "Canarias");
					datosComunidadControlador(sessionFactory, "Cantabria");
					datosComunidadControlador(sessionFactory, "Castilla La Mancha");
					datosComunidadControlador(sessionFactory, "Castilla y Leon");
					datosComunidadControlador(sessionFactory, "Catalunia");
					datosComunidadControlador(sessionFactory, "Comunidad Valenciana");
					datosComunidadControlador(sessionFactory, "Extremadura");
					datosComunidadControlador(sessionFactory, "Galicia");
					datosComunidadControlador(sessionFactory, "Madrid");
					datosComunidadControlador(sessionFactory, "Murcia");
					datosComunidadControlador(sessionFactory, "Navarra");
					datosComunidadControlador(sessionFactory, "Pais Vasco");
					datosComunidadControlador(sessionFactory, "La Rioja");
					datosComunidadControlador(sessionFactory, "Ceuta");
					datosComunidadControlador(sessionFactory, "Melilla");
					
					
					
					
					
				}
			} catch (Exception exception) {
				// TODO: handle exception
				exception.printStackTrace();				
			}
			  
			
		}
	}
	
	
	public void datosComunidadControlador (SessionFactory sessionFactory, String comunidad) {
		
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

			frame.textArea.setText(frame.textArea.getText() + votosComunidad.toString() + "\n");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	
	
}

