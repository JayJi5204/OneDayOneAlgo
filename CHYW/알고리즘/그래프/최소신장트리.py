class Unionfind:
    def __init__(self,size):
        self.parent = list(range(size))

    def find(self,u):
        if self.parent[u] != u:
            self.parent[u] = self.find(self.parent[u])
        return self.parent[u]

    def union(self,u,v):
        root_u = self.find(u)
        root_v = self.find(v)
        if root_u != root_v:
            self.parent[root_v] = root_u

def kruskal(n,edges:list):
    '''
    크루스칼 알고리즘 구현
    최소 신장 트리를 찾는 알고리즘
    간선 중심의 그리디 알고리즘
    1.간선을 오름차순으로 정렬
    2.간선을 하나씩 확인하며 사이클이 발생하지 않는 경우에만 집합에 포함
    3.사이클 발생 여부는 Union-Find 자료구조로 확인
    '''
    uf = Unionfind(n)
    edges.sort(key=lambda x:x[2])
    mst_cost = 0
    mst_edges = []

    for u,v,cost in edges:
        if uf.find(u) != uf.find(v):
            uf.union(u,v)
            mst_cost += cost
            mst_edges.append((u,v,cost))

    return mst_cost,mst_edges

import heapq

def prim(start,graph):
    '''
    프림 알고리즘 구현
    최소 신장 트리를 찾는 알고리즘
    정점 중심의 그리디 알고리즘
    1.시작 정점을 선택하고, 해당 정점과 인접한 간선들을 우선순위 큐에 삽입
    2.우선순위 큐에서 최소 간선을 추출하고, 해당 간선이 연결하는 정점이 이미 선택된 정점이 아니면 집합에 포함
    3.새로 선택된 정점과 인접한 간선들을 우선순위 큐에 삽입
    '''
    n = len(graph)
    visited = [False]*n
    min_heap = []
    mst_cost = 0
    mst_edges = []

    visited[start] = True
    for to,cost in graph[start]:
        heapq.heappush(min_heap,(cost,start,to))

    while min_heap:
        cost,u,v = heapq.heappop(min_heap)
        if not visited[v]:
            visited[v] = True
            mst_cost += cost
            mst_edges.append((u,v,cost))

            for to,next_cost in graph[v]:
                if not visited[to]:
                    heapq.heappush(min_heap,(next_cost,v,to))

    return mst_cost,mst_edges