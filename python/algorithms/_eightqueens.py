#!/usr/bin/python

def eightqueens(board, n):
    if n is 8:
        printboard(board)
        return True
    placed = False
    while not placed:
        placed = placequeen(board, n)
        if placed:
            placed = eightqueens(board, n + 1)
        else:
            return False
    return True
# TODO Check Manhattan distance
def placequeen(board, n):
    j = 0
    while j < 8:
        if board[n][j] is 9:
            board[n][j] = 0
            k = n + 1
            d = 1
            while k < 8:
                board[k][j] = 1
                if j - d >= 0:
                    board[k][j - d] = 1
                if j + d < 8:
                    board[k][j + d] = 1
                k += 1
                d += 1
        elif board[n][j] is 1:
            board[n][j] = 9
            break
        j += 1
    if j is 8:
        return False
    n += 1
    d = 1
    while n < 8:
        board[n][j] = 0
        if j - d >= 0:
            board[n][j - d] = 0
        if j + d < 8:
            board[n][j + d] = 0
        n += 1
        d += 1
    return True

def printboard(board):
    print "-----------------------------"
    for i in range(8):
        for j in range(8):
            print str(board[i][j]) + " ",
        print

if __name__ == '__main__':
    board = [[1 for x in range(8)] for x in range(8)]
    eightqueens(board, 0)
