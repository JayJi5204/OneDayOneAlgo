class SelectionSort:
    def __init__(self):
        pass

    def sort(self, arr):
        '''
        선택정렬 구현
        선택된 값과 나머지 데이터중에 비교하여 알맞은 자리를 찾는 알고리즘
        안정성은 보장되지 않는다.
        '''
        n = len(arr)
        for i in range(n):
            min_idx = i
            for j in range(i + 1, n):
                if arr[j] < arr[min_idx]:
                    min_idx = j
            arr[i], arr[min_idx] = arr[min_idx], arr[i]
        return arr