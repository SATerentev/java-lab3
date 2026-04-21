public class Piano extends MusicalInstrument{
    private int keysCount;
    private KeyLayout keyLayout;

    public Piano(String name, int keysCount, KeyLayout keyLayout){
        if (keysCount < 0){
            throw new IllegalArgumentException("Количество клавиш не может быть меньше 0");
        }

        if (keyLayout == null){
            throw new IllegalArgumentException("Раскладка клавиш не может быть пустой");
        }

        super(name);
        this.keyLayout = keyLayout;
        this.keysCount = keysCount;
    }

    public int getKeysCount(){
        return keysCount;
    }

    public Result<Integer> setKeysCount(int keysCount){
        if (keysCount > 0){
            this.keysCount = keysCount;
            return new Result<Integer>(true, this.keysCount, null);
        }

        return new Result<Integer>(false, null, "Количество клавиш не может быть пустым");
    }

    public KeyLayout getKeyLayout(){
        return keyLayout;
    }

    public Result<KeyLayout> setKeyLayout(KeyLayout keyLayout){
        if (keyLayout != null){
            this.keyLayout = keyLayout;
            return new Result<KeyLayout>(true, this.keyLayout, null);
        }

        return new Result<KeyLayout>(false, null, "Раскладка клавиш не может быть пустой");
    }

    @Override
    public String toString(){
        return "Фортепиано - " + getName() + ", количество клавиш - " + keysCount + ", раскладка - " + keyLayout + ".";
    }

    @Override
    public boolean equals(Object obj){
        if (!super.equals(obj)) return false;

        var piano = (Piano)obj;
        return (piano.getKeyLayout() == keyLayout && piano.getKeysCount() == keysCount);
    }
}
