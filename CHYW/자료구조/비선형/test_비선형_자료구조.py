#pytest
def test_heapq():
    from 힙 import Heapq
    heapq = Heapq()
    heap = []
    heapq.heappush(heap, 5)
    heapq.heappush(heap, 3)
    heapq.heappush(heap, 8)
    heapq.heappush(heap, 1)
    assert heap == [1, 3, 8, 5]
    assert heapq.heappop(heap) == 1
    assert heap == [3, 5, 8]
    heapq.heapify(heap)
    assert heap == [3, 5, 8]
def test_binarysearchtree():
    from 이진탐색트리 import BinarySearchTree
    
    arr = [50,30,24,5,28,45,98,52,60]
    bst = BinarySearchTree(arr[0])
    for i in range(1,len(arr)):
        bst.insert(arr[i])

    assert bst.preorder() == [50, 30, 24, 5, 28, 45, 98, 52, 60]
    assert bst.inorder() == [5, 24, 28, 30, 45, 50, 52, 60, 98]
    assert bst.postorder() == [5, 28, 24, 45, 30, 60, 52, 98, 50]