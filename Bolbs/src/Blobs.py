from collections import defaultdict
import math
import os
import time



def get_blobs():
    blobs = []

    sufficient_blobs = False

    while ( not sufficient_blobs ):
        print("How many blobs do you want to insert? ")
        number_of_blobs = int(input())
        i = 0
        if number_of_blobs == 1 or number_of_blobs == 0:
            print("Not enaigh blobs, try another number\n")
        else:
            sufficient_blobs = True

    for i in range(0,number_of_blobs):
        print(f"Insert comma delimited elements of {i + 1} blob")
        #blob = tuple(input())
        blob = tuple(map(int, input().split(',')))
        print(blob)
        blobs.append(blob)
        ++i
    return blobs



def blobs_smaller_than(blob_index, blobs):
    '''given a single blob and a list of other blobs,
     return a list of blobs that are smaller than blob'''
    smaller_blobs =[]

    for j in [x for x in range(0,len(blobs)) if x != blob_index]:

        if blobs[blob_index][2] > blobs[j][2]:
            smaller_blobs.append(j)
    return smaller_blobs

def closest_blob(x1,x2, blobs, index):
    '''given a location and a list of blobs,
    return the blob from the list which is closest to the location'''

    distances = []
    #print(f"Blobs inside closest loop{blobs}")
    if not index:
       # print(f"no smaller blobs available")#no return

        return blobs

    if len(index) == 1:
        #print("just one blob to move towards")
        return blobs[0]
    else:
        # index_closest_blob = []
        for blob in blobs:
            distances.append(euclidian_distance(x1,x2,blob[0], blob[1]))

        closest_blob = blobs[distances.index(min(distances))]

        return closest_blob


def move(blob, x_location,y_location):
    '''given a blob and a location,
    return the blob with the location updated to move a single step towards location'''

    distances = []
    #print(f"Blob {blob} moves towards {x_location} {y_location}")
    x = blob[0]
    y = blob[1]
    possible_locations_to_move = [(x, y + 1),
                                  (x + 1 , y + 1),
                                  (x + 1 , y),
                                  (x + 1, y - 1),
                                  (x, y -1),
                                  (x -1, y -1),
                                  (x -1, y),
                                  (x - 1, y + 1)
                                  ]

    for location in possible_locations_to_move:
        distances.append(euclidian_distance(location[0],location[1], x_location, y_location))
    location_to_move = possible_locations_to_move[distances.index(min(distances))]

    return (location_to_move[0],location_to_move[1], blob[2])


def merge_blobs(blobs):
    '''given list of blobs,
    return the list with all blobs that are in the same location merged together'''
    new_blobs=[]
    blobs_already_merged = []

    for i in range(0, len(blobs)):
        blob_x, blob_y = blobs[i][0] , blobs[i][1]
        for j in range(i + 1, len(blobs)):

            if blob_x == blobs[j][0] and blob_y == blobs[j][1] :
                new_blobs.append((blob_x,blob_y, blobs[i][2] + blobs[j][2]))
                blobs_already_merged.append(i)
                blobs_already_merged.append(j)

        if is_blob_to_add(i, blobs_already_merged):
                 new_blobs.append(blobs[i])

   # print(f"new blobs {new_blobs}")
    return new_blobs

def is_blob_to_add(index, blob_merged):
    ''' given a certain index of the blob that is currently under study and a list of blobs that have been merged'''
   # print(f" blob analized {blob_merged}")
    blob_to_add = True
    for blob_index in blob_merged:
        if blob_index == index:
            blob_to_add = False

    return blob_to_add

def find_hight_and_with_matrix( blobs ):
    ''' given a list of blob find hight and with of the matrix to create'''
    x_max: int = 0
    x_min: int = 0
    y_max: int = 0
    y_min: int = 0

    for blob in blobs:
        print(blob)

        if x_max < blob[0]:
            x_max = blob[0]
            print(x_max)
        if x_min > blob[0]:
            x_min = blob[0]

        if y_max < blob[1]:
            y_max = blob[1]

        if y_min > blob[1]:
            y_min = blob[1]

    print(f"this is x_min:{x_min}\nthis is x_max:{x_max}\nthis is y_min:{y_min}\nthis is y_max:{y_max}\n")
    return x_min,y_min,x_max,y_max

