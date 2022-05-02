Demineur: Demineur.class Menu.class Case.class Game.class GameGrid.class MenuListener.class CaseListener.class EndScreen.class

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

MenuListener.class: MenuListener.java
	javac MenuListener.java

CaseListener.class: CaseListener.java
	javac CaseListener.java

EndScreen.class: EndScreen.java
	javac EndScreen.java

clean:
	rm *.class

run: Demineur
	java Demineur

.PHONY: clean run