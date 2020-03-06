package Pacman;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fenetre extends JPanel {
    JFrame frame=new JFrame();
  	private Key KeyList=new Key();
	private Graphe gph=Game.getGh();
	public Color getColor3() {
	// TODO Auto-generated method stub
	Color clr=new Color(192,192,192);
	return clr;
	
	}
	
	
 public Fenetre() {
     frame.setContentPane(gph);
	 frame.setSize(Game.getWidth(),Game.getHeight());
	 frame.setTitle("Pac-Man");
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 frame.setLocationRelativeTo(null);
	 frame.setVisible(true);
	 frame.setResizable(false);
	 frame.setBackground(getColor3());
	 frame.add(this);
	 frame.addKeyListener(KeyList);
   }
}
