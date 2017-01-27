#!/usr/bin/python

class Node():
    '''Node is an element of Binary Tree'''
    def __init__(self, value):
        self.data = value
        self.left = None
        self.right = None

class BinaryTree():
    '''Binary Tree is constructed through level-order traversal of array of items. The array must have a NoneType object
    for null nodes.'''
    def __init__(self, array):
        self.root = Node(array[0])
        n = len(array)
        i = 1
        node = self.root
        queue = [node]
        while i < n:
            node = queue.pop(0)
            node.left = Node(array[i]) if array[i] is not None else None
            i += 1
            if node.left is not None:
                queue.append(node.left)
            if i < n:
                node.right = Node(array[i]) if array[i] is not None else None
                i += 1
                if node.right is not None:
                    queue.append(node.right)

def binary_tree_input():
    print "Tree array ('x' for null node):",
    array = raw_input().split()
    return [int(x) if x != 'x' else None for x in array]


