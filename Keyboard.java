import java.util.Scanner;

public class Keyboard {
    public String input;

    public void getAInput(){
        // update this.input
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            this.input = scanner.nextLine();
        }
    }

    public boolean inputEqualTo(String input){
        return this.input.equals(input);
    }

    public void waitConfirmation(){
        System.out.println("Presionar Enter para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();
    }
   
}
