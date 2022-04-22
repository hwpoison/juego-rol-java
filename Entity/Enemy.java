package Entity;

public class Enemy extends Body {
    String name;
    int power;
    char texture;
    public Enemy(String name, int power, char texture) {
        this.name = name;
        this.power = power;
        this.texture = texture;
    }
}
