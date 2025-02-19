def solution(board, moves):
    answer = 0
    stack = []
    
    rows = len(board)
    cols = len(board[0])
    new_board = []
    
    for i in range(cols):
        new_board.append([board[j][i] for j in range(rows)])
    
    for move in moves:
        move -= 1
        for i in range(rows):
            if new_board[move][i] != 0:
                doll = new_board[move][i]
                new_board[move][i] = 0
                
                stack.append(doll)
                
                while len(stack)>=2 and stack[-1] == stack[-2]:
                    stack.pop()
                    stack.pop()
                    answer += 2
                break
        
    return answer