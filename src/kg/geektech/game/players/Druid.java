package kg.geektech.game.players;

public class Druid extends Hero {
    public static boolean baff = true;

    public Druid(int health, int damage, String name) {
        super(health, damage, SuperAbility.PRIZYV_ANGEL_AND_VORON, name);


    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

        if (boss.getHealth() < 350 && baff == true) {
            boss.setDamage(boss.getDamage() * 2);
            System.out.println("Друид призвал боссу Ворона, а ворон увеличил урон босса на: [" + boss.getDamage() + "] единиц!");
            baff = false;
        }
    }
}