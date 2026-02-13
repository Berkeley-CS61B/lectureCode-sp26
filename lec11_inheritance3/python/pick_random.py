import random

def pick_random(list):
   index = random.randint(0, len(list) - 1)
   return list[index]

x = [1, 2, 3, 4, 5]
print(pick_random(x))
