/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package domain;

import java.util.List;

import domain.model.Bill;
import pesistence.*;


public class BillServiceImpl implements BillService {
    private BillDAO billDAO;

    

    public BillServiceImpl() {
        // Initialize the StudentDAO (Data Access Layer)
        billDAO = new BillDAOImpl(new BillJdbcGateway());
    }

    @Override
    public void addBill(Bill bill) {
        billDAO.addBill(bill);
    }

    @Override
    public void updateBill(Bill bill) {
        billDAO.updateBill(bill);
    }

    @Override
    public void deleteBill(int billId) {
        billDAO.deleteBill(billId);
    }

    @Override
    public Bill getBillById(int billId) {
        return billDAO.getBillById(billId);
    }

    @Override
    public List<Bill> getAllBills() {
        return billDAO.getAllBills();
    }
}



