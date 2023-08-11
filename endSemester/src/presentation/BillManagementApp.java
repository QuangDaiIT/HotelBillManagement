package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import domain.*;
import domain.model.Bill;
import pesistence.BillJdbcGateway;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Date;

public class BillManagementApp extends JFrame {
    private BillService billService;
    private BillJdbcGateway billJdbcGateway;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton backButton, totalQuantButton , avgMoneyButton, addButton, editButton, deleteButton, findButton;
    private JTextField maHDTextField , TenKHTextField ,maPhongTextField, ngayHDTextField, donGiaTextField, loaiHDTextField, soLuongDTextField;
    public BillManagementApp(BillJdbcGateway billJdbcGateway) {
        this.billJdbcGateway = billJdbcGateway;

        // Create JTable to display student list
        setTitle("Bill Management");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Ma Hoa Don");
        tableModel.addColumn("Ten KH");
        tableModel.addColumn("Ma Phong");
        tableModel.addColumn("Ngay Hoa Don");
        tableModel.addColumn("Don Gia");
        tableModel.addColumn("Loai HD");
        tableModel.addColumn("So Luong");
        tableModel.addColumn("Thanh Tien");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        
        // Create JPanel for student details input and buttons
        JPanel inputPanel = new JPanel(new BorderLayout(10,2));
        JPanel jtextfieldIn = new JPanel(new GridLayout(8, 2));
        JPanel jbuttonIn = new JPanel(new GridLayout(2,2));
        maHDTextField = new JTextField();
        TenKHTextField = new JTextField();
        maPhongTextField = new JTextField();
        ngayHDTextField = new JTextField();
        donGiaTextField = new JTextField();
       loaiHDTextField = new JTextField();
        soLuongDTextField = new JTextField();
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        findButton = new JButton("Find");
        backButton = new JButton("Back");
        totalQuantButton = new JButton("Total Quant");
        avgMoneyButton = new JButton("Average Money");

        //new GridLayout(7, 2)
        
        
        jtextfieldIn.add(new JLabel("Ma Hoa Don:"));
         jtextfieldIn.add(maHDTextField);
        jtextfieldIn.add(new JLabel("Ten KH:"));
        jtextfieldIn.add(TenKHTextField);
        jtextfieldIn.add(new JLabel("Ma Phong:"));
        jtextfieldIn.add(maPhongTextField);
        jtextfieldIn.add(new JLabel("Ngay Hoa Don:"));
        jtextfieldIn.add(ngayHDTextField);
        jtextfieldIn.add(new JLabel("Don Gia:"));
        jtextfieldIn.add(donGiaTextField);
        jtextfieldIn.add(new JLabel("Loai HD:"));
        jtextfieldIn.add(loaiHDTextField);
        jtextfieldIn.add(new JLabel("So Luong:"));
        jtextfieldIn.add(soLuongDTextField);
        // inputPanel.add(cssTextField);
        jbuttonIn.add(addButton);
        jbuttonIn.add(editButton);
        jbuttonIn.add(deleteButton);
        jbuttonIn.add(findButton);
        jbuttonIn.add(backButton);
        jbuttonIn.add(totalQuantButton);
        jbuttonIn.add(avgMoneyButton);
        inputPanel.add(jtextfieldIn, BorderLayout.NORTH);
        inputPanel.add(jbuttonIn, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Add action listeners for buttons
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBill();
            }
        });
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editBill();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteBill();
            }
        });
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findBill();
            }
        });

        totalQuantButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quantBill();
            }
        });

        avgMoneyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                avgMoney();
            }
        });

        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                showSelectedBillInfo();
            }
        });

       backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadBillList();
            }
        });


        // Load initial student list
         loadBillList();
    }

    private void showSelectedBillInfo() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int soHD = (int) table.getValueAt(selectedRow, 0);
            Bill bill = billJdbcGateway.getBillById(soHD);
            if (bill != null) {
                populateInputFields(bill);
            }
        }
    }

    private void populateInputFields(Bill bill) {
        maHDTextField.setText(String.valueOf(bill.getMaHD()));
        TenKHTextField.setText(bill.getTenKH());
        maPhongTextField.setText(String.valueOf(bill.getMaPhong()));
        ngayHDTextField.setText(String.valueOf(bill.getNgayHD()));
        donGiaTextField.setText(String.valueOf(bill.getDonGia()));
        loaiHDTextField.setText(String.valueOf(bill.getLoaiHD()));
        soLuongDTextField.setText(String.valueOf(bill.getSoLuong()));
    }

    // Method to add a student
   
    private void addBill() {
        int maHD = Integer.parseInt(maHDTextField.getText());
        String tenKH = TenKHTextField.getText();
        int maPhong = Integer.parseInt(maPhongTextField.getText());
        // SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        // DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String ngayHD = ngayHDTextField.getText();
        // Date ngayHD = df.parse(ngayHDTextField.getText());
        
        Double donGia = Double.parseDouble(donGiaTextField.getText());
        String loaiHD = loaiHDTextField.getText();
        int soLuong = Integer.parseInt(soLuongDTextField.getText());
        // Calculate the average mark using the formula provided
        // double averageMark = (javaMark * 2.0 + htmlMark + cssMark) / 4.0;
        // create table bill2 (
        // MaPhong int,
        // TenKH nvarchar(50),
        // NgayHD date,
        // MaHD int,
        // DonGia smallmoney,
        // LoaiHD nvarchar(50),
        // SoLuong int,
        // ThanhTien smallmoney
        // )


        Bill bill = new Bill(maHD, tenKH, maPhong, ngayHD, donGia, loaiHD,soLuong);
        // billService.addBill(bill);
        billJdbcGateway.addBill(bill);
        clearFields();
        loadBillList();
        JOptionPane.showMessageDialog(null,"them hoa don thanh cong!");
    }

    // Method to edit a student
    private void editBill() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "vui long cho mot hoa don de chinh sua!");
            return;
        }
         
        int maHD = Integer.parseInt(maHDTextField.getText());
        String tenKH = TenKHTextField.getText();
        int maPhong = Integer.parseInt(maPhongTextField.getText());
        String ngayHD =  ngayHDTextField.getText(); 
        Double donGia = Double.parseDouble(donGiaTextField.getText());
        String loaiHD = loaiHDTextField.getText();
        int soLuong = Integer.parseInt(soLuongDTextField.getText());
        // Calculate the average mark using the formula provided
        // double averageMark = (javaMark * 2.0 + htmlMark + cssMark) / 4.0;

        Bill bill = new Bill(maHD, tenKH, maPhong, ngayHD, donGia, loaiHD, soLuong);
        // billService.updateBill(bill);
        billJdbcGateway.updateBill(bill);
        clearFields();
        loadBillList();
        JOptionPane.showMessageDialog(null,"sua hoa don thanh cong!");

    }

    // Method to delete a student
    private void deleteBill() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "vui long chon mot hoa don de xoa.");
            return;
        }

        int billId = (int) tableModel.getValueAt(row, 0);
        // billService.deleteBill(billId);
        int choice = JOptionPane.showConfirmDialog(
            null,
            "Bạn có chắc chắn muốn xoa hoa don nay?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {
            billJdbcGateway.deleteBill(billId);
            clearFields();
            loadBillList();
            JOptionPane.showMessageDialog(null,"xoa hoa don thanh cong!");
        } else {
        }
        

    }

    // Method to find a student
    
    private void findBill() {
        String enterField;
        int billId = Integer.parseInt(enterField = JOptionPane.showInputDialog(null,"vui long nhap vao ma hoa don can tim!"));
        // int billId = Integer.parseInt(maHDTextField.getText());
        Bill bill = billJdbcGateway.getBillById(billId);
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
        if (bill != null) {
            Object[] rowData = { bill.getMaHD(), bill.getTenKH(), bill.getMaPhong(),
            bill.getNgayHD(), bill.getDonGia(), bill.getLoaiHD(), bill.getSoLuong(), bill.pay() };
            tableModel.addRow(rowData);
            maHDTextField.setText(String.valueOf(bill.getMaHD()));
            TenKHTextField.setText(bill.getTenKH());
            maPhongTextField.setText(String.valueOf(bill.getMaPhong()));
            ngayHDTextField.setText(String.valueOf(bill.getNgayHD()));
            donGiaTextField.setText(String.valueOf(bill.getDonGia()));
            loaiHDTextField.setText(String.valueOf(bill.getLoaiHD()));
            soLuongDTextField.setText(String.valueOf(bill.getSoLuong()));
        } else {
            JOptionPane.showMessageDialog(this, "Khong tim thay hoa don!");
            clearFields();
        }
    }

    // Method to load the student list into the JTable
    
    private void loadBillList() {
        // List<Student> students = studentService.getAllStudents();
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
        List<Bill> bills = billJdbcGateway.getAllBills();
        // students.add(new Student(111, "Le Van Teo", "IT", 5, 5, 5, 5));
        // students.add(new Student(222, "Le Van Ty", "IT", 7,
        //         7, 5, 7));
        // students.add(new Student(333, "Le Van Tung", "IT", 5,
        //         5, 5, 5));
        
        // tableModel.setRowCount(0); // Clear previous data
        for (Bill bill : bills) {
            Object[] rowData = { bill.getMaHD(), bill.getTenKH(), bill.getMaPhong(),
                    bill.getNgayHD(), bill.getDonGia(), bill.getLoaiHD(), bill.getSoLuong(), bill.pay() };
            System.out.println(bill.getTenKH());
            tableModel.addRow(rowData);
        }
        // billJdbcGateway.
        
    }
