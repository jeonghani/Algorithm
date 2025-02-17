def solution(n):
    li = list(str(n))
    print(li)
    li.sort(reverse=True)
    return int("".join(li))