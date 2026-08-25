# Breitensuche
#
# graph: graph.graph.Graph
# Eine Nachbarschaftsliste. Der ungerichtete Graph muss keinen Zyklus haben.
#
# anfangknoten: int
# Name des Knoten
def breitensuche(graph, anfangknoten):

    # Fangen wir mit dem Anfangknoten an.
    zusehen = [anfangknoten]
    gesehen = set()

    # Während es Knoten zu sehen gibt.
    while len(zusehen) > 0:

        # Der näechste Knoten.
        naechste = zusehen.pop(0)

        # Der näechste Knoten ist gesehen.
        gesehen.add(naechste)
        
        for nachbar in graph.nachbarliste[naechste]:

            # not in gesehen: O(1)
            if nachbar not in gesehen:
                zusehen.append(nachbar)

    return gesehen
