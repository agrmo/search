# Tiefensuche
# 
# graph: Der Graph ist eine Nachbarschaftsliste. Der ungerichtete
# Graph muss keinen Zyklus haben.
#
# anfangsknoten: int
def tiefensuche(graph, anfangsknoten):

    # Fangen wir mit dem Anfangknoten an.
    zusehen = [anfangsknoten]
    gesehen = []

    # Während es Knoten zu sehen gibt.
    while len(zusehen) > 0:

        # Nehme den nächsten Knoten.
        naechste = zusehen.pop(0)

        # Der näechste Knoten ist gesehen.
        gesehen.append(naechste)

        # Für jeden seiner Nachbarn.
        for nachbar in graph.nachbarliste[naechste]:

            # Ist der Nachbar noch nicht gesehen, suche in diese
            # Richtung.
            if nachbar not in gesehen:
                zusehen.insert(0, nachbar)

    return gesehen