def clear():
    os.system( 'cls' )

def is_blob(i,j,blobs):
    positions = []
    for blob in blobs:
        # print(f"i {i} and j {j}")
        # print()
        # print(blob[0] == i and blob[1] == j)
        if blob[0] == i and blob[1] == j:
            positions.append(blob[2])
    return positions

def display_world(x_min,y_min,x_max,y_max, blobs):
    ''' given a width and height and a list of blobs, draw the world'''
    time.sleep(1.5)
    clear()

    #world = np.zeros(shape=(width + 1, height + 1), dtype= int)
    #
    # for blob in blobs:
    #     world[blob[0], blob[1]] = blob[2]

###finding max
    for i in range(x_min,x_max+1):
        for j in range(y_min,y_max + 1 ):
            blob_value = is_blob(i,j,blobs)
            if blob_value:
                print(blob_value[0],end="  ")
            else:
                print(".", end= " ")
            # print(j)
            # print([x[0] for x in blobs])
            # print([y[1] for y in blobs] == j)
            # for blob in blobs:
            #     print(blob)
            # # print([x[0] for x in blobs] == i and [y[1] for y in blobs] == j)
            # # if False:
            # #     print(blobs[2], end="  ")
            # # else:
            # print(".", end= " ")
        print()
    # #print('\n'.join(' '.join(map(str, x)) for x in world)) ottimo ma  non so come mettere l'if statement

    print()

def euclidian_distance(x1, y1, x2, y2):
    return math.sqrt(math.pow(x1-x2, 2)+ math.pow(y1-y2,2))



if __name__ == '__main__':

    #blobs = [(0, 2, 1), (2, 1, 2)]
    #blobs = get_blobs()
    #blobs = [(4, 3, 4), (4, 6, 2), (8, 3, 2), (2, 1, 3)]
    blobs = [(-5,2,1), (3,0,3),(0,5,4)]
    #blobs = [(-57, -16, 10),(-171, -158, 13),(-84, 245, 15),(-128, -61, 16),(65, 196, 4),(-221, 121, 8),(145, 157, 3),(-27, -75, 5)] ### need to find a way to display this
    #print(blobs)
    number_of_blobs_that_do_not_move: int = 0

    x_min,y_min,x_max,y_max = find_hight_and_with_matrix(blobs)
    print(f"This is the first array of blobs {blobs}")

### finding the correlation between blobs
    while len(blobs) > 1:
    #while number_of_blobs_that_do_not_move  <= len(blobs):

        display_world(x_min,y_min,x_max,y_max, blobs)
        blob_bigger_than_blobs = defaultdict(list)
        for i in range(0, len(blobs)):
            smaller_blobs = blobs_smaller_than(i,blobs)
            blob_bigger_than_blobs[i] = blobs_smaller_than(i,blobs)

    ##finding closest blob by blobs
        blob_moves_towards_blob = defaultdict(list) ###the key will be the blob that needs to move and the value is the one that stays still
        #print(blob_bigger_than_blobs)
        for key, value in list(blob_bigger_than_blobs.items()):
            blob_moves_towards_blob[key] = closest_blob(blobs[key][0], blobs[key][1], [blobs[x] for x in value], value)

    ##moving blob towards the closest one
        new_blobs = []

        for index_still_blob,blob_moves in list(blob_moves_towards_blob.items()):
            if not blob_moves:
                number_of_blobs_that_do_not_move = number_of_blobs_that_do_not_move + 1
                new_blobs.append(blobs[index_still_blob])

            else:

                new_blobs.append(move(blobs[index_still_blob],blob_moves[0],blob_moves[1]))

        blobs = merge_blobs(new_blobs)
    else:
        display_world(x_min,y_min,x_max,y_max, blobs)
        print(f"The program is finished. the last blob is {blobs}")

