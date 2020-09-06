# import numpy as np
# from collections import defaultdict
# from sklearn.metrics.pairwise import euclidean_distances
#
# ###creating the matrix
# blobs = [(0,2,1),(2,1,2), (1, 1, 3)]
# x: int = 0;
# y: int = 0;
#
# for blob in blobs:
#     print(blob)
#     ##finding x I can't always assome that the matrix is a 3x3 matrix i have to get the highest x
#     if x < blob[0]:
#         x = blob[0]
#
#     ##finding y I can't always assome that the matrix is a 3x3 matrix i have to get the highest y
#     if y < blob[1]:
#         y = blob[1]
#
# print(x, y)
#
# ### creating a matrix with all zeros
# a = np.zeros(shape=(x + 1,y  + 1))
# print(a)
#
# for blob in blobs:
#     a[blob[0],blob[1]] = blob[2]
#
# print(a)
#
# ####finding smaller blobs  list of blobs that are smaller than him.
# list_of_smaller_blobs_by_blob = defaultdict(list)
# for i in range(0, len(blobs)):
#     for j in [x for x in range(0,len(blobs)) if x != i]:
#         if blobs[i][2] > blobs[j][2]:
#             list_of_smaller_blobs_by_blob[i].append(j)
#
# print(list_of_smaller_blobs_by_blob)
#
# ###moving blob nearer
# for i in list_of_smaller_blobs_by_blob:
#     print(blobs[i])
#     print(list_of_smaller_blobs_by_blob[i])
#     for index_smaller_blob in list_of_smaller_blobs_by_blob[i]:
#         print(blobs[index_smaller_blob])
#         coordinates_of_blob_that_moves = blobs[i]
#         coordinates_of_blob_that_stays_steal = blobs[index_smaller_blob]
#         position_next_to_the_original_one = [(blobs[i][0], blobs[i][1])]
#         if blobs[i][0] < x and blobs[i][1]< y :
#             print(blob[i])
#
#
#         #euclidean_distances(X, [[0, 0]])
#         ##original_distance =
#             ## to find a way to look into if there's more than one blob that is smaller and then to find out il senso orario e come scegliere quello di senso orario.
#             # How do I say to a blob to get closer? Distanza euclidea sembra la meglio, non ho trovato suggerimenti ma penso che merita calcolare la distanza iniziare.
#             ## poi muovere di uno quello che si deve avvicinare in tutte le direzioni possibili e per ogni direzione calcolare la distanza dal punto di arrivo.
#
#
#         #cazzata scrivere equazione della retta passante per quei punti e poi prendere i due punti sulla retta distanti uno dal punto original e di quelli calcolare distanza euclidea e prendere quello piu vicino.
#
# #print(blobs[0][0])




# import os
# import time
#
# def clear():
#     os.system( 'cls' )
# #clear = lambda: os.system('clear')
# print(" Hello ")
# time.sleep(5)
# clear()
# print("World!")
import sys
input1 = sys.argv[1]
#input1 = input()
print(input1)