def solution(arr):
    answer = 0
    prev = arr
    
    while True:
        curr = []
        
        for i in prev :
            if i>=50 and i%2==0:
                curr.append(i//2)
            elif i<50 and i%2==1:
                curr.append(i*2+1)
            else:
                curr.append(i)
        if prev == curr:
            break
        answer+=1
        prev=curr
    return answer