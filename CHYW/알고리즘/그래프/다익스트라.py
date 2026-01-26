from typing import Optional,Union,List,Dict
from collections import defaultdict

class Dijkstra:
    def __init__(self,edges=None):
        if edges is not None:
            self.graph = defaultdict(list)
            for edge in edges:
                u,v,cost = edge
                self.graph[u].append((v,cost))

    def search(self,start:Optional[int],end:Optional[int]=None,graph:Union[List,Dict]=None):
        '''
        다익스트라 알고리즘 구현
            1. 최단거리를 구할 노드에서 시작하여, 거리가 입력된 노드 중 최단거리가 가장 작은 노드를 돌아가며 선택
            2. 노드를 돌아가면서, 더 짧은 거리가 나오면 값을 갱신하여 넣는다.
            3. 도착 정점까지의 비용을 리턴
        '''
        
        import heapq
        
        dist = [float('inf') for _ in range(len(graph))]
        dist[start]=0
        
        q = []
        heapq.heappush(q,(0,start))

        while q:
            cost,now = heapq.heappop(q)
            
            if dist[now] < cost:
                continue

            for _next in graph[now]:
                next_node,next_cost = _next
                if cost + next_cost < dist[next_node]:
                    dist[next_node] = cost + next_cost
                    heapq.heappush(q,(cost + next_cost,next_node)) 

        return dist[end]
    
    def __repr__(self):
        return '''
        Docstring for __repr__

        다익스트라 알고리즘은 다이나믹 프로그래밍을 활용한 대표적인 최단경로 탐색 알고리즘이다.
        다익스트라 알고리즘은 특정한 하나의 정점에서 다른 모든 정점으로 가는 최단 경로를 알려준다. 다만 이 때 음의 간선을 포함할 수 없다.
        현실세계에서는 음의 간선이 존재하지 않기 때문에 다익스트라는 현실 세계에 사용하기 매우 적합한 알고리즘 중 하나라고 할 수 있다.
        '''

