
from itertools import product
from sys import stderr
from main.FlashPoint import *

if __name__ == "__main__":


    input = [
        (1 ,1),
        (2 ,1),
        (3 ,1),
        (6 ,5),
        (2 ,4),
        (1 ,1),
        (2 ,1),
        (5 ,5),
        (5 ,5),
        (1 ,9),
        (5 ,7),
        (2, 2)
    ]

    flashpoint = FlashPoint();
    for x,y in input:
        print(x,y)

        new_board = flashpoint.updateBoard(x,y)
        print(new_board)
