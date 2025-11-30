import heapq

def solution(operations):
    '''
    이중 우선순위 큐
    명령어에 따라 최댓값과 최솟값을 삭제하는 문제
    주어진 명령어는 백만이기 때문에 O(n) 또는 O(nlogn)로 접근해야 한다.

    반복문을 돌면서 숫자가 정렬되어 있다면 그것이 최선이므로

    heap 자료구조를 사용한다.
    최댓값과 최솟값을 동시에 구해야하므로 min_heap과 max_heap 두개를 사용한다.
    두개의 큐는 항상 같은 원소를 가지도록 유지해야 하나의 큐처럼 동작할 수 있다. 
    
    따라서, 삭제 연산이 들어올 때마다 반대 큐에서도 해당 원소를 삭제해준다.
    '''
    max_heap = []
    min_heap = []
    for operation in operations:
        if max_heap and operation =='D 1': #최댓값 삭제
            max_value = -heapq.heappop(max_heap)
            # print("max",max_value)
            min_heap.remove(max_value)
        elif min_heap and operation =='D -1': #최솟값 삭제
            min_value = heapq.heappop(min_heap)
            # print("min",min_value)
            max_heap.remove(-min_value)
        elif operation[0] == 'I':
            cmd,number = operation.split()
            heapq.heappush(max_heap,-int(number))
            heapq.heappush(min_heap,int(number))
            
    return [-heapq.heappop(max_heap),heapq.heappop(min_heap)] if max_heap and min_heap else [0,0]