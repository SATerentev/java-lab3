public class Guitar extends MusicalInstrument{
    private int stringsCount;

    public Guitar (String name, int stringsCount){
        if (stringsCount < 0){
            throw new IllegalArgumentException("Количество струн не может быть меньше 0");
        }

        super(name);
        this.stringsCount = stringsCount;
    }

    public int getStringsCount(){
        return stringsCount;
    }

    public Result<Integer> setStringsCount(int stringsCount){
        if (stringsCount > 0){
            this.stringsCount = stringsCount;
            return new Result<Integer>(true, stringsCount, null);
        }

        return new Result<Integer>(false, null, "Количество струн не может быть меньше 0");
    }

    @Override
    public String toString(){
        return "Гитара - " + getName() + ", " + stringsCount + " струн.";
    }

    @Override
    public boolean equals(Object obj){
        if (!super.equals(obj)) return false;

        Guitar guitar = (Guitar)obj;
        return guitar.getName().equals(getName());
    }
}
