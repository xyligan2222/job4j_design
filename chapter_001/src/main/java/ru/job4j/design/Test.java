package ru.job4j.design;

import ru.job4j.design.collection.SimpleArray;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {

        int first = 0b101;
        int second = 0b10;
        Type[] interfaces = SimpleArray.class.getGenericInterfaces();
        //Type[] gTypes = ((ParameterizedType) type).getActualTypeArguments();
       // SimpleArray<String> test = new SimpleArray<>();
        for (Type type : interfaces) {
            Type[] gTypes = ((ParameterizedType) type).getActualTypeArguments();
            for (Type gType : gTypes) {
                System.out.println("Generic type:" + gType.toString());
            }
        }




        System.out.println(first % second);

        System.out.println(Short.hashCode((short) 21));
    }
}
