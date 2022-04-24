import Entity.Player;
import Screen.Coords;
import Screen.ScreenDriver;
import Entity.Enemy;

import java.util.List;
import java.util.ArrayList;

public class Game {
    public static void main(String[] args)
    {
        // preparar pantalla y entrada
        ScreenDriver screen = new ScreenDriver();
        screen.initScreen();
        Keyboard keyboard = new Keyboard();
        boolean enJuego = true;

        // crear jugador
        Player player = new Player("Player", 3, 100, "@");    
        player.setPosition(new Coords(0, 0));
        
        // crear enemigos
        List<Enemy> allEnemies = new ArrayList<Enemy>();
        for(int i = 0; i < 3; i++){
            allEnemies.add(new Enemy());
            allEnemies.get(i).setPosition(Coords.random());
        }

        while(enJuego){
            screen.erase(); // Borrar pantalla

            // jugador y enemigos
            screen.drawBody(player);
            for(Enemy enemy : allEnemies){
                screen.drawBody( enemy);
            }

            // dibujar pantalla y mensajes
            screen.printText("==========================");
            screen.draw(); 
            screen.printText("==========================");
            screen.printSomeLastMessages();
            // eventos del juego
            
            // Cuando el jugador toca a un enemigo
            Enemy targetEnemy = player.touchEnemies(allEnemies);
            if(targetEnemy!=null){
                screen.printText("El enemigo tiene " + targetEnemy.power + " de poder.");
                screen.printText("Te has topado con " + targetEnemy.name  +" ¿Deseas atacar? (y/n)");
                keyboard.getAInput();
                if(keyboard.inputEqualTo("y")){
                    if(player.attack(targetEnemy)){
                        targetEnemy.kill();
                        screen.addMessage("¡Has ganado!");
                    }else{
                        screen.addMessage("¡El enemigo es muy poderoso!");
                        screen.printText("Te ha quitado " + targetEnemy.power +  " de vida.");
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
            
            // Eventos del teclado
            screen.printText("Elige una acción:");
            keyboard.getAInput();
            switch(keyboard.input){
                case "w":
                    player.moveTo('w');
                    break;
                case "s":
                    player.moveTo('s');
                    break;
                case "a":
                    player.moveTo('a');
                    break;
                case "d":
                    player.moveTo('d');
                    break;
                case "q":
                    if(player.potions > 0){
                        screen.addMessage("¡Has usado una poción!");
                        player.drinkAPotion();
                        player.potions--;
                    }else{
                        screen.addMessage("No tienes más pociones!");
                    }
                    break;
                default:
                    screen.addMessage("No puedes hacer eso.");
                    break;
            }
        
            
        }
        // game over
        screen.ClearConsoleScreen();
        screen.printText("¡Hasta la próxima!");

    }
}


