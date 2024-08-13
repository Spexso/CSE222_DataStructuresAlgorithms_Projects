JC = javac
JFLAGS = -g
TARGET = Core
SOURCES = Core.java Person.java SocialNetworkGraph.java

default: clean $(TARGET) run

$(TARGET): $(SOURCES)
		$(JC) $(JFLAGS) $(SOURCES)

run: $(TARGET)
		java $(TARGET)

clean:
		rm -f *.class

.PHONY: clean default run