def solution(my_string, queries):
    answer = list(my_string)
    for i in range(len(queries)):
        s = queries[i][0]
        e = queries[i][1]
        
        sub_str = answer[s:e+1][::-1]
        answer[s:e+1] = sub_str
    answer = ''.join(answer)
    return answer