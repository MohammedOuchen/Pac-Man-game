package Pacman;

import java.awt.Color;

public class FontomeVulnerable  extends FontomeState  {

	protected FontomeVulnerable(Fontome fontome) {
		super(fontome);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public State getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State setState(State s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getCLR() {
		// TODO Auto-generated method stub
		return Color.blue;
	}

	@Override
	public Boolean kill(Coordinate c) {
		// TODO Auto-generated method stub
		if(Game.getpacman().getBody().get(0).getX()==c.getX()&&Game.getpacman().getBody().get(0).getY()==c.getY()) {
		fontome.getBody().get(0).setX(18);
		fontome.getBody().get(0).setY(10);
		
		}
			
		return false;
	}

}
