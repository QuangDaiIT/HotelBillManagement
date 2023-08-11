package command;

import pesistence.BillJdbcGateway;

public class FindCommand extends Command {
public FindCommand(BillJdbcGateway billJdbcGateway){
            super(billJdbcGateway);
        }
        @Override
        public void execute() {
    
        }

}
