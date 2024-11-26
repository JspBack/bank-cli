build:
	javac *.java
	jar cfe Main.jar Main *.class
	java -jar main.jar