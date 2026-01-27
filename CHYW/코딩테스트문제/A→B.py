'''
문제 설명:
    정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.

    2를 곱한다.
    1을 수의 가장 오른쪽에 추가한다. 
    A를 B로 바꾸는데 필요한 연산의 최솟값을 리턴

제한 사항:
    A, B (1 ≤ A < B ≤ 10^9)

문제 풀이:
    곱하기 2와 뒤에 1을 붙이는 연산만을 가지고 연산의 최솟값을 리턴해야한다.
    단순 for문을 사용하여 완전탐색을 진행할 경우 최악의 경우 10억 개의 연산을하므로 시간초과

    따라서 현재 값에서 연산을 수행한 값만을 활용한다면, 아래와 같이 연산을 줄일 수 있다.
        - 곱하기 2의 경우 n/2
        - 뒤에 1을 붙이는 경우 n/10

    BFS를 사용하여 큐에 [값,연산횟수]를 저장한다면, 최단 경로로 목표값에 도달할 수 있다.
    즉 최소연산 횟수를 구할 수 있다. 
'''

from collections import deque

def solution(A,B):
    q = deque()
    q.append((A,1))

    while q:
        x,cost = q.popleft()
        if x == B:
            return cost
        
        if x < B:
            q.append((x*2,cost+1))
            q.append((int(str(x)+'1'),cost+1))

    return -1

if __name__=="__main__":
    A,B = list(map(int,input().split()))
    print(solution(A,B))