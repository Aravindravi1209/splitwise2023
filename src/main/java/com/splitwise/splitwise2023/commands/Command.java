package com.splitwise.splitwise2023.commands;

public interface Command {

    boolean canExecute(String input);

    void execute(String input);
}
