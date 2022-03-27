class Node:
    def __init__(self, parent, element, left=None, right=None):
        self.parent = parent
        self.element = element
        self.left = left
        self.right = right
        self.depth = parent.depth + 1 if parent is not None else 0

    def setleft(self, element):
        self.left = Node(self, element)
        return self.left
    
    def setright(self, element):
        self.right = Node(self, element)
        return self.right

    def children(self):
        return (self.left, self.right) 

    def isroot(self):
        return self.parent == None
    
    def haschildren(self):
        return None not in self.children()

    def isleft(self):
        if not self.isroot():
            return self.parent.left == self
        return False

def printtree(startingnode, depth):
    def build(*args):
        print(*args, sep='', end='')

    for d in range(depth-1):
        build('|   ')

    if depth > 0:
        build('+–––')
    print(startingnode.element)

    if not startingnode.haschildren():
        return

    for child in reversed(startingnode.children()):
        printtree(child, depth+1)

    for d in range(depth):
        build('|   ')
    print()

root = Node(None, 0)
nR = root.setright(1)
nL = root.setleft(2)
nRR = nR.setright(3)
nRL = nR.setleft(4)
nLR = nL.setright(5)
nLL = nL.setleft(6)
nRRR = nRR.setright(7)
nRRL = nRR.setleft(8)
nRRL.setright(9)
nRRL.setleft(10)

printtree(root, 0)
