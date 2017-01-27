#!usr/bin/python

def quicksort(arr, start, end):
  if start < end:
    pivot_index = partition(arr, start, end)
    quicksort(arr, start, pivot_index - 1)
    quicksort(arr, pivot_index + 1, end)
    
def partition(arr, start, end):
  pivot_index = median(arr, start, end)
  pivot = arr[pivot_index]
  left, right = start, end
  if pivot_index == end:
    left, right = start, end - 1
  elif pivot_index == start:
    left, right = start + 1, end
  while left < right:
    while arr[left] <= pivot and left < end:
      left += 1
    while arr[right] > pivot and right > start or right == pivot_index:
      right -= 1
    if left < right:
      swap(arr, left, right)
      left += 1
      right -= 1
    if left == right:
      break
    print arr, 'left', left, 'right', right
  if pivot_index == start:
    swap(arr, pivot_index, right)
    return right
  if pivot_index == end:
    swap(arr, pivot_index, left)
    return left
  if left < pivot_index:
    swap(arr, left, pivot_index)
    return left
  swap(arr, right, pivot_index)
  return right

def median(arr, start, end):
  mid = (start + end) / 2
  if arr[start] > arr[end]:
    if arr[start] < arr[mid]:
      return start
    if arr[end] > arr[mid]:
      return end
    return mid
  if arr[end] < arr[mid]:
    return end
  if arr[start] > arr[mid]:
    return start
  return mid
      
def swap(arr, x, y):
  temp = arr[x]
  arr[x] = arr[y]
  arr[y] = temp
        
if __name__ == '__main__':
  arr = map(int, raw_input().strip().split(' '))
  quicksort(arr, 0, len(arr) - 1)
  print arr
