package Entity;

public class Player extends Body {
    public String name;
    public char texture;
    public int power;

    public Player(String name, int power, char texture) {
        this.name = name;
        this.power = power;
        this.texture = texture;
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
}