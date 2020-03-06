package Pacman;

import java.awt.Color;

import Pacman.Pac_gomme.Pacgomme_type;

public class PacgommeNormal implements Pac_gomme{

	protected int XPosition;
	protected int YPosition;

	
	public  PacgommeNormal(int XPosition,int YPosition) {
		this.XPosition=XPosition;
		this.YPosition=YPosition;
	}
	


	
	public Color getColor() {
		return Color.blue;
	};


	public Pacgomme_type getType() {

		return Pacgomme_type.PacgommeNormal;
	}




	@Override
	public int getXPosition() {
		// TODO Auto-generated method stub
		return XPosition;
	}




	@Override
	public int getYPosition() {
		// TODO Auto-generated method stub
		return YPosition;
	}

}
