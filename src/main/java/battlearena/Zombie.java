package battlearena;

public class Zombie extends Enemy implements IZombie {

    public Zombie(int healthPoints, int attackDamage) {
        super(healthPoints, attackDamage);
    }

    @Override
    public void talk() {
        System.out.println("*Grumbling...*");
    }

    @Override
    public void specialAttack() {
        boolean didSpecialAttackWork = Math.random() < .50;

        if (didSpecialAttackWork) {
            setHealthPointsRemaining(getHealthPointsRemaining() + 2);
            System.out.println("Zombie regenerated 2 HP!");
        } else {
            System.out.println("Zombie failed to regenerate.");
        }
    }

    @Override
    public void battleStance() {
        System.out.println("Zombie takes a slow, staggering battle stance...");
    }

    public void spreadDisease() {
        System.out.println("The zombie is trying to spread infection");
    }
}
