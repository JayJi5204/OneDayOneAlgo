import sys
from collections import defaultdict

input = sys.stdin.readline

n,m = map(int,input().split())

db = defaultdict(str)
index_db = defaultdict(str)

for i in range(1,n+1):
    string = input().replace('\n','')
    idx = str(i)
    db[string] = idx
    index_db[idx] = string

for _ in range(m):
    question = input().replace('\n','')
    if db.get(question,None) is not None:
        print(db[question])
    elif index_db.get(question,None) is not None:
        print(index_db[question])