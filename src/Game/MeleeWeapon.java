package Game;

import app.Result;

import java.util.Random;

public class MeleeWeapon extends Equipment {
    private int damage;
    private double attackRange;
    private static final Random rand = new Random();
    private static final String[] NAMES = new String[] {"name 1", "name 2", "name 3"};
    private static final int MAX_PRICE = 1000;
    private static final int MAX_DAMAGE = 100;
    private static final double MAX_ATTACK_RANGE = 20;

    {
        System.out.println("Создано новое оружие " + getName());
    }

    public MeleeWeapon(String name, Rarity rarity, int price, int damage, double attackRange){
        super(name, rarity, price);

        if ((damage < 0 || damage > MAX_DAMAGE) || (attackRange < 0 || attackRange > MAX_ATTACK_RANGE)){
            throw new IllegalStateException();
        }

        this.damage = damage;
        this.attackRange = attackRange;
    }

    public MeleeWeapon(){
        String name = NAMES[rand.nextInt(NAMES.length)];
        Rarity rarity = Rarity.values()[rand.nextInt(Rarity.values().length)];
        super(name, rarity, rand.nextInt(MAX_PRICE));

        this.damage = rand.nextInt(MAX_DAMAGE);
        this.attackRange = rand.nextDouble(MAX_ATTACK_RANGE);
    }

    public int getDamage(){
        return damage;
    }

    public Result<Integer> setDamage(int damage){
        if (damage >= 0 && damage < MAX_DAMAGE){
            this.damage = damage;
            return new Result<Integer>(true, damage, null);
        } else {
            return new Result<Integer>(false, null, "Урон не может быть меньше 0");
        }
    }

    public double getAttackRange(){
        return attackRange;
    }

    public Result<Double> setAttackRange(double attackRange){
        if (attackRange >= 0 && attackRange < MAX_ATTACK_RANGE){
            this.attackRange = attackRange;
            return new Result<Double>(true, attackRange, null);
        } else {
            return new Result<Double>(false, null, "Дистанция атаки не может быть меньше 0");
        }
    }
}
