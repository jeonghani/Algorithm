def solution(my_string, s, e):
    sub = my_string[s:e+1]
    answer = my_string[:s] + sub[::-1]+my_string[e+1:]
    return answer