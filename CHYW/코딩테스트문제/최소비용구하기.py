"""
문제 설명:
    N개의 도시가 있다. 
    그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다. 
    우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다.
    A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력하여라. 
    도시의 번호는 1부터 N까지이다.

문제 풀이:
    그래프가 주어지고, 시작 도시에서 도착 도시 까지의 최소비용을 구하는 문제는 다익스트라로 해결할 수 있다.
    1. 다익스트라 알고리즘을 구현한다.
"""

import heapq

def dijkstra(start,end,graph):
    dist = [float('inf')] * len(graph)
    dist[start] = 0

    q = []
    heapq.heappush(q,(0,start))

    while q:
        cost,now = heapq.heappop(q)
        if dist[now] < cost:
            continue

        for i in graph[now]:
            if cost + i[1] < dist[i[0]]:
                dist[i[0]] = cost + i[1]
                heapq.heappush(q,(cost+i[1],i[0]))
    return dist[end]

if __name__ == "__main__":
    import sys
    input = sys.stdin.readline
    n = int(input())
    m = int(input())

    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        a,b,c = list(map(int,input().split()))
        graph[a].append((b,c))
    start,end = list(map(int,input().split()))
    print(dijkstra(start,end,graph))
