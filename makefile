JC = javac -encoding UTF-8 -implicit:none

Demineur: Demineur.class Menu.class Case.class Game.class GameGrid.class MenuListener.class CaseListener.class EndScreen.class EndScreenListener.class Options.class

Demineur.class: Demineur.java
	${JC} Demineur.java

Case.class: Case.java
	${JC} Case.java

Menu.class: Menu.java
	${JC} Menu.java

Game.class: Game.java
	${JC} Game.java

GameGrid.class: GameGrid.java
	${JC} GameGrid.java

MenuListener.class: MenuListener.java
	${JC} MenuListener.java

CaseListener.class: CaseListener.java
	${JC} CaseListener.java

EndScreen.class: EndScreen.java
	${JC} EndScreen.java

EndScreenListener.class: EndScreenListener.java
	${JC} EndScreenListener.java

Options.class: Options.java
	${JC} Options.java

Save.class: Save.java
	${JC} Save.java

clean:
	rm *.class

run: Demineur
	java Demineur

.PHONY: clean run