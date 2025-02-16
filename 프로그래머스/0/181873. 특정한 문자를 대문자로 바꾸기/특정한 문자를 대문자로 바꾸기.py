def solution(my_string, alp):
    answer = ''
    for i in my_string:
        answer+=i.upper() if i==alp else i
    return answer