package Entity;

import java.util.List;

import Entity.Enemies.Enemy;

public class Player extends Character {
    public int score;
    public int potions;

    public Player(String name, int power, int life, String sprite) {
        this.name = name;
        this.power = power;
        this.life = life;
        this.sprite = sprite;
        this.potions = 2;
        this.visible = true;
    }

    public void drinkAPotion() {
        this.life += 10;
    }

    public boolean attack(Enemy enemy){
        if(this.power > enemy.power){
            enemy.life -= this.power;
            this.score++;
            return true;
        }
        if(this.power <= enemy.power){
            this.life -= enemy.power;
            return false;
        }
        return false;
    } 

    public void moveTo(char direction) {
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