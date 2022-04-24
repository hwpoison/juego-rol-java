package Entity.Enemies;

import Entity.Character;

public class Enemy extends Character {
    public Enemy(String name, int power, String sprite) {
        this.name = name + "_" + (int)(Math.random() * 100);
        this.power = power;
        this.sprite = sprite;
        this.visible = true;
    }

    public void kill() {
        this.visible = false;
    }
}
