package Pacman;

import java.awt.Color;

public class SuperPacMan extends  PacManState  {

	protected SuperPacMan(Pacman pacman) {
		super(pacman);
		// TODO Auto-generated constructor stub
	}

	@Override
	public State getState() {
		// TODO Auto-generated method stub
		return State.SuperPacMan;
	}

	@Override
	public State setState(State s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getCLR() {
		// TODO Auto-generated method stub
		return Color.orange;
	}

	@Override
	public void setCLR(Color c) {
		// TODO Auto-generated method stub
		
	}

}
