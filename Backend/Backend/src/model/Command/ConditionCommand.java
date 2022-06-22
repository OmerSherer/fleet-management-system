package model.Command;

import model.Expression.ExpressionEvaluator;
import model.Interpreter.Parser;
import model.Interpreter.SymbolTable;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public abstract class ConditionCommand extends Command {

    Scanner scanner;
    Queue<Command> commands = new LinkedList<>();
    public ConditionCommand(String[] args) {
        super(args);
    }

    public void SetConditionCommand(Scanner scanner) {
        this.scanner = scanner;
        // continue until the first { is found
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.contains("{")) {
                break;
            }
        }

        // continue until the last } is found
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            commands.add(Parser.parse(line, symbolTable, scanner));
            if (line.contains("}")) {
                break;
            }
        }
    }

    public boolean checkCondition(){
        String operand1 = args[1], operand2 = args[3], operator = args[2];
        double val1 = ExpressionEvaluator.evaluate(ExpressionEvaluator.replaceVarWithVal(operand1, symbolTable));
        double val2 = ExpressionEvaluator.evaluate(ExpressionEvaluator.replaceVarWithVal(operand2, symbolTable));
        return switch (operator) {
            case "<" -> (val1 < val2);
            case ">" -> (val1 > val2);
            case "<=" -> (val1 <= val2);
            case ">=" -> (val1 >= val2);
            case "==" -> (val1 == val2);
            case "!=" -> (val1 != val2);
            default -> false;
        };

    }
}
