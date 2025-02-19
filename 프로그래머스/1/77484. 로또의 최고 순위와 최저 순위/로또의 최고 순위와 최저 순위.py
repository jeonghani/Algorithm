def solution(lottos, win_nums):
    cnt = 0
    cnt_0 = 0
    for num in lottos:
        if num in win_nums:
            cnt+=1
        if num == 0:
            cnt_0 += 1
    
    def get_rank(count):
        if count == 6:
            return 1
        elif count == 5:
            return 2
        elif count == 4:
            return 3
        elif count == 3:
            return 4
        elif count == 2:
            return 5
        else:
            return 6
    
    high = get_rank(cnt_0+cnt)
    low = get_rank(cnt)
    return [high, low]