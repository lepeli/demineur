Demineur: Demineur.class Menu.class
Demineur.class: Demineur.java
	javac Demineur.java
Case.class: Case.java
	javac Case.java
Menu.class: Menu.java
	javac Menu.java	
clean:
	rm *.class
run: Demineur
	java Demineur
.PHONY: clean run