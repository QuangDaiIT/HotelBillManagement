package command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

import domain.model.Bill;
import pesistence.BillJdbcGateway;

public class AverageCommand extends Command {

        public AverageCommand(BillJdbcGateway billJdbcGateway){
            super(billJdbcGateway);
        }
    
        @Override
        public void execute() {
        String enterField;
        Double tongTien = 0.0;
        Double dk = 0.0;
        enterField = JOptionPane.showInputDialog(null,"nhap vao thang muon tinh tien trung binh!");
        // String dateString = "2023-08-10"; // Chuỗi ngày trong định dạng yyyy-MM-dd
        List<Bill> bills = billJdbcGateway.getAllBills();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date;
        int month;
        int convert = Integer.parseInt(enterField);
        if(0 < convert && convert < 13){
            for (Bill bill : bills) {      
             date = LocalDate.parse(bill.getNgayHD(), formatter);
             month = date.getMonthValue();
             
             System.out.println(month);
             if(enterField.equals(Integer.toString(month))){
                tongTien += bill.pay();
                dk += 1.0;
                System.out.println(tongTien);
             }
        }
        if(dk != 0.0) {
            JOptionPane.showMessageDialog(null,"Tiền trung bình của tháng : "+ enterField + " là : " +  tongTien/dk + "vnd");
        }else {
            JOptionPane.showMessageDialog(null,"Tiền trung bình của tháng : "+ enterField + " là : " +  tongTien + "vnd");
        } 
        }else {
            JOptionPane.showMessageDialog(null, "thang khong hop le!");
        }    
            
        }
        
    }
