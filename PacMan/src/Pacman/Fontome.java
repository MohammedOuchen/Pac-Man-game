package Pacman;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Pacman.PacmanEvent.ChangeType;



public class Fontome {
	
    private List<Coordinate> body;
	private Game game;
	private DirectionFantome direction;
	private boolean alive;
	private List<PacmanObserver> observers;
    private Color ColorFontome;
    private FontomeState State;
    
    
	public Fontome(Game game, Coordinate start) {
		observers = new ArrayList<>();
		alive = true;
		this.game = game;
		direction = DirectionFantome.Right;
		body = new ArrayList<>();
		body.add(start);
	    State=new FontomeNormal(this);
	}
 
	
	public FontomeState getState() {
		return State;
	}

	public void setState(FontomeState state) {
		State = state;
	}

	public Color getColorFontome() {
		return State.getCLR();
	}
	
	public Boolean   Kill(Coordinate c){	
		return State.kill(c);
	}
	
	public DirectionFantome getDirection() {
		return direction;
	}

	public void setDirection(DirectionFantome direction) {
		this.direction = direction;
	}
	
	
	public DirectionFantome getDirectionAleatoire() {
		Random rand = new Random(); 
		int nombreAleatoire = rand.nextInt(4);
		DirectionFantome directionale = null ;
		directionale=directionale.Down;
		switch(nombreAleatoire) {
		case 0:	directionale=directionale.Down;
		break;
		case 1:	directionale=directionale.Left;
		break;
		case 2:	directionale=directionale.Right;
		break;
		case 3:	directionale=directionale.Up;
		break;
		}
		return directionale;
	}
	
	
	public List<Coordinate> getBody() {
		return new ArrayList<>(body);
	}

	public void move() {
		Coordinate current = body.get(body.size() - 1);
		Coordinate next = new Coordinate(current.getX() + direction.getX(), current.getY() + direction.getY());
		if(next.getX()!=-1&&next.getX()!=35)	
	    while(game.isOut(next)) {
		direction=this.getDirectionAleatoire();
	    next = new Coordinate(current.getX() + direction.getX(), current.getY() + direction.getY());	 
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
          body.add(next);
 	      body.remove(0);
      if(this.Kill(next)||this.Kill(current)) {//quand le pacman est mort revient la position initial et les fontomes aussi
	      game.PositionStartFontome();
	      game.getpacman().setAlive();
    	  game.getpacman().getBody().get(0).setX(18);
    	  game.getpacman().getBody().get(0).setY(17); 
    	  game.getpacman().getDirections().set(0,Direction.Up);
    	  game.getpacman().getDirections().set(1,Direction.Up);
       }
      }

	public boolean isAlive() {
		return alive;
	}

}
