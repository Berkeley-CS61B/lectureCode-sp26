void main() {
    Dog lildog = new Dog(5);
    Dog clifford = new Dog(1000);

    Dog bigger = Dog.maxDog(clifford, lildog);
    bigger.makeNoise();
}