class HeapSort:
    def __init__(self):
        pass
    
    def sort(self,arr,reverse=False):
        import heapq
        heap = []

        #max_heap
        if reverse:
            for i in range(len(arr)):
                heapq.heappush(heap,-arr[i])
            return [-heapq.heappop(heap) for _ in range(len(arr))] 
        #min_heap
        else:
            heapq.heapify(arr)

            return [heapq.heappop(arr) for _ in range(len(arr))]
    
    def __repr__(self):
        return '''
                힙정렬 알고리즘
                파이썬 heapq를 사용하여 min_heap, max_heap 구현
                '''