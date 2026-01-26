#pytest
def test_다익스트라():
    from 다익스트라 import Dijkstra

    graph = {
        0:[], 
        1:[(2, 2), (3, 3), (4, 1), (5, 10)], 
        2:[(4, 2)], 
        3:[(4, 1), (5, 1)], 
        4:[(5, 3)], 
        5:[]
    }

    dijkstra = Dijkstra()
    start,end = 1,5

    assert dijkstra.search(start,end,graph) == 4
    
def test_너비우선탐색():
    from 너비우선탐색 import BreadthFirstSearch

    graph = {
        0: [1, 2],
        1: [0, 3, 4],
        2: [0, 5],
        3: [1],
        4: [1, 5],
        5: [2, 4]
    }

    bfs = BreadthFirstSearch()

    assert bfs.search(start=0,graph=graph) == [0,1,2,3,4,5]
    assert bfs.get_path() == '0 -> 1 -> 2 -> 3 -> 4 -> 5'

def test_깊이우선탐색():
    from 깊이우선탐색 import DepthFirstSearch

    graph = {
        0: [1, 2],
        1: [0, 3, 4],
        2: [0, 5],
        3: [1],
        4: [1, 5],
        5: [2, 4]
    }

    start = 0
    
    arr = ['A', 'B', 'C']
    r = 2

    dfs = DepthFirstSearch()

    assert list(dfs.search(x=start,graph=graph)) == [0,1,3,4,5,2]
    assert list(dfs.permutations(arr,r)) == [['A', 'B'], ['A', 'C'], ['B', 'A'], ['B', 'C'], ['C', 'A'], ['C', 'B']]
    assert list(dfs.combinations(arr,r)) == [['A', 'B'], ['A', 'C'], ['B', 'C']]

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


def test_floyd_warshall():
    from 플로이드워셜 import FloydWarshall
    n=4
    edges = [
        (1, 2, 4),
        (1, 3, 1),
        (1, 4, 6),
        (3, 1, 5),
        (3, 4, 4),
        (4, 3, 2)
    ]
    fw = FloydWarshall(n, edges)
    dist = fw.floyd_warshall()
    assert dist[1][4] == 5  # 1 -> 3 ->
    assert dist[4][2] == 11  # 4 -> 3 -> 1 -> 2
    path = fw.get_path(1, 4)
    assert path == "1 -> 3 -> 4"
    path_no = fw.get_path(2, 4)
    assert path_no == "경로 없음"