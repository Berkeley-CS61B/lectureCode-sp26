class Dog {
    int size;

    // this is a constructor which is different
    // from a function, it says how to make a Dog
    // rather than taking some parametres and giving you
    // an object back
    Dog(int s) {
        size = s;
    }

    void grow() {
        size += 1;
    }

    void makeNoise() {
        if (size < 10) {
            IO.println("yip");
        } else if (size < 30) {
            IO.println("bark");
        } else {
            IO.println("arrooooooo!");
        }
    }

    Dog maxDog(Dog otherDog) {
        if (otherDog.size > size) {
            return otherDog;
        }
        return this; // like self in Python
                     // but it's not a parameter of the function
    }

    // a static method is similar to a class method in Python
    // there is no this in a static method
    static Dog maxDog(Dog d1, Dog d2) {
        if (d1.size > d2.size) {
            return d1;
        }
        return d2;
    }
}


