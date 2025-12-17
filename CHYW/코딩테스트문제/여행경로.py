from collections import defaultdict

answer = []

def dfs(x,n,start,graph,result):
    global answer
    if x == n:
        answer.append(result[:])
        return result[:]
    
    for i in range(len(graph[start])):
        end,visited = graph[start][i]
        if visited == 0:
            graph[start][i] = (end,1)
            result.append(end)
            dfs(x+1,n,end,graph,result)
            result.pop()
            graph[start][i] = (end,0)
    return None

def solution(tickets):
    '''
    문제 설명
    주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
    항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
    
    제한사항
    모든 공항은 알파벳 대문자 3글자로 이루어집니다.
    주어진 공항 수는 3개 이상 10,000개 이하입니다.
    tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
    주어진 항공권은 모두 사용해야 합니다.
    만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
    모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.

    나의 아이디어
    제한 사항을 살펴보면 "[a, b]는 a 공항에서 b 공항으로 가는 항공권"이며 이것을 이용해 순서를 만들어야함을 알 수 있다.
    따라서 그래프를 그릴 수 있으며 DFS/BFS로 탐색을 진행해야함을 알 수 있다.

    까다로웠던 점은 같은 곳을 방문할 수 있어 알고리즘이 무한 루프에 빠지지 않게 조심해야한다.
    나의 경우에는 그래프 자체를 체크하여 한번 쓴 항공권은 더 이상 쓰지 못하게 했다.
    '''

    n=len(tickets)
    graph = defaultdict(list)
    for ticket in tickets:
        a,b = ticket
        graph[a].append((b,0))
        
    dfs(0,n,'ICN',graph,['ICN'])
    answer.sort()
    
    return answer[0]