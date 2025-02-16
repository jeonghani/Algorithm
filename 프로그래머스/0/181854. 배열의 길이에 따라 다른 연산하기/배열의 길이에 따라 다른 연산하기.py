def solution(arr, n):
    answer = arr
    
    if len(arr)%2==0:
        answer = [value+n if i%2==1 else value for i, value in enumerate(answer)]
    else:
        answer = [value+n if i%2==0 else value for i, value in enumerate(answer)]
    
    return answer