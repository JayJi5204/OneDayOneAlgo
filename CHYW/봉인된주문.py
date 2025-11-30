def n2bit(x,n):
    answer = []
    while x>0:
        share = x//n
        remainer = x%n
        if remainer == 0:
            remainer=26
            share-=1
        answer.append(remainer)
        x = share
    return answer[::-1]

def alpha2n(x,n,table):
    import math
    answer=0
    x = x[::-1]
    for i in range(len(x)):
        answer += (math.pow(n,i) * table[x[i]])
    return int(answer)

def solution(n, bans):
    '''
    봉인된 주문의 패턴은 아래와 같다.

    "a"→"b"→"c"→"d"→"e"→"f"→...→"z"
    →"aa"→"ab"→...→"az"→"ba"→...→"by"→"bz"→"ca"→...→"zz"
    →"aaa"→"aab"→...→"aaz"→"aba"→...→"azz"→"baa"→...→"zzz"
    →"aaaa"→...→"aazz"→"abaa"→...→"czzz"→"daaa"→...→"zzzz"
    →"aaaaa"→ ...

    몇몇 주문을 삭제하면 그만큼 빈 공간을 앞에서 당겨와 채운다.
    주어진 n번째 주문을 찾는것이 목표이다.

    가장 쉽게 푼다면 완전탐색으로 테이블을 만든뒤에 배열 속에서 삭제 및 탐색을 진행한다.
    하지만 그렇게 한다면 시간초과가 되므로 테이블을 만들지 않고 진행해야한다.

    나의 아이디어
    주어진 변수는 10진수 n,알파뱃 이다. 문제를 보자 알파뱃은 26진수기에 26진수로 통일해야 겠다는 생각이 났다.
    변수를 하나의 단위로 통일하면 대소 비교가 가능하고 큰 값은 그대로 놔두고 작은 값들만 빼면 몇번 째인지 알 수 있기 때문이다.
    그리고 그게 곧 바로 정답으로 이어진다.

    나의 풀이
    1. 알파뱃은 26개 이므로 주어진 n을 26진수로 변환
    2. 주어진 알파뱃 또한 26진수로 변환
    3. 모두 26진수로 통일했으므로 대소 비교를 통해 n보다 작은 값이 발견되면 n+1을 해준다.
    4. 마지막으로 26진수를 알파뱃으로 변환한다.

    '''
    answer = ''
    
    table = {}
    for idx,i in enumerate('abcdefghijklmnopqrstuvwxyz',1):
        table[i] = idx
    
    bans = sorted(bans,key=lambda x:(len(x),x))
    
    for ban in bans:
        value = alpha2n(ban,26,table)
        if value > n:
            break
        n+=1

    n_26 = n2bit(n,26)
    
    alphabets = list('abcdefghijklmnopqrstuvwxyz')

    for i in n_26:
        answer+=alphabets[i-1]

    return answer