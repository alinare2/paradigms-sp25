import math

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    def print(self):
        print(f'{self.x}, {self.y}')
    
    #distance functions
    def distance(self, obj):
        return math.sqrt((self.x - obj.x)**2 + (self.y-obj.y)**2)
    def distFromOrg(self):
        return math.sqrt((self.x - 0)**2 + (self.y-0)**2)
    
    #defining special methods
    def __gt__(self, obj):
        return self.distFromOrg() > obj.distFromOrg()
    def __ge__(self, obj):
         return self.distFromOrg() >= obj.distFromOrg()
    def __lt__(self, obj):
         return self.distFromOrg() < obj.distFromOrg()
    def __le__(self, obj):
         return self.distFromOrg() <= obj.distFromOrg()
    def __eq__(self, obj):
         return self.distFromOrg() == obj.distFromOrg()
        
#create points to test
p1 = Point(2,3)  
p2 = Point(-3,1) 
p3 = Point(-2,-3)

#test functionality
print(p1 > p2)
print(p1 == p2)
print(p1 < p2)
print(p1 == p3)