package command;

import pesistence.BillJdbcGateway;

public class AddCommand extends Command{

    public AddCommand(BillJdbcGateway billJdbcGateway){
            super(billJdbcGateway);
        }

    @Override
    public void execute() {
        
    }
}