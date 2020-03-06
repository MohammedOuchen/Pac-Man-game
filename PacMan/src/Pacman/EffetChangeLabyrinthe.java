package Pacman;

import java.awt.Color;

public class EffetChangeLabyrinthe implements PacgommeEffet {

	@Override
	public void effet(Pacman pacman) {
		    Game.changeMap();
	        Game.getpacman().changerMap();
	        Game.getpacman().GagnerPoints(900);
	}

	@Override
	public Color getColor() {
		Color clr=new Color(4,166,24);
		return clr;
		
	}

}
