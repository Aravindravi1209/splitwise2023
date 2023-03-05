package com.splitwise.splitwise2023.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandsRegistry {

    private List<Command> commands = new ArrayList<>();

     @Autowired
    public CommandsRegistry(RegisterUserCommand registerUserCommand) {
        commands.add(registerUserCommand);
    }

    public boolean register(Command command)
    {
        if(!commands.contains(command))
        {
            commands.add(command);
            return true;
        }
        return false;
    }

    public boolean deRegister(Command command)
    {
        if(!commands.contains(command))
        {
            return false;
        }
        commands.remove(command);
        return true;
    }

    public void execute(String input)
    {
        for(Command command : commands)
        {
            if(command.canExecute(input))
            {
                command.execute(input);
                return;
            }
        }
    }
}
