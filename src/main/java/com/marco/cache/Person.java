package com.marco.cache;

public class Person {
    private String name;
    private int age;
    // 构造器
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // 获取名字value
    public String getName() {
        return name;
    }
    // 改名字value
    public void setName(String name) {
        this.name = name;
    }
    // 获取年龄value
    public int getAge() {
        return age;
    }
    // 改年龄value
    public void setAge(int age) {
        this.age = age;
    }
    // 对象转字符串
    public String toString() {
        return "{ " +
                "name: " + name + ", age: " + age +
                " }";
    }


}
