package memento_t;

import components.Branch;

import java.util.ArrayList;

public class Originator {
   private ArrayList<Branch> state;

   public void setState(ArrayList<Branch> state){
      this.state = state;
   }

   public ArrayList<Branch> getState(){
      return state;
   }

   public Memento saveStateToMemento(){
      return new Memento(state);
   }

   public void getStateFromMemento(Memento Memento){
      state = Memento.getState();
   }
}
