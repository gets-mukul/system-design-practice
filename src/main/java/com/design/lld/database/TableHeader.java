package com.design.lld.database;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TableHeader implements DataTypes {

    String name;
    String type;
    Boolean canNull;
    Constraint constraint;
}
