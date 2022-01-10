package ejemplo.hilos.concurrente;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FramePrincipal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numeroEjecucion = 0;
	
	private PanelPrincipal panelPrincipal;
	private Thread hilo;
	
	public FramePrincipal () {
		
		setBounds(600, 300, 400, 350);
		setTitle("Programación concurrente");
		
		//Panel principal
		panelPrincipal = new PanelPrincipal();
		add(panelPrincipal, BorderLayout.CENTER);
		
		//Botones
		JPanel panelBotones = new JPanel();
		dibujarBotones(panelBotones, "Pulsa", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comenzar();				
			}
		});
		
		dibujarBotones(panelBotones, "Salir", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
		
		dibujarBotones(panelBotones, "Detener", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				detener();
			}
		});
		
		add(panelBotones, BorderLayout.SOUTH);		
		
	}
	
	public void detener() {
		//hilo.stop();
		hilo.interrupt();
		System.out.println("Se detiene el hilo " + numeroEjecucion);
	}
	
	public void dibujarBotones(Container panel, String caption, ActionListener evento) {
		
		JButton boton = new JButton(caption);
		panel.add(boton);
		boton.addActionListener(evento);
		
	}
	
	public void comenzar() {
		
		Pelota pelota = new Pelota();
		
		panelPrincipal.add(pelota);
		
		Runnable pelotaHilo = new PelotaThread(pelota, panelPrincipal);
		
		hilo = new Thread(pelotaHilo);
		
		hilo.start();
		
		numeroEjecucion++;
		System.out.println("Ejecuntando el hilo " + numeroEjecucion);
		
		
		/*for (int i = 0; i < 3000; i++) {
			
			pelota.mover(panelPrincipal.getBounds());
			panelPrincipal.paint(panelPrincipal.getGraphics());
			
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}*/
		
		
		
	}
	
}
