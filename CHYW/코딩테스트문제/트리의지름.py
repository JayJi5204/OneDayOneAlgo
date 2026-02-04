'''
문제 설명:
    트리(tree)는 사이클이 없는 무방향 그래프이다. 
    트리에서는 어떤 두 노드를 선택해도 둘 사이에 경로가 항상 하나만 존재하게 된다. 
    트리에서 어떤 두 노드를 선택해서 양쪽으로 쫙 당길 때, 가장 길게 늘어나는 경우가 있을 것이다. 
    이럴 때 트리의 모든 노드들은 이 두 노드를 지름의 끝 점으로 하는 원 안에 들어가게 된다.

    이런 두 노드 사이의 경로의 길이를 트리의 지름이라고 한다. 
    정확히 정의하자면 트리에 존재하는 모든 경로들 중에서 가장 긴 것의 길이를 말한다.

    입력으로 루트가 있는 트리를 가중치가 있는 간선들로 줄 때, 
    트리의 지름을 구해서 출력하는 프로그램을 작성하시오. 

제한 사항:
    시간 제한 2초
    메모리 제한 128 MB

문제 풀이:
    DFS를 사용하여 목표지점 까지의 거리를 누적하고 
    누적된 값이 가장 큰 노드 두 개를 선별하면 된다.
'''
import sys
sys.setrecursionlimit(10**6)

def dfs(start,graph,visited,cost):
    for i in graph[start]:
        if visited[i[0]] == -1:
            visited[i[0]] = cost + i[1]
            dfs(i[0],graph,visited,cost+i[1])
    return

def solution(n,graph):
    
    visited = [-1]*(n+1)
    visited[1] = 0
    dfs(1,graph,visited,0)
    lastNode = visited.index(max(visited))

    visited = [-1]*(n+1)
    visited[lastNode] = 0
    dfs(lastNode,graph,visited,0)
    
    return max(visited)

if __name__=="__main__":
    n = int(input())
    graph = [[] for _ in range(n+1)]

    for i in range(n-1):
        a,b,c = list(map(int,input().split()))
        graph[a].append((b,c))
        graph[b].append((a,c))
    print(solution(n,graph))