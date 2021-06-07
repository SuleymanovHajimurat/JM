import java.util.Arrays;
import java.util.List;

public class Computation { // Класс расчета


    public String result(String op) throws  CalculatorException {

        String a; // Операнд первый;  не обеспечивал инкапсуляцию, хотя примерно представляю как это реализуется
        String b; // Операнд второй
        String operator; // Оператор
        double ans = 0;


        // Разделение элементов списка по оператору,
        // при необходимости можно добавить еще операторы соответствующим циклом.
        List<String> lstStr1;

        if (op.contains("+")) {
            lstStr1 = Arrays.asList(op.split("\\+"));
            operator = "+";
        } else if (op.contains("-")) {
            lstStr1 = Arrays.asList(op.split("-"));
            operator = "-";
        } else if (op.contains("*")) {
            lstStr1 = Arrays.asList(op.split("\\*"));
            operator = "*";
        } else if (op.contains("/")) {
            lstStr1 = Arrays.asList(op.split("/"));
            operator = "/";
        } else {
            throw new CalculatorException();
        }

        // Проверка числа элементов списка:
        if (lstStr1.size() != 2 || lstStr1.get(0).isEmpty()) {
            throw new CalculatorException();
        }

        // Ссылки на элементы списка:
        a = lstStr1.get(0);
        b = lstStr1.get(1);

        int ai = 0;
        int bi = 0;

        // Преобразование в целые числа
        boolean flag = false;
        try {
            ai = Integer.parseInt(a);
            bi = Integer.parseInt(b);
        } catch (Exception e) {
            try {
                ai = NumConverter.convertToArabian(a);
                bi = NumConverter.convertToArabian(b);
                flag = true;
            } catch (Exception e1) {
                throw new CalculatorException();
            }
        }
         // Контроль размера чисел
        if (ai < 1 || ai > 10 || bi < 1 || bi > 10) {
            throw new CalculatorException();
        }

        // Вычисления
        double ad = (double) ai; // Возможно, это лишнее, но
                                 // по условию ТЗ (п.3) выходное число может быть любым,
        double bd = (double) bi; // поэтому решил добавить тип double
        switch (operator){
            case "-": ans = ad - bd;
                break;
            case "+": ans = ad + bd;
                break;
            case "*": ans = ad * bd;
                break;
            case "/": ans = ad / bd;
                break;
                default:
        }

        if(flag){
                String ansStr = ConvertBackToRoman.convertBackToRoman((int) ans);
                return ansStr;
            }
        return Double.toString(ans);
    }
}