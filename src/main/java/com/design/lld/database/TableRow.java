package com.design.lld.database;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Map;

@Getter
@Setter
public class TableRow {
    private int rowId;
    private Map<String, Object> columnValues;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public TableRow(int rowId, Map<String, Object> columnValues) {
        this.columnValues = columnValues;
        this.rowId = rowId;
    }
}
