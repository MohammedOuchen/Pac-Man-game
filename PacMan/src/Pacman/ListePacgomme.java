package Pacman;
import java.awt.Color;



import java.util.ArrayList;
import java.util.List;

public class ListePacgomme {
    
    private static List<Pac_gomme> pacgommes=new ArrayList<Pac_gomme>();
    
public static  List<Pac_gomme> ListePacgomme(){ 
   
  Pac_gomme bnn=null;
  
 for(int i =0; i <21; i++) {
	      for(int j = 0; j <35; j++) {

		      if(Game.getMap()[i][j].equals("-")) {
		        if(i==19&&j==1) {
				    bnn=PacgommeFactory.makePacgommeInvisible(j, i);
				    pacgommes.add(bnn); 
			     }else if(i==1&&j==33){
				     bnn=PacgommeFactory.makeSuperPacgomme(j,i);
				     pacgommes.add(bnn); 
			     }else if(i==19 && j==33){
				     bnn=PacgommeFactory.makePacgommeChangeLyprinth(j,i);
				     pacgommes.add(bnn); 
				 }else {
				     bnn=PacgommeFactory.makePacgommeNormal(j,i);
			         pacgommes.add(bnn); 
			     }
		        } 
		     }
}
return pacgommes;
}
}