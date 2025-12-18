class InsertionSort:
    def __init__(self):
        pass
    def sort(self,arr,reverse=False):
        '''
        삽입정렬 알고리즘 구현
        key 값을 기준으로 그 앞쪽에 있는 값들과 비교하여
        key 값이 더 작으면 한 칸씩 뒤로 밀고, key 값이 들어갈 자리를 찾는다.
        시간복잡도: O(n^2)
        '''
        
        for i in range(1,len(arr)):
            key=arr[i]
            if reverse:
                j=i-1
                while j>=0 and arr[j]<key:
                    arr[j+1]=arr[j]
                    j-=1
                arr[j+1]=key
            else:
                j=i-1
                while j>=0 and arr[j]>key:
                    arr[j+1]=arr[j]
                    j-=1
                arr[j+1]=key
        return arr