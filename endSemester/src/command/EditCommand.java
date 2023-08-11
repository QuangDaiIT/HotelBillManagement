package command;

import pesistence.BillJdbcGateway;

public class EditCommand extends Command {
   public EditCommand(BillJdbcGateway billJdbcGateway){
            super(billJdbcGateway);
        }

    @Override
    public void execute() {

    }
}
