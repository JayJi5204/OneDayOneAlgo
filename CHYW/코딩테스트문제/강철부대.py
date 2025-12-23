'''
문제설명
강철부대로 복귀할 수 있는 최단시간을 담은 배열을 return

나의 아이디어
roads는 노드의 간선을 포함하고 있으므로 그래프 문제
3<= n <= 100,000
roads <= 500,000
간선의 가중치는 1로 일정하기 때문에 BFS로 접근

주의해야할 점은 sources에 주어진 정점마다 bfs를 실행 시 시간초과가 걸림
목표지점에서 각 정점마다 얼마나 걸리는지 계산하는 것이 시간복잡도를 줄이는 방법
'''

from collections import deque

def bfs(start,graph,visited):
    q = deque()
    q.append((start,0))
    while q:
        x,cost = q.popleft()
        
        for i in graph[x]:
            if not visited[i]:
                visited[i] = cost+1
                q.append((i,cost+1))
        
    return visited

def solution(n, roads, sources, destination):
    answer = []
    graph = [[] for _ in range(n+1)]
    for road in roads:
        a,b = road
        graph[a].append(b)
        graph[b].append(a)
    
    visited = [0]*(n+1)
    bfs(destination,graph,visited)
    visited[destination] = 0
    
    for source in sources:
        if source == destination:
            answer.append(0)
        elif visited[source] == 0:
            answer.append(-1)
        else:
            answer.append(visited[source])
    
    return answer