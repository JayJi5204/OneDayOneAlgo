from collections import deque,defaultdict
from typing import Union,List,Dict

class BreadthFirstSearch():
    def __init__(self):
        self.graph=None
        self.result = []
        self.visited = defaultdict(bool)

    def search(self,start:Union[int,str],graph:Union[List,Dict]=None):
        """
        :param start: 시작 정점
        :type start: Union[int, str]
        
        :param graph: 인접리스트
        :type graph: Union[List,Dict]

        너비우선탐색 알고리즘 구현체
        인접리스트로 나타내어진 그래프에서, 시작 정점과 가장 가까운 노드를 탐색한다.
        """
        if graph is None:
            raise AssertionError("그래프가 없습니다.")
        self.graph=graph
        q = deque()
        q.append(start)
        self.visited[start] = 1

        while q:
            current = q.popleft()
            self.result.append(current)

            for neighbor in self.graph[current]:
                if self.visited.get(neighbor,0) == 0:
                    q.append(neighbor)
                    self.visited[neighbor]=1
            
        return self.result
    def get_path(self):
        return ' -> '.join(map(str,self.result))
    
    def __str__(self):
        return f"""
            BFS 탐색 순서: {self.get_path()} 
        """
    
    def __repr__(self):
        return f"""
            BFS(graph={self.graph})
        """