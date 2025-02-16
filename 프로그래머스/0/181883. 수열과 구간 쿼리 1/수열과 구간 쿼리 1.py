def solution(arr, queries):
    answer = arr
    for i in range(len(queries)):
        s = queries[i][0]
        e = queries[i][1]
        
        for j in range(s, e+1):
            answer[j]+=1
    return answer