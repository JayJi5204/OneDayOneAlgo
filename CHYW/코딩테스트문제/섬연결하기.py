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
            
def solution(n, costs):
    '''
    n개의 섬 사이에 다리를 건설하는 비용이 주어질 때, 최소 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 리턴하는 문제
    모든 노드를 연결하는 최소 신장 트리를 찾는 문제이다.
    
    가능한 알고리즘:
        1.크루스칼 알고리즘
        2.프림 알고리즘
        3.다익스트라
    
    시간복잡도와 공간복잡도를 고려하면 DP를 사용하는 다익스트라가 제일 좋지만, 크루스칼 알고리즘으로 풀이하려고 한다.    
    '''

    mst_cost,mst_edges = kruskal(n,costs)
    
    return mst_cost