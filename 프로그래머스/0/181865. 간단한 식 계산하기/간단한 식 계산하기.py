def solution(binomial):
    answer = 0
    bin_split = binomial.split()
    
    if bin_split[1] == "+":
        return int(bin_split[0])+int(bin_split[2])
    elif bin_split[1] =="-":
        return int(bin_split[0])-int(bin_split[2])
    else:
        return int(bin_split[0])*int(bin_split[2])
    return answer