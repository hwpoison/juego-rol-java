package Entity.Enemies;

public class EnemyGenerator {
   public static Dragon aDragon() {
      return new Dragon(10);
   }

   public static Zombie aZombie() {
      return new Zombie(5);
   }

   public static Enemy random() {
      int random = (int)(Math.random() * 2);
      switch(random) {
         case 0:
            return aZombie();
         default:
            return aDragon();
      }
   }
}
