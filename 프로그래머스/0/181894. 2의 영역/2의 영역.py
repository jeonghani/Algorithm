def solution(arr):
    answer = []
    two_index = [i for i, value in enumerate(arr) if value == 2]
    
    if len(two_index) == 0:
        answer = [-1]
    elif len(two_index) >= 2:
        answer = arr[two_index[0]: two_index[-1]+1]
    else:
        answer = [arr[two_index[0]]]
    
    return answer