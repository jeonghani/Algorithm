def solution(arr, k):
    answer = arr
    for i in range(len(arr)):
        if k%2 == 0:
            answer[i] = arr[i]+k
        else:
            answer[i] = arr[i]*k
    return answer