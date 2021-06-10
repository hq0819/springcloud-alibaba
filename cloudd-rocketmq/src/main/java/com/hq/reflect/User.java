package com.hq.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class User {
    @AnnotationTest(name="hq")
    String name;
    @AnnotationTest(age = 20)
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    private User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        Class<User> c = User.class;
        User user01 = c.newInstance();
        Constructor<User> declaredConstructor = c.getDeclaredConstructor(String.class, int.class);
        User zs = declaredConstructor.newInstance("zs", 1234);
        Field[] declaredFields = c.getDeclaredFields();
        for (Field f : declaredFields){
            AnnotationTest annotation = f.getAnnotation(AnnotationTest.class);
            System.out.println(annotation.age());


        }

        Annotation[] declaredAnnotations = c.getDeclaredAnnotations();
        for (Annotation a: declaredAnnotations) {

        }
    }
}
