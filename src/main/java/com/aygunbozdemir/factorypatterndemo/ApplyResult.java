package com.aygunbozdemir.factorypatterndemo;

import lombok.Data;

@Data
public class ApplyResult {

    private String applyId;
    private Phone phone;
    private Status status;

    public ApplyResult(String applyId, Phone phone, Status status) {
        this.applyId = applyId;
        this.phone = phone;
        this.status = status;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "ApplyResult : \n" +
                "applyId='" + applyId + '\n' +
                ", phone=" + phone + "\n" +
                ", status=" + status + "\n";
    }
}
