package battlearena;

public class Enemy implements IEnemy {

    private int id;
    private int healthPointsRemaining;
    private int healthPoints;
    private int attackDamage;

    private static int numberOfEnemies;

    public Enemy(int healthPoints, int attackDamage) {
        this.healthPoints = healthPoints;
        this.healthPointsRemaining = healthPoints;
        this.attackDamage = attackDamage;

        numberOfEnemies++;
        this.id = numberOfEnemies;
    }

    public String getEnemyName() {
        return this.getClass().getSimpleName();
    }

    public int getHealthPointsRemaining() {
        return healthPointsRemaining;
    }

    public void setHealthPointsRemaining(int healthPointsRemaining) {
        this.healthPointsRemaining = healthPointsRemaining;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getId() {
        return id;
    }

    public static int getNumberOfEnemies() {
        return numberOfEnemies;
    }

    @Override
    public void talk() {
        System.out.println(getEnemyName() + ": I am ready to fight!");
    }

    @Override
    public void walkForward() {
        System.out.println(getEnemyName() + " walks forward.");
    }

    @Override
    public void attack() {
        System.out.println(getEnemyName() + " attacks for " + attackDamage + " damage!");
    }

    @Override
    public void specialAttack() {
        System.out.println(getEnemyName() + " has no special attack.");
    }
}
