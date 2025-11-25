def solution1():
    """
    연산자 끼워 넣기
    주어진 수열 사이에 연산자를 끼워넣는다.
    만들 수 있는 식의 결과가 최대인 것과 최소인것을 구한다.
    연산자의 순서에 따라 최대 최소가 결정되므로 순열을 사용하여 경우의 수를 구한다.
    수열의 길이는 100이하 이므로 순열을 사용해도 충분히 구현 가능
    입력: 수열과 연산자
    출력: 최대값 최소값
    """
    from itertools import permutations

    answer = [-int(1e9), int(1e9)]
    N = int(input())
    arr = list(map(str,input().split()))
    operator = list(map(int,input().split()))
    operators = []
    for a,b in zip(['+','-','*','//'],operator):
        operators.extend([a]*b)
        
    for p in permutations(operators,len(operators)):
        total_expression = arr[0]
        expression = arr[0]
        cal = 0
        for i in range(len(arr)-1):
            total_expression+=p[i]
            total_expression+=arr[i+1]
            expression+=p[i]
            expression+=arr[i+1]
            #음수를 양수로 나눌 때
            if expression[0] == '-' and p[i] == '//':
                cal=eval(expression[1:])
                cal*=-1
            else:
                cal=eval(expression)
                
            expression = str(cal)
        if answer[0] < cal:
            answer[0] = cal
        if answer[1] > cal:
            answer[1] = cal

    for ans in answer:
        print(ans)
    return

def solution2():
    '''
    첫번 째 풀이에서는 완전탐색을 이용했고, 결과는 시간초과
    백트레킹 방식 왔던 길을 되돌아 가며 가지치기하는 방식으로 탐색
    즉 연산자의 개수 만큼 탐색
    '''
    answer = [-int(1e9), int(1e9)]
    N = int(input())
    arr = list(map(int,input().split()))
    add,sub,mul,div, = map(int,input().split())


    def dfs(x,add,sub,mul,div,_sum):
        global answer
        if x == N:
            answer[0] = max(answer[0],_sum)
            answer[1] = min(answer[1],_sum)
            return
        
        if add:
            dfs(x+1,add-1,sub,mul,div,_sum + arr[x])
        if sub:
            dfs(x+1,add,sub-1,mul,div,_sum - arr[x])
        if mul:
            dfs(x+1,add,sub,mul-1,div,_sum * arr[x])
        if div:
            dfs(x+1,add,sub,mul,div-1,int(_sum / arr[x]))

    dfs(1,add,sub,mul,div,arr[0])
    print(answer[0])
    print(answer[1])
    return