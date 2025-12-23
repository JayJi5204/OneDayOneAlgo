class BinarySearch:
    def __init__(self):
        pass

    def search_right(a,x,low=0,high=None,*,key=None):
        if low < 0:
            raise ValueError('low must be non-negative')
        
        if high is None:
            high = len(a)

        if key is None:
            while low < high:
                mid = (low+high)//2
                if x < a[mid]:
                    high=mid
                else:
                    low=mid+1
        else:
            while low<high:
                mid= (low+high) // 2
                if x < key(a[mid]):
                    high=mid
                else:
                    low=mid+1

        return low
    
    def search_left(a,x,low=0,high=None,*,key=None):
        if low < 0:
            raise ValueError('low must be non-negative')
        
        if high is None:
            high = len(a)

        if key is None:
            while low < high:
                mid = (low + high) // 2
                if a[mid] < x:
                    low = mid+1
                else:
                    high = mid
        else:
            while low < high:
                mid = (low + high) // 2
                if key(a[mid]) < x:
                    low = mid+1
                else:
                    high = mid
        return low
    
    def __repr__(self):
        return '''
        이진탐색 구현
        이진 탐색 알고리즘은 리스트의 중간 값과 비교하여 검색값을 찾는다.
        중간 값을 찾아야하기 때문에 반드시 정렬된 배열에서만 사용할 수 있다.

        이진탐색의 동작 방식은 다음과 같다.
        1. 배열의 중간 값을 가져온다.
        2. 중간값과 검색 값을 비교한다.
        3. 값을 찾거나 간격이 비어있을 때까지 반복

        키가 의미하는 것은 함수로서 정렬 순서를 지정할 수 있다.

        bisect_left, bisect_right 처럼 search_left, search_right로 구분하여 구현했다.
        '''
