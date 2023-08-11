package command;

import pesistence.BillJdbcGateway;

public class DeleteCommand extends Command{
    
    public DeleteCommand(BillJdbcGateway billJdbcGateway){
            super(billJdbcGateway);
        }

    @Override
    public void execute() {

    }
}