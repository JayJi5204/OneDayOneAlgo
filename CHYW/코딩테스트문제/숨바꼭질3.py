"""
문제 설명:
    수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
    수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
    수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

제한 사항:
    시간제한 2초
    메모리 제한 512MB

문제 풀이:
    BFS로 문제를 해결할 수 있다.
    순간이동을 할 때는 시간이 걸리지 않기 때문에, 순간이동을 우선적으로 고려하여 탐색을 진행한다.
    따라서 큐에 삽입할 때, 순간이동한 위치를 먼저 삽입하고, 걷는 위치를 나중에 삽입한다.
    이를 통해 최단 시간을 구할 수 있다.
"""
from collections import deque

def solution(n, k):
    max_value = 100000
    visited = [0] * (max_value + 1)
    
    q = deque()
    q.append((n, 0))

    while q:
        x,cost = q.popleft()
        
        if x == k:
            return cost
        
        for i in [x*2, x-1, x+1]:
            if 0 <= i <= max_value and not visited[i]:
                visited[i] = 1
                if i == x * 2:
                    q.appendleft((i, cost))
                else:
                    q.append((i, cost + 1))
    return

if __name__ == "__main__":
    import sys
    input = sys.stdin.readline

    n, k = map(int, input().split())
    print(solution(n, k))