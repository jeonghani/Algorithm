def solution(strArr):
    lenArr = [len(s) for s in strArr]
    cntArr = []
    
    for i in set(lenArr):
        cntArr.append(lenArr.count(i))
    return max(cntArr)