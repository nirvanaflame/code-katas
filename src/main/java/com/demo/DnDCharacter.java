package com.demo;

import java.util.Random;

public class DnDCharacter {

    Random random;
    int charisma;
    int constitution;
    int dexterity;
    int intelligence;
    int strength;
    int wisdom;

    public DnDCharacter() {
        random = new Random();
        charisma = ability();
        constitution = ability();
        dexterity = ability();
        intelligence = ability();
        strength = ability();
        wisdom = ability();
    }

    public int ability() {
        random.nextInt(1, 7);
        return random.ints(4, 1, 7).sorted().skip(1).sum();
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getHitpoints() {
        return 10 + modifier(constitution);
    }

    public int modifier(int constitution) {
        return Math.floorDiv((constitution - 10), 2);
    }
}
