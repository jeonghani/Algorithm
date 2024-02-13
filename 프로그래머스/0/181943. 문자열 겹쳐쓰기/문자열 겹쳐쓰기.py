def solution(my_string, overwrite_string, s):
    mylist = list(my_string)
    overlist = list(overwrite_string)
    mylist[s:s+len(overlist)] = overlist
    answer = ''.join(mylist)
    return answer