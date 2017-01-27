#!/usr/bin/python

from binarytree import BinaryTree

contents = raw_input("Binary tree: ").split()
for i in range(len(contents)):
    if contents[i] == 'x':
        contents[i] = None
    else:
        contents[i] = int(contents[i])
print contents
tree = BinaryTree(contents)

def sum_paths(root, path, p_sum, value):
    if root is None:
        return
    p_sum += root.data
    newpath = []
    newpath.extend(path)
    newpath.append(root.data)
    if p_sum == value:
        print newpath, root.data
    else:
        print newpath, root.data, "NO"
    sum_paths(root.left, newpath, p_sum, value)
    sum_paths(root.right, newpath, p_sum, value)
    sum_paths(root.left, [], 0, value)
    sum_paths(root.right, [], 0, value)

_sum = int(raw_input("Enter path sum: "))
sum_paths(tree.root, [], 0, _sum)
