package Pacman;

import java.awt.Color;

public class EffetSuperPacMan implements PacgommeEffet{

	@Override
	public void effet(Pacman pacman) {
				pacman.setState(new SuperPacMan(Game.getpacman()));
				pacman.getGame().getFontome1().setState(new FontomeVulnerable(pacman.getGame().getFontome1()));
				pacman.getGame().getFontome2().setState(new FontomeVulnerable(pacman.getGame().getFontome2()));
				pacman.getGame().getFontome1().setState(new FontomeVulnerable(pacman.getGame().getFontome3()));
				pacman.getGame().getFontome1().setState(new FontomeVulnerable(pacman.getGame().getFontome4()));
				Game.getpacman().GagnerPoints(400);
			//	Game.PositionStartFontome();
	}

	@Override
	public Color getColor() {
		Color clr=new Color(239,103,37);
		return clr;
	}

}
