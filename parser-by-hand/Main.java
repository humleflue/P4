import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    private static TokenStream ts = new TokenStream(new ArrayList<String>(
        Arrays.asList("numberdcl", "id", "lparen", "rparen", "assign", "numberval", "plus", "numberval", "minus", "numberval", "semicolon","$")
    ));

    public static void main(String[] args) {
        Dcls();
        Stmts();
        match(ts, "$");
        System.out.print("Parsing successful");
    }

    public static void match(TokenStream ts, String token) {
        if(ts.peek() == token) {
            System.out.print("Successfully matched " + token + "\n");
            ts.advance();
        }
        else {
            String errorMessage = String.format("Expected token %s, but got %s.", token, ts.peek());
            throw new UnexpectedTokenException(errorMessage);
        }
    }

    private static void Stmts() {
        switch(ts.peek()) {
            case "textval": case "id": case "lparen": case "numberval":
                Stmt();
                match(ts, "semicolon");
                Stmts();
                break;
            default: break;
        }
	} 

	private static void Dcls() {
        if(ts.peek() == "numberdcl" || ts.peek() == "textdcl") {
            Dcl();
            match(ts, "semicolon");
            Dcls();
        }
	} 

	private static void Dcl() {
        Type();
        match(ts, "id");
        match(ts, "lparen");
        Dclparams();
        match(ts, "rparen");
        match(ts, "assign");
        Stmt();
	} 

	private static void Stmt() {
        if(ts.peek() == "textval") {
            match(ts, "textval");
        }
        else {
            Math();
        }
	} 

	private static void Math() {
        Term();
        Followterm();
	} 

	private static void Followterm() {
        if(ts.peek() == "plus" || ts.peek() == "minus") {
            Simpleops();
            Math();
        }
        
	} 

	private static void Simpleops() {
        if(ts.peek() == "plus") {
            match(ts, "plus");
        }
        else {
            match(ts, "minus");
        }
    }

    private static void Term() {
        if(ts.peek() == "id") {
            Funccall();
        }
        else {
            Val();
        }
	} 

	private static void Val() {
        if(ts.peek() == "lparen") {
            match(ts, "lparen");
            Math();
            match(ts, "rparen");
        }
        else {
            match(ts, "numberval");
        }
	} 

	private static void Funccall() {
        match(ts, "id");
        match(ts, "lparen");
        Stmtparams();
        match(ts, "rparen");
	} 

	private static void Stmtparams() {
        switch(ts.peek()) {
            case "textval": case "id": case "lparen": case "numberval":
                Stmt();
                Stmtmoreparams();
                break;
            default: break;
        }
	} 

	private static void Stmtmoreparams() {
        if(ts.peek() == ",") {
            match(ts, ",");
            Stmt();
            Stmtmoreparams();
        }
	} 

	private static void Dclparams() {
        if(ts.peek() == "numberdcl" || ts.peek() == "textdcl") {
            Dclparam();
            Dclmoreparams();
        }
	} 

	private static void Dclmoreparams() {
        if(ts.peek() == ",") {
            match(ts, ",");
            Dclparam();
            Dclmoreparams();
        }
	}

	private static void Dclparam() {
        Type();
        match(ts, "id");
	}

	private static void Type() {
        if(ts.peek() == "numberdcl") {
            match(ts, "numberdcl");
        }
        else {
            match(ts, "textdcl");
        }
	} 
}
