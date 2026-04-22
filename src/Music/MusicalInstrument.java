package Music;

import app.Result;

public abstract class MusicalInstrument {
    private String name;

    public MusicalInstrument(String name){
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Result<String> setName(String name){
        if (name != null && name.isEmpty()){
            this.name = name;
            return new Result<String>(true, this.name, null);
        }

        return new Result<String>(false, null, "Имя не может быть пустым");
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != getClass()) return false;

        MusicalInstrument instrument = (MusicalInstrument) obj;
        return instrument.getName().equals(name);
    }
}
