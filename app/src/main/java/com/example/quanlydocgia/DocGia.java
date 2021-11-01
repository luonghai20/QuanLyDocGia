package com.example.quanlydocgia;

public class DocGia {
    int IdAnh;
    String MaTenDG;
    boolean checked;

    public DocGia(int idAnh, String maTenDG, boolean del) {
        IdAnh = idAnh;
        MaTenDG = maTenDG;
        checked = del;
    }

    public int getIdAnh() {
        return IdAnh;
    }

    public void setIdAnh(int idAnh) {
        IdAnh = idAnh;
    }

    public String getMaTenDG() {
        return MaTenDG;
    }

    public void setMaTenDG(String maTenDG) {
        MaTenDG = maTenDG;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
