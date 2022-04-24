import Entity.Player;
import Entity.RigidBody;
import Entity.Enemies.Enemy;
import Entity.Enemies.EnemyGenerator;
import Screen.Coords;
import Screen.ScreenDriver;

import java.util.List;
import java.util.ArrayList;

public class Game {
    public static void main(String[] args)
    {
        // preparar pantalla y entrada
        ScreenDriver screen = new ScreenDriver();
        screen.initScreen();

        // initializar el teclado
        Keyboard keyboard = new Keyboard();
        boolean enJuego = true;

        // crear al jugador
        Player player = new Player("Player", 3, 100, "@");    
        player.setPosition(new Coords(0, 0));
        
        // crear los enemigos y asignarles un lugar en la pantalla
        List<RigidBody> allEnemies = new ArrayList<RigidBody>();
        for(int i = 0; i < 4; i++){
            allEnemies.add(EnemyGenerator.random());
            allEnemies.get(i).setPosition(Coords.random());
        }
        // mensaje bienvenida
        screen.addMessage("Hola " + player.name + "!, estás en una aldea llena de zombies y dragones");
        screen.addMessage("Para moverte, usa las flechas del teclado, a sobrevivir!");
        // iniciar el bucle principal
        while(enJuego){
            // borrar la pantalla
            screen.erase();

            // refrescar la posición actual
            // del jugardor y los enemigos
            screen.drawBody(player);
            for(RigidBody enemy : allEnemies){
                screen.drawBody(enemy);
            }

            // dibujar el contenido
            screen.printText("==========================");
            screen.draw();  // contenido
            screen.printText("==========================");
            

            // Evento: Cuando el jugador toca a un enemigo
            // (todo lo que suceda ahora se representará en la próxima iteración)
            Enemy targetEnemy = (Enemy) player.isCollidingWith(allEnemies);
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

            // Detecta si el jugador se quedó sin vida.    
            screen.printSomeLastMessages(); // mensajes
            if(player.life <= 0){
                screen.printText("¡Has perdido!");
                enJuego = false;
                gameOver(screen);
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
    }

    public static void gameOver(ScreenDriver screen) {
        screen.ClearConsoleScreen();
        screen.printText("¡Hasta la próxima!");
    }
}


