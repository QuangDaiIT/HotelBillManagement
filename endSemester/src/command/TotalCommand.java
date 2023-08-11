package command;

import pesistence.BillJdbcGateway;

public class TotalCommand extends Command{
        public TotalCommand(BillJdbcGateway billJdbcGateway){
            super(billJdbcGateway);
        }

        @Override
        public void execute() {
    
        }
}
