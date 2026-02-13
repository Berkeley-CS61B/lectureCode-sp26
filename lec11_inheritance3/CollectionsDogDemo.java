package lec11_inheritance3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDogDemo {
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();

        dogs.add(new Dog("Grigometh", 200));
        dogs.add(new Dog("Pelusa", 5));
        dogs.add(new Dog("Clifford", 9000));

        // operator overloading in Java does not exist


        Dog maxDog = Collections.max(dogs);

        Dog maxByName = Collections.max(dogs, Dog.NAME_COMPARATOR);

        // Not in scope for 61B but you can also use a lambda
        // expression in Java to define a Comparator rather than a 
        // separate class. Lambdas in Java are done using ->
        // 
        // Comparator<Dog> dc = (d1, d2) -> d1.name.compareTo(d2.name);

    }
}