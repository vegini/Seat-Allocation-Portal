



.PHONY: all 

all : documentation

GaleShapley: Algo1/GaleShapley.java Algo1/Meritlist.java Algo1/VirtualProgramme.java Algo1/Candidate.java
	
	javac Algo1/*.java
	java Algo1/GaleShapley
	

Meritlist: Algo2/Candidate.java Algo2/Meritlist.java Algo2/VirtualProgramme.java
	cd Algo2
	javac Meritorder.java
	java Meritorder
	cd ..

documentation:
	doxygen -g /Algo1/config
	doxygen /Algo1 config
	
	#mv latex html Algo1
	






