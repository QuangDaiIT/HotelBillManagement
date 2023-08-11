/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package pesistence;

import java.util.List;

import domain.model.Bill;

public class BillDAOImpl implements BillDAO {
    private BillGateway billGateway;

    public BillDAOImpl(BillGateway billGateway) {
        this.billGateway = billGateway;
    }


    @Override
    public void addBill(Bill bill) {
        billGateway.addBill(bill);
    }

    @Override
    public void updateBill(Bill bill) {
        billGateway.updateBill(bill);
    }

    @Override
    public void deleteBill(int billId) {
        billGateway.deleteBill(billId);
    }

    @Override
    public Bill getBillById(int billId) {
        return billGateway.getBillById(billId);
    }

    @Override
    public List<Bill> getAllBills() {
        return billGateway.getAllBills();
    }
}



