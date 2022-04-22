import Entity.Player;


import Entity.Enemy;

public class Main {
    public static void main (String[]args)
    {
        Screen screen = new Screen();
        Player player = new Player("Player", 10, '@');    
        Enemy  enemy = new Enemy("Enemy", 10, '#');

        player.setPosition(0, 0);
        enemy.setPosition(5, 0);

        while(true){
            screen.ClearConsoleScreen();
            screen.erase(); // Reset screen

            System.out.println("==========");

            screen.drawBody(player.position, player.texture);

            screen.drawBody(enemy.position, '*');

            if(player.isCollidingWith(enemy)){
                System.out.println("You lose! :(");
                break;
            }

            player.move('d');

            screen.drawScreen(); // Draw screen
            screen.Sleep(1);
        }
    }


}


