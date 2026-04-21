public final class Services {
    private Services() { }
    public static Result<Guitar> findFirstGuitarWithMaxStrings(MusicalInstrument[] instruments){
        int max = 0;
        Guitar result = null;

        for (var instrument : instruments) {
            if (!(instrument instanceof Guitar)){
                continue;
            }

            var guitar = (Guitar)instrument;

            if (guitar.getStringsCount() > max) {
                result = guitar;
                max = guitar.getStringsCount();
            }
        }

        if (result != null){
            return new Result<Guitar>(true, result, null);
        }
        else{
            return new Result<Guitar>(false, null, "Такая гитара не найдена (все гитары с 0 струнами или гитары отсутствуют)");
        }
    }

    public static Result<Double> getAverageStringsCount(MusicalInstrument[] instruments){
        int sum = 0;
        int instrumentCount = 0;

        for (var instrument : instruments){
            if (!(instrument instanceof Guitar)){
                continue;
            }

            var guitar = (Guitar)instrument;

            sum += guitar.getStringsCount();
            instrumentCount++;
        }

        if (instrumentCount == 0){
            return new Result<Double>(false, null, "Количество гитар в массиве - 0");
        }
        else{
            return new Result<Double>(true, (double)sum / instrumentCount, null);
        }
    }

    public static Result<Integer> getMaxKeysCountOctave(MusicalInstrument[] instruments){
        int max = 0;
        Piano result = null;

        for(var instrument : instruments){
            if (!(instrument instanceof Piano)){
                continue;
            }

            var piano = (Piano)instrument;

            if (piano.getKeyLayout() != KeyLayout.OCTAVE){
                continue;
            }

            if (piano.getKeysCount() > max){
                result = piano;
                max = piano.getKeysCount();
            }
        }

        if (result == null){
            return new Result<Integer>(false, null, "Такое фортепиано не найдено (везде либо 0 клавиш, либо фортепиано в массиве отсутствуют)");
        } else {
            return new Result<Integer>(true, max, null);
        }
    }
}
