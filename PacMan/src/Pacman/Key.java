package Pacman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import Pacman.Direction;
import Pacman.Game;

public class Key implements KeyListener  {

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("ici key ");
	   //      this.keyPressed(e);
					switch(e.getKeyCode()) {
									case KeyEvent.VK_UP : Game.getpacman().setDirection(Direction.Up); 
										break;
									case KeyEvent.VK_DOWN : Game.getpacman().setDirection(Direction.Down);
										break;
									case KeyEvent.VK_RIGHT : Game.getpacman().setDirection(Direction.Right);
										break;
									case KeyEvent.VK_LEFT : Game.getpacman().setDirection(Direction.Left);
										break;
									default: break;
			                       }
			

					
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
