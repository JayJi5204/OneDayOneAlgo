'''
문제 설명:
    유현이가 새 집으로 이사했다. 새 집의 크기는 N×N의 격자판으로 나타낼 수 있고, 1×1크기의 정사각형 칸으로 나누어져 있다. 각각의 칸은 (r, c)로 나타낼 수 있다. 여기서 r은 행의 번호, c는 열의 번호이고, 행과 열의 번호는 1부터 시작한다. 
    각각의 칸은 빈 칸이거나 벽이다.
    오늘은 집 수리를 위해서 파이프 하나를 옮기려고 한다. 파이프는 2개의 연속된 칸을 차지하는 크기이다.
    파이프는 회전시킬 수 있으며, 아래와 같이 3가지 방향이 가능하다.
        →, ↘, ↓
    
    파이프는 매우 무겁기 때문에, 유현이는 파이프를 밀어서 이동시키려고 한다. 벽에는 새로운 벽지를 발랐기 때문에, 파이프가 벽을 긁으면 안 된다. 즉, 파이프는 항상 빈 칸만 차지해야 한다.
    파이프를 밀 수 있는 방향은 총 3가지가 있으며, →, ↘, ↓ 방향이다. 파이프는 밀면서 회전시킬 수 있다. 회전은 45도만 회전시킬 수 있으며, 미는 방향은 오른쪽, 아래, 또는 오른쪽 아래 대각선 방향이어야 한다.
    파이프가 가로로 놓여진 경우에 가능한 이동 방법은 총 2가지, 세로로 놓여진 경우에는 2가지, 대각선 방향으로 놓여진 경우에는 3가지가 있다.

    가장 처음에 파이프는 (1, 1)와 (1, 2)를 차지하고 있고, 방향은 가로이다. 파이프의 한쪽 끝을 (N, N)로 이동시키는 방법의 개수를 구해보자.

제한 사항:
    N(3 ≤ N ≤ 16)
    빈 칸은 0, 벽은 1로 주어진다. (1, 1)과 (1, 2)는 항상 빈 칸이다.
    시간 제한 1초
    메모리 제한 512MB

문제 풀이:
    파이프의 끝점을 (N,N)으로 이동시키는 모든 경우의 수를 구하는 문제이다.
    따라서 DFS를 사용하여 파이프에 끝점을 조건에 따라 이동시키면 모든 경우의 수를 구할 수 있다.

    파이프는 놓여진 방향에 따라서 이동할 수 있는 방법이 다르다.
    1. 가로로 놓여진 경우: 오른쪽, 대각선 아래
    2. 세로로 놓여진 경우: 아래, 대각선 아래
    3. 대각선으로 놓여진 경우: 오른쪽, 아래, 대각선 아래

    위의 조건에 따라서 분기하고 재귀적으로 수행한다.

    단, 3차원 메모이제이션을 사용하여 이미 방문한 좌표와 방향에 대해서는 다시 계산하지 않도록 한다.
    3차원을 선언하는 이유는 파이프의 방향에 따라서 이동할 수 있는 방법이 다르기 때문이다.

    DP로도 풀이가 가능하다.
    왜냐하면, 특정 좌표에 도달하는 방법의 수는 이전 좌표에서 도달하는 방법의 수의 합이기 때문이다.
    수능 수학에서 나오는 문제와 마찬가지로, 2차원 grid 형태의 문제에서 최단 경로로 도착지에 도달하는 방법에 수를 리턴하는 방법과 같다.
'''

import sys

def dfs(x,y,direction,n,house,memo):
    if x == n - 1 and y == n - 1:
        return 1
    
    if memo[x][y][direction] != -1:
        return memo[x][y][direction]
    
    paths = 0

    if direction == 0 or direction == 2:
        if y + 1 < n and house[x][y + 1] == 0:
            paths += dfs(x, y + 1, 0, n, house, memo)
    
    if direction == 1 or direction == 2:
        if x + 1 < n and house[x + 1][y] == 0:
            paths += dfs(x + 1, y, 1, n, house, memo)
    
    if x + 1 < n and y + 1 < n and house[x][y + 1] == 0 and house[x + 1][y] == 0 and house[x + 1][y + 1] == 0:
        paths += dfs(x + 1, y + 1, 2, n, house, memo)
    
    memo[x][y][direction] = paths
    return paths

def solution(n,house,memo):
    return dfs(0,1,0,n,house,memo)

def _solution(n,house):
    dp = [[[0]*3 for _ in range(n)] for _ in range(n)]
    dp[0][1][0] = 1

    for x in range(n):
        for y in range(n):
            # 수평 방향
            if y + 1 < n and house[x][y + 1] == 0:  # 오른쪽으로 이동 가능
                dp[x][y + 1][0] += dp[x][y][0]  # 수평 유지
            if x + 1 < n and y + 1 < n and house[x + 1][y + 1] == 0 and house[x][y + 1] == 0 and house[x + 1][y] == 0:
                dp[x + 1][y + 1][2] += dp[x][y][0]  # 대각선으로 이동

            # 수직 방향
            if x + 1 < n and house[x + 1][y] == 0:  # 아래로 이동 가능
                dp[x + 1][y][1] += dp[x][y][1]  # 수직 유지
            if x + 1 < n and y + 1 < n and house[x + 1][y + 1] == 0 and house[x][y + 1] == 0 and house[x + 1][y] == 0:
                dp[x + 1][y + 1][2] += dp[x][y][1]  # 대각선으로 이동

            # 대각선 방향
            if y + 1 < n and house[x][y + 1] == 0:  # 오른쪽으로 이동 가능
                dp[x][y + 1][0] += dp[x][y][2]  # 수평으로 이동
            if x + 1 < n and house[x + 1][y] == 0:  # 아래로 이동 가능
                dp[x + 1][y][1] += dp[x][y][2]  # 수직으로 이동
            if x + 1 < n and y + 1 < n and house[x + 1][y + 1] == 0 and house[x][y + 1] == 0 and house[x + 1][y] == 0:
                dp[x + 1][y + 1][2] += dp[x][y][2]  # 대각선으로 이동

    return sum(dp[n-1][n-1])

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    house = [list(map(int,sys.stdin.readline().strip().split())) for _ in range(n)]
    memo = [[[-1]*3 for _ in range(n)] for _ in range(n)]
    print(solution(n,house,memo))
    print(_solution(n,house))