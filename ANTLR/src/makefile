JAVAC = javac
ANTLRC = antlr4

TARGET = Main
GEN_TARGET = Gen

ANTLR_SOURCE = ./Buff/Buff_1_1
PACKAGE_NAME = Buff

$(TARGET).class: $(ANTLR_SOURCE).class $(GEN_TARGET).class
	$(JAVAC) $(TARGET).java

$(ANTLR_SOURCE).class:
	$(ANTLRC) -package $(PACKAGE_NAME) $(ANTLR_SOURCE).g4

$(GEN_TARGET).class:
	$(JAVAC) $(GEN_TARGET).java

clean:
	$(RM) *.class