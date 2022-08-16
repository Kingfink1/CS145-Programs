# Walter Hathaway
# 8/3/22
# Lab 5: Towers of Hanoi
# CS 145
# This program will solve the Towers of Hanoi puzzle using recursion

def TowersOfHanoi(n , A, B, C):
    # If there is only one disk present then it moves it to the final destination
    if n==1:
        print("Disk 1 from",A,"to",B)
        return
    # moves remaining n-1 disks to the middle post
    TowersOfHanoi(n-1, A, C, B)
    print("Disk",n,"from",A,"to",B)
    # moves disk from destination to middle then initial post
    TowersOfHanoi(n-1, C, B, A)

TowersOfHanoi(4,'A','B','C')
