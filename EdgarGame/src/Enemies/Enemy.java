package Enemies;

/* Classe abstract implementa um metodo abstrato */
public class Enemy {
    protected String type;
    protected double life = 100.00;
    protected int defenseFactor;
    protected int attackFactor;

    /* CONSTRUTOR */
    public Enemy(String type, int defenseFactor, int attackFactor) {
        this.type = type;
        this.defenseFactor = defenseFactor;
        this.attackFactor = attackFactor;
    }

    public void print() {
        System.out.println("-----Enemy-----");
        System.out.println("Type: " + type + "\n Life:" + life);
    }

    public boolean isAlive() {
        return !(life <= 0);
    }

    public double health() {
        return life;
    }

    public void takeDamage(double damage) {
        damage -= Math.random() * defenseFactor;
        life -= damage;
    }

    public int attack() {
        return (int) Math.floor(Math.random() *attackFactor);
    }

}


