Demineur: Demineur.class
Demineur.class: Demineur.java
	javac Demineur.java
clean:
	rm *.class
run: Demineur
	java Demineur
.PHONY: clean run