package Entity;

public class Enemy extends Character {
    public Enemy(String name, int power, String sprite) {
        this.name = name;
        this.power = power;
        this.sprite = sprite;
    }

    public Enemy() {
        this.name = "Enemy_" + (int)(Math.random()*100);
        this.power = (int)Math.random() * 20;
        this.sprite = "#";
        this.visible = true;
    }

    public void kill() {
        this.visible = false;
    }
}
