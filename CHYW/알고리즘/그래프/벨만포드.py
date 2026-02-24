class BellmanFord():
    def __init__(self):
        pass

    def search(self,start,edges):
        dist = [float('inf')]*(len(edges))
        dist[start] = 0
        for i in range(len(edges)):
            for u,v,weight in edges:
                #현재 간선을 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if dist[u] != float('inf') and dist[u] + weight < dist[v]:
                    dist[v] = dist[u] + weight

                    if i == len(edges)-1:
                        return True, [] #음수 사이클 발생
        return False,dist

    def __repr__(self):
        return """
            벨만-포드 알고리즘은 한 정점에서 다른 모든 정점까지의 최단 경로를 구하는 알고리즘이다. 이때, 다익스트라와 달리 간선의 가중치가 음수인 경우에도 최단 거리를 구할 수 있다.
            단, 모든 간선의 비용이 양수일 때는 다익스트라를, 음수 간선이 포함되어 있으면 벨만-포드를 사용하면 된다.

            벨만-포드의 과정은 아래와 같다.
            1. 출발 노드를 설정한다.
            2. 최단거리 테이블을 초기화한다.
            3. 다음의 과정을 (V(=정점)-1)번 반복한다.
                1. 모든 간선 E개를 하나씩 확인한다.
                2. 각 가선을 거처 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신한다.
            
            벨만-포드는 모든 정점과 간선을 확인하므로  시간 복잡도는 O(VE)가 된다.
            
            만약 음수 간선 순환이 발생하는지 체크하고 싶다면 3번 과정을 한 번 더 수행한다.
            벨만 포드 알고리즘은 한 노드에서 다른 노드까지의 최단 경로를 많아봐야 V-1개의 간선을 지난다는 가정을 세운다.
            이것의 의미는, 최단 경로가 V-1개보다 많은 간선을 지나게 된다면 음의 사이클이 존재한다는 의미다.
        """
    