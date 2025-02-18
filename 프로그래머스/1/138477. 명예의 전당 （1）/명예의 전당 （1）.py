def solution(k, score):
    answer = []
    li = []
    for i in range(len(score)):
        li.append(score[i])
        li.sort(reverse=True)
        if len(li)>k:
            li.pop(-1)
        answer.append(li[-1])
    return answer