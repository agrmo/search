# search

Graph search algorithms.

## breadth

Breadth first search using a queue.

## depth

Depth first search using a stack.

## wavesearch

A neutered version of Dijkstra which doesn't consider prior distances, but rather simply expands a wavefront of nodes by selecting the cheapest edge from the wave. This is only a small step before Dijkstra, where you add in the prior distances into the calculation for selecting the cheapest edge. This does not always give shortest distances, like Dijkstra, but it could have other interesting properties about it. I'll call it "wavesearch" or maybe "Dumbstra." This will be useful in constructing other "wave" algorithms. The idea is interesting because we can begin the wave at multiple disconnected points in a graph. The wave will still tell you which nodes are on its edge, and which are cheapest.

## dijkstra

A dorky implementation of Dijkstra which expands a wavefront of nodes while updating the distances. Not efficient, but very intuitive. 

### example

```
            2   5      1
          1 - 7 - 3 ------4
              \   |        \
              4\  |2        \3
                \ | 1     3  \   3
                 0-----8------2------5
                  \   /        \
                  9\ /1         \2
                    10           \
                                  6
                                   \
                                    \3
                                     \
                                      9
```

Dijkstra returns the distances,

```
[6, 0, 10, 7, 8, 13, 12, 2, 7, 15, 8]
```

Compare this with Wavesearch (select the cheapest unseen edge),

```
[6, 0, 12, 8, 9, 15, 14, 2, 7, 17, 8]
```

