from collections import defaultdict
from typing import Union,List,Dict,Optional

class DepthFirstSearch():
    def __init__(self):
        pass
    
    def search(
            self,
            x:Union[int,str],
            graph:Union[List,Dict]=None,
            visited:Union[List,Dict]=defaultdict(bool)):
        '''
        Docstring for search
        
        DFS
        :param x: 시작 정점
        :type x: Union[int, str]

        :param graph: 인접리스트
        :type graph: Union[List, Dict]

        :param order: 순회 순서
        :type order: str
        '''

        if graph is None:
            raise AssertionError("그래프가 없습니다.")
             
        visited[x]=1
        yield x
        
        for i in graph[x]:
            if visited.get(i,0) == 0:
                yield from self.search(i,graph,visited)
        
        
    def permutations(
            self,
            arr:Optional[List],
            r:Optional[int]
            ):
        '''
        Docstring for permutations
        
        순열: 서로 다른 n개의 원소에서 r개를 중복없이 골라 순서대로 나열하는 경우의 수

        :param arr: 서로 다른 n개의 원소를 담은 배열
        :type arr: Optional[List]
        
        :param r: 선택할 원소 수
        :type r: Optional[int]
        '''
        
        for i in range(len(arr)):
            if r == 1:
                yield [arr[i]]
            else:
                for next in self.permutations(arr[:i]+arr[i+1:],r-1):
                    yield [arr[i]] + next
    
    def combinations(
            self,
            arr:Optional[List],
            r:Optional[int]
        ):
        '''
        Docstring for combinations

        조합: 서로 다른 n개의 원소에서 r개를 뽑는 경우의 수

        :param arr: 서로 다른 n개의 원소를 담은 배열
        :type arr: Optional[List]
        
        :param r: 선택할 원소의 수
        :type r: Optional[int]
        '''
        for i in range(len(arr)):
            if r == 1:
                yield [arr[i]]
            else:
                for next in self.permutations(arr[i+1:],r-1):
                    yield [arr[i]] + next

    