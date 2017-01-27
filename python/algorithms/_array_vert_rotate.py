#!/usr/bin/python

a = raw_input("Enter space separated integer array: ").split()
a = map(int, a)

b = []
grp = 1
l = len(a)
while grp < l / 2:
    i, j = 0, l / 2
    while i < l / 2:
        for k in range(0, grp):
            b.append(a[i + k])
        i += grp
        for k in range(0, grp):
            b.append(a[j + k])
        j += grp
    a = b
    b = []
    grp = 2 * grp
print a
