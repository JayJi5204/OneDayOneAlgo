def _siftup(heap, pos):
    endpos = len(heap)
    startpos = pos
    newitem = heap[pos]
    # Bubble up the smaller child until hitting a leaf.
    leftpos = 2*pos + 1    # leftmost child position
    while leftpos < endpos:
        # Set childpos to index of smaller child.
        rightpos = leftpos + 1
        if rightpos < endpos and not heap[leftpos] < heap[rightpos]:
            leftpos = rightpos
        # Move the smaller child up.
        heap[pos] = heap[leftpos]
        pos = leftpos
        leftpos = 2*pos + 1
    #The leaf at pos is empty now. Put newitem there, and bubble it up
    #to its final resting place (by sifting its parents down).
    heap[pos] = newitem
    _siftdown(heap,startpos,pos)

def _siftdown(heap, startpos, pos):
    newitem = heap[pos]
    #Follow the path to the root, moving parents down until finding a place
    #newitem fits.
    while pos > startpos:
        parentpos = (pos -1) >> 1
        parent = heap[parentpos]
        if newitem < parent:
            heap[pos] = parent
            pos = parentpos
            continue
        break
    heap[pos] = newitem

class Heapq:
    def __init__(self):
        pass

    @staticmethod
    def heappush(heap, item):
        """Push item onto heap, maintaining the heap invariant."""
        heap.append(item)
        _siftdown(heap, 0, len(heap)-1)

    @staticmethod
    def heappop(heap):
        """Pop the smallest item off the heap, maintaining the heap invariant."""
        lastelt = heap.pop() # raises appropriate IndexError if heap is empty
        if heap:
            returnitem = heap[0]
            heap[0] = lastelt
            _siftup(heap,0)
            return returnitem
        return lastelt

    @staticmethod
    def heapify(x):
        """Transform list into a heap, in-place, in O(len(x)) time."""
        n = len(x)
        #Transform bottom-up. the largest index there's any point to looking at
        #is the largest with a child index in-range, so must have 2*i + 1 < n
        #or i < (n-1)/2. if n is even = 2*j, this is (2*j-1)/2 = j-1/2 so
        #j-1 is the larges, which is n//2 - 1. If n is odd = 2*j+1, this is
        #(2*j+1-1)/2 = j so j-1 is the largest, and that's again n//2 -1.
        for i in reversed(range(n//2)):
            _siftup(x,i)
    
    def __repr__(self):
        return '''
                파이썬 표준 라이브러리 heapq 모듈
                최소 힙(min heap) 구현

                                            0

                            1                                 2

                    3               4                5               6

                7       8       9       10      11      12      13      14

                15 16   17 18   19 20   21 22   23 24   25 26   27 28   29 30

                완전 이진 트리(Complete Binary Tree)
                - 마지막 레벨을 제외한 모든 레벨이 완전히 채워져 있고, 마지막 레벨은 왼쪽부터 채워져 있는 트리
                - 배열로 쉽게 표현 가능
                힙(Heap)
                - 완전 이진 트리의 일종
                - 부모 노드가 자식 노드보다 항상 크거나(최대 힙) 작음(최소 힙)
                - 우선순위 큐(Priority Queue)라고 불리기도 함

                주요 연산
                - heappush(heap, item): 힙에 새로운 아이템 추가
                - heappop(heap): 힙에서 가장 작은 아이템 제거 및 반환
                - heapify(x): 리스트 x를 힙으로 변환
                시간 복잡도: O(log n) (삽입 및 삭제), O(n) (힙 변환)
                활용 예시
                - 작업 스케줄링
                - 다익스트라 최단 경로 알고리즘         
                '''