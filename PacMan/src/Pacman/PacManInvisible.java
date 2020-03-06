package Pacman;

import java.awt.Color;


public class PacManInvisible extends  PacManState {
public boolean Start;
	protected PacManInvisible(Pacman pacman) {
		super(pacman);
		Start=true;
		// TODO Auto-generated constructor stub
	}



	@Override
	public State getState() {
		// TODO Auto-generated method stub
		return State.PacMamInvisible;
	}

	@Override
	public Color getCLR() {
		// TODO Auto-generated method stub
		Color clr=new Color(255,255,164);
		return clr;
	}

	@Override
	public void setCLR(Color c) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public State setState(State s) {
		// TODO Auto-generated method stub
		return null;
	}


}
