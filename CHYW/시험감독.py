def dfs(x,graph,visited):
    visited[x] = 1
    
    for i in graph[x]:
        if visited[i]: continue
        dfs(i,graph,visited)
               
def solution(n, computers):
    """
    Docstring for solution
    
    :param n: 컴퓨터 개수
    :param computers: 연결에 대한 정보
    
    기본적인 DFS/BFS를 사용하여 문제를 해결한다.
    연결된 그룹이 총 몇개인지 구하는 문제이므로

    진입이 가능한 노드마다 DFS/BFS를 사용한다.
    """
    answer = 0
    visited = [0]*n
    graph = [[] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if computers[i][j] == 1:
                graph[i].append(j)
                
    for i in range(n):
        if visited[i] == 0:
            dfs(i,graph,visited)
            answer+=1
    return answer