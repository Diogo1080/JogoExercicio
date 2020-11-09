import Enemies.Enemy;

import java.util.Scanner;

public class Game {
    private boolean status = true;
    private int stage;
    private final String[] enemyTypes = new String[]{"Elf", "Dwarf", "Human"};
    private final Enemy[] enemies = new Enemy[6];
    private final Player player = new Player();

    public void start() {
        for (int i = 0; i < enemies.length - 1; i++) {
            int enemy = (int) Math.floor(Math.random() * Math.floor(3));
            enemies[i] = EnemyFactory.createEnemy(enemyTypes[enemy]);
        }

        enemies[enemies.length - 1] = EnemyFactory.createEnemy("Dragon");

        round();
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

    private void round() {
        stage = 0;
        do {
            player.print();
            enemies[stage].print();
            Scanner scan = new Scanner(System.in);
            //Draw in screen options
            System.out.println("1: Attack enemy");
            System.out.println("2: Special Attack");
            System.out.println("3: Recharge");
            System.out.println("4: Avoid enemy");
            System.out.println("5: Quit game");

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

