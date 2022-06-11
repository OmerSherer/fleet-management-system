package model;

import java.io.PrintStream;

public class Commands {
    PrintStream out = System.out;

    public interface ICommand {
        int execute(String[] arr, int index);
    }

    public abstract class Command implements ICommand {
        public abstract int execute(String[] arr, int index);
    }

    public class OpenServerCommand extends Command {
        public int execute(String[] arr, int index) {
            System.out.println("server opened!");
            return index + 1;
        }
    }

    public class ConnectCommand extends Command {
        public int execute(String[] arr, int index) {
            System.out.println("connected!");
            return index + 1;
        }
    }

    public class DefineVarCommand extends Command {
        public int execute(String[] arr, int index) {
            System.out.println("var defined!");
            return index + 1;
        }
    }

    public class PrintCommand extends Command {
        public int execute(String[] arr, int index) {
            index++;
            int flag = 0;
            while (flag != 2 && index < arr.length) {
                if(arr[index].contains("\"")){
                    flag++;
                }
                arr[index] = arr[index].replace("\"", "");
                out.println(arr[index]);
                index++;
            }
            return index + 1;
        }
    }

}
