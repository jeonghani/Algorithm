def solution(video_len, pos, op_start, op_end, commands):
    op_start_m, op_start_s = map(int, op_start.split(':'))
    op_end_m, op_end_s = map(int, op_end.split(':'))
    len_m, len_s = map(int, video_len.split(':'))
    cur_m, cur_s = map(int, pos.split(':'))
    
    for i in commands:
        if op_start_m * 60 + op_start_s <= cur_m * 60 + cur_s <= op_end_m * 60 + op_end_s:
            cur_m, cur_s = op_end_m, op_end_s
            
        cur_m = int(cur_m)
        cur_s = int(cur_s)
        
        if i == 'prev':
            cur_s = cur_s-10
            if cur_s < 0:
                cur_m = cur_m - 1
                cur_s += 60
        elif i == 'next':
            cur_s = cur_s + 10
            if cur_s >= 60:
                cur_m = cur_m + 1
                cur_s -= 60
                
        if cur_m < 0:
            cur_m, cur_s = 0, 0
        if cur_m * 60 + cur_s > len_m * 60 + len_s:
            cur_m, cur_s = len_m, len_s
    
    if op_start_m * 60 + op_start_s <= cur_m * 60 + cur_s <= op_end_m * 60 + op_end_s:
        cur_m, cur_s = op_end_m, op_end_s
        
    return '{:02d}:{:02d}'.format(cur_m, cur_s)