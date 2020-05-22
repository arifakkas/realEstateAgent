package se311project;

import java.io.IOException;
// One of the concrete command classes of the command pattern
// It is usually related with the customers

public class customerCommands implements Command {

    private Agent _agent;
    private int _operation;
    private String _customerName;
    private String _customerSurname;
    private Long _identityNumber;

    public customerCommands(int operation, String customerName, String customerSurname,
            Long identityNumber) throws ClassNotFoundException, IOException {

        _agent = Agent.getSingletonAgent();
        _operation = operation;
        _customerName = customerName;
        _customerSurname = customerSurname;
        _identityNumber = identityNumber;

    }

    @Override
    public void executeCommand() throws IOException, ClassNotFoundException {
        _agent.CustomerOperations(_operation, _customerName, _customerSurname, _identityNumber);
    }

}
