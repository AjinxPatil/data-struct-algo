#!/usr/bin/python

import sys

def generate_parentheses(n):
    if n is None:
        return n
    if n is 1:
        return ['()']
    prev = generate_parentheses(n - 1)
    return _add_new_parenthesis(prev)

def _add_new_parenthesis(prev):
    curr1 = ['()' + x for x in prev]
    curr2 = ['(' + x + ')' for x in prev]
    return curr1 + curr2

if __name__ == '__main__':
    lis = generate_parentheses(int(sys.argv[1]))
    for p in lis:
        print p
