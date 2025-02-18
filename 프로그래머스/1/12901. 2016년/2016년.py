def solution(a, b):
    day = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    name = ['FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED', 'THU']
    days=0
    for i in range(a-1):
        days+=day[i]
    days+=b-1
    days = days%7
    return name[days]