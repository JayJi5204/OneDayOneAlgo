class MergeSort:
    def __init__(self):
        pass

    def sort(self,arr,reverse=False):
        sorted_list = self.merge_sort(arr)
        return sorted_list[::-1] if reverse else sorted_list
    
    def merge_sort(self,arr):
        '''
        병합정렬을 구현한다.
        병합정렬은 분할 정복과 재귀 알고리즘을 이용한 정렬 알고리즘으로, 시간복잡도는 O(nlogn)이다.
        하나의 리스트를 두 개의 균등한 크기로 분할하고 분할된 부분 리스트를 정렬한 다음, 두 개의 정렬된 부분 리스트를 합하여 전체가 정렬된 리스트를 얻는 방법이다.
        단, 길이가 1이 될 때까지 분할 후 정렬 및 합병 과정을 거친다.
        '''
        if len(arr) <= 1:
            return arr
        
        mid = len(arr)//2
        left,right = self.divide(arr,mid)

        left_ = self.merge_sort(left)
        right_ = self.merge_sort(right)

        return self.merge(left_,right_)
    
    @staticmethod
    def divide(arr,key):
        '''
        Docstring for divide
        같은 크기의 2개의 부분 리스트로 분할한다.
        '''
        return arr[:key],arr[key:]

    @staticmethod
    def merge(left,right):
        '''
        Docstring for merge
        정렬된 부분 리스트를 하나의 리스트에 통합한다.
        '''
        i,j = 0,0
        sorted_list = []
        
        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                sorted_list.append(left[i])
                i+=1
            else:
                sorted_list.append(right[j])
                j+=1
        
        while i < len(left):
            sorted_list.append(left[i])
            i+=1

        while j < len(right):
            sorted_list.append(right[j])
            j+=1
        
        return sorted_list