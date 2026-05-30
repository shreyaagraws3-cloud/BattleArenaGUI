package battlearena;

public class Ogre extends Enemy implements IOgre {

    public Ogre(int healthPoints, int attackDamage) {
        super(healthPoints, attackDamage);
    }

    @Override
    public void talk() {
        System.out.println("Ogre: Bath? What is that? I am just hungry.");
    }

    @Override
    public void specialAttack() {
        boolean didSpecialAttackWork = Math.random() < .20;

        if (didSpecialAttackWork) {
            setHealthPointsRemaining(getHealthPointsRemaining() + 4);
            System.out.println("Ogre's attack increased by 4!");
        } else {
            System.out.println("Ogre's special attack failed.");
        }
    }

    @Override
    public void stareDown() {
        System.out.println("The ogre stares you down with rage...");
    }
}
