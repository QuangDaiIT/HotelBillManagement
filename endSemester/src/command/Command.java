package command;

import domain.model.Bill;
import pesistence.BillJdbcGateway;

public abstract class Command {

    protected Bill billRemote;
    protected BillJdbcGateway billJdbcGateway;

    public abstract void execute();

    public void setModelRemote(Bill billRemote) {
        this.billRemote = billRemote;
    }

    public Command(){}

    public Command(Bill billRemote) {
        this.billRemote = billRemote;
    }

    public Command(BillJdbcGateway billJdbcGateway) {
        this.billJdbcGateway = billJdbcGateway;
    }

    
    
}
