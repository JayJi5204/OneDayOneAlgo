'''
문제 설명:
    트리(tree)는 사이클이 없는 무방향 그래프이다. 
    트리에서는 어떤 두 노드를 선택해도 둘 사이에 경로가 항상 하나만 존재하게 된다. 
    트리에서 어떤 두 노드를 선택해서 양쪽으로 쫙 당길 때, 가장 길게 늘어나는 경우가 있을 것이다. 
    이럴 때 트리의 모든 노드들은 이 두 노드를 지름의 끝 점으로 하는 원 안에 들어가게 된다.

    이런 두 노드 사이의 경로의 길이를 트리의 지름이라고 한다. 
    정확히 정의하자면 트리에 존재하는 모든 경로들 중에서 가장 긴 것의 길이를 말한다.

    입력으로 루트가 있는 트리를 가중치가 있는 간선들로 줄 때, 트리의 지름을 리턴 

제한 사항:
    시간 제한 2초
    메모리 제한 128 MB
    1 <= n <= 10000

문제 풀이:
    트리는 사이클이 없는 그래프이므로, 
    임의의 노드에서 가장 먼 지점은 항상 트리의 끝 노드이기에 임의의 노드에서 가장 거리가 먼 점 x를 찾고,
    다시 x에서 가장 거리가 먼 점 y를 찾으면 트리의 지름이다.

    문제에서 어떤 두 노드를 선택해도 둘 사이에 경로가 항상 하나만 존재한다고 언급했다.
    따라서 어떤 노드에서 출발해도 "가장 먼 노드는 1개다"라고 가정 할 수 있다.

    하지만 어떤 노드에서 출발해야 지름의 크기를 최대로 키울 수 있는지 모르므로,
    먼저, 가장 거리가 먼 노드를 찾고
    그 후에, 가장 거리가 먼 노드에서 가장 거리가 먼 노드를 찾아 낸다면, 그것이 트리의 지름이 된다.

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