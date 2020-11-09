import Enemies.*;

public class EnemyFactory{

    public static Enemy createEnemy(String enemy) {
        return switch (enemy) {
            case "Elf" -> new Elf(12, 12);
            case "Dward" -> new Dwarf(3, 13);
            case "Human" -> new Human(8, 9);
            default -> new Dragon(20, 20);
        };
    }


}