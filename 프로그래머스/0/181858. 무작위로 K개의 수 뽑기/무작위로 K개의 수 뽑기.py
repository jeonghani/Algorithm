def solution(arr, k):
    answer = []
    
    for i in range(len(arr)):
        if len(answer)>=k:
            break
        if arr[i] not in answer:
            answer.append(arr[i])
    if len(answer)<k:
        answer += [-1 for i in range(k-len(answer))]
    return answer