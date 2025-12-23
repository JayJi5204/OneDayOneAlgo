class QuickSort:
    '''
    Docstring for QuickSort

    하나의 리스트를 피벗(pivot)을 기준으로 두 개의 비균등한 크기로 분할하고 분할된 부분 리스트를 정렬한 다음,
    두 개의 정렬된 부분 리스트를 합하여 전체가 정렬된 리스트가 되게 하는 방법.
    퀵 정렬은 다음의 단계들로 이루어진다.
    1. 분할: 입력 배열을 피벗을 기준으로 비균등하게 2개의 부분 배열로 분할한다.
    2. 정복: 부분 배열을 정렬한다. 부분 배열의 크기가 충분히 작지 않으면 순환 호출을 이용하여 다시 분할 정복 방법을 적용한다.
    3. 결합:정렬된 부분 배열들을 하나의 배열에 합병한다.
    4. 순환 호출이 한번 진행될 때마다 최소한 하나의 원소(피벗)는 최종적으로 위치가 정해지므로, 이 알고리즘은 반드시 끝난다는 것을 보장할 수 있다.

    '''
    def __init__(self):
        pass

    def sort(self):
        return
    
    def quick_sort(self,arr):
        if len(arr) <= 1:
            return arr
        
        pivot = arr[len(arr) // 2]
        left = [x for x in arr if x < pivot]
        middle = [x for x in arr if x == pivot]
        right = [x for x in arr if x > pivot]

        return self.quick_sort(left) + middle + self.quick_sort(right)

    def _quick_sort(self,arr, low, high):
        if low < high:
            # 분할(Partition)을 통해 피벗의 최종 위치를 결정함
            pivot_index = self.partition(arr, low, high)
            
            # 피벗을 제외한 왼쪽과 오른쪽 부분을 재귀적으로 정렬
            self._quick_sort(arr, low, pivot_index - 1)
            self._quick_sort(arr, pivot_index + 1, high)

    def partition(self,arr, low, high):
        pivot = arr[high]  # 맨 뒤의 원소를 피벗으로 설정
        i = low - 1        # 작은 원소들이 들어갈 구역의 경계 인덱스
        
        for j in range(low, high):
            # 현재 원소가 피벗보다 작거나 같다면 교환
            if arr[j] <= pivot:
                i += 1
                arr[i], arr[j] = arr[j], arr[i]
                
        # 반복이 끝난 후 피벗을 자기 자리(i+1)로 이동
        arr[i + 1], arr[high] = arr[high], arr[i + 1]
        return i + 1