def solution(s):
    idx = len(s)//2
    if len(s)%2==0:
        return s[idx-1]+s[idx]
    else:
        return s[idx]