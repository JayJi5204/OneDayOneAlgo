from collections import deque,Counter
'''
n개의 노드가 있는 그래프가 있을 때, 각 노드는 1~n까지 번호가 매겨져 있다.
가장 멀리 떨어진 노드의 갯수를 리턴하는 문제이다.

단 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미한다.

제한사항:
노드의 개수 n은 2 이상 20,000 이하입니다.
간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.

제한 사항을 고려했을 때 DFS보다는 BFS로 접근하는 것이 유리하다.
따라서 BFS로 접근한다.
1.BFS로 접근할 때, 각 노드까지의 거리를 기록하는 리스트를 하나 생성한다.
2.그럼 대략 [0,1,2,2,3,3,4] 이런식으로 거리가 기록될 것이다.
3.이 리스트를 Counter로 갯수를 세어 가장 큰 key값의 value를 리턴한다.

'''
def bfs(x,graph,visited):
    
    q = deque()
    q.append((x,0))
    visited[x] = 1
    
    while q:
        x,cost = q.popleft()
        
        for i in graph[x]:
            if not visited[i]:
                q.append((i,cost+1))
                visited[i] = cost+1
                
    return visited

def solution(n, edges):
    answer = 0
    graph = [[] for _ in range(n+1)]
    visited = [0]*(n+1)
    for edge in edges:
        a,b = edge
        graph[a].append(b)
        graph[b].append(a)

    distance = bfs(1,graph,visited)
    c = Counter(distance)

    return c[max(c)]