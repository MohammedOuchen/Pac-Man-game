package Pacman;

public class PacgommeFactory {

	
	public static Pac_gomme makePacgommeNormal(int x,int y) {
		return new PacgommeNormal(x,y);
	}
	
	public static Pac_gomme makePacgommeInvisible(int x,int y) {
		return new SuperPacgomme(x,y,new EffetPacManInvisible());
	}
	public static Pac_gomme makeSuperPacgomme(int x,int y) {
		return new SuperPacgomme(x,y,new EffetSuperPacMan());
	}
	public static Pac_gomme makePacgommeChangeLyprinth(int x,int y) {
		return new SuperPacgomme(x,y,new EffetChangeLabyrinthe());
	}
}
