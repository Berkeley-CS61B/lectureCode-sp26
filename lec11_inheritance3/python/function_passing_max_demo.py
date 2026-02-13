def get_the_max(x, key):
    max_value = x[0]
    for item in x:
        if key(item) > key(max_value):
            max_value = item
    return max_value

def length_of_name(dog):
    return len(dog.name)

class Dog:
    def __init__(self, name, size):
        self.name = name
        self.size = size
    
    def __gt__(self, other):
        return self.size > other.size


def length_of_name(dog):
    return len(dog.name)

dogs = [Dog("Grigometh", 10), 
                Dog("Pelusa", 5), 
                Dog("Clifford", 9000)]

max_dog = get_the_max(dogs, length_of_name)


print(f"The max dog is: {max_dog}")