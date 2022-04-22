import Entity.Coords;

public class Screen
{
  int SCREEN_WIDTH = 20;
  int SCREEN_HEIGHT = 5;
  char defaultBackground = '.';
  char[][] surface = new char[SCREEN_WIDTH][SCREEN_HEIGHT];
  
  public void drawScreen(){
     for(int y = 0; y < this.SCREEN_HEIGHT; y++){
         for(int x = 0; x < this.SCREEN_WIDTH; x++){
            System.out.printf("%c", this.surface[x][y]);
         }
         System.out.printf("\n");
     }
  }
  public void erase() {
        for(int y=0; y < this.SCREEN_HEIGHT; y++){
            for(int x=0; x < this.SCREEN_WIDTH; x++){
                this.surface[x][y] = this.defaultBackground; 
        }
    }
  }
   
  public void drawBody(Coords position, char texture) {
      this.surface[position.x][position.y] = texture;
  } 

  public void Sleep(int seconds) { 
    try {
        Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
  }

  public void drawInScreen(int x, int y, char character) {
        this.surface[x][y] = character; 
  }

  public void ClearConsoleScreen() {
             System.out.print("Everything on the console will cleared");
        System.out.print("\033[H\033[2J");
        System.out.flush();
  }

  public void printText(String text) {
        System.out.print(text);
  }

}

class Jugador {
    int y;
    int x;
}



