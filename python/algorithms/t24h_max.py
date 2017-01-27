#!/usr/bin/python

# t24h_max finds for given 4 integers, the maximum possible time in 24-hour format
# that can be constructed from the given integers.
# Author: Ajinkya Patil

# 24-hour format = <H1><H2>:<M1><M2>
# Positions in format
H1 = 1
H2 = 2
M1 = 3
M2 = 4

def give_best(nums, limit):
    # gives the best match for given limit

    x = 0           # best match variable
    i, used = 0, 0  # used is index of the number in nums that is best match
    while i < 4:
        if nums[i] > x and nums[i] <= limit:
            x = nums[i]
            used = i
        i += 1
    if x != 0:
        nums[used] = 0  # best match found, zero the number in nums
    return x

def pos_lim(pos, h1=0):
    # finds the max number the position pos in 24-hour format can hold

    if pos == H1: return 2
    if pos == H2: 
        if h1 < 2: return 9 # H2 is dependent on value of H1
        return 3
    if pos == M1: return 5
    if pos == M2: return 9

def construct(h1, h2, m1, m2):
    nums = [h1, h2, m1, m2]
    try:
        nums = map(int, nums)
        h1 = give_best(nums, pos_lim(H1))
        h2 = give_best(nums, pos_lim(H2, h1))
        m1 = give_best(nums, pos_lim(M1))
        m2 = give_best(nums, pos_lim(M2))
        t = [h1, h2, m1, m2]
        t = map(str, t)
        return t[0] + t[1] + ":" + t[2] + t[3]
    except ValueError:
        print "ERROR: Inputs must be integers."

if __name__ == '__main__':
    nums= map(int, raw_input("Enter 4 digits separated by space: ").split(' '))
    print construct(nums[0], nums[1], nums[2], nums[3])
