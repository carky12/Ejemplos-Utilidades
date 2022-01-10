package ejemplo.hilos.concurrente;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanelPrincipal extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
	
	public void add(Pelota pelota) {
		pelotas.add(pelota);
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		for (Pelota p: pelotas) {
			g2.fill(p.getShape());
		}
		
	}

}
