'''
집에서 학교 까지 가는데 필요한 최단 경로의 경우의 수를 구하는 문제이다.
물에 잠긴 곳은 지나지 않는 규칙을 가지고 있다.
오른쪽, 아래쪽으로만 이동한다.

DP를 활용하면 쉽게 구할 수 있다. 
오른쪽, 아래쪽만 이동하므로 고려해야할 변수는 딱 2개 이기에, 점화식은 아래와 같다.

dp[i][j] = dp[i-1][j] + dp[i][j-1]

단, 물에 잠긴 곳은 0으로 처리해주면 된다.
주의해야할 점은 웅덩이의 좌표계가 반대로 되어있다는 점
'''
def solution(m, n, puddles):
    answer = 0
    puddles = [[y,x] for [x,y] in puddles]
    dp = [[0]*(m+1) for _ in range(n+1)]
    dp[1][1] = 1
    
    for i in range(1,n+1):
        for j in range(1,m+1):
            if i==1 and j==1: continue
            if [i,j] in puddles:
                dp[i][j]=0
            else:
                dp[i][j] = dp[i-1][j] + dp[i][j-1]

    return dp[-1][-1]%1000000007