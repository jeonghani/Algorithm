def solution(s):
    answer = []
    last = {}
    for i, char in enumerate(s):
        if char not in last:
            answer.append(-1)
        else:
            answer.append(i-last[char])
        last[char] = i
    return answer