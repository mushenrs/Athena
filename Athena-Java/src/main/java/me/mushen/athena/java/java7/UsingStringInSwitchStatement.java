package me.mushen.athena.java.java7;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-24
 */
public class UsingStringInSwitchStatement {
    // switch case语句中可以使用字符串类型
    public static void main(String[] args){
        testStringInSwitch("January");
        testStringInSwitch("February");
        testStringInSwitch("September");
        testStringInSwitch("");
//        testStringInSwitch(null); // java.lang.NullPointerException
    }

    private static void testStringInSwitch(String month){
//        if(month == null || month.length() == 0){
//            System.out.println("month should not be null");
//            return;
//        }
        switch (month){
            case "January":
            case "March" :
            case "May":
            case "July" :
            case "August":
            case "October" :
            case "December":
                System.out.println(month + "has 31 days");
                break;
            case "February":
                System.out.println(month + "has 28 days");
                break;
            case "April":
            case "June":
            case "September":
            case "November":
                System.out.println(month + "has 30 days");
                break;
            default:
                System.out.println("Unknow Month");
        }
    }
}
