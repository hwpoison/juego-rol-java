package Entity;

public class Player extends Character {
    public int score;
    public int potions;
    
    public Player(String name, int power, int life, char texture) {
        this.name = name;
        this.power = power;
        this.life = life;
        this.texture = texture;
        this.potions = 2;
    }

    public void move(char direction) {
        switch (direction) {
            case 'w':
                this.position.y--;
                break;
            case 's':
                this.position.y++;
                break;
            case 'a':
                this.position.x--;
                break;
            case 'd':
                this.position.x++;
                break;
        }
    }

    public String getLife() {
        return "Te queda: " + this.life + " de vida.";
    }
}