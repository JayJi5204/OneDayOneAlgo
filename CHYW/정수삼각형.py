'''
정수 삼각형은 거쳐간 숫자의 합이 가장 큰 경우를 찾아보는 것이다.
완전 탐색으로 접근할 경우 n^2이 될 수 있겠지만 전형적인 DP이기 때문에

DP문제로 접근한다.

아래의 수 중 왼쪽 오른쪽, 둘 중 한칸만 움직이는 문제이기 때문에
아래와 같이 점화식을 세우면 최댓값을 리턴할 수 있다.

dp[i+1][j] = max(triangle[i+1][j] + dp[i][j],dp[i+1][j])
dp[i+1][j+1] = max(triangle[i+1][j+1] + dp[i][j],dp[i+1][j+1])
'''

def solution(triangle):
    answer = 0
    n = len(triangle)
    dp = [[0]*n for _ in range(n)]
    dp[0][0] = triangle[0][0]
    
    for i in range(n-1):
        for j in range(len(triangle[i])):
            dp[i+1][j] = max(triangle[i+1][j] + dp[i][j],dp[i+1][j])
            dp[i+1][j+1] = max(triangle[i+1][j+1] + dp[i][j],dp[i+1][j+1])
    return max(dp[-1])