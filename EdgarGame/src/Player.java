public class Player implements PlayerInterface {
    private int health = 100;
    private int normalAttack = 30;
    private int specialAttack = 50;
    private int specialAttackCounter = 3;
    private int healthRechargeCounter = 3;

    public int getHealth() {
        return health;
    }

    @Override
    public void getHitted(double hit) {
        health -= hit;
    }

    @Override
    public int rechargeHealth(int health) {
        if (healthRechargeCounter != 0) {
            this.health += health;
            if (this.health >= 100) {
                this.health = 100;
            }
            healthRechargeCounter--;
            return this.health;
        }
        return 0;
    }

    @Override
    public int normalAttack() {
        return normalAttack;
    }

    @Override
    public int specialAttack() {
        if (specialAttackCounter != 0) {
            specialAttackCounter--;
            return specialAttack;
        }
        return 0;
    }

    public void print() {
        System.out.println(" ----Player---- ");
        System.out.println(" Health: " + health);
    }

    public boolean isAlive() {
        return health > 0;
    }
}
