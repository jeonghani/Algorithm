def solution(today, terms, privacies):
    answer = []
    
    year, month, day = map(int, today.split('.'))
    today_days = (year * 12 * 28) + (month * 28) + day

    term_dict = {}
    for term in terms:
        n, mon = term.split()
        term_dict[n] = int(mon) * 28
    
    for i, privacy in enumerate(privacies, start=1):
        date, x = privacy.split()
        p_year, p_month, p_day = map(int, date.split('.'))
        
        expire_days = (p_year * 12 * 28) + (p_month * 28) + p_day + term_dict[x] - 1
        
        if expire_days < today_days:
            answer.append(i)
        
    return answer