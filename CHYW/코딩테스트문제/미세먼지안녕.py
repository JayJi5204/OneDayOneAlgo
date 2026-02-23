"""
문제 설명:
    미세먼지를 제거하기 위해 구사과는 공기청정기를 설치하려고 한다. 
    공기청정기의 성능을 테스트하기 위해 구사과는 집을 키그가 RxC인 격자판으로 나타냈고, 
    1x1 크기의 칸으로 나눴다. 구사과는 뛰어난 코딩 실력을 이용해 (r,c)에 있는 미세먼지 양을 실시간으로 모니터링하는 시스템을 개발했다. 
    (r,c)는 r행,c열을 의미한다.

    공기청정기는 항상 1번 열에 설치외어 있고, 크기는 두 행을 차지한다. 공기 청정기가 설치되어 있지 않은 칸에는 미세먼지가 있고,(r,c)에 있는 미세먼지의 양은 $A_{r,c}$이다.
    1초 동안 아래 적힌 일이 순서대로 일어난다.
        1. 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
            - (r,c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
            - 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
            - 확산되는 양은 $A_{r,c} / 5$이고 소수점은 버린다. 즉, $|A_{r,c}/5|$
            - (r,c)에 남은 미세먼지의 양은 A_{r,c} - |A_{r,c}/5| x (확산된 방향의 개수)이다.
        
        2. 공기청정기가 작동한다.
            - 공기청정기에서는 바람이 나온다.
            - 위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
            - 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
            - 공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.

    방의 정보가 주어졌을 때, T초가 지난 후 구사과의 방에 남아있는 미세먼지의 양을 구해보자.     

제한 사항:
    시간 제한 1초 
    메모리 제한 512MB
    공기청정기가 설치된 곳은 $A_{r,c}$가 -1, 가장 윗 행, 아랫 행과 두 칸이상 떨어져 있다.

문제 풀이:
    구현 및 시뮬레이션 문제이다.
    1초 동안 아래의 규칙을 지키면된다.
        1. 미세먼지 확산(네 방향 확산)
        2. 공기청정기 작동(바람의 방향으로 미세먼지 1칸 이동)
    
    미세 먼지 확장은 완전 탐색을 할 필요 없이 BFS를 사용하면된다.(단, 모든 좌표가 큐에 들어가 있어야한다.)
    바람의 방향은 공기청정기의 좌표를 기준으로 테두리를 순회한다.(단, 위쪽 공기청정기는 반시계, 아래쪽 공기청정기는 시계방향으로 순회)

    문제에서는 t초가 주어진다. 
    시간을 1초 증가 시킬 때마다, BFS 및 이동 알고리즘을 실행한다.
"""

from collections import deque
dy,dx = [-1,0,1,0],[0,1,0,-1]

def init_queue(board):
    air_purifier=[]
    q = deque()
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] > 0:
                q.append((i,j,board[i][j]))
            if board[i][j] == -1:
                air_purifier.append((i,j))
    return (air_purifier,q)

def bfs(q:deque,board:list[list]):

    while q:
        y,x,cost = q.popleft()
        
        can_go = []
        for i in range(4):
            yy = y + dy[i]
            xx = x + dx[i]

            if 0<=yy<len(board) and 0<=xx<len(board[0]) and board[yy][xx] != -1:
                can_go.append((yy,xx))

        board[y][x] = board[y][x] - (int(cost/5))*len(can_go)
        
        for _yy,_xx in can_go:    
            board[_yy][_xx]+=(cost//5)

    return board


def cleanUp(y,x,d,board):
    v=0
    while True:
        yy = y + dy[d]
        xx = x + dx[d]
        if yy < 0 or yy >= len(board) or xx < 0 or xx >= len(board[0]):
            d=(d+3)%4
            continue
        else:
            if board[yy][xx] == -1:
                return board

            tmp = board[yy][xx]
            board[yy][xx] = v
            v=tmp
            y,x = yy,xx

def cleanDown(y,x,d,board):
    v=0
    while True:
        yy = y + dy[d]
        xx = x + dx[d]
        if yy < 0 or yy >= len(board) or xx < 0 or xx >= len(board[0]):
            d=(d+1)%4
            continue
        else:
            if board[yy][xx] == -1:
                return board

            tmp = board[yy][xx]
            board[yy][xx] = v
            v=tmp
            y,x = yy,xx
        

def getTotalDust(board,debug=False):
    answer=0
    for i in board:
        answer+=sum(i)
        if debug:
            print(i)
    return answer+2

def solution():
    R,C,T = map(int,input().split())
    board = []

    for _ in range(R):
        board.append(list(map(int,input().split())))   

    for t in range(T):
        air_purifier,q = init_queue(board)
        board = bfs(q,board)
        board = cleanUp(*air_purifier[0],1,board)
        board = cleanDown(*air_purifier[1],1,board)
    return getTotalDust(board)

if __name__=="__main__":
    print(solution())

