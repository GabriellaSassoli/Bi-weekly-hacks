
import src.Blobs as bl
import unittest

blobs = [(0, 2, 1), (2, 1, 2)]

class TestController(unittest.TestCase):

    def test_blob_small_than(self):
        self.assertEqual([0],bl.blobs_smaller_than(1, blobs))

    def test_closest_blob(self):
        self.assertEqual((0, 2, 1), bl.closest_blob(blobs[0][0],blobs[0][1], blobs,[0]))

    def test_move(self):
        self.assertEqual((1,2,2), bl.move((2, 1, 2), 0,2))

    def test_merge_blobs(self):
        self.assertEqual(blobs, bl.merge_blobs(blobs))

    def test_find_highgt_and_with_matrix(self):
        self.assertEqual(2,2, bl.find_hight_and_with_matrix(blobs))

    def test_euclidian_distance(self):
        self.assertEqual(1, bl.euclidian_distance(0,0,1,0))

        
if __name__ == '__main__':
    unittest.main()