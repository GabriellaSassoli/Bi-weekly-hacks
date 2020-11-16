class Cell:
    def __init__(self, symbol, x, y):
        self.x = x
        self.y = y
        self.symbol = symbol
        print(self.symbol,self.x,self.y)

    def getSymbol(self):

        return self.symbol

    def getX(self):

        return self.x

    def getY(self):

        return self.y

    ###note there's no type checking