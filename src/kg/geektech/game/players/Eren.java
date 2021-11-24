package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Eren extends Hero {
    public Eren(int health, int damage, String name) {
        super(health, damage, SuperAbility.BAFF_HPBIG, name);

    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean baff = RPG_Game.random.nextBoolean();
        if (baff) {
            this.setHealth(this.getHealth() + 100);
            this.setDamage(this.getDamage() + 10);
            System.out.println("Эрен Увеличил себя на [50%]");
        } else {
            this.setDamage(this.getDamage() - 10);
            this.setHealth(this.getHealth() - 100);
            System.out.println("Эрен уменьшил себя на [50%]");
        }


    }


}
