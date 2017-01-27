#!/usr/bin/python

from python.datastructures import binarytree as bt

def lca(root, node1, node2):
    if root is None:
        return -1
    ancestor = -1
    if root.data == node1:
        ancestor = node1
    elif root.data == node2:
        ancestor = node2
    left_result = lca(root.left, node1, node2)
    right_result = lca(root.right, node1, node2)
    if ancestor == -1:
        if left_result != -1 and right_result != -1:
            ancestor = root.data
        elif left_result != -1:
            ancestor = left_result
        else:
            ancestor = right_result
    return ancestor

tree = bt.BinaryTree(bt.binary_tree_input())
nodes = map(int, raw_input("The two nodes: ").split())
print lca(tree.root, nodes[0], nodes[1])

