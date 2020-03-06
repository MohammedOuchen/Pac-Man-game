package Pacman;




import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Pacman.PacmanEvent.ChangeType;


public class Pacman {

	private int point;
    private int MultipleDePoint;
	private List<Coordinate> body;
	private Game game;
	private Direction direction;
    private Color clr;
	private int alive;
	private List<PacmanObserver> observers;
	private List<Direction> Directions;
	private static List<Pac_gomme> pacgommes=ListePacgomme.ListePacgomme();
	private PacManState State;
	private boolean ChangerMap=false;
	public Pacman(Game game,Coordinate start) {
					point=0;
				    MultipleDePoint=1;
					observers = new ArrayList<>();
					alive =3;
					this.game = game;
					direction = Direction.Up;
					body = new ArrayList<>();
					Directions =new  ArrayList<>();
					body.add(start);
					State=new PacManNormal(this);
	}
	
	public Game getGame() {
		return game;
	}
	
	public void changerMap() {
		ChangerMap=true;
	}
	public boolean isChangerMap() {
		return ChangerMap;
	}
	
	public void setState(PacManState state) {
		State = state;
	}
	public PacManState getState() {
		return State;
	}
    public Color getClr() {
		return State.getCLR();
	}
	public void setClr(Color clr) {
	State.setCLR(clr);
	}

	public void setAlive() {
		alive--;
	}
	public int getMultipleDePoint() {
		return MultipleDePoint;
	}

	public void setMultipleDePoint(int multipleDePoint) {
		MultipleDePoint = multipleDePoint;
	}

	public static List<Pac_gomme> getPacgommes() {
		return pacgommes;
	}

	public static void setPacgommes(List<Pac_gomme> pacgommes) {
		Pacman.pacgommes = pacgommes;
	}

	public boolean  Eat(Coordinate c){	
		for(Pac_gomme pac :Game.getPacgommes()) {
			if(pac.getXPosition()==c.getX()&&pac.getYPosition()==c.getY())
	   return true;
				
		}
		return false ;
	}
	public List<Direction> getDirections() {
		return Directions;
	}

	public void setDirections(List<Direction> directions) {
		Directions = directions;
	}

	public void register(PacmanObserver o) {
		observers.add(o);
	}

	public void unregister(PacmanObserver o) {
		observers.remove(o);
	}

	private void notifyObserver(List<PacmanEvent> events) {
		for (PacmanObserver pacmanObserver : observers) {
			pacmanObserver.notify(events);
		}
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public List<Coordinate> getBody() {
		return new ArrayList<>(body);
	}
   public void GagnerPoints(int NBPoint) {
	   point=point+NBPoint;
   }
	public void move1() {
		int taille=this.getDirections().size();
		Coordinate current = body.get(body.size() - 1);
		Coordinate next = new Coordinate(current.getX() + direction.getX(), current.getY() + direction.getY());
		
	  if(this.getDirections().size()==2) {
	        	this.getDirections().remove(1);	
	        }
		
		 if(this.getDirections().size()==0) {
	        	this.getDirections().add(direction);	
	        }
		  this.getDirections().add(direction);
	if(next.getX()!=-1&&next.getX()!=35) {		  
      if(game.isOut(next)) {
    	  next = new Coordinate(current.getX() + this.getDirections().get(0).getX(), current.getY() +this.getDirections().get(0).getY());  
    	  if(game.isOut(next)) {
    		  next=current;
    	  }
    	 
      }else {
    	  this.getDirections().set(0,this.getDirections().get(1));
      }
	}
      if(game.ACote(next)) {
    	  if(next.getX()==-1) {
    		  next.setX(34);
    		  next.setY(9);
    	  }else {
    		  next.setX(0);
    		  next.setY(9);
    	  }
      }
   
   if(this.Eat(next)) {
   
   	  this.GagnerPoints(100);
     Game.Dispparaittre(next);
     }
   
   body.add(next);
  
	
    List<PacmanEvent> events = new ArrayList<>();
	events.add(new PacmanEvent(next, ChangeType.ENTER));
	events.add(new PacmanEvent(body.get(0),ChangeType.LEAVE));
	notifyObserver(events);			
		body.remove(0);
	    

	}

	
	public int getAlive() {
		return alive;
	}

	public void setAlive(int alive) {
		this.alive = alive;
	}

	public int getPoint() {
		return point;
	}


}
