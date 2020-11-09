import Enemies.Enemy;

import java.util.Scanner;

public class Game {
    private boolean status = true;
    private int stage;
    private String[] enemyTypes = new String[]{"Elf", "Dwarf", "Human"};
    private Enemy[] enemies = new Enemy[6];
    private Player player = new Player();

    public void start() {
        for (int i = 0; i < enemies.length - 1; i++) {
            int randomDefence = (int) (Math.random() * 20);
            int randomAttack = (int) (Math.random() * 10);
            int enemy = (int) Math.floor(Math.random() * Math.floor(3));

            enemies[i] = new Enemy(enemyTypes[enemy], randomDefence, randomAttack);
        }

        int randomDefence = (int) (Math.random() * 20) + 10;
        int randomAttack = (int) (Math.random() * 20) + 10;
        enemies[enemies.length - 1] = new Enemy("Dragon", randomDefence, randomAttack);
    }

    private void normalAttack() {
        enemies[stage].takeDamage(player.normalAttack());
        if (enemies[stage].isAlive()) {
            player.getHitted(enemies[stage].attack());
        } else {
            stage++;
        }
    }

    private void specialAttack() {
        int specialAttack = player.specialAttack();
        if (specialAttack != 0) {
            enemies[stage].takeDamage(specialAttack);
            if (enemies[stage].isAlive()) {
                player.getHitted(enemies[stage].attack());
            } else {
                stage++;
            }
        } else {
            System.out.println("You don't have anymore special attacks.");
        }
    }

    private void recharge() {
        int rechargeHealth = player.rechargeHealth(15);
        if (rechargeHealth == 0) {
            System.out.println("You don't have anymore recharges.");
        }
        player.rechargeHealth(15);
    }

    public void round() {
        stage = 0;
        do {
            player.print();
            enemies[stage].print();
            Scanner scan = new Scanner(System.in);
            System.out.println(" 1: Attack enemy");
            System.out.println(" 2: Special Attack");
            System.out.println(" 3: Recharge");
            System.out.println(" 4: Avoid enemy");
            System.out.println(" 5: Quit game");
            int choice = scan.nextInt();  // Read user input
            switch (choice) {
                case 1 -> normalAttack();
                case 2 -> specialAttack();
                case 3 -> recharge();
                case 5 -> {
                    status = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Choice doesn't exists.");
            }
            if (!player.isAlive()) {
                status = false;
                System.out.println("You died");
            }
            if (enemies[enemies.length - 1].health() <= 0) {
                status = false;
            }
        } while (status);
    }
}

