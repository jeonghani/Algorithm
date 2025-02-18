def solution(name, yearning, photo):
    answer = []
    for i in range(len(photo)):
        res = 0
        for j in range(len(photo[i])):
            if photo[i][j] in name:
                res+=yearning[name.index(photo[i][j])]
        answer.append(res)
    return answer