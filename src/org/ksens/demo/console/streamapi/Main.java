package org.ksens.demo.console.streamapi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        StringBuilder input = new StringBuilder();
        System.out.println("Count positive numbers: "+ Stream.of(2, 3, 0, -1, 3).filter(x -> x>0).count());
        System.out.println("Count negative numbers: "+ Stream.of(2, 3, 0, -1, 3).filter(x -> x<0).count());
        System.out.println("Count numbers with two digits: "+ Stream.of(22, 13, 0, -1, 3).filter(x -> Math.abs(x)>9 && Math.abs(x)<100).count());
        System.out.println("Count mirror numbers: "+ Stream.of(212, 13, 20, -31, 333).filter(x -> x.toString().equals(new StringBuilder().append(x).reverse().toString())).count());

        Map<String, String> map = new HashMap<>();
        map.put("Молоко", "Йогурт");
        map.put("Овощи", "Помидоры");
        map.put("Фрукты", "Папая");
        map.put("Напитки", "Чай");

        map.forEach((k,v) -> System.out.println("Key: "+k + " Value: "+ v));
        map.entrySet().stream().filter(x-> x.getValue().length()<5).forEach(x-> System.out.println("Less 5 symbols: " + x.getValue()));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input product title:");
        String title = scanner.nextLine();
        System.out.println("Count products "+map.entrySet().stream().filter(x-> x.getValue().equals(title)).count());
        System.out.println("Input first letter of product:");
        String letter = scanner.nextLine();
        map.entrySet().stream().filter(x -> x.getValue().charAt(0) == letter.charAt(0)).forEach(x-> System.out.println("This products: "+ x.getValue()));
        map.entrySet().stream().filter(x -> x.getKey().equals("Молоко")).forEach(x-> System.out.println("Category Молоко product: "+ x.getValue()));
    }
}
