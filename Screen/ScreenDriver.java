package Screen;
import java.util.List;

import Entity.RigidBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ScreenDriver
{
    static int SCREEN_WIDTH = 20;
    static int SCREEN_HEIGHT = 7;
    String defaultBackground;
    String [][] surface;
    List<String> messages;

    public void initScreen() {
      this.defaultBackground = " ";
      this.surface = new String[SCREEN_WIDTH][SCREEN_HEIGHT];
      this.messages = new ArrayList<String>();
    }

    public static int getScreenWidth() {
      return SCREEN_WIDTH;
    }
    
    public static int getScreenHeight() {
      return SCREEN_HEIGHT;
    }

    public void drawChar(String c, int x, int y) {
      this.surface[x][y] = c;
    }

    public void draw(){
        for(int y = 0; y < SCREEN_HEIGHT; y++){
            for(int x = 0; x < SCREEN_WIDTH; x++){
              System.out.print(this.surface[x][y]);
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
          for(int y=0; y < SCREEN_HEIGHT; y++){
              for(int x=0; x < SCREEN_WIDTH; x++){
                  this.surface[x][y] = this.defaultBackground; 
          }
      }
    }
      
    public void drawBody(RigidBody body) {
      if(!body.visible) return;
      if(body.position.x < 0 || body.position.x >= SCREEN_WIDTH 
        || body.position.y < 0 || body.position.y >= SCREEN_HEIGHT){
          return;
      }else{
          this.surface[body.position.x][body.position.y] = body.sprite;
      }
    } 

    public void Sleep(int seconds) { 
      try {
          Thread.sleep(seconds * 1000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
    }

    public void ClearConsoleScreen() {
    	String command = "cmd.exe /c cls";
    	 
    	try {
    	    Process process = Runtime.getRuntime().exec(command);
    	 
    	    BufferedReader reader = new BufferedReader(
    	            new InputStreamReader(process.getInputStream()));
    	    String line;
    	    while ((line = reader.readLine()) != null) {
    	        System.out.println(line);
    	    }
    	 
    	    reader.close();
    	 
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}
        System.out.flush();
    }

    public void printText(String text) {
          System.out.println(text);
    }

}
