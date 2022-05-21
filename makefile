JC = javac -encoding UTF-8 -implicit:none

Demineur: Demineur.class Menu.class Case.class Game.class EndScreen.class Options.class Save.class

Demineur.class: Demineur.java
	${JC} Demineur.java

Case.class: Case.java CaseListener.class
	${JC} Case.java

Menu.class: Menu.java MenuListener.class
	${JC} Menu.java

Game.class: Game.java GameGrid.class
	${JC} Game.java

GameGrid.class: GameGrid.java
	${JC} GameGrid.java

MenuListener.class: MenuListener.java
	${JC} MenuListener.java

CaseListener.class: CaseListener.java
	${JC} CaseListener.java

EndScreen.class: EndScreen.java EndScreenListener.class
	${JC} EndScreen.java

EndScreenListener.class: EndScreenListener.java
	${JC} EndScreenListener.java

Options.class: Options.java MenuListener.class
	${JC} Options.java

Save.class: Save.java
	${JC} Save.java

clean:
	rm -rf *.class doc/

run: Demineur
	java Demineur

debug: Demineur

	java Demineur 2> debug.txt

doc:
	javadoc -d doc/ *.java

.PHONY: clean run doc debug