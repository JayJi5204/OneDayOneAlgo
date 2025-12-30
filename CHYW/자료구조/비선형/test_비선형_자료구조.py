#pytest
def test_minimum_spanning_tree():
    from 최소신장트리 import kruskal, prim
    # 크루스칼 알고리즘 테스트
    n = 4
    edges = [(0, 1, 1), (0, 2, 3), (1, 2, 1), (1, 3, 4), (2, 3, 2)]
    mst_cost, mst_edges = kruskal(n, edges)
    assert mst_cost == 4
    assert set(mst_edges) == {(0, 1, 1), (1, 2, 1), (2, 3, 2)} 
    # 프림 알고리즘 테스트
    graph = [
        [(1, 1), (2, 3)],
        [(0, 1), (2, 1), (3, 4)],
        [(0, 3), (1, 1), (3, 2)],
        [(1, 4), (2, 2)]
    ]
    mst_cost_prim, mst_edges_prim = prim(0, graph)
    assert mst_cost_prim == 4
    assert set(mst_edges_prim) == {(0, 1, 1), (1, 2, 1), (2, 3, 2)}

def test_heapq():
    from 힙 import Heapq
    heapq = Heapq()
    heap = []
    heapq.heappush(heap, 5)
    heapq.heappush(heap, 3)
    heapq.heappush(heap, 8)
    heapq.heappush(heap, 1)
    assert heap == [1, 3, 8, 5]
    assert heapq.heappop(heap) == 1
    assert heap == [3, 5, 8]
    heapq.heapify(heap)
    assert heap == [3, 5, 8]