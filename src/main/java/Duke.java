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

        // List to store type of item
        String[] typeList = new String[100];

        // Create a scanner to read from standard input.
        Scanner sc = new Scanner(System.in);
        String cmd = sc.nextLine();
        while (!cmd.equals("bye")) {
            if (cmd.equals("list")) {
                System.out.println(line);
                for (int i = 0; i < count; i++) {
                    String type = " ";
                    if (typeList[i] != null) {
                        type = typeList[i];
                    }
                    if (checkedList[i]) {
                        System.out.println((i + 1) + ".[" + type + "][X] " + cmdList[i]);
                    } else {
                        System.out.println((i + 1) + ".[" + type + "][ ] " + cmdList[i]);
                    }
                }
                System.out.println(line);
            } else if (cmd.matches("^done [0-9]+$")){
                String[] temp = cmd.split(" ");
                int itemNo = Integer.parseInt(temp[1]);

                // Make sure itemNo is within limit
                if ((itemNo <= count) && (itemNo > 0)) {
                    String type = " ";
                    if (typeList[itemNo - 1] != null) {
                        type = typeList[itemNo - 1];
                    }

                    checkedList[itemNo - 1] = true;
                    System.out.println(line);
                    System.out.println("congrats on completing this task! :");
                    System.out.println("  [" + type + "][X] " + cmdList[itemNo - 1]);
                } else {
                    System.out.println(line);
                    System.out.println(" ☹ sorry..i cant seem to find the task you're looking for");
                }
                System.out.println(line);
            } else if (cmd.matches("^todo .*$")
                    || cmd.matches("^deadline .* /by .*$")
                    || cmd.matches("^event .* /at .*$")) {
                String[] temp = cmd.split(" ", 2);
                if (temp[1].equals("")) {
                    System.out.println(line);
                    System.out.println(" ☹ oh noes..the description of a " + temp[0] + " cannot be empty");
                    System.out.println(line);
                } else {
                    System.out.println(line);
                    System.out.println("noted! ive added this task:");

                    // Separate into cases
                    switch (temp[0]) {
                        case "todo":
                            typeList[count] = "T";
                            cmdList[count] = temp[1];
                            System.out.println("  [" + typeList[count] + "][ ] " + cmdList[count]);
                            break;
                        case "deadline":
                            typeList[count] = "D";
                            String[] temp_deadline = temp[1].split(" /by ", 2);
                            cmdList[count] = temp_deadline[0] + " (by: " + temp_deadline[1] + ")";
                            System.out.println("  [" + typeList[count] + "][ ] " + cmdList[count]);
                            break;
                        case "event":
                            typeList[count] = "E";
                            String[] temp_event = temp[1].split(" /at ", 2);
                            cmdList[count] = temp_event[0] + " (at: " + temp_event[1] + ")";
                            String type3 = typeList[count];
                            System.out.println("  [" + typeList[count] + "][ ] " + cmdList[count]);
                            break;
                    }
                    count++;
                    System.out.println("now you have " + count + " tasks in your list");
                    System.out.println(line);
                }
            } else {
                // Error handling for todo, deadline & event
                if (cmd.equals("todo") || cmd.equals("deadline") || cmd.equals("event")) {
                    System.out.println(line);
                    System.out.println(" ☹ oh noes..the description of a " + cmd + " cannot be empty");
                    System.out.println(line);
                } else {
                    System.out.println(line);
                    System.out.println(" ☹ oops..im sorry, but i dont know what that means :(");
                    System.out.println(line);
                }
            }
            cmd = sc.nextLine();
        }

        System.out.println(line);
        System.out.println("bye friend!");
        System.out.println(line);
    }
}
