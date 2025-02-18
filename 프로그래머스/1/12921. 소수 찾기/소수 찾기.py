def solution(n):
    li = [True] * (n+1)
    li[0] = li[1] = False
    
    for i in range(2, int(n**0.5)+1):
        if li[i]:
            for j in range(i*i, n+1, i):
                li[j] = False
    return sum(li)