##case/when/then


from main.Cell import *

import unittest

class TestCellClass(unittest.TestCase):

    def test_Cell(self):
        ##case when
        cell = Cell('#',1,1)
        symbol = cell.getSymbol()
        x = cell.getX()
        y = cell.getY()
        #print(x)
        #then
        self.assertEqual(symbol, '#')
        self.assertEqual(x,1)
        self.assertEqual(y, 1)

    def test_wrong_input(self):
        ##case when
        cell = Cell(1,'#',3)
        symbol = cell.getSymbol()
        x = cell.getX()
        y = cell.getY()

        #then
        self.assertEqual(symbol, 1)
        self.assertEqual(x,'#')
        self.assertEqual(y, 3)

if __name__ == '__main__':
    unittest.main()
