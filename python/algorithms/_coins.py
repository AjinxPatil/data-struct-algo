#!/usr/bin/python

import sys

def coins(n):
    np = [1 for x in range(n + 1)]
    dnp = [0 for x in range(n + 1)]
    qdnp = [0 for x in range(n + 1)]
    for i in range(n + 1):
        np[i] += i / 5
        rest = i
        while rest >= 0:
            dnp[i] += np[rest]
            rest -= 10
        rest = i
        while rest >= 0:
            qdnp[i] += dnp[rest]
            rest -= 25
    return qdnp[n]

if __name__ == '__main__':
    print coins(int(sys.argv[1]))
