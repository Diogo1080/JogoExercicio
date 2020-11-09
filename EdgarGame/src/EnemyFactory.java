import Enemies.*;

public class EnemyFactory{
    public static Enemy createEnemy(String enemy) {
        return switch (enemy) {
            case "Elf" -> new Elf(16, 12);
            case "Dwarf" -> new Dwarf(8, 16);
            case "Human" -> new Human(10, 12);
            default -> new Dragon(20, 20);
        };
    }
}