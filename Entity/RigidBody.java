package Entity;

public class RigidBody {
   public int id;
   public Coords position;

   public boolean isCollidingWith(RigidBody body) {
        if (this.position.x == body.position.x 
         && this.position.y == body.position.y)
                return true;
        return false;
   }

   public void setPosition(int x, int y) {
      this.position = new Coords(x, y);
   }
}