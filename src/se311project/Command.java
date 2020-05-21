package se311project;

import java.io.IOException;
import java.lang.ClassNotFoundException;

// Command pattern interface
interface Command {

    public void executeCommand() throws IOException, ClassNotFoundException;

}
