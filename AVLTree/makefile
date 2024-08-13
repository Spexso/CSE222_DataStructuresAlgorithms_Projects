JC = javac
JFLAGS = -g
TARGET = Core
SOURCES = Core.java Stock.java AVLTree.java StockDataManager.java ProcessHandler.java GUIVisualization.java

default: clean $(TARGET) run

$(TARGET): $(SOURCES)
		$(JC) $(JFLAGS) $(SOURCES)

run: $(TARGET)
		java -Djava.compiler=NONE -Xint $(TARGET) input

clean:
		rm -f *.class

.PHONY: clean default run