package Entity;

import Screen.Coords;
import java.util.List;

public class RigidBody {
   public int id;
   public String sprite;
   public boolean visible;
   public Coords position;

   public boolean isCollidingWith(RigidBody body) {
        if (this.position.x == body.position.x 
         && this.position.y == body.position.y)
                return true;
        return false;
   }
   // apply upcasting
   public RigidBody isCollidingWith(List<RigidBody> bodies) { 
        for (RigidBody body : bodies) {
            if (this.isCollidingWith(body))
                  return body;
        }
        return null;
   }

   public void setPosition(Coords position) {
      this.position = position;
   }
}