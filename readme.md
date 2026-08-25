# search

Graph search algorithms.

## breadth

Breadth first search using a queue.

## depth

Depth first search using a stack.

## dijkstra-wavefront

A dorky implementation of Dijkstra which expands a wavefront of nodes while updating the distances. Not efficient, but very intuitive. Also will be useful in constructing other "wavefront" algorithms. The wavefront implementation is interesting because we can begin the wavefront at multiple disconnected points in a graph. The wave will still tell you which nodes are on its edge, and which are cheapest.

