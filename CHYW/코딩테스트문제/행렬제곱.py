'''
문제 설명:
    크기가 NxN 행렬 A가 주어진다. 이때, A의 B제곱을 리턴.
    수가 매우 커질 수 있으니, A^B의 각 원소를 1,000으로 나눈 나머지를 출력 

제한 사항:
    시간 제한 1초
    메모리 제한 256MB
    2 ≤ N ≤  5
    1 ≤ B ≤ 100,000,000,000

문제 풀이:
    A^n x A^m = A^n+m이 성립한다.
    또한 일반적으로 AB = BA가 성립하지 않지만, 제곱은 자기 자신의 곱이므로 성립한다.
    즉, 교환 법칙이 성립한다는 뜻이므로, 
    우리는 power함수가 그러하듯 분할 정복을 사용해 log n으로 풀이할 수 있다.

    A^10 을 예로 들어보자

    A^10 = A^5 x A^5
    A^5 = A^2 x A^2 x A^1
    A^2 = A^1 x A^1
    A^1 = A

    시간 복잡도를 log n으로 줄일 수 있다.

    이제 A^2 일 때의 행렬의 계산 방법을 살펴보자
    일반적으로 진행 했을 경우 n^3의 시간 복잡도가 나온다.

    A^2 = a b c a b c a^2+ad+ag b^2+be+bh c^2+cf+ci
          d e f d e f ad+d^2+dg be+e^2+he cf+f^2+fi
          g h i g h i ag+dg+g^2 bh+he+h^2 ci+fi+i^2

    하지만, 입력으로 주어지는 A가 매우 작으므로, n^3로 진행해도 무방하다.
'''

def multiply_matrix(A:list[list],B:list[list],C:int):
    n,m = len(A),len(B)
    matrix = [[0]*m for _ in range(n)]

    for i in range(n):
        for j in range(m):
            for k in range(n):
                matrix[i][j] += (A[i][k] * B[k][j])
            matrix[i][j]%=C
    return matrix

def dfs(A:list[list],B:int,C:int):

    if B == 1:
        for i in range(len(A)):
            for j in range(len(A)):
                A[i][j] %= C
        return A
    
    _A = dfs(A,B//2,C)

    if B%2==0:
        return multiply_matrix(_A,_A,C)
    else:
        return multiply_matrix(A,multiply_matrix(_A,_A,C),C)

def solution(A:list[list],B:int,C):

    return dfs(A,B,C)
    
if __name__=="__main__":
    n,B = list(map(int,input().split()))
    A = []
    for i in range(n):
        A.append(list(map(int,input().split())))
    
    for answer in solution(A,B,C=1000):
        print(*answer)
