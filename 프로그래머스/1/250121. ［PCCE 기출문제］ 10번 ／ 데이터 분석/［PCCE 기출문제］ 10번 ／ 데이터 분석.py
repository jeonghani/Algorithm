def solution(data, ext, val_ext, sort_by):
    answer = []
    
    index = 0
    if ext == "code":
        index = 0
    elif ext == "date":
        index = 1
    elif ext == "maximum":
        index = 2
    elif ext == "remain": 
        index = 3
    
    answer.extend([x for x in data if x[index]<val_ext])
    
    sort_index = 0
    if sort_by == "code":
        sort_index = 0
    elif sort_by == "date":
        sort_index = 1
    elif sort_by == "maximum":
        sort_index = 2
    elif sort_by == "remain": 
        sort_index = 3
    
    answer.sort(key=lambda x:x[sort_index])
    print(answer)
    return answer