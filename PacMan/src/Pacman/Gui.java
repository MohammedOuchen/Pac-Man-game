package Pacman;

import java.awt.Color;

import Pacman.PacManState.State;

public class Gui {
    Game game;
	public Gui() {
	int width =715;
	
	int heigth =500;
	game = new Game(width,heigth,new Coordinate(17,18),new Coordinate(18,8));
  	game.getpacman().register(game.getGh());



    while(game.getpacman().getAlive()>0&&game.getPacgommes().size()>0) {
		
    game.step();
	game.AjouterVie();
	game.stepFontome1();
	game.stepFontome2();
	game.stepFontome3();
	game.stepFontome4();
	try {
			Thread.sleep(150);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}	
}
	
   public Game getGame() {
	return game;
   }
}
