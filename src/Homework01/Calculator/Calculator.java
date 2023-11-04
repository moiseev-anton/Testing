package Homework01.Calculator;

public class Calculator {

    // Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) throws ArithmeticException {
        if (purchaseAmount < 0){
            throw new ArithmeticException("Purchase amount must be non-negative");
        }
        if (discountAmount < 0 || discountAmount > 100){
            throw new ArithmeticException("Discount amount must be 0 - 100");
        }
        double discount = purchaseAmount * discountAmount / 100;
        return purchaseAmount - discount;
    }
}