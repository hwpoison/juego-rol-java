import Entity.Player;
import Entity.Enemy;

public class Actions {
    public static boolean attack(Player player, Enemy enemy){
        if(player.power > enemy.power){
            enemy.life = enemy.life - player.power;
            player.score++;
            return true;
        }
        if(player.power < enemy.power){
            player.life = player.life - enemy.power;
            return false;
        }
        return false;
    } 

    public static void heal(Player player){
        player.life += 10;
    }
}
