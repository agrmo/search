# search

Search algorithms on various data structures.

## depth-undirected-node

Return the nodes from depth first search on an undirected graph.

### example

```
                     5       4
                      \     /
                       2   3
                        \ /
                    13-7-1-6-12
                        / \
                       8   9
                      /     \
                     10      11
```

returns

```
[1, 9, 11, 8, 10, 6, 12, 3, 4, 2, 5, 7, 13]
```

## depth-undirected-edge-node

Return the edges from depth first search on an undirected graph. Note very particularly that there are two kinds of DFS: DFS that groups the edges together from a node ("per-node DFS") and DFS that spelunks the edge strictly before the others from their parent ("per-edge DFS"). This is per-node DFS.

### example

```
                     5       4
                      \     /
                       2   3
                        \ /
                    13-7-1-6-12
                        / \
                       8   9
                      /     \
                     10      11
```

returns

```
[1, 7]
[1, 2]
[1, 3]
[1, 6]
[1, 8]
[1, 9]
[9, 11]
[8, 10]
[6, 12]
[3, 4]
[2, 5]
[7, 13]
```

## breadth-undirected-node

Return the nodes from depth first search on an undirected graph.

### example

```
                     5       4
                      \     /
                       2   3
                        \ /
                    13-7-1-6-12
                        / \
                       8   9
                      /     \
                     10      11
```

returns

```
[1, 7, 2, 3, 6, 8, 9, 13, 5, 4, 12, 10, 11]
```

## breadth-undirected-edge

Return the edges from depth first search on an undirected graph.

### example

```
                     5       4
                      \     /
                       2   3
                        \ /
                    13-7-1-6-12
                        / \
                       8   9
                      /     \
                     10      11
```

returns

```
[1, 7]
[1, 2]
[1, 3]
[1, 6]
[1, 8]
[1, 9]
[7, 13]
[2, 5]
[3, 4]
[6, 12]
[8, 10]
[9, 11]
```

## wavesearch

A neutered version of Dijkstra which doesn't consider prior distances, but rather expands a wavefront of nodes by selecting the cheapest edge to an unseen node. This is one step before Dijkstra, where you also consider prior distances in the calculation. This does not give shortest distances, whereas Dijkstra does, but it could have other interesting properties about it. I'll call it "wavesearch" or maybe "Dumbstra." This will be useful in constructing other "wave" algorithms. The idea is interesting because we can begin the wave at multiple disconnected points in a graph. The wave will still tell you which nodes are on its edge, and which are cheapest.

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

returns

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

returns

```
[6, 0, 10, 7, 8, 13, 12, 2, 7, 15, 8]
```
