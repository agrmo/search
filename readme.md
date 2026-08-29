# search

Search algorithms on various data structures.

## depth-binary-tree

Serial recursive depth first search on a binary tree. Will be useful for Priority Queue implementations.

### example

```
             3
            / \
           /   \
          /     \
         5       2
        / \     / \
       1   9   5   8
```

Returns

```
[3, 2, 8]
```

## breadth-undirected

Breadth first search on an undirected graph.

## depth-undirected

Depth first search on an undirected graph.

## wavesearch

A neutered version of Dijkstra which doesn't consider prior distances, but rather expands a wavefront of nodes by selecting the cheapest edge to an unseen node. This is one step before Dijkstra, where you add in the prior distances into the calculation for selecting the cheapest edge. This does not always give shortest distances, like Dijkstra, but it could have other interesting properties about it. I'll call it "wavesearch" or maybe "Dumbstra." This will be useful in constructing other "wave" algorithms. The idea is interesting because we can begin the wave at multiple disconnected points in a graph. The wave will still tell you which nodes are on its edge, and which are cheapest.

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

Wavesearch returns

```
[6, 0, 12, 8, 9, 15, 14, 2, 7, 17, 8]
```

## dijkstra

A dorky implementation of Dijkstra which expands a wavefront of nodes while updating the distances. Not efficient, but intuitive.

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

Dijkstra returns the distances (select cheapest distance),

```
[6, 0, 10, 7, 8, 13, 12, 2, 7, 15, 8]
```
