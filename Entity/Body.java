package Entity;

public class Body {
   public Coords position;
   // detect collision
   public boolean isCollidingWith(Body body) {
        // print actual status
        if (this.position.x == body.position.x 
               && this.position.y == body.position.y) {
            return true;
        } else {
            return false;
        }
   }

   public void setPosition(int x, int y) {
      this.position = new Coords();
       this.position.x = x;
       this.position.y = y;
   }
}