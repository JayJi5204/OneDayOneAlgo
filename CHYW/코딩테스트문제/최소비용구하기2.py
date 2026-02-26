"""
문제 설명:
    n(1≤n≤1,000)개의 도시가 있다. 
    그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1≤m≤100,000)개의 버스가 있다. 
    우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다. 
    그러면 A번째 도시에서 B번째 도시 까지 가는데 드는 최소비용과 경로를 출력하여라. 
    항상 시작점에서 도착점으로의 경로가 존재한다.


    첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.
    둘째 줄에는 그러한 최소 비용을 갖는 경로에 포함되어있는 도시의 개수를 출력한다. 출발 도시와 도착 도시도 포함한다.
    셋째 줄에는 최소 비용을 갖는 경로를 방문하는 도시 순서대로 출력한다. 경로가 여러가지인 경우 아무거나 하나 출력한다.

제한 사항:
    시간 제한 1초
    메모리 제한 256MB
    n(1≤n≤1,000)
    m(1≤m≤100,000)

문제 풀이:
    최단 경로를 계산하는 문제이므로 다익스트라를 사용하면 된다.
    단, 지나왔던 경로를 저장해야하므로 갱신될 때 마다 이전 인덱스를 추가해주면 된다.
"""

def dijkstra(start,end,graph):
    import heapq

    dist = [float('inf')]*(len(graph)+1)
    dist[start] = 0
    prev_node = [0]*(len(graph)+1)
    q = []
    heapq.heappush(q,(0,start))
    
    while q:
        cost,now = heapq.heappop(q)
        
        if dist[now] < cost:
            continue

        for next_node,next_cost in graph[now]:
            if dist[next_node] > cost + next_cost:
                dist[next_node] = cost + next_cost
                prev_node[next_node] = now
                heapq.heappush(q,(cost+next_cost,next_node))

    path = [end]
    while end != start:
        end = prev_node[end]
        path.append(end)
    return dist, path[::-1]

def solution():
    n = int(input())
    m = int(input())
    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        a,b,c = map(int,input().split())
        graph[a].append((b,c))
    start,end = map(int,input().split())
    dist,path = dijkstra(start,end,graph)
    
    print(dist[end])
    print(len(path))
    print(*path)
    return

if __name__=="__main__":
    solution()