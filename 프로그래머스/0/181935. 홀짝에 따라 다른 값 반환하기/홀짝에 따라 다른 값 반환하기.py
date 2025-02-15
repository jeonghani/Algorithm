def solution(n):
    ans = 0
    if n % 2 != 0 :
        for i in range(n+1):
            if i % 2 != 0:
                ans+=i
    else :
        for i in range(n+1):
            if i % 2 == 0:
                ans += i*i
    return ans