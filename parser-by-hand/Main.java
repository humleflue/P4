import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    private static TokenStream ts = new TokenStream(new ArrayList<String>(
        Arrays.asList("numberdcl", "id", "(", ")", "=", "numberval", "+", "numberval", "-", "numberval", "nl" ,"$")
    ));

    public static void main(String[] args) {
        Dcls();
        Stmts();
        match(ts, "$");
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
                match(ts, "nl");
                Stmts();
                break;
            default: break;
        }
	} 

	private static void Dcls() {
        if(ts.peek() == "numberdcl" || ts.peek() == "textdcl") {
            Dcl();
            match(ts, "nl");
            Dcls();
        }
	} 

	private static void Dcl() {
        Type();
        match(ts, "id");
        match(ts, "(");
        Dclparams();
        match(ts, ")");
        match(ts, "=");
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
        if(ts.peek() == "+" || ts.peek() == "-") {
            Simpleops();
            Math();
        }
        
	} 

	private static void Simpleops() {
        if(ts.peek() == "+") {
            match(ts, "+");
        }
        else {
            match(ts, "-");
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
        if(ts.peek() == "(") {
            match(ts, "(");
            Math();
            match(ts, ")");
        }
        else {
            match(ts, "numberval");
        }
	} 

	private static void Funccall() {
        match(ts, "id");
        match(ts, "(");
        Stmtparams();
        match(ts, ")");
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
