package com.gabrielsantos.notificationsapi.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PurchaseStatus {

    PENDING(0, "Pending purchase"),
    APPROVED(1,"Approved purchase"),
    REPROVED(2,"Reproved purchase");

    private final Integer id;

    private final String description;

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

}
