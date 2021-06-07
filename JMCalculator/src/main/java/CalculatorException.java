public class CalculatorException extends Throwable {
    public CalculatorException() {
        System.out.println("Неверный формат ввода");
    }

    public CalculatorException(String error){
        this();
        System.out.println(error);
    }
}
