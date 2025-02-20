def solution(s):
    li = list(map(int, s.split(' ')))
    answer = f"{min(li)} {max(li)}"
    return answer