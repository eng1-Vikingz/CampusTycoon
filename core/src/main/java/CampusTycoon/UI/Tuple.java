package CampusTycoon.UI;

public class Tuple<X, Y> { 

    public final X x; 
    public final Y y; 

    public Tuple(X x, Y y) { 
      this.x = x; 
      this.y = y; 
    } 

    @Override
    public String toString() {

        String str = "[ " + x  + " : " + y +"]";
        return str;
    }

    @Override
    public boolean equals(Object o){
      if(this == o){
        return true;
      }

      if(o == null){
        return false;
      }

      if(o instanceof Tuple){
        Tuple<X, Y> tuple = (Tuple<X, Y>) o;
        
        if(this.x.equals(tuple.x) && this.y.equals(tuple.y)){
          return true;
        }
      }

      return false;

    }


  } 