package Screen;

public class Coords {
   public int x;
   public int y; 

   public Coords(int x, int y) {
      this.x = x;
      this.y = y;
   }

   public static Coords random(){
      int x = (int)(Math.random() * ScreenDriver.getScreenWidth());
      int y = (int)(Math.random() * ScreenDriver.getScreenHeight());
      return new Coords(x, y);
   }
}
