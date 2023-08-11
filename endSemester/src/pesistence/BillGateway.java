
package pesistence;

import java.util.List;

import domain.model.Bill;

public interface BillGateway {
    void addBill(Bill Bill);
    void updateBill(Bill Bill);
    void deleteBill(int BillId);
    Bill getBillById(int BillId);
    List<Bill> getAllBills();
}



