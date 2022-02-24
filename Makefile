all:run

makeDir:
	mkdir -p class

compile:makeDir src/Main.java src/GetRandomWord.java
	javac -d class src/*

run:compile
	java -cp class Main

clean:
	rm -rf class
