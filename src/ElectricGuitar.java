public class ElectricGuitar extends Guitar{
    private PowerSource powerSource;

    public ElectricGuitar(String name, int stringsCount, PowerSource powerSource){
        if (powerSource == null){
            throw new IllegalArgumentException();
        }

        super(name, stringsCount);
        this.powerSource = powerSource;
    }

    public PowerSource getPowerSource(){
        return powerSource;
    }

    public Result<PowerSource> setPowerSource(PowerSource powerSource){
        if (powerSource != null){
            this.powerSource = powerSource;
            return new Result<PowerSource>(true, this.powerSource, null);
        }

        return new Result<PowerSource>(false, null, "Источник питания не может быть пустым");
    }

    @Override
    public String toString(){
        return "Электрогитара - " + getName() + ", количество струн - " + getStringsCount() + ", источник питания - " + powerSource + ".";
    }

    @Override
    public boolean equals(Object obj){
        if (!super.equals(obj)) return false;

        var eguitar = (ElectricGuitar) obj;
        return eguitar.getPowerSource() == powerSource;
    }
}
