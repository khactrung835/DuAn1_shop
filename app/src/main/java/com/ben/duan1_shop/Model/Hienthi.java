package com.ben.duan1_shop.Model;

public class Hienthi {
    private String tv;
    private int hinh;

    public Hienthi(){}

    public Hienthi(String tv, int hinh) {
        this.tv = tv;
        this.hinh = hinh;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
