import java.util.NoSuchElementException;

public class PostfixEvaluator {
	private char ADD = '+';
	private char SUB = '-';
	private char MUL = '*';
	private char DIV = '/';
	
	LinkedStack<Double> stack;
	
	PostfixEvaluator() {
		stack = new LinkedStack<Double>();
	}
	
	public double evaluate(String expression) throws PostfixEvaluator.IncorrectInput, PostfixEvaluator.NotEnoughOperands, PostfixEvaluator.TooManyOperands {
		String[] input = expression.split(" ");
		for(int i = 0; i < input.length; i++) {
			String value = input[i];
			if(!isOperator(value)) {
				try {
					stack.push(Double.parseDouble(value));
				} catch (NumberFormatException ex) {
					throw new IncorrectInput("Please Make Sure Input is Correct");
				}
			} else {
				try {
					double op2 = stack.pop();
					double op1 = stack.pop();
					evalSingleOp(value.charAt(0), op1, op2);
				} catch (NoSuchElementException ex) {
					throw new NotEnoughOperands("Please Make Sure there are enough Operands");
				}
			}
		}
		if(stack.size() > 1) {
			throw new TooManyOperands("Please Make Sure there isn't too Many Operands");
		}
		try {
			return stack.pop();	
		} catch (NoSuchElementException ex) {
			throw new IncorrectInput("Please Make Sure Input is Correct");
		}
	}
	
	public boolean isOperator(String token) {
		if(token.equals(Character.toString(ADD)) || token.equals(Character.toString(SUB)) || token.equals(Character.toString(MUL)) || token.equals(Character.toString(DIV))) {
			return true;
		}
		return false;
	}
	
	public double evalSingleOp(char operation, double op1, double op2) {
		if(operation == ADD) {
			double r = op1 + op2;
			stack.push(r);
			return r;
		} else if(operation == SUB) {
			double r = op1 - op2;
			stack.push(r);
			return r;
		} else if(operation == MUL) {
			double r = op1 * op2;
			stack.push(r);
			return r;
		} else {
			double r = op1 / op2;
			stack.push(r);
			return r;
		}
		
	}
	
	public class IncorrectInput extends Exception { 
	    public IncorrectInput(String errorMessage) {
	        super(errorMessage);
	    }
	}
	
	public class NotEnoughOperands extends Exception { 
	    public NotEnoughOperands(String errorMessage) {
	        super(errorMessage);
	    }
	}
	
	public class TooManyOperands extends Exception { 
	    public TooManyOperands(String errorMessage) {
	        super(errorMessage);
	    }
	}
}
