package homeworks.homework8;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.time.LocalDate.*;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("magazine", 150,true, LocalDate.of(2023,9,27)));
        products.add(new Product("book", 35,false, LocalDate.of(2023,7,11)));
        products.add(new Product("book", 65,false, LocalDate.of(2023,5,8)));
        products.add(new Product("book", 440,true, LocalDate.of(2022,3,7)));
        products.add(new Product("moovie", 270,false, LocalDate.of(2011,3,22)));
        products.add(new Product("book", 285,true, LocalDate.of(2019,6,14)));
        products.add(new Product("book", 185,true, LocalDate.of(2014,2,21)));
        products.add(new Product("book", 415,false, LocalDate.of(2008,6,17)));
        products.add(new Product("magazine", 332,true, LocalDate.of(2023,2,11)));
        products.add(new Product("book", 228,false, LocalDate.of(2003,3,13)));

        System.out.println("--------------------1");
        products.stream()
                .filter(product -> product.price > 250 )
                .filter(product -> Objects.equals(product.type, "book"))
                .forEach(System.out::println);

        System.out.println("--------------------2");
        products.stream()
                .filter(product -> Objects.equals(product.type, "book"))
                .filter(product -> product.discountPossible)
                .map(product -> new Product(product.getType(), (int) (product.getPrice() * 0.9), product.getDiscountPossible(),product.getAdded()))
                .forEach(System.out::println);

        System.out.println("--------------------3");
        products.stream()
                .filter(product -> Objects.equals(product.type, "moovie"))
                .map(product -> product.price)
                .min(Integer::compareTo)
                .ifPresentOrElse(min -> {System.out.println("minimal price is - " + min);},
                        ()-> System.out.println("category not found"));

        System.out.println("--------------------4");
        products.stream()
                .sorted(Comparator.comparing(Product::getAdded).reversed())
                .limit(3)
                .forEach(System.out::println);

        System.out.println("--------------------5");
        double costAll = products.stream()
                .filter(product -> product.price < 75)
                .filter(product -> Objects.equals(product.type, "book"))
                .filter(product -> product.getAdded().getYear() == 2023)
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println(costAll);

        System.out.println("--------------------6");
        Map<String,List<Product>> dictionary = products.stream()
                .collect(Collectors.groupingBy(Product::getType));

        dictionary.forEach((category,byIn)->{
            System.out.println(category + ":");
            byIn.forEach(System.out::println);
        });
    }
}