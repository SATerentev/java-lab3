package Game;

import app.Result;

public class Equipment extends Item{
    private Rarity rarity;
    private int price;
    private int durability;
    private boolean broken;

    public Equipment(String name, Rarity rarity, int price){
        super(name);

        if (rarity == null || price < 0){
            throw new IllegalStateException();
        }

        this.rarity = rarity;
        this.price = price;
        durability = 100;
        broken = false;
    }

    public void interact(){
        // player.getItem(this)
        System.out.println(getName() + " [" + rarity + "] подобран в инвентарь.");
    }

    public Rarity getRarity(){
        return rarity;
    }

    public Result<Rarity> setRarity(Rarity rarity){
        if (rarity != null){
            this.rarity = rarity;
            return new Result<Rarity>(true, rarity, null);
        } else {
            return new Result<Rarity>(false, null, "Rarity не может быть null");
        }
    }

    public int getPrice(){
        return price;
    }

    public Result<Integer> setPrice(int price){
        if (price >= 0) {
            this.price = price;
            return new Result<Integer>(true, price, null);
        } else {
            return new Result<Integer>(false, null, "Цена не может быть отрицательной");
        }
    }

    public int getDurability(){
        return durability;
    }

    public void changeDurability(int delta){
        durability += delta;

        if (durability <= 0)
            breakDown();

        if (durability > 100)
            durability = 100;

        if (broken && durability > 0)
            getFixed();
    }

    public void changeDurability(double percent){
        durability += (int)(durability * percent);

        if (durability <= 0)
            breakDown();

        if (durability > 100)
            durability = 100;
    }

    public boolean isBroken(){
        return broken;
    }

    private void breakDown(){
        System.out.println(getName() + " сломался");
        broken = true;
    }

    private void getFixed(){
        System.out.println(getName() + " починился");
        broken = false;
    }
}
