"""
문제 설명:
    중위 표기식을 후위 표기식으로 바꾼다.
    예를 들어 a+b*c는 (a+(b*c))로 바꾸고 
    그 다음에 안에 있는 괄호의 연산자 *를 괄호 밖으로 꺼내게 되면 (a+bc*)가 된다.
    마지막으로 +를 괄호의 오른쪽으로 고치면 abc*+가 되게 된다.

    즉 우선 순위가 높은 것들을 먼저 처리한 후 마지막에 남은 연산자들을 차례대로 빼준다.

    중위 표기식이 주어졌을 때 후위 표기식으로 고치는 프로그램을 작성

제한 사항:
    시간 제한 2초 
    메모리 제한 128MB
    표기식은 알파벳 대문자와 +, -, *, /, (, )로만 이루어져 있으며, 길이는 100을 넘지 않는다. 

문제 풀이:
    두 개의 스택을 활용하면 될 것같다.
    첫 번째 스택은 피연산자를, 두 번째 스택은 연산자를 담는다.
    첫 번째 스택은 피연산자 스택, 두 번째 스택은 연산자 스택이라고 하겠다.

    1. 연산자 스택 마지막에서 * 또는 /가 나올 때 마지막 스택을 비우면서 피연산자 스택에 더해준다.
    2. 그룹 연산자 ()가 나오게된다면 괄호가 닫힐 때 사이에 있는 연산자를 모두 비운다.  

"""

def solution():
    expression = list(input())
    stack = []
    answer = ''

    priority = { '*':2,'/':2, '+':1, '-':1,'(':0 }

    for exp in expression:
        if exp.isalpha():
            answer+=exp
        elif exp == '(':
            stack.append(exp)
        elif exp == ')':
            while stack and stack[-1] != '(':
                answer+=stack.pop()
            stack.pop()
        else:
            while stack and priority[stack[-1]] >= priority[exp]:
                answer+=stack.pop()
            stack.append(exp)

    while stack:
        answer+=stack.pop()
        
    return answer
if __name__=="__main__":
    print(solution())