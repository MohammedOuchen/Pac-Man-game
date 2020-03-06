package Pacman;

import java.awt.Color;

public class EffetPacManInvisible implements PacgommeEffet {

	@Override
	public void effet(Pacman pacman) {
		// TODO Auto-generated method stub
		pacman.setState(new PacManInvisible(Game.getpacman()));
	/*	Game.getFontome1().setState(new FontomeMangepas(Game.getFontome1()));
		Game.getFontome2().setState(new FontomeMangepas(Game.getFontome2()));
		Game.getFontome3().setState(new FontomeMangepas(Game.getFontome3()));
		Game.getFontome4().setState(new FontomeMangepas(Game.getFontome4()));
		*/Game.getpacman().GagnerPoints(200);	
	}

	@Override
	public Color getColor() {
		Color couleur=new Color(128,0,255);
		return couleur;
	}

}
