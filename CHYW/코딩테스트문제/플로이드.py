'''
문제 설명:
    n개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1 ≤ m ≤ 100,000)개의 버스가 있다. 
    각 버스는 한 번 사용할 때 필요한 비용이 있다.
    모든 도시의 쌍 (A, B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하시오.

제한 사항:
    시간 제한 1초
    메모리 제한 256MB
    n(2 ≤ n ≤ 100)
    시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.

문제 풀이:
    문제의 제목과 같이  플로이드워셜 알고리즘으로 풀이하면된다.

    플로이드 워셜은 모든 정점 쌍 간의 최단 경로 알고리즘이며 동시에 다이나믹 프로그래밍이다.
    a -> b로 가는 최단 거리보다 a -> k를 거쳐 b로 가는 거리가 더 짧은지 검사한다.
    정점 쌍 (a,b) => (1,2) (1,3) ...은 2차원 배열로 나타낼 수 있다.
    
    2차원 배열에서 동작하는 점화식은 다음과 같다.
    dp[i][j] = min(dp[i][j],dp[i][k]+dp[k][j])

    단,시작 도시와 도착 도시를 연결하는 노선은 중복해서 나타나므로 그래프에 가장 작은 값이 들어가도록 구현해야한다.
'''

def solution(n,dp):
    for k in range(1,n+1):
        for i in range(1,n+1):
            for j in range(1,n+1):
                dp[i][j] = min(dp[i][j],dp[i][k]+dp[k][j])
    return dp

if __name__=="__main__":
    n = int(input())
    m = int(input())
    dp = [[float('inf')]*(n+1) for _ in range(n+1)]

    for i in range(n+1):
        dp[i][i] = 0

    for i in range(m):
        a,b,c = list(map(int,input().split()))
        dp[a][b]=min(dp[a][b],c)

    for _ in solution(n,dp)[1:]:
        print(*[i if i!=float('inf') else 0 for i in _[1:]])