package Pacman;

import java.awt.Color;



public abstract class FontomeState {
	public static enum State{FontomeNormal,FontomeVulnerable,FontomeMangepas}

	protected Fontome fontome;

	protected FontomeState(Fontome fontome) {
			this.fontome=fontome;
						}

	public abstract State getState();
	public abstract State setState(State s);
	public abstract Color getCLR();

	public abstract Boolean kill(Coordinate c);




}
