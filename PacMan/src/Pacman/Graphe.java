package Pacman;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Pacman.PacmanEvent.ChangeType;



public class Graphe extends JComponent  implements  PacmanObserver  {
	
	@Override
	protected void paintComponent(Graphics gd) {
		// TODO Auto-generated method stub
	  Graphics2D g = (Graphics2D)gd;   
      int x=0,y=0;
	  try {
	      DessinMap(g);
	  } catch (IOException e1) {
	      // TODO Auto-generated catch block
	      e1.printStackTrace();
	  }
		 DissinerPacgomme(g);
		
	  try {
		  
		  DessinPacMan(g);
	  } catch (IOException e) {
	  // TODO Auto-generated catch block
		 e.printStackTrace();
	  }
	   DessinFontomes(g);
	  Font font = new Font("Courier", Font.BOLD, 20);
	    g.setFont(font);
	    g.setColor(getColor());          
		g.drawString("Score :"+Game.getpacman().getPoint(),5,440);
	    g.drawString("Nombre de Vies :"+Game.getpacman().getAlive(),490,440);	
	 if(Game.getpacman().getAlive()==0)
		g.drawString("Mort!",250,440);	

	if(Game.getPacgommes().size()==0)
	    g.drawString("Gagne!",250,440);	
	    }

	private void DissinerPacgomme(Graphics2D g) {
		List<Pac_gomme> pacgommes=Game.getPacgommes();
    for(Pac_gomme pac :pacgommes) {
		    g.setColor(pac.getColor());
			if(pac.getColor()==Color.blue)
			g.fillOval(pac.getXPosition()*20+3,pac.getYPosition()*20+3,10,10);
			else
			g.fillOval(pac.getXPosition()*20,pac.getYPosition()*20,19,19);
				
		}
	}

	private void DessinFontomes(Graphics g)  {
		for(Coordinate cord :Game.getFontome1().getBody()) {
						
			if(Game.getFontome3().getColorFontome()!=Color.blue) {
			g.setColor(Color.red);
							
			}else {
			g.setColor(Color.blue);
			}			
			g.fillOval(cord.getX()*20,cord.getY()*20,20,20);g.setColor(getColor3());
			g.fillArc(cord.getX()*20,cord.getY()*20,20,20, -110, 20);
			g.fillArc(cord.getX()*20,cord.getY()*20,20,20, -70, 20);
			g.fillArc(cord.getX()*20,cord.getY()*20,20,20, -150, 20);
			g.setColor(Color.black);
			g.fillOval(cord.getX()*20+10,cord.getY()*20,5,5);
			g.fillOval(cord.getX()*20,cord.getY()*20,5,5);
		   }
		
		for(Coordinate cord :Game.getFontome2().getBody()) {
		
			if(Game.getFontome3().getColorFontome()!=Color.blue) {
				Color clr=new Color(0,255,255);
				g.setColor(clr);
			}else {
					g.setColor(Color.blue);
			}
			g.fillOval(cord.getX()*20,cord.getY()*20,20,20);g.setColor(getColor3());
			g.fillArc(cord.getX()*20,cord.getY()*20,20,20, -110, 20);
			g.fillArc(cord.getX()*20,cord.getY()*20,20,20, -70, 20);
			g.fillArc(cord.getX()*20,cord.getY()*20,20,20, -150, 20);
			g.setColor(Color.black);
			g.fillOval(cord.getX()*20+10,cord.getY()*20,5,5);
			g.fillOval(cord.getX()*20,cord.getY()*20,5,5);
			
		}
		for(Coordinate cord :Game.getFontome3().getBody()) {
			if(Game.getFontome3().getColorFontome()!=Color.blue) {
            Color clr=new Color(255,72,72);
			g.setColor(clr);
			}else {
				g.setColor(Color.blue);
			}
			g.fillOval(cord.getX()*20,cord.getY()*20,20,20);g.setColor(getColor3());
			g.fillArc(cord.getX()*20,cord.getY()*20,20,20, -110, 20);
			g.fillArc(cord.getX()*20,cord.getY()*20,20,20, -70, 20);
			g.fillArc(cord.getX()*20,cord.getY()*20,20,20, -150, 20);
			g.setColor(Color.black);
			g.fillOval(cord.getX()*20+10,cord.getY()*20,5,5);
			g.fillOval(cord.getX()*20,cord.getY()*20,5,5);
			
		}
		for(Coordinate cord :Game.getFontome4().getBody()) {
			g.setColor(Game.getFontome4().getColorFontome());
			g.fillOval(cord.getX()*20,cord.getY()*20,20,20);g.setColor(getColor3());
			g.fillArc(cord.getX()*20,cord.getY()*20,20,20, -110, 20);
			g.fillArc(cord.getX()*20,cord.getY()*20,20,20, -70, 20);
			g.fillArc(cord.getX()*20,cord.getY()*20,20,20, -150, 20);
			g.setColor(Color.black);
			g.fillOval(cord.getX()*20+10,cord.getY()*20,5,5);
			g.fillOval(cord.getX()*20,cord.getY()*20,5,5);
			
	 }
	}
	
	
	
