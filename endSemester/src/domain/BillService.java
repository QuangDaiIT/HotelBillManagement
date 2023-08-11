/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package domain;

import java.util.List;

import domain.model.Bill;

public interface BillService {
    void addBill(Bill bill);
    void updateBill(Bill bill);
    void deleteBill(int billId);
    Bill getBillById(int billId);
    List<Bill> getAllBills();

}
