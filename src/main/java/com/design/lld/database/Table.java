package com.design.lld.database;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.*;

@Getter
@Setter
public class Table {
    private static int nextRowId;
    private String tableName;
    private static List<TableHeader> headerList;
    private List<TableRow> rowsList;
    private Timestamp createdAt;

    Table(String name, List<TableHeader> headerList) {
        this.tableName = name;
        this.headerList = headerList;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.rowsList = new ArrayList<>();
        nextRowId = 0;
    }

    public int insertRowIntoTable(List<Object> values) throws Exception {
        validateRow(values);
        nextRowId++;
        Map<String, Object> valuesMap = new HashMap<>();
        for (int i = 0; i < values.size(); i++) {
            valuesMap.put(headerList.get(i).name, values.get(i));
        }

        TableRow newRow = new TableRow(nextRowId, valuesMap);
        rowsList.add(newRow);
        return nextRowId;

    }

    public boolean deleteRowFromRowId(int rowId) {
        Optional<TableRow> rowToDelete = rowsList.stream().filter(row -> row.getRowId() == rowId).findAny();

        if (!rowToDelete.isPresent()) {
            return false;
        } else {
            rowsList.remove(rowToDelete.get());
            return true;
        }
    }

    private static void validateRow(List<Object> values) throws Exception {

        if (values.size() != headerList.size()) {
            throw new Exception("Number of items in row doesn't match number of headers in the table");
        }

        for (int i = 0; i < values.size(); i++) {
            TableHeader currentHeader = headerList.get(i);
            Object currentValue = values.get(i);

            switch (currentHeader.constraint) {
                case STRING_LENGTH_20:
                    String stringValue = currentValue.toString();
                    if (stringValue.length() > 20) {
                        throw new Exception("String Value at column: " + i + " violates constraint "
                                + currentHeader.constraint.name() + " for value " + currentValue);
                    }
                    break;

                case INT_RANGE_1024:
                    int intValue = (int) currentValue;
                    if (intValue > 1024 || intValue < -1024) {
                        throw new Exception("Integer value at columnt: " + i + " violates constraint "
                                + currentHeader.constraint.name() + " for value " + currentValue);
                    }
                    break;

                case NONE:
                    break;

                default:
                    throw new Exception("Unknown constraints");
            }
        }

    }


}
