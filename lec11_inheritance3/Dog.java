package lec11_inheritance3;

import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    public String name;
    public int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    // this is a cousin of __gt__ in Python
    public int compareTo(Dog uddaDog) {
        return this.size - uddaDog.size;
    }

    // because this class is non-static, we have to have an actual dog to make one of these things
    // this is just like an SLList, there needs to be an actual SLList for a Node to be created
    //
     // as our last annoying Java syntax of our class, if we make this class static
    // it can be created independently of any specific Dog
    private static class NameComparator implements Comparator<Dog> {
        public int compare(Dog d1, Dog d2) {
//            return a positive number if d1 is lexicographically later;
            return d1.name.compareTo(d2.name);
        }
    }

    public static final Comparator<Dog> NAME_COMPARATOR = new NameComparator();

}