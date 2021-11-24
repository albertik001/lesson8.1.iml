package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Magic extends Hero {
    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int magicbaff = RPG_Game.random.nextInt(5) + 1;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setDamage(heroes[i].getDamage() + magicbaff);
            }
        }
        System.out.println("Антимаг увеличил урон героям на: [" + magicbaff + "]");
    }
}
