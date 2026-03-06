"""
문제 설명:
    피보나치 수를 구하는 프로그램을 작성한다.
    피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.

    이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.

    n=17일때 까지 피보나치 수를 써보면 다음과 같다.

    0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
    첫째 줄에 n번째 피보나치 수를 1,000,000,007으로 나눈 나머지를 출력한다.

제한 사항:
- 시간제한 1초
- 메모리제한 256MB
- n은 1,000,000,000,000,000,000보다 작거나 같은 자연수이다.

문제 풀이:
    n의 크기가 해가 넘어간다.
    dp를 사용한다해도 통과가 불가능하다.

    문제를 찾아보니 이 문제는 도가뉴 항등식이란 피나보나치 수열에서 성립하는 아래의 항등식을 적용해야한다고 한다.
    도가뉴 항등식이란 피보나치 수열에서 성립하는 아래의 항등식을 말한다.

    F_{m+n} = F_{m-1}F_{n} + F_{m}F_{n+1}

    이 항등식을 짝수(m대신 n대입)와 홀수(m 대신 n+1 대입)로 나누어서 변형하면 아해의 두항등식이 나오게 된다.
    F_{2n} = F_{n}(F_{n} + 2F_{n-1})
    F_{2n+1} = F^2_{n} + F^2_{n+1}

    dp 함수 내에서 i 값의 짝수 홀수를 판별하여 해당하는 항등식을 이용하여 값을 계산하고 해당값을 1,000,000,007로 나누어 저장해둔 후 사용하는 방식으로 구현한다.
    .
    덧셈, 뺄셈, 곱셈에 대한 모듈러 산술 연산 분배 법칙은 아래와 같다.
    (A±B)modC=(AmodC±BmodC)modC
    (A∗B)modC=(AmodC∗BmodC)modC


    다른 풀이 방법으로 선형대수학과 행렬을 이용할 수 있다.
    선형방정식을 풀 때 여러개의 연립방정식이 주어진다면 하나의 행렬 꼴로 표현하게 될 경우 선형 방정식의 해가 존재하는지 없는지 판단을 하기 쉬워진다.
    가우스 소거, 크래머 공식 등 여러 방법에 의해 쉽게 미지수에 대한 답 혹은 일반항을 찾을 수 있다.

    즉, 우리가 해야할 일은 선형방정식을 행렬 꼴로 변환하는 것이다.
    피보나치 방정식을 Ax=b 형태의 행렬로 만드는 것이다.

    피보나치 방정식을 행렬로 표현한다면 다음과 같다.
    a [F_{n+2}] = [1 1][F_{n+1} F_{n}]^T

    하지만, 이것만으로는 행렬 연산을 통해 의미를 얻을 수 있는 수식은 아니다. 
    F라는 방정식에 대해 n번째 값을 구하기 위해 Ax=b 꼴로 만들어야한다.
    그러기 위해 x인 [F_{n+1} F_{n}]^T를 공통으로 둘 수 있는 하나의 간단한 식을 추가해야한다.
    b [F_{n+1}] = [1 0][F_{n+1} F_{n}]^T

    그리고 a와b를 합쳐 다음과 같은 행렬 꼴을 만든다.
    $$\begin{pmatrix} F_{n+2} \\ F_{n+1} \end{pmatrix} = \begin{pmatrix} 1 & 1 \\ 1 & 0 \end{pmatrix} \begin{pmatrix} F_{n+1} \\ F_n \end{pmatrix}$$

    위의 두 식(a,b)을 행렬의 곱셈 구조로 나타내면, 현재 상태를 이용헤 다음 상태를 만들겠다는 의미가 된다. 
    즉, 현재 상태를 선형 변환을 통해 다음 상태로 만들 수 있게된다.

    이 과정을 반복하여 n=1 부터 시작해서 대입해보면 규칙이 보인다.
    $\begin{pmatrix} F_2 \\ F_1 \end{pmatrix} = \begin{pmatrix} 1 & 1 \\ 1 & 0 \end{pmatrix} \begin{pmatrix} F_1 \\ F_0 \end{pmatrix}$
    $\begin{pmatrix} F_3 \\ F_2 \end{pmatrix} = \begin{pmatrix} 1 & 1 \\ 1 & 0 \end{pmatrix} \begin{pmatrix} F_2 \\ F_1 \end{pmatrix} = \begin{pmatrix} 1 & 1 \\ 1 & 0 \end{pmatrix}^2 \begin{pmatrix} F_1 \\ F_0 \end{pmatrix}$

    이를 일반화하면 다음과 같은 식으로 일반화 할 수 있다.
    $$\begin{pmatrix} F_{n+1} \\ F_n \end{pmatrix} = \begin{pmatrix} 1 & 1 \\ 1 & 0 \end{pmatrix}^n \begin{pmatrix} F_1 \\ F_0 \end{pmatrix}$$

    위 식은 n이 행렬의 거듭제곱으로 들어가므로 분할 정복으로 풀면된다.
    단, 홀수일 때와 짝수 일때를 구분하여 코드를 작성한다.
"""

import sys
sys.setrecursionlimit(10**8)


memo={}
memo[0]=1
memo[1]=1
memo[2]=1
def dfs(i):
    if i not in memo:
        if i %2==0:
            memo[i] = (dfs(i//2) * (dfs(i//2) + 2*dfs(i//2-1)))%1_000_000_007
        else:
            memo[i] = (dfs(i//2)**2 + dfs(i//2+1)**2)%1_000_000_007
    return memo[i]

def solution1():
    n = int(input())
    return dfs(n)

def multifly_matrix(A:list[list],x:list[list],mod:1000000007):
    """
    입력의 모양과 출력의 모양은 같아야한다.
    return Ax=b
    """
    b = [[0]*2 for _ in range(2)]

    for i in range(2):
        for j in range(2):
            for k in range(2):
                b[i][j] += (A[i][k] * x[k][j])
            b[i][j]%=mod
    return b

def dfs(n,A,mod=1_000_000_007):
    """
    Ax=b
    """
    if n == 1:
        return A
    
    _A = dfs(n//2,A)

    if n%2==0:
        return multifly_matrix(_A,_A,mod)
    else:
        return multifly_matrix(multifly_matrix(_A,_A,mod),A,mod)
    
def solution2():
    n = int(input())
    A = [[1,1],[1,0]]
    x = [1,0]
    return dfs(n,A)[0][1]

print(solution1())
print(solution2())
