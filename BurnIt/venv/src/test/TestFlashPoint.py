from main.FlashPoint import *

import unittest

class TestCellClass(unittest.TestCase):

    def test_update_board_not_equal(self):
        ##case
        flashpoint = FlashPoint()

        ##
        x = 4
        y = 1
        flashpoint.updateBoard(x,y)

        #then
        self.assertNotEqual(flashpoint.getBoard(x,y), 'S')

    def test_update_board_equal(self):
        ##case
        flashpoint = FlashPoint()

        ##
        x = 3
        y = 1
        flashpoint.updateBoard(x, y)

        # then
        self.assertEqual(flashpoint.getBoard(x, y), 'S')

    def test_update_board_equal_fire(self):
        ##case
        flashpoint = FlashPoint()

        ##
        x = 3
        y = 1
        flashpoint.updateBoard(x, y)
        flashpoint.updateBoard(x, y)

        # then
        self.assertEqual(flashpoint.getBoard(x, y), 'F')

    def test_update_board_X_bigger(self):
        ##case
        flashpoint = FlashPoint()

        ##
        x = 20
        y = 1
        update = flashpoint.updateBoard(x, y)

        # then
        self.assertEqual(update, None)
        ##self.assertRaises("list index out of range")

    def test_update_board_Y_bigger(self):
        ##case
        flashpoint = FlashPoint()

        ##
        x = 1
        y = 20
        update = flashpoint.updateBoard(x, y)

        # then
        self.assertEqual(update, None)

    def test_update_board_equal_fire(self):
        ##case
        flashpoint = FlashPoint()

        ##
        x = 2
        y = 1
        flashpoint.updateBoard(x + 1, y)
        flashpoint.updateBoard(x + 1, y)
        flashpoint.updateBoard(x, y)

        # then
        self.assertEqual('F', flashpoint.getBoard(x, y))


    def test_fire_through_wall(self):
        ##case
        flashpoint = FlashPoint()

        ##
        x = 5
        y = 5
        flashpoint.updateBoard(x, y)
        flashpoint.updateBoard(x, y)
        flashpoint.updateBoard(x, y + 2)

        # then
        self.assertEqual('F', flashpoint.getBoard(x, y + 2))

    def test_fire_through_wall(self):
        ##case
        flashpoint = FlashPoint()

        ##when
        x = 1
        y = 5
        flashpoint.updateBoard(x, y)
        flashpoint.updateBoard(x, y)
        flashpoint.updateBoard(x, y + 2)

        # then
        self.assertEqual('F', flashpoint.getBoard(x, y + 2))

if __name__ == '__main__':
    unittest.main()