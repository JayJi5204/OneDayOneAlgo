'''
begin -> target로 바꿈
DFS/BFS 문제
'''

def check(x1:str,x2:str):
    '''
    문자열 x1,x2가 한 단어 빼고 같은지 확인한다.
    '''
    if len(x1) != len(x2):
        return False
    
    cnt=0
    for a,b in zip(x1,x2):
        if a!=b:
            cnt+=1
        if cnt==2:
            return False
        
    return True

answer = int(1e9)

def dfs(x,begin,target,words,visited):
    global answer
    
    if begin==target:
        answer = min(answer,x)
        return
    
    for i in range(len(words)):
        if not visited[i] and check(begin,words[i]):
            visited[i]=1
            dfs(x+1,words[i],target,words,visited)
            visited[i]=0
            
def solution(begin, target, words):
    
    if target not in words:
        return 0
    
    visited=[0]*len(words)
    dfs(0,begin,target,words,visited)
    
    return answer