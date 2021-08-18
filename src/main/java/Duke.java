import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        String line = "===========================";
        System.out.println(line);
        System.out.println("hello! i'm calico ☺");
        System.out.println("how can i assist you?");
        System.out.println(line);

        // List to store commands
        String[] cmdList = new String[100];
        int count = 0;

        // List to store checked items
        boolean[] checkedList = new boolean[100];

        // Create a scanner to read from standard input.
        Scanner sc = new Scanner(System.in);
        String cmd = sc.nextLine();
        while (!cmd.equals("bye")) {
            if (cmd.equals("list")) {
                System.out.println(line);
                for (int i = 0; i < count; i++) {
                    if (checkedList[i]) {
                        System.out.println((i + 1) + ".[X] " + cmdList[i]);
                    } else {
                        System.out.println((i + 1) + ".[ ] " + cmdList[i]);
                    }
                }
                System.out.println(line);
            } else if (cmd.matches("^done [0-9]+$")){
                String[] temp = cmd.split(" ");
                int itemNo = Integer.parseInt(temp[1]);

                // Make sure itemNo is within limit
                if ((itemNo <= count) && (itemNo > 0)) {
                    checkedList[itemNo - 1] = true;
                    System.out.println(line);
                    System.out.println("congrats on completing this task! :");
                    System.out.println("  [X] " + cmdList[itemNo - 1]);
                } else {
                    System.out.println(line);
                    cmdList[count] = cmd;
                    count++;
                    System.out.println("added: " + cmd);
                }
                System.out.println(line);
            } else {
                System.out.println(line);
                cmdList[count] = cmd;
                count++;
                System.out.println("added: " + cmd);
                System.out.println(line);
            }
            cmd = sc.nextLine();
        }

        System.out.println(line);
        System.out.println("bye friend!");
        System.out.println(line);
    }
}
