def solution(id_list, report, k):
    answer = []
    report_list = {name:[] for name in id_list}
    report_count = {name:0 for name in id_list}
    stop_id = []
    for i in report:
        n, m = i.split()
        if m not in report_list[n]:
            report_list[n].append(m)
            report_count[m] += 1
    for i in report_count:
        if report_count[i] >= k:
            stop_id.append(i)
    
    for name in id_list:
        mail_count = 0
        for reported_user in report_list[name]:
            if reported_user in stop_id:
                mail_count+=1
        answer.append(mail_count)
    
    return answer