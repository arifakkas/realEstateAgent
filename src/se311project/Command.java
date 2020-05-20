package se311project;

import java.io.IOException;
import java.lang.ClassNotFoundException;

interface Command {
    
    public void executeCommand() throws IOException, ClassNotFoundException;
    
}
