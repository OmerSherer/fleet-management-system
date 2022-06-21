package model.Command;

import model.Expression.ExpressionEvaluator;

public class PrintCommand extends Command {
    public PrintCommand() {
        super();
    }


    @Override
    public void execute(String[] args) {
        //ExpressionEvaluator evaluator = new ExpressionEvaluator();

        // add all the args to a string with spaces in between
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            sb.append(args[i]);
            sb.append(" ");
        }
        // remove the last space
        sb.deleteCharAt(sb.length() - 1);

        // substring the string inside the quotes if there are any
        String str = sb.toString();
        if (str.indexOf('"') != -1 && str.indexOf('"') != str.lastIndexOf('"')) {
            str = str.substring(str.indexOf('"') + 1, str.lastIndexOf('"'));
            System.out.println(str);
        }

        // evaluate the expression if it is an expression
        if (ExpressionEvaluator.isExpression(str)) {
            System.out.println(ExpressionEvaluator.evaluate(str));
            return;
        }

        // if the string is a double, print it
        if (ExpressionEvaluator.isDouble(str)) {
            System.out.println(str);
        }


    }

    public static void main(String[] args) {
        PrintCommand command = new PrintCommand();
        String str = "print 1";
        String[] args1 = str.split(" ");
        command.execute(args1);
    }
}
