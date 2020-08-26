from collections import defaultdict
import math


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

    if not index:
        print(f"no smaller blobs available")#no return

        return index

    if len(index) == 1:
        print("just one blob to move towards")
        return index
        ##blob_by_distance_to_location = {}
    else:
        index_closest_blob = []
        for blob_index in index:
            distances.append(euclidian_distance(x1,x2,blobs[blob_index][0], blobs[blob_index][1]))

        index_closest_blob.append(distances.index(min(distances)))
        print(f"The closest blob is number {distances.index(min(distances))} of the array")
        return index_closest_blob
          #  print(distances.index(min(distances)))
        #return index_closest_blob

    return index_closest_blob

def move(blob, blob_index, x_location,y_location):
    '''given a blob and a location,
    return the blob with the location updated to move a single step towards location'''

    distances = []
    print(f"Blob {blob} moves towards {x_location} {y_location}")
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
    ### Should I do a test to check that the possible location don't go out of the matrix?

    #print(possible_locations_to_move)
    for location in possible_locations_to_move:
        distances.append(euclidian_distance(location[0],location[1], x_location, y_location))
    location_to_move = possible_locations_to_move[distances.index(min(distances))]
    #print(f"location to move {blobs}")
    #print(blobs)
    #print()

    #blobs[blob_index] = (location_to_move[0],location_to_move[1], blob[2])

    # print(blobs)
    # print(blobs[blob_index])
    #### work on how to move blob
    #blobs[blob_index] = (possible_locations_to_move[distances.index(min(distances))], blob[2])
    # print(blobs)
    return (location_to_move[0],location_to_move[1], blob[2])
        #print("The location is " + str(location))

def merge_blobs(blobs):
    '''given list of blobs,
    return the list with all blobs that are in the same location merged together'''
    new_blobs=[]
    blobs_already_merged = []
    blob_duplicated = 0
    #print("into merge blobs")
    for i in range(0, len(blobs)): # blob in blobs:
        blob_x, blob_y = blobs[i][0] , blobs[i][1]
        #print(f"this is the blob {blobs[i]}, this is the blob_x {blob_x} and this is blob_y {blob_y}")
        for j in range(i + 1, len(blobs)):
            #print(j)
            #print(f"Inside he second loop. This is the second blob_x {blobs[j][0]} and this is the second blob_y {blobs[j][1]}")

            if blob_x == blobs[j][0] and blob_y == blobs[j][1] :
                #print("Inside the loop")
                new_blobs.append((blob_x,blob_y, blobs[i][2] + blobs[j][2]))
                blobs_already_merged.append(i)
                blobs_already_merged.append(j)

        if is_blob_to_add(i, blobs_already_merged):
                 new_blobs.append(blobs[i])

    print(f"new blobs {new_blobs}")
    return new_blobs

def is_blob_to_add(index, blob_merged):
    ''' given a certain index of the blob that is currently under study and a list of blobs that have been merged'''
    print(f" blob analized {blob_merged}")
    blob_to_add = True
    for blob_index in blob_merged:
        if blob_index == index:
            blob_to_add = False

    return blob_to_add

def display_world(width, height, blobs):
    ''' given a width and height and a list of blobs, draw the world'''

def euclidian_distance(x1, y1, x2, y2):
    return math.sqrt(math.pow(x1-x2, 2)+ math.pow(y1-y2,2))

# def min_element_of_list(list):
#     print("In min element def")
#     print(list)
#     print(list[0])


    # min_ele = list[0]
    # for i in range(1, len(list)):
    #     if list[i] < min_ele:
    #         min_ele = list[i]
    # return min_ele


if __name__ == '__main__':
    blobs = [(0, 2, 1), (2, 1, 2), (1, 1, 3)]
    x: int = 0;
    y: int = 0;
    number_of_blobs_that_do_not_move: int = 0

    print(f"This is the first array of blobs {blobs}")

### finding the correlation between blobs
    while number_of_blobs_that_do_not_move  != len(blobs) :
    #for i in range(0,5):
        blob_bigger_than_blobs = defaultdict(list)
        for i in range(0, len(blobs)):
            smaller_blobs = blobs_smaller_than(i,blobs)
            blob_bigger_than_blobs[i] = blobs_smaller_than(i,blobs)
        #print(blob_bigger_than_blobs)

    ##finding closest blob by blobs
        blob_moves_towards_blob = defaultdict(list) ###the key will be the blob that needs to move and the value is the one that stays still
        for key, value in list(blob_bigger_than_blobs.items()):
            #print( key, value )

           # print(closest_blob(blobs[key][0], blobs[key][1], [blobs[x] for x in value], value))
            print(f"Analyzing blob {key}")
            blob_moves_towards_blob[key] = closest_blob(blobs[key][0], blobs[key][1], [blobs[x] for x in value], value)

        print("The key is the blob that we are considering and the value is the closest blob")
        print(blob_moves_towards_blob)
        #closest_blob(location, blob)

    ##moving blob towards the closest one
        new_blobs = []

        for key,value in list(blob_moves_towards_blob.items()):
            #print(key,value)
            if not value:
                print(f"the blob {key} doesn't have to move")
                number_of_blobs_that_do_not_move = number_of_blobs_that_do_not_move + 1
                new_blobs.append(blobs[key])

            else:
                index_blob_staying_still = value[0]

                new_blobs.append(move(blobs[key], key, blobs[index_blob_staying_still][0],blobs[index_blob_staying_still][1]))
        print(f"This are the old blobs {blobs}")
        print(f"THis are the new blobs {new_blobs}")

        blobs = merge_blobs(new_blobs)

        print(f"Merged blobs {blobs}")
    else:
        print(f"The program is finished. the last blob is {blobs}")

        #
        # blobs = new_blobs
        # print(f"This is the new blob {blobs}")
        # for j in [x for x in range(0, len(blobs)) if x != blob_index]:
