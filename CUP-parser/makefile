JAVAC = javac
CFLAGS = -cp .:java-cup-11b-runtime.jar 

JFLEXC = jflex
CUPC = cup

TARGET = main
LEXER_TARGET = Lexer
PARSER_TARGET = parser
SYM_TARGET = sym

GRAMMAR_SOURCE = grammar

$(TARGET).class: $(TARGET).java $(LEXER_TARGET).class $(PARSER_TARGET).class
	$(JAVAC) $(CFLAGS) $(TARGET).java

$(LEXER_TARGET).class: $(LEXER_TARGET).jflex
	$(JFLEXC) $(LEXER_TARGET).jflex

$(PARSER_TARGET).class: $(GRAMMAR_SOURCE).cup
	$(CUPC) $(GRAMMAR_SOURCE).cup

clean:
	$(RM) *.class $(LEXER_TARGET).java* $(PARSER_TARGET).java $(SYM_TARGET).java