	private void DessinPacMan(Graphics g) throws IOException {
		 for(Coordinate cord :Game.getpacman().getBody()) {
		  g.setColor(Game.getpacman().getClr());
		 
		  //Up
		 if(Game.getpacman().getDirections().get(0).getX()==0 && Game.getpacman().getDirections().get(0).getY()==-1 ) {
		  g.setColor(Game.getpacman().getClr());g.fillOval(cord.getX()*20,cord.getY()*20,20,20);g.setColor(getColor3());g.fillArc(cord.getX()*20,cord.getY()*20,20,20, -320, 100);
		 
		 }else {
		  //Down
		  if(Game.getpacman().getDirections().get(0).getX()==0 && Game.getpacman().getDirections().get(0).getY()==1 ) {
		   g.setColor(Game.getpacman().getClr());g.fillOval(cord.getX()*20,cord.getY()*20,20,20);g.setColor(getColor3());g.fillArc(cord.getX()*20,cord.getY()*20,20,20, -140, 100);
		   
		  }else {
		   //Right
		   if(Game.getpacman().getDirections().get(0).getX()==1 && Game.getpacman().getDirections().get(0).getY()==0 ) {
		    g.setColor(Game.getpacman().getClr());g.fillOval(cord.getX()*20,cord.getY()*20,20,20);g.setColor(getColor3());g.fillArc(cord.getX()*20,cord.getY()*20,20,20, -50, 100);
		   
		   }else {
		    //Left
		     g.setColor(Game.getpacman().getClr());g.fillOval(cord.getX()*20,cord.getY()*20,20,20);g.setColor(getColor3());g.fillArc(cord.getX()*20,cord.getY()*20,20,20, -230, 100);
		    }
		  }
		 }
		}
	   }


	private void DessinMap(Graphics g) throws IOException {
				String[][] map;
		map=Game.getMap();

		for(int i =0; i <21; i++)
		{ 
		  for(int j = 0; j <35; j++)
		  {
			 if(map[i][j]=="#") {
				 g.setColor(getColor());  
				 g.fill3DRect(j*20,i*20,20,20,true); 
			 }
			}
		  }
		}
	
	
	public Color getColor() {
		// TODO Auto-generated method stub
		Color clr=new Color(69,69,69);
		return clr;
	}
	public Color getColor2() {
		// TODO Auto-generated method stub
		Color clr=new Color(60,30,0);
		return clr;
	}
	public Color getColor3() {
		// TODO Auto-generated method stub
		Color clr=new Color(192,192,192);
		return clr;
	}
	public Color getColor4() {
		// TODO Auto-generated method stub
		Color clr=new Color(130,65,0);
		return clr;
	}
	
	
   @Override
   public void notify(List<PacmanEvent> events) {
	// TODO Auto-generated method stub
    for(PacmanEvent event: events) {
	   if(event.getChangeType()==PacmanEvent.ChangeType.ENTER)
		 this.repaint();
	}
	     System.out.println();
   }

}
