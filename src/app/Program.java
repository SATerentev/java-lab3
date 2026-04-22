package app;

import Music.MusicalInstrument;

public class Program {
    public static void main(){
        MusicalInstrument[] instruments = new MusicalInstrument[20];

        for (int i = 0; i < 20; i++){
            instruments[i] = InstrumentsFactory.CreateRandomMusicalInstrument();
        }

        for (MusicalInstrument instrument : instruments) {
            System.out.println(instrument.toString() + " | class - " + instrument.getClass());
        }

        System.out.println("\n\n");

        var result1 = Services.findFirstGuitarWithMaxStrings(instruments);
        var result2 = Services.getAverageStringsCount(instruments);
        var result3 = Services.getMaxKeysCountOctave(instruments);

        if (result1.IsSuccess()){
            System.out.println("Гитара с самым большим количеством струн - " + result1.Value());
        } else {
            System.out.println(result1.ErrorMessage());
        }

        System.out.println("-----------------------");

        if (result2.IsSuccess()){
            System.out.println("Среднее количество струн на гитарах - " + result2.Value());
        } else {
            System.out.println(result2.ErrorMessage());
        }

        System.out.println("-----------------------");

        if (result3.IsSuccess()){
            System.out.println("Максимальное количество клавиш на фортепиано с октавной раскладкой - " + result3.Value());
        }
    }
}
