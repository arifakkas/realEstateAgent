package se311project;

import java.io.IOException;
import java.time.LocalDate;

// One of the concrete command classes of the Command pattern
// It is usually related with the estates
public class agentCommands implements Command {

    private Agent _agent;
    private int _operation;
    private int _estateType;
    private Location _location;
    private Boolean _forSale;
    private Boolean _forRent;
    private Long _price;
    private LocalDate _date;

    public agentCommands(int operation, int estateType, Location location, Boolean forSale, Boolean forRent,
            Long price, LocalDate date) throws ClassNotFoundException, IOException {

        _agent = Agent.getSingletonAgent();
        _operation = operation;
        _estateType = estateType;
        _location = location;
        _forSale = forSale;
        _forRent = forRent;
        _price = price;
        _date = date;

    }

    @Override
    public void executeCommand() throws IOException, ClassNotFoundException {
        _agent.EstateOperations(_operation, _estateType, _location, _forSale, _forRent, _price, _date);
    }

}
