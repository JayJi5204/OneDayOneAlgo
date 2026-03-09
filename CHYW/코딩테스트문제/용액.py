"""
문제 설명:
    KOI 부설 과학연구소에서는 많은 종류의 산성 용액과 알칼리성 용액을 보유하고 있다.
    산성 용액의 특성 값은 1부터 1,000,000,000까지의 양의 정수로 나타내고, 알칼리성 용액의 특성값은 -1 부터 -1,000,000,000까지의 음의 정수로 나타낸다.

    같은 양의 두용액을 혼합한 용액의 특성 값은 혼합에 사용된 각 용액의 특성값의 합으로 정의한다. 이 연구소에서는 같은 양의 두 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들려고 한다.

    예를 들어, 주어진 요액들의 특성값이 [-99, -2, -1,4 98]인 경우에는 특성 값이 -99인 용액과 특성값이 98인 용액을 혼합하면 특성값이 -1인 용액을 만들 수 있고, 이 용액의 특성값이 0에 가장 가까운 용액이다.
    참고로, 두 종류의 알칼리성 용액 혹은 산성만으로 특성값이 0에 가장 가까운 혼합 용액을 만드는 경우도 존재할 수 있다.

    산성 용액과 알칼리성 용액의 특성값이 정렬된 순서로 주어졌을 때, 이중 두개의 서로 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액을 찾아야한다. 
    특성값이 0에 가장 가까운 용액을 만들어내는 경우가 두 개 이상일 경우에는 그 중 아무것이나 하나를 출력한다.

제한 사항:
- 시간제한 1초
- 메모리 제한 128MB
- 전체 용액의 수 N(2<= N <= 100,000)

문제 풀이 아이디어:
- 두 용액을 합쳐 0에 가깝게 만들어야한다.
- 이분탐색 또는 투 포인터로 접근한다.

문제 풀이:
- 풀이 1 이분 탐색
    하나의 인덱스를 기준으로 그 앞의 나머지 배열을 대상으로 이분 탐색을 진행한다.
    하나의 인덱스는 두 개의 용액중 하나가 되며, 탐색하는 인덱스는 나머지 용액이 된다.
    두 용액을 더했을 때 0보다 작다면 start=mid+1
    두 용액을 더했을 때 0보다 크다면 end=mid-1
    
- 풀이 2 투포인터
    투 포인터 알고리즘을 사용하기 위해서 생각해야할 것은 딱 두가지다.
    두 개의 포인터를 각각 무엇으로 잡을지와, 각 포인터가 움직여야할 상황을 정의하는 것이다.

    테스트케이스에서 확인할 수 있듯이 용액 중 특성값이 가장 작은 값과 큰 값을 더하는 것이 0에 가까운 특성값을 만드는 하나의 방법처럼 보인다.
    따라서, 특성값이 가장 작은 0번 인덱스 갑이 가장 큰 마지막 값을 초기 포인터로 설정해 주었다.
    이후, 두 포인터가 가르키는 값을 더한 후 해당 값의 절대값이 0과 가장 가까운 것을 각각 저장해둔다.

    포인터를 이동시킬때는 두 포인터가 가르키는 값을 더한 값이 0보다 크냐 작냐를 기준으로 한다.

    만약 해당 값이 0보다 작다는 것은 두 포인터가 더한 값을 증가시켜줘야하기 때문에 왼쪽 포인터를 1 더해주고, 그게 아니라면 값을 감소시켜줘야하기 때문에 오른쪽 포인터에서 1을 빼준다.
"""

def binarySearch(n,liquids):
    answer = [0,0]
    summation = float("inf")

    for i in range(n):
        current = liquids[i]
        start,end = i+1,n-1
        while start<=end:
            mid=(start+end)//2
            temp = current+liquids[mid]

            if abs(temp) < summation:
                summation = abs(temp)
                answer[0]=i
                answer[1]=mid

            if temp < 0:
                start = mid+1
            else:
                end = mid-1
    return [liquids[answer[0]],liquids[answer[1]]]

def twoPointer(n,liquids):

    answer = [0,0]
    summation = float("inf")

    start,end=0,n-1

    while start<end:
        temp = liquids[start]+liquids[end]
        
        if abs(temp) < summation:
            summation=abs(temp)
            answer[0]=start
            answer[1]=end

        if temp < 0:
            start+=1
        else:
            end-=1
            
    return [liquids[answer[0]],liquids[answer[1]]]

def solution(num):
    n = int(input())
    liquids = list(map(int,input().split()))
    if num==1:
        print(*binarySearch(n,liquids))
    if num==2:
        print(*twoPointer(n,liquids))
    
solution(2)