package com.example.music;

import java.io.Serializable;

public class Baihat  implements Serializable {
    private  String tenbaihat;
    private int  baihat;

    public Baihat(String tenbaihat, int baihat) {
        this.tenbaihat = tenbaihat;
        this.baihat = baihat;
    }

    public int  getBaihat() {
        return baihat;
    }

    public String getTenbaihat() {
        return tenbaihat;
    }
}
