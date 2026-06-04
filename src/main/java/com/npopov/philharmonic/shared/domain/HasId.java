package com.npopov.philharmonic.shared.domain;

public interface HasId<ID> {
    ID getId();
    void setId(ID id);
}