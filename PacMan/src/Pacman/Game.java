package Pacman;

import java.util.ArrayList;
import java.util.List;

import Pacman.PacManState.State;
import Pacman.Pac_gomme.Pacgomme_type;

public class Game {
	
	private static int height;
	private static int width;
	private static Pacman pacman;
	private static Fontome fontome1,fontome2,fontome3,fontome4;
    private static SuperPacgomme sup;
	private static Fenetre fenetre;
    private static Carte1 carte=new Carte1();
    private static String[][] Map=carte.Map();
	private static Graphe gh=new Graphe();
	private boolean ChangeEtat;
	private int Compte;
    private  int PlusVie;   
    
    private static String[][] Map2=carte.Map2();

	public Game(int width, int height, Coordinate CPacman,Coordinate CFontome ) {
		this.height = height;
		this.width = width;
		
		pacman = new Pacman(this,CPacman);
		fontome3=new Fontome(this,CFontome);
		fontome1=new Fontome(this,CFontome);
		fontome2=new Fontome(this,CFontome);
		fontome4=new Fontome(this,CFontome);
		fenetre=new Fenetre();
	    ChangeEtat=false;
	    Compte=0;
	    PlusVie=1;
	}	
	
	public static void changeMap() {
		Map=Map2;
		
	}
	
	 public boolean isChangeEtat() {
			return ChangeEtat;
		}


		public void setChangeEtat(boolean changeEtat) {
			ChangeEtat = changeEtat;
		}


		public int getCompte() {
			return Compte;
		}


		public void setCompte(int compte) {
			Compte = compte;
		}

    
	public static Fontome getFontome1() {
		return fontome1;
	}
	public static Fontome getFontome2() {
		return fontome2;
	}
	public static Fontome getFontome3() {
		return fontome3;
	}
	public static Fontome getFontome4() {
		return fontome4;
	}
	public static String[][] getMap() {
		return Map;
	}
	public static  List<Pac_gomme> getPacgommes() {
		return pacman.getPacgommes();
	}
	
	public static void Dispparaittre(Coordinate  n) {
	
		int i=0;
		for(Pac_gomme pac :getPacgommes()) {
			if(pac.getXPosition()==n.getX()&&pac.getYPosition()==n.getY()) { 
			
				break;	
			}
      	i++;
		}
		if(pacman.getPacgommes().get(i).getType()==Pacgomme_type.SuperPacgomme) {
			 sup=(SuperPacgomme) pacman.getPacgommes().get(i);
			 sup.effet(pacman);
		}

	
		pacman.getPacgommes().remove(i);
		
	}
	public void setMap(String[][] map) {
		Map = map;
	}
	
	

    public static Graphe getGh() {
		return gh;
	}
	public static Pacman getpacman() {
		return pacman;
	}
	
	public static int getHeight() {
		return height;
	}

	public static int getWidth() {
		return width;
	}
	
	public void ChangeEtath() {
		if(pacman.getState().getState()==State.PacMamInvisible||pacman.getState().getState()==State.SuperPacMan) {
			this.setChangeEtat(true);
		
		}

	}
	public static boolean ACote(Coordinate c) {
		
		if (c.getX() ==-1 &&c.getY()==9) {
	         return true;
		}
 
		if (c.getX() ==35 &&c.getY()==9)
			return true;
		return false;
	}
	 boolean isOut(Coordinate c) {
		if(this.getMap()[c.getY()][c.getX()].equals("#"))
			return true;
		

		return false;
	}
	
	 public void AjouterVie() {
	
		 int nbVies;
		 if(pacman.getPoint()>=5000*PlusVie) {
			 nbVies=pacman.getAlive();
			 nbVies++;
			 pacman.setAlive(nbVies);
			 PlusVie++;
   
		     }
	
	 }

	 public void PositionStartFontome() {
			this.getFontome1().getBody().get(0).setX(18);
			this.getFontome1().getBody().get(0).setY(8);
			
		this.getFontome2().getBody().get(0).setX(18);
	    this.getFontome2().getBody().get(0).setY(8);
			
			this.getFontome3().getBody().get(0).setX(18);
			this.getFontome3().getBody().get(0).setY(8);

			this.getFontome4().getBody().get(0).setX(18);
			this.getFontome4().getBody().get(0).setY(8);
	 }
	public void step() {
		this.ChangeEtath();
		if(this.isChangeEtat()==true) {
			if(this.getCompte()<60) {
			this.setCompte(this.getCompte()+1);
			}else{
						this.setChangeEtat(false);
						this.setCompte(0);
						pacman.setState(new PacManNormal(pacman));
					   fontome1.setState(new FontomeNormal(fontome1));
					   fontome2.setState(new FontomeNormal(fontome2));
					   fontome3.setState(new FontomeNormal(fontome3));
					   fontome4.setState(new FontomeNormal(fontome4));
		     }
		}
		
		pacman.move1();
		if(pacman.getState().getState()==State.SuperPacMan) {
			pacman.move1();	
		}
	}
	public void stepFontome1() {
		fontome1.move();
	}
	public void stepFontome2() {
		fontome2.move();
	}
	public void stepFontome3() {
		fontome3.move();
	}
	public void stepFontome4() {
		fontome4.move();
	}
}
