package com.kfyty.loveqq.framework.boot.javafx.example.model;

import com.kfyty.loveqq.framework.core.autoconfig.annotation.NestedConfigurationProperty;
import lombok.Data;

@Data
@NestedConfigurationProperty
public class User {
    private String name;

    @NestedConfigurationProperty
    private Dept dept;

    @Data
    public static class Dept {
        private String deptName;
    }
}
