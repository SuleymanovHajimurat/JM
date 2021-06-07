import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorMain { // Основной класс, обеспечивает ввод/вывод
    public static void main(String[] args) throws CalculatorException, IOException {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Введите данные в формате: ЧИСЛО <ОПЕРАТОР> ЧИСЛО.");
        System.out.println("Поддерживаемые операторы: +, -, *, /,");
        System.out.println("Поддерживаемые числа: целые от 1 до 10, либо римские от I до X");
        System.out.println("Примечание: пробелы допустимы, символы римских чисел не чувствительны к регистру");
        System.out.println("-----------------------------------------------------------------------------------");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String operation = reader.readLine();
        String op = operation.replaceAll("\\s", "");// Удаление пробелов для единообразной структуры данных

        Computation computation = new Computation();
        String result = computation.result(op);
        System.out.println("Результат:"+result);

    }

}
