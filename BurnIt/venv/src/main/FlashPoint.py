# 1. inizializza la cella
# 2. update it (controlla prima se x e y sono valide)
# 4. forma smoke controllando il trasforma cella
# 3. trasforma la cella e le celle vicine ( forse due diverse funzioni)
from main.Cell import *

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

        if x > 0  and x < self.height and y > 0  and y < self.width:
            FlashPoint.putSmokeOrFire(self,self.board[x][y],x,y)
            FlashPoint.printBoard(self)
        else:
            print(f"This point ({x},{y}) is invalid ")

    def putSmokeOrFire(self, cellValue,x,y):
        neighbours_symbol = [cell[0] for cell in FlashPoint.neiborhood(self,x,y)]
        if cellValue == 'S':
            self.board[x][y] = 'F'
            FlashPoint.expandFireStoF(self, x,y)
            FlashPoint.expandFire_pipe(self,x,y)
        if cellValue == ' ' and 'F' in neighbours_symbol:
            self.board[x][y] = 'F'
            FlashPoint.expandFireStoF(self, x, y)
            FlashPoint.expandFire_pipe(self, x, y)
        if cellValue == ' ' and 'F' not in neighbours_symbol:
            self.board[x][y] = 'S'
            FlashPoint.expandFire_pipe(self, x, y)


    def expandFireStoF(self,x,y):
        neighbours = FlashPoint.neiborhood(self, x, y)
        for index in range(0, len(neighbours)):
            if 'S' in neighbours[index][0]:
                x = neighbours[index][1]
                y = neighbours[index][2]
                self.board[x][y] = 'F'
                FlashPoint.expandFireStoF(self,x,y)

    def expandFire_pipe(self,x,y):
        cells = FlashPoint.neiborhood(self, x, y)
        cells.append((self.board[x][y],x,y))

        for index in range(0, len(cells)):
            if '_' in cells[index][0]:
                if y > cells[index][2]:
                    self.board[x][cells[index][2] - 1 ] = 'F'
                if y < cells[index][2]:
                    self.board[x][cells[index][2] + 1] = 'F'
            if '|' in cells[index][0]:
                if y > cells[index][2]:
                    self.board[x][cells[index][2] - 1 ] = 'F'
                if y < cells[index][2]:
                    self.board[x][cells[index][2] + 1] = 'F'


    ## return  'F' if cellValue == 'S' else 'S' if cellValue == ' ' else cellValue
    ### here we are missing to considerate if smoke is next to fire and if is next to an open door.

    def neiborhood(self,x,y):
        neighbors = []

        if x > 0:
           # Cell(self.board[x - 1][y], x - 1, y)
            neighbors.append((self.board[x - 1][y], x - 1, y))
        if x < self.height - 1:
            neighbors.append((self.board[x + 1][y], x + 1, y))
        if y > 0:
            neighbors.append((self.board[x][y - 1], x , y - 1))
        if y < self.width - 1:
            neighbors.append((self.board[x][y + 1], x, y + 1))

        return neighbors

    def printBoard(self):

        for x in range(0,self.height):
            print(''.join(self.board[x]))

    def getBoard(self,x,y):
        return self.board[x][y]