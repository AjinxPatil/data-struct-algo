#!/usr/bin/python

a = raw_input("Array: ").split()
a = map(int, a)
small = a[0]
diff = 0
for i in range(len(a)):
    if a[i] > small and a[i] - small > diff:
        diff = a[i] - small
    elif a[i] < small:
        small = a[i]
print "Max Forward Diff:", diff
