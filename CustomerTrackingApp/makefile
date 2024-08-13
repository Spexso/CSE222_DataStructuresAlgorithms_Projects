# Variables
JC = javac
JFLAGS = -g
TARGET = CustomerTrackingSystem
SOURCES = customer.java corporate_customer.java retail_customer.java CustomerTrackingSystem.java order.java person.java ReadFileManager.java operator.java

# Default target
all: clean $(TARGET)

$(TARGET): $(SOURCES)
		$(JC) $(JFLAGS) $(SOURCES)

# Clean up
clean:
	rm -f *.class

# Run the program
run: $(TARGET).class
	java $(TARGET)

# Create jar file
jar: $(TARGET).class
	jar cvfe $(TARGET).jar $(TARGET) *.class

# Clean and rebuild
rebuild: clean all
