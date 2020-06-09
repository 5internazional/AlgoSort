package app;

import command.CommandFactory;

public class Main {
    public static void main(String[] args) {
        CommandFactory cf = new CommandFactory();
        cf.chooseListable();

    }
}

