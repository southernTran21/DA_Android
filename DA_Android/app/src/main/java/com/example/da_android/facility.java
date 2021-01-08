package com.example.da_android;

public class facility {
    private String id;
    private String QRCODE;
    private String donViQuanLy;
    private String donViTinh;
    private String ngayMua;
    private String giaTien;
    private String hanSuDung;
    private String moTa;
    private String nameCat;
    public String name;

    public facility(String id, String QRCODE, String donViQuanLy, String donViTinh, String ngayMua, String giaTien, String hanSuDung, String moTa, String nameCat, String name) {
        this.id = id;
        this.QRCODE = QRCODE;
        this.donViQuanLy = donViQuanLy;
        this.donViTinh = donViTinh;
        this.ngayMua = ngayMua;
        this.giaTien = giaTien;
        this.hanSuDung = hanSuDung;
        this.moTa = moTa;
        this.nameCat = nameCat;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQRCODE() {
        return QRCODE;
    }

    public void setQRCODE(String QRCODE) {
        this.QRCODE = QRCODE;
    }

    public String getDonViQuanLy() {
        return donViQuanLy;
    }

    public void setDonViQuanLy(String donViQuanLy) {
        this.donViQuanLy = donViQuanLy;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }

    public String getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(String hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNameCat() {
        return nameCat;
    }

    public void setNameCat(String nameCat) {
        this.nameCat = nameCat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
