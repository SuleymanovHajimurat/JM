import java.util.TreeMap;

// Видел различные реализации: с помощью классов TreeMap, HashSetMap, Enum и др.
// Поэтому решил отдельно добавить класс ConvertBackToRoman с методом, использующим TreeMap

public class ConvertBackToRoman {

        private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

        static {
            map.put(100, "C"); // Предельное возможное число по ТЗ, при необходимости числа можно добавить
            map.put(90, "XC");
            map.put(50, "L");
            map.put(40, "XL");
            map.put(10, "X");
            map.put(9, "IX");
            map.put(5, "V");
            map.put(4, "IV");
            map.put(1, "I");
        }

    public final static String convertBackToRoman(int numInt) {
        int l =  map.floorKey(numInt);
        if ( numInt == l ) {
            return map.get(numInt);
        }
        return map.get(l) + convertBackToRoman(numInt-l);
    }

}