// int maHD, String tenKH, int maPhong, Date ngayHD,Double donGia, Double thanhTienH, Double thanhTienD
    // Method to clear input fields
    private void clearFields() {
        maHDTextField.setText("");
        TenKHTextField.setText("");
        maPhongTextField.setText("");
        ngayHDTextField.setText("");
        donGiaTextField.setText("");
        loaiHDTextField.setText("");
        soLuongDTextField.setText("");
    }

    // public void displays(int i) {
    //     Bill bil = list.get(i);
    // }

    public void avgMoney() {
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

    public void quantBill() {
        String enterField;
        int soLuongHD = 0;
        enterField = JOptionPane.showInputDialog(null,"nhập vào loại hóa đơn!");
        // String dateString = "2023-08-10"; // Chuỗi ngày trong định dạng yyyy-MM-dd
        List<Bill> bills = billJdbcGateway.getAllBills();
        
        if(enterField.equals("ngay") || enterField.equals("gio")) {
                if(enterField.equals("ngay")){
                    for (Bill bill : bills) {      
                        if(enterField.equals(bill.getLoaiHD())){
                            soLuongHD += bill.getSoLuong();
                        }
                }
            }else if(enterField.equals("gio")) {
                    for (Bill bill : bills) {      
                        if(enterField.equals(bill.getLoaiHD())){
                            soLuongHD += bill.getSoLuong();
                        }
                }
            }
            JOptionPane.showMessageDialog(null,"số lượng hóa đơn theo "+ enterField + " là : " +  soLuongHD + " hóa đơn");
        } else {
            JOptionPane.showMessageDialog(null,"gia tri nhap khong hop le!");
        }
    }

}
