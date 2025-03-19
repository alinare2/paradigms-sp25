def move_robot(n):
    #intial position and steps
    curr_position = (0,0)
    positions = [curr_position]
    step_amount = 1 


    #directional matrix of the robot
    directions = [(0,1), (1,0), (0,-1), (-1,0)]
    direction = 0

    #iter through moves
    for i in range(n):
        x, y = directions[direction]
        
        #update position using step and direction matrix
        curr_position = (curr_position[0] + x* step_amount, curr_position[1] + y*step_amount)
        positions.append(curr_position)

        #get the new directional matrix index
        direction = (direction + 1) % 4 

        step_amount += 1
    
    return positions

# #testing
# for v in move_robot(10):
#     print(v)