package memento_t;

import components.Branch;
import java.util.ArrayList;

public class Memento {
   private ArrayList<Branch> state;

   public Memento(ArrayList<Branch> state){
      this.state = state;
   }

   public ArrayList<Branch> getState(){
      return state;
   }	
}
