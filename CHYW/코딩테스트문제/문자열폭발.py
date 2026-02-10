'''
문제 설명:
    상근이는 문자열에 폭발 문자열을 심어 놓았다. 폭발 문자열이 폭발하면 그 문자열에서 사라지며,
    남은 문자열은 합쳐지게 된다.

    폭발은 다음과 같은 과정으로 진행된다.
        1. 문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발하게 된다. 남은 문자열을 순서대로 이어 붙여 새로운 문자열을 만든다.
        2. 새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수도 있다.
        3. 폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다.
    상근이는 모든 폭발이 끝난 후에 어떤 문자열이 남는지 구해보려고 한다. 
    남아있는 문자가 없는 경우가 있다. 이 때는 "FRULA"를 출력한다.
    폭발 문자열은 같은 문자를 두 개 이상 포함하지 않는다.

제한 사항
    시간 제한 2초
    메모리 128MB
    1<= 문자열 <= 1,000,000

문제 풀이:
    먼저 아래의 예제를 살펴보자,

    문자열: mirkovC4nizCC44
    폭발 문자열: C4

    C4를 삭제하면서, 합치면 -> mirkovnizCC44
    C4를 삭제하면서, 합치면 -> mirkovnizC4
    C4를 삭제하면서, 합치면 -> mirkovniz

    최종적으로 mirkovniz가 남는다.

    단순하게 풀이하면, 반복문을 돌면서 찾기 및 삭제를 한다.
    스택으로 문자열을 쌓으면서 해결하면 될 것 같다.
'''

def solution(string,bomb_str):
    stack = []

    for i in range(len(string)):
        stack.append(string[i])
        if stack[-len(bomb_str):] == bomb_str:
            for _ in range(len(bomb_str)):
                stack.pop()

    return ''.join(stack) if stack else "FRULA"

if __name__=="__main__":
    string,bomb_str = list(input()),list(input())
    print(solution(string,bomb_str))