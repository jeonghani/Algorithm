def solution(arr, queries):
    answer = [0 for i in range(len(queries))]
    
    for i in range(len(queries)):
        s = queries[i][0]
        e = queries[i][1]
        k = queries[i][2]
        
        num_min = float('inf')
        for j in range(s, e+1):
            if arr[j]>k and arr[j]<num_min:
                num_min = arr[j]
        if num_min == float('inf'):
            num_min = -1
        answer[i] = num_min
    
    return answer