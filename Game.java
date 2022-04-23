import Entity.Player;
import Screen.ScreenDriver;
import Entity.Enemy;

import java.util.List;
import java.util.ArrayList;

public class Game {
    public static void main (String[]args)
    {
        // preparar pantalla y entrada
        ScreenDriver screen = new ScreenDriver();
        screen.initScreen();
        Keyboard keyboard = new Keyboard();
        boolean enJuego = true;

        // posicionar entidades
        Player player = new Player("Player", 10, 100, '@');    
        player.setPosition(0, 0);
        
        List<Enemy> allEnemies = new ArrayList<Enemy>();
        allEnemies.add(new Enemy("Enemy1", 10, '#'));
        allEnemies.add(new Enemy("Enemy2", 10, '#'));
        allEnemies.add(new Enemy("Enemy3", 10, '#'));


        while(enJuego){
            screen.erase(); // Borrar pantalla

            // jugador y enemigos
            screen.drawBody(player.position, player.texture);
            for(Enemy enemy : allEnemies){
                enemy.setPosition(3, 4);
                screen.drawBody(enemy.position, enemy.texture);
            }

            // dibujar pantalla y mensajes
            screen.draw(); 
            screen.printSomeLastMessages();

            Enemy enemy = allEnemies.get(0);
            // eventos del juego 
            if(player.isCollidingWith(enemy)){
                screen.printText("El enemigo tiene " + enemy.power + " de poder.");
                screen.printText("¿Deseas atacar? (y/n)");
                keyboard.getAInput();
                if(keyboard.inputEqualTo("y")){
                    if(Actions.attack(player, enemy)){
                        screen.printText("¡Has ganado!");
                    }else{
                        screen.printText("¡El enemigo es muy poderoso!");
                    }
                }else if(keyboard.inputEqualTo("n")){
                    screen.printText("Bueno, has decidido echarte atrás, has sobrevivido, pero sin valor!, el juego ha terminado.");
                    keyboard.waitConfirmation();
                    break;
                }
            }

            if(player.life <= 0){
                screen.printText("¡Has perdido!");
                enJuego = false;
            }else{
                screen.printText("Te queda: " + player.life + " de vida.");
            }
            
            // eventos del teclado
            screen.printText("Elige una acción:");
            keyboard.getAInput();
            switch(keyboard.input){
                case "w":
                    player.move('w');
                    break;
                case "s":
                    player.move('s');
                    break;
                case "a":
                    player.move('a');
                    break;
                case "d":
                    player.move('d');
                    break;
                case "q":
                    if(player.potions > 0){
                        screen.addMessage("¡Has usado una poción!");
                        Actions.heal(player);
                        player.potions--;
                    }else{
                        screen.addMessage("No tienes más pociones!");
                    }
                    break;
                default:
                    break;
            }
        
        }

        // game over
        screen.ClearConsoleScreen();
        screen.printText("¡Hasta la próxima!");

    }
}


