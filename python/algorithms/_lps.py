#!/usr/bin/python

s = raw_input("String:").strip()

def lps(s):
    n = len(s)
    maxx = 1
    start = 0
    cache = [[0] * n] * n
    for i in range(n):
        cache[i][i] = 1
    for i in range(n - 1):
        if s[i] == s[i + 1]:
            cache[i][i + 1] = 1
            start = i
            maxx = 2
    for i in range(3, n + 1):
        for j in range(0, n - i + 1):
            k = j + i - 1
            if s[j] == s[k] and cache[j + 1][k - 1]:
                cache[j][k] = 1
                start = j
                maxx = i
    return maxx

print lps(s)

