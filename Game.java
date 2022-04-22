import Entity.Player;
import Entity.Enemy;

import java.util.*;

public class Game {
    public static void main (String[]args)
    {
        Game game = new Game();
        Screen screen = new Screen();
        Player player = new Player("Player", 10, '@');    
        Enemy  enemy = new Enemy("Enemy", 99, '#');

        player.setPosition(0, 0);
        enemy.setPosition(5, 0);

        while(true){
            screen.ClearConsoleScreen();
            screen.erase(); // Reset screen

            screen.drawBody(player.position, player.texture);
            screen.drawBody(enemy.position, enemy.texture);

            player.move('d');

            screen.drawScreen(); // Draw screen
            screen.Sleep(1);

            if(player.isCollidingWith(enemy)){
                screen.printText("¿Deseas atacar a enemy? (y/n)");
                String answer = game.getInput();
                if(answer.equals("y")){
                    if(player.power >= enemy.power){
                        screen.printText("¡Has ganado!");
                        break;
                    } else {
                        screen.printText("¡Uhh, era muy poderoso, ¡Has perdido!");
                        break;
                    }
                }else if(answer.equals("n")){
                    screen.printText("Bueno, has decidido echarte atrás, has sobrevivido, pero sin valor!");
                    break;
                }
                break;
            }
        }
    }

    public void attack(Player player, Enemy enemy){
        if(player.isCollidingWith(enemy)){
            enemy.power -= player.power;
        }
    }

    public String getInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        return (String)input;
    }
}


