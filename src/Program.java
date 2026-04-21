public class Program {
    public static void main(){
        MusicalInstrument[] instruments = new MusicalInstrument[20];

        for (int i = 0; i < 20; i++){
            instruments[i] = Factory.CreateRandomMusicalInstrument();
        }

        for (MusicalInstrument instrument : instruments) {
            System.out.println(instrument.toString() + " | class - " + instrument.getClass());
        }
    }
}
