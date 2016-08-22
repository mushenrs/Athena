package me.mushen.athena.test;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-21
 */
public class PersonExample {

    public static void main(String[] args){
        // 对类进行实例化,获得一个对象
        Person person = new Person();
        // 名字叫“Robb”
        person.name = "Robb";
        // 年龄是28岁
        person.age = 28;
        // 性别是男(用字符M表示)
        person.sex = 'M';
    }
}

class Person {
    // 姓名
    String name;
    // 年龄
    int age;
    // 性别
    char sex;
}
