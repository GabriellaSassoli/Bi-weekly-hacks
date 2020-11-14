# 1. inizializza la cella
# 2. update it (controlla prima se x e y sono valide)
# 4. forma smoke controllando il trasforma cella
# 3. trasforma la cella e le celle vicine ( forse due diverse funzioni)
from Cell import *

class FlashPoint:

    def __init__(self):
        self.board = [list(s) for s in [
            r"#############/#",
            r"#     |       #",
            r"#     #       #",
            r"#     #       #",
            r"#######       #",
            r"#     _       #",
            r"###############"]]

        self.width = len(self.board[0])
        self.height = len(self.board)

    def updateBoard(self, x,y):

        print( x > 0  and x < self.width  and y > 0  and y < self.height)
        if x > 0  and x < self.width and y > 0  and y < self.height:
            FlashPoint.putSmokeOrFire(self,self.board[x][y],x,y)
            FlashPoint.printBoard(self)
        else:
            print(f"This point ({x},{y}) is invalid ")

    def putSmokeOrFire(self, cellValue,x,y):
        if cellValue == 'S':
            self.board[x][y] = 'F'
        # if cellValue == ' ' #and 'F' in FlashPoint.neiborhood(self,x,y):
        #     return 'F'
        if cellValue == ' ': #and 'F' not in FlashPoint.neiborhood(self,x, y):
            self.board[x][y] = 'S'
        
    ## return  'F' if cellValue == 'S' else 'S' if cellValue == ' ' else cellValue
    ### here we are missing to considerate if smoke is next to fire and if is next to an open door.

    def neiborhood(self,x,y):
        neighbors = []

        if x > 0:
            neighbors.append(Cell(self.board[x-1][y], x-1,y))
        if x < self.width - 1:
            neighbors.append(Cell(self.board[x+1][y], x + 1,y))
        if y > 0:
            neighbors.append(Cell(self.board[x][y - 1], x , y-1 ))
        if y > self.height - 1:
            neighbors.append(Cell(self.board[x][y + 1], x, y + 1))

        return neighbors

    def printBoard(self):
        print("print board")
        for x in range(0,self.height):
            #for y in range(0, self.height):
            print(''.join(self.board[x]))
