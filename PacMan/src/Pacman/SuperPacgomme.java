package Pacman;

import java.awt.Color;

public class SuperPacgomme implements Pac_gomme {
	
	protected int XPosition;
	protected int YPosition;
    private PacgommeEffet effet;
	
	public  SuperPacgomme(int XPosition,int YPosition,PacgommeEffet effet) {
		this.XPosition=XPosition;
		this.YPosition=YPosition;
		this.effet=effet;
	}
	

	public int getXPosition() {
		return XPosition;
	}

	
	public int getYPosition() {
		return YPosition;
	}
	
	public Color getColor() {
		return effet.getColor();
	};

	public void effet(Pacman pacman) {
		effet.effet(pacman);
	}
	@Override
	public Pacgomme_type getType() {
		// TODO Auto-generated method stub
		return Pacgomme_type.SuperPacgomme;
	}

}
