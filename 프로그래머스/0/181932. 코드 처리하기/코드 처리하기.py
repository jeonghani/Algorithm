def solution(code):
    ret = ''
    mode=0
    
    for i in range(len(code)):
        if mode == 0 and code[i] == "1":
            mode = 1
        elif mode == 0 and i % 2 == 0:
            ret+=code[i]
        elif mode == 1 and code[i] == "1":
            mode = 0
        elif mode == 1 and i % 2 == 1:
            ret += code[i]
    return ret if len(ret)!=0 else 'EMPTY'