class FloydWarshall:
    def __init__(self, n, edges: list):
        """
        :param n: 노드의 개수
        :param edges: 간선 정보 리스트
            각 간선 정보는 (u, v, cost) 형태의 튜플로 표현
        """
        self.n = n
        self.INF = int(1e9)
        self.graph = [[self.INF] * (n + 1) for _ in range(n + 1)]
        self.parent = [[0] * (n + 1) for _ in range(n + 1)]
        
        for i in range(n + 1):
            self.graph[i][i] = 0

        for u, v, cost in edges:
            self.graph[u][v] = cost
            self.parent[u][v] = u

    def floyd_warshall(self):
        dist = [row[:] for row in self.graph]
        for k in range(1, self.n + 1):
            for i in range(1, self.n + 1):
                for j in range(1, self.n + 1):
                    if dist[i][j] > dist[i][k] + dist[k][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]
                        self.parent[i][j] = self.parent[k][j]
        return dist

    def get_path(self, i, j):
        if self.parent[i][j] == 0:
            return "경로 없음"
        path = [j]
        while i != j:
            j = self.parent[i][j]
            path.append(j)
        return " -> ".join(map(str, path[::-1]))

    def __str__(self):
        dist_matrix = self.floyd_warshall()
        lines = []
        
        # 1. 최단 거리 표 (Matrix)
        lines.append("\n[최단 거리 인접 행렬]")
        header = "      " + "".join([f"[{i:^3}]" for i in range(1, self.n + 1)])
        lines.append(header)
        lines.append("-" * len(header))
        
        for i in range(1, self.n + 1):
            row = f"[{i:^3}] "
            for j in range(1, self.n + 1):
                d = dist_matrix[i][j]
                val = "INF" if d >= self.INF else str(d)
                row += f"{val:^5} "
            lines.append(row)
        
        # 2. 상세 경로 리스트
        lines.append("\n[모든 경로 상세]")
        for i in range(1, self.n + 1):
            for j in range(1, self.n + 1):
                if i != j:
                    path_str = self.get_path(i, j)
                    cost = dist_matrix[i][j]
                    cost_str = f"(비용: {cost})" if cost < self.INF else "(도달 불가)"
                    lines.append(f"{i} to {j}: {path_str} {cost_str}")
                    
        return "\n".join(lines)
    def __repr__(self):
        return f"""플로이드 워셜 알고리즘 구현
        모든 정점 쌍 간의 최단 경로를 찾는 알고리즘
        시간 복잡도: O(V^3)
        공간 복잡도: O(V^2)
        
        플로이드 워셜 알고리즘은 다익스트라 알고리즘과 마찬가지로 단계별로 거쳐 가는 노드를 기준으로 알고리즘을 수행한다.
        다만 매 단계마다 방문하지 않은 노드 중에 최단 거리를 갖는 노드를 찾는 과정이 필요하지 않다.
        
        플로이드 워셜은 2차원 테이블에 최단 거리 정보를 저장한다.
        플로이드 워셜 알고리즘은 다이나믹 프로그래밍 유형에 속한다.
        각 단계마다 특정한 노드 k를 거쳐가는 경우를 확인한다.
        a -> b로 가는 최단 거리보다 a -> k를 거쳐 b로 가는 거리가 더 짧은지 검사한다.
        
        점화식은 다음과 같다:
        dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
        
        알고리즘 동작 방식:
            1. 모든 정점 쌍 (i, j)에 대해 초기 거리를 설정한다. (i에서 j로 직접 가는 간선이 없으면 무한대로 설정)
            2. 각 정점 k에 대해, 모든 정점 쌍 (i, j)에 대해 다음을 수행한다:
            - dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
            3. 모든 정점 쌍에 대한 최단 거리가 dist 테이블에 저장된다.
            
        FloydWarshall(graph={self.graph})
        """