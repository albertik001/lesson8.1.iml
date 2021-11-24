package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int roundNumber;
    public static Random random = new Random();
    private static int tekhp;
    private static int hpboss;


    public static void start() {
        Boss boss = new Boss(700, 50, "Tanos");
        Warrior warrior = new Warrior(260, 15, "Varvar");
        Medic doc = new Medic(230, 10, 15, "Aibolit");
        Berserk berserk = new Berserk(270, 20, "Bers");
        Magic magic = new Magic(250, 25, "Antimag");
        Medic assistant = new Medic(270, 15, 5, "Stajer");
        Eren titan = new Eren(200, 25, "Eren");
        Druid druid = new Druid(150, 20, "Serafim");
        Sharik sharik = new Sharik(250, 30, "Sharik");
        Hero[] heroes = {warrior, doc, berserk, magic, assistant, titan, druid, sharik};
        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }


    public static int getRoundNumber() {
        return roundNumber;
    }

    public static void setRoundNumber(int roundNumber) {
        RPG_Game.roundNumber = roundNumber;
    }

    private static void round(Boss boss, Hero[] heroes) {
        roundNumber++;
        bossHits(boss, heroes);
        heroesHit(boss, heroes);
        heroesAppliesSuperAbilities(boss, heroes);
        printStatistics(boss, heroes);
        warriordamage(heroes);
        antimagdamage(heroes);
        berserkdamage(heroes);
        docdamage(heroes);
        docdamage1(heroes);
        erendamage(heroes);
        hpstandart(boss);

    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                hero.setHealth(hero.getHealth() - boss.getDamage());
                tekhp = heroes[5].getHealth();
                hpboss = boss.getDamage();
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        final int hj = boss.getDamage();
        boss.setDamage(hj);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0)
                boss.setHealth(boss.getHealth() - hero.getDamage());
        }
    }

    private static void heroesAppliesSuperAbilities(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0)
                hero.applySuperPower(boss, heroes);
        }
    }


    private static void warriordamage(Hero[] heroes) {
        heroes[0].setDamage(15);
    }

    private static void docdamage(Hero[] heroes) {
        heroes[1].setDamage(20);
    }

    private static void berserkdamage(Hero[] heroes) {
        heroes[2].setDamage(20);
    }

    private static void antimagdamage(Hero[] heroes) {
        heroes[3].setDamage(25);
    }


    private static void docdamage1(Hero[] heroes) {
        heroes[4].setDamage(15);
    }


    private static void erendamage(Hero[] heroes) {
        if (heroes[5].getHealth() >= 0) {
            heroes[5].setDamage(25);
            heroes[5].setHealth(tekhp);
        }
        tekhp = 0;
    }

    private static void hpstandart(Boss boss) {
        if (boss.getDamage() > 50)
            boss.setDamage(hpboss);
    }


    public static Random getRandom() {
        return random;
    }

    public static void setRandom(Random random) {
        RPG_Game.random = random;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println((roundNumber == 0 ? "BEFORE START" : roundNumber + " ROUND")
                + " _____________");
        System.out.println("Boss " + boss.getName() +
                " health: " + boss.getHealth() + " [" + boss.getDamage() + "]");
        for (Hero hero : heroes) {
            /*System.out.println(heroes[i].getClass().getSimpleName() +
                    " health: " + heroes[i].getHealth()
                    + "[" + heroes[i].getDamage() + "]");*/
            System.out.println(hero.getName() +
                    " health: " + hero.getHealth()
                    + " [" + hero.getDamage() + "]");
        }
        System.out.println("_____________");
    }
}
