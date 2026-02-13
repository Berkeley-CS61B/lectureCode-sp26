def get_the_max(x):
    max_value = x[0]
    for item in x:
        if item > max_value:
            max_value = item
    return max_value

class Dog:
    def __init__(self, name, size):
        self.name = name
        self.size = size
    
    def __gt__(self, other):
        return self.size > other.size

max_value = get_the_max([1, 2, 3, 4, 5])


list_of_dogs = [Dog("Grigometh", 10), 
                Dog("Pelusa", 5), 
                Dog("Clifford", 9000)]

max_dog = get_the_max(list_of_dogs)



print(f"The max dog is: {max_dog}")