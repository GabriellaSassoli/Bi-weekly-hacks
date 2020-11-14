
from itertools import product
from sys import stderr
from FlashPoint import *

if __name__ == "__main__":

    input = [
        (1,1),
        (2,1),
        (3,1),
        (4,1),
        (2,2),
        (2,3),
        (2,3),
        (2,1)
    ]

    flashpoint = FlashPoint();
    print([(x,y) for x,y in input])
    for x,y in input:
        print(x,y)

        new_board = flashpoint.updateBoard(x,y)
        print(new_board)
