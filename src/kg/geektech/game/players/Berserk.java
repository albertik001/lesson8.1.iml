package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Berserk extends Hero {
    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int block = RPG_Game.random.nextInt(50) + 1;
        this.setHealth(this.getHealth() + block);
        boss.setHealth(boss.getHealth() - block);
        System.out.println("Берсеерк Поглотил: [" + block + "] damage!");
    }

}
