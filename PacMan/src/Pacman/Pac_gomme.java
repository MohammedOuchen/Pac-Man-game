package Pacman;

import java.awt.Color;

public interface  Pac_gomme {

    
    public static enum Pacgomme_type {
    	PacgommeNormal, SuperPacgomme;
    }

	
    public abstract Pacgomme_type getType();


	public abstract int getXPosition();


	public abstract int getYPosition();


	public abstract Color getColor();
	
}