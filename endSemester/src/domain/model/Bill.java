/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package domain.model;
import java.util.Date;

// import java.sql.Date;

public class Bill {
    private int maHD;
    private String tenKH;
    private int maPhong;
    private String ngayHD;
    private Double donGia;
    private int soLuong = 0;
    private String loaiHD;
   
    public Bill(int maHD, String tenKH, int maPhong, String ngayHD,Double donGia,String loaiHD, int soLuong) {
        this.maPhong = maPhong;
        this.ngayHD = ngayHD;
        this.maHD = maHD;
        this.donGia = donGia;
        this.loaiHD= loaiHD;
        this.soLuong = soLuong;
        this.tenKH = tenKH;
    }

    public int getMaHD() {
        return this.maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public String getTenKH() {
        return this.tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getMaPhong() {
        return this.maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public String getNgayHD() {
        return this.ngayHD;
    }

    public void setNgayHD(String ngayHD) {
        this.ngayHD = ngayHD;
    }

    public Double getDonGia() {
        return this.donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public String getLoaiHD() {
        return this.loaiHD;
    }

    public void setLoaiHD(String loaiHD) {
        this.loaiHD = loaiHD;
    }

    public int getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }


    @Override
    public String toString() {
        return "maHD: " + maHD + ", tenKH: " + tenKH + ", maPhong: " + maPhong + ", ngayHD: " + ngayHD
                + ", donGia: " + donGia + ", loaiHD: " + loaiHD + ", soLuong: " + soLuong + "Thanh Tien:" + pay();
    }

    public Double pay() {
        Double thanhTien;
        System.err.println(loaiHD);
        System.out.println(loaiHD.toString() == "ngay");
        if(loaiHD.equals("ngay")){
            if(this.soLuong > 7) {
                int ngayThem = soLuong - 7;
                Double Giam = ((ngayThem*donGia)*20)/100;
                Double ngayGiam = ngayThem*donGia - Giam;
                thanhTien = ngayGiam + donGia*7.0;
            }else{
                thanhTien = soLuong*donGia;
            }
             return thanhTien;
        }else{
            if(24 < soLuong && soLuong < 30){
                thanhTien = donGia*24.0;
            }else if(30 < soLuong){
                thanhTien = soLuong*donGia;
            }else {
                thanhTien = soLuong*donGia;
            }
            return thanhTien;
            
        }
    }
}
