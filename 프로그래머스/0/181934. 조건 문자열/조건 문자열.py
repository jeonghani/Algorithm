def solution(ineq, eq, n, m):
    ans = 0
    if ineq == '>':
        if eq == '=':
            ans = 1 if n>=m else 0
        else :
            ans = 1 if n>m else 0
    else :
        if eq == '=':
            ans = 1 if n<=m else 0
        else :
            ans = 1 if n<m else 0
    return ans