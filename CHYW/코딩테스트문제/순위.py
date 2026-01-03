"""
문제 설명:
    정확하게 순위를 매길 수 있는 선수의 수를 리턴하는 문제
문제 풀이:
    삼단 논법이 바로 떠오르는 문제이다.
    a>b, b<c 이면 a>c
    1이 2를 이기고 2가 3을 이기면 1은 3을 이긴다.
    삼단 논법하면 떠오르는 알고리즘은 플루이드 와샬이다.
    
    i번째 사람의 순위는 2가지 방법으로 결정 할 수 있다.
        1. i번째 사람이 다른 사람과 n-1번 경기를 함
        2. 이미 순위가 결정된 사람과 싸워 나온 승패를 이용
    
    이는, 바로 알 수도 있고, 한다리 건너건너 알 수 도 있다는 것 -> 플루이드 와샬을 이용한다.
    일반적인 경우 거처가는 정점이 있을 때 비용이 더 적은지 확인 하는 절차가 필요하다.
    하지만 지금은 연결이 됐는지만 확인하면된다.

"""
def solution(n, results):
    answer = 0
    ranks = [[0]*n for _ in range(n)]
    
    for win,lose in results:
        ranks[win-1][lose-1] = 1
        ranks[lose-1][win-1] = -1
    
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if i == j: continue
                if ranks[i][j] != 0: continue
                if ranks[i][k] == 1 and ranks[k][j] == 1:
                    ranks[i][j] = 1
                    ranks[j][i] = -1
                    
    for rank in ranks:
        if rank.count(0) == 1:
            answer+=1
    return answer