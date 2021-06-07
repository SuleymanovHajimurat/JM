public class NumConverter { // Класс конвертации типов

    private static int decodeSingle(char letter) {
        switch (letter) {

            case 'X':      // Предельное возможное число по ТЗ, при необходимости числа можно добавить
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }

    // Метод конвертации римских чисел к целочисленному типу.

    public static int convertToArabian(String strRoman) {
        int result = 0;
        String uRoman = strRoman.toUpperCase();
        for (int i = 0; i < uRoman.length() - 1; i++) {
            if (decodeSingle(uRoman.charAt(i)) < decodeSingle(uRoman.charAt(i + 1))) {
                result -= decodeSingle(uRoman.charAt(i));
            } else {
                result += decodeSingle(uRoman.charAt(i));
            }
        }
        result += decodeSingle(uRoman.charAt(uRoman.length() - 1));
        return result;
    }
}

