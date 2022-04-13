package cn.tedu.shoot;

public class ddd {
    String name1 = "a";
    String address1 = "shandong";
    int age1 = 3;
    void sayHi(){
        System.out.println("大家好,我叫" + name1 + ",今年" + age1 + "岁了,家住" + address1);
    }

    String name2 = "b";
    String address2 = "hunan";
    int age2 = 4;
    void sayHi2(){
        System.out.println("大家好,我叫" + name2 + ",今年" + age2 + "岁了,家住" + address2);
    }
    String name3 = "c";
    String address3 = "guangxi";
    int age3 = 4;
    void sayHi3(){
        System.out.println("大家好,我叫" + name3 + ",今年" + age3 + "岁了,家住" + address3);
    }


}
class Student{
    String name;
    String address;
    int age;
    void sayHi(){
        System.out.println("大家好,我叫" + name + ",今年" + age + "岁了,家住" + address);
    }
}
class test{
    public static void main(String[] args) {
        Student a1 = new Student();
        a1.name ="a";
        a1.address = "shandong";
        a1.age = 3;
        a1.sayHi();

        Student a2 = new Student();
        a2.name ="a";
        a2.address = "shandong";
        a2.age = 3;
        a2.sayHi();

        Student a3 = new Student();
        a3.name ="a";
        a3.address = "shandong";
        a3.age = 3;
        a3.sayHi();
    }
}
