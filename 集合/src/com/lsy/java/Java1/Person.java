package com.lsy.java.Java1;

/**
 * @author lsy
 * @Data 2022/6/1620:58
 * @Vervion
 */
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }

        Person person = (Person) o;

        if (age != person.age) {
            return false;
        }
        return name != null ? name.equals(person.name) : person.name == null;
    }

//    @Override
//    public int hashCode() {
//        int result = name != null ?  name.hashCode() : 0;
//        result = 31 * result + age;
//        return result;
//    }
}
