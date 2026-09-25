mkdir -p classes
javac -d classes $(find src -type f) && java -cp classes suche.tiefe.Main
