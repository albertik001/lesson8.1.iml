package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;


public class Sharik extends Hero {

    public Sharik(int health, int damage, String name) {
        super(health, damage, SuperAbility.ZASHARIT, name);


    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean round = random.nextBoolean();
        int zasharil = 100;
        for (int i = 0; i < heroes.length; i++) {
            if (round == true && heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - zasharil);
                i = RPG_Game.random.nextInt(heroes.length);
                heroes[i].setHealth(heroes[i].getHealth() + zasharil);
                System.out.println(" Шарик Забрал у Таноса [" + zasharil + "] HP и перевел герою: [" + heroes[i].getName() + "]");
                break;
            } else {
                System.out.println("Шарик не зашарил!");
                break;
            }
        }

    }
}

