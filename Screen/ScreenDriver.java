package Screen;
import Entity.Coords;
import java.util.List;
import java.util.ArrayList;

public class ScreenDriver
{
    int SCREEN_WIDTH = 20;
    int SCREEN_HEIGHT = 5;
    char defaultBackground;
    char[][] surface;
    List<String> messages;

    public void initScreen() {
      this.defaultBackground = '.';
      this.surface = new char[this.SCREEN_WIDTH][this.SCREEN_HEIGHT];
      this.messages = new ArrayList<String>();
    }

    public void draw(){
        for(int y = 0; y < this.SCREEN_HEIGHT; y++){
            for(int x = 0; x < this.SCREEN_WIDTH; x++){
              System.out.printf("%c", this.surface[x][y]);
            }
            System.out.printf("\n");
        }
    }

    public void addMessage(String message){
      System.out.println("Added message: " + message);
      this.messages.add(message);
    }

    public void printSomeLastMessages(){
      if(this.messages.size() > 0){
        System.out.println(this.messages.get(this.messages.size()- 1));
      }
    }

    public void erase() {
          ClearConsoleScreen();
          for(int y=0; y < this.SCREEN_HEIGHT; y++){
              for(int x=0; x < this.SCREEN_WIDTH; x++){
                  this.surface[x][y] = this.defaultBackground; 
          }
      }
    }
      
    public void drawBody(Coords position, char texture) {
      // avoid out of screen 
      if(position.x < 0 || position.x >= this.SCREEN_WIDTH || position.y < 0 || position.y >= this.SCREEN_HEIGHT){
          return;
      }else{
          this.surface[position.x][position.y] = texture;
      }
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
          System.out.print("\033[H\033[2J");
          System.out.flush();
    }

    public void printText(String text) {
          System.out.println(text);
    }

}
