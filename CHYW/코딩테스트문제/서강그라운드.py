"""
문제 설명:
    예은이는 요즘 가장 인기가 있는 게임 서강그라운드를 즐기고 있다. 
    서강그라운드는 여러 지역중 하나의 지역에 낙하산을 타고 낙하하여, 그 지역에 떨어져 있는 아이템들을 이용해 서바이벌을 하는 게임이다. 
    서강그라운드에서 1등을 하면 보상으로 치킨을 주는데, 예은이는 단 한번도 치킨을 먹을 수가 없었다. 자신이 치킨을 못 먹는 이유는 실력 때문이 아니라 아이템 운이 없어서라고 생각한 예은이는 낙하산에서 떨어질 때 각 지역에 아이템 들이 몇 개 있는지 알려주는 프로그램을 개발을 하였지만 어디로 낙하해야 자신의 수색 범위 내에서 가장 많은 아이템을 얻을 수 있는지 알 수 없었다.
    각 지역은 일정한 길이 l (1 ≤ l ≤ 15)의 길로 다른 지역과 연결되어 있고 이 길은 양방향 통행이 가능하다. 예은이는 낙하한 지역을 중심으로 거리가 수색 범위 m (1 ≤ m ≤ 15) 이내의 모든 지역의 아이템을 습득 가능하다고 할 때, 예은이가 얻을 수 있는 아이템의 최대 개수를 알려주자.

    예은이의 수색범위가 4라고 하자. ( 원 밖의 숫자는 지역 번호, 안의 숫자는 아이템 수, 선 위의 숫자는 거리를 의미한다) 
    예은이가 2번 지역에 떨어지게 되면 1번,2번(자기 지역), 3번, 5번 지역에 도달할 수 있다. 
    (4번 지역의 경우 가는 거리가 3 + 5 = 8 > 4(수색범위) 이므로 4번 지역의 아이템을 얻을 수 없다.) 
    이렇게 되면 예은이는 23개의 아이템을 얻을 수 있고, 이는 위의 필드에서 예은이가 얻을 수 있는 아이템의 최대 개수이다.
    예은이가 얻을 수 있는 최대 아이템 개수를 출력한다.

제한 사항:
    시간 제한 1초
    메모리 제한 128 MB
    지역의 개수 n (1 ≤ n ≤ 100)
    수색범위 m (1 ≤ m ≤ 15)
    길의 개수 r (1 ≤ r ≤ 100)

문제 풀이:
    그래프 알고리즘을 적용할 수 있으며, 수색 범위안에서 탐색을 진행해야한다.
    또한 간선에 가중치를 고려해야하기 때문에 다익스트라를 적용하면 된다.

    다익스트라는 BFS + Heap + dp의 조합으로 구현할 수 있다.
"""

import heapq

def dijkstra(start,graph):

    dist = [float('inf') for _ in range(len(graph))]
    dist[start]=0

    q = []
    heapq.heappush(q,(0,start))

    while q:
        cost,now = heapq.heappop(q)
        
        if dist[now] < cost:
            continue
        
        for _next in graph[now]:
            nxt_node, nxt_cost = _next
            if dist[nxt_node] > nxt_cost + cost:
                dist[nxt_node] = nxt_cost + cost
                heapq.heappush(q,(nxt_cost + cost,nxt_node))
    return dist

def solution():
    answer = 0
    n,m,r = map(int,input().split())
    t = list(map(int,input().split()))
    
    graph = [[] for _ in range(n+1)]

    for _ in range(r):
        a,b,c = map(int,input().split())
        graph[a].append((b,c))
        graph[b].append((a,c))
    for i in range(1,n+1):
        info = [idx for idx,d in enumerate(dijkstra(i,graph)) if d<=m]
        answer=max(answer,sum([t[i-1] for i in info]))
    return answer
if __name__=="__main__":
    print(solution())