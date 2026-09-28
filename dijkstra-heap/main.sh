mkdir -p classes
javac -d classes $(find src -type f) && java -cp classes suche.dijkstra.haufen.Main
