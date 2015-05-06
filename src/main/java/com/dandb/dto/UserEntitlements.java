package com.dandb.dto;

import java.util.ArrayList;
import java.util.List;

public class UserEntitlements {
    private List<Entitlement> entitlements = new ArrayList<Entitlement>();

    public List<Entitlement> getEntitlements() {
        return entitlements;
    }

    public void setEntitlements(List<Entitlement> entitlements) {
        this.entitlements = entitlements;
    }
}
