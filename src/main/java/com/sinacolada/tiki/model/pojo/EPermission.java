package com.sinacolada.tiki.model.pojo;

import lombok.Getter;

@Getter
public enum EPermission {

    USER_READ("user:read"), USER_WRITE("user:write"), DB_ACCESS("db_access");

    private final String permission;

    private EPermission(String permission) {
        this.permission = permission;
    }

}