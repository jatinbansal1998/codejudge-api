package org.codejudge.sb.constants;

public enum Status {
    FAILURE("failure"), SUCCESS("success");
    private String status;

    public String getValue() {
        return this.status;
    }

    Status(String status) {
        this.status = status;
    }
}
