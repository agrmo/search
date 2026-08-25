from suche.tiefe.tiefensuche import tiefensuche
from graph.graph import Graph

# python -m suche.tiefe.main

def beispieleins():
    #                1 
    #              /
    # 0 ---- 5 - 2 - 4 - 11
    #         \
    #          3
    #           \
    #            6
    #      7
    #      |
    #      8 - 9 - 10
    #
    g = Graph(12,[[0,5],[5,2],[5,3],[3,6],[2,4],[2,1],[7,8],[8,9],[10,9],[11,4]])
    gesehen = tiefensuche(g, 0)
    print(gesehen)

    gesehen = tiefensuche(g, 8)
    print(gesehen)

def main():
    beispieleins()
    
if __name__ == "__main__":
    main()
