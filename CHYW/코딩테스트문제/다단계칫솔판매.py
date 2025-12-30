'''
트리를 만들고 자신의 부모를 탐색하는 과정을 구현해야한다.
알고리즘은 그래프 탐색 DFS/BFS, 유니온 파인드

제한사항:
    enroll의 길이 1이상 10,000이하
    referral의 길이는 enroll의 길이와 같음
    seller의 길이는 1이상 100,000이하
    amount의 길이는 seller의 길이와 같으며 원소의 범위는 1 이상 100 이하인 자연수

이 문제는 단순히 부모를 탐색하는 과정을 포함하고 있다.
반복문을 사용하든 dfs를 사용하든 시간복잡도가 O(n^2) 이다.
대략 10,000 * 100,000 = 10^9 이므로 시간초과가 날 수 있다.

하지만 최대로 벌 수 있는 금액은 100 * 100 = 10,000 이므로 재귀 호출 또는 반복의 횟수가 최대 5번이다.
따라서 시간복잡도는 O(n) 이므로 dfs 또는 반복문을 사용해서 접근할 수 있다.

풀이:
    1. 그래프를 딕셔너리로 표현
    2. DFS로 자신의 부모를 탐색하며 수익 분배

'''

from collections import defaultdict

def dfs(x,graph,cost,answer):
    
    if x == '-' or cost-cost//10 < 1 :
        return answer
    
    answer[x]+=cost-cost//10
    
    for i in graph[x]:
        dfs(i,graph,cost//10,answer)

def solution(enroll, referral, seller, amount):
    answer = dict([(e,0) for e in enroll]+[('-',0)])
    
    graph = defaultdict(list)
    
    for e,r in zip(enroll,referral):
        graph[e].append(r)
    
    for x,cost in zip(seller,amount):
        dfs(x,graph,cost*100,answer)
    
    return list(answer.values())[:-1]