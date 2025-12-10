import heapq

def solution(n,works):
    if sum(works) <= n:
        return 0
    
    '''
    야근 피로도 = sum(남은 작업량^2)
    야근 피로도를 최소화 한다는 것은 n을 활용해서 최대한 높은 숫자를 깍아줘야한다.
    가장 단순하게 아이디어를 구현 O(n^2)의 시간 복잡도를 가진다. 시간 초과 발생
    '''
    for i in range(n):
        max_work = max(works)
        works[works.index(max_work)] -= 1

    return sum(x**2 for x in works)

def solution(n, works):
    if sum(works) <= n:
        return 0
    
    ''' 
    야근 피로도 = sum(남은 작업량^2)
    야근 피로도를 최소화 한다는 것은 n을 활용해서 최대한 높은 숫자를 깍아줘야한다.
    max heap 자료구조를 활용해서 O(nlogk) 시간 복잡도로 접근한다.
    '''

    works = [-work for work in works]
    heapq.heapify(works)
    
    for i in range(n):
        max_work = heapq.heappop(works)
        heapq.heappush(works,(max_work+1))
    
    return sum([(-work)**2 for work in works])