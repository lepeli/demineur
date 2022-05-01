Demineur: Demineur.class Menu.class Case.class Game.class GameGrid.class

Demineur.class: Demineur.java
	javac Demineur.java

Case.class: Case.java
	javac Case.java

Menu.class: Menu.java
	javac Menu.java	

Game.class: Game.java
	javac Game.java

GameGrid.class: GameGrid.java
	javac GameGrid.java

clean:
	rm *.class

run: Demineur
	java Demineur

.PHONY: clean run