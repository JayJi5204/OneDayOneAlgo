class prefixSum:
    def __init__(self):
        pass
    
    def __call__(arr:list,A:int,B:int):
        '''
        누적합 구현체
        인덱스 A,B가 주어지면 구간의 합을 리턴한다.
        '''
        for i in range(1,len(arr)):
            arr[i] = arr[i] + arr[i-1]
        
        return arr[B] - arr[A]