package app;

import Music.*;

import java.util.Random;

public final class Factory {
    private Factory() { }
    private final static Random rand = new Random();
    private final static int TYPES_COUNT = 3;
    private final static String[] names = new String[] {"name 1", "name 2", "name 3", "name 4", "name 5", "name 6", "name 7", "name 8"};

    public static MusicalInstrument CreateRandomMusicalInstrument() {
        switch (rand.nextInt(TYPES_COUNT)){
            case 0:
                return new Guitar(
                        names[rand.nextInt(names.length)], // Берем случайное имя из names[]
                        rand.nextInt(12) // Случайно число от 0 до 12
                );
            case 1:
                return new ElectricGuitar(
                        names[rand.nextInt(names.length)], // Случайное имя из names[]
                        rand.nextInt(12), // Случайное число от 0 до 12
                        PowerSource.values()[rand.nextInt(PowerSource.values().length)] // Случайное значение из Music.PowerSource
                );
            case 2:
                return new Piano(
                        names[rand.nextInt(names.length)], // Случайное имя из names[]
                        rand.nextInt(200), // Случайное число от 0 до 200
                        KeyLayout.values()[rand.nextInt(KeyLayout.values().length)] // Случайное значение из Music.KeyLayout
                );
            default:
                throw new IllegalStateException("Произошло что-то плохое");
        }
    }
}
