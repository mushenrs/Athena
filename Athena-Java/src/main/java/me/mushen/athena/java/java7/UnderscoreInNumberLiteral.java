package me.mushen.athena.java.java7;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-24
 */
public class UnderscoreInNumberLiteral {
    // 使用下划线来操作数字字面量, 是的数字更容易阅读
    // 下划线不能放在整数的开头和结尾
    // 下划线不能放在浮点数的小数点前面
    // 下划线不能放在表示数字是Long或者Float的结尾标识符前面
    public static void main(String[] args){
        int intValue1 = 1_000_100;
        int intValue2 = 1__000_100;
//        int notValidIntValue1 = _100;
//        int notValidIntValue2 = 100_;
        System.out.println("intValue1: " + intValue1 + "\tintValue2: " + intValue2);
        long longValue = 1_000_000_000_000L;
//        long notValidLongValue = 1_000_000_000_000_L;
        System.out.println("longValue: " + longValue);
        double doubleValue1 = 1_000_000_000.0;
        double doubleValue2 = 2___3;
//        double notValidDoubleValue1 = 100_.0;
//        float notValidDoubleValue2 = 100.0_F;
        System.out.println("doubleValue1: " + doubleValue1 + "\tdoubleValue2: " + doubleValue2);
    }
}
