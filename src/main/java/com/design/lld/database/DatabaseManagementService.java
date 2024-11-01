package com.design.lld.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DatabaseManagementService {
    Map<String, Object> tables;

    DatabaseManagementService() {
        this.tables = new HashMap<>();
    }

    public Table createTable(String tableName, List<TableHeader> headers) throws Exception {
        if (tables.containsKey(tableName)) {
            throw new Exception("Table name already exists");
        } else {
            Table newTable = new Table(tableName, headers);
            tables.put(newTable.getTableName(), newTable);
            return newTable;
        }
    }

    public void deleteTable(String tableName) throws Exception {
        if (tables.containsKey(tableName)) {
            throw new Exception("Table name already exists");
        } else {
            tables.remove(tableName);
        }
    }

    public int insertEntryInTable(String tableName, List<Object> tableEntries) throws Exception {
        if (!tables.containsKey(tableName)) {
            throw new Exception("Table not found");
        } else {
            Table existingTable = (Table) tables.get(tableName);
            return existingTable.insertRowIntoTable(tableEntries);
        }
    }

    public void deleteRowFromRowId(String tableName, int rowId) throws Exception {
        if (tables.containsKey(tableName)) {
            throw new Exception("Table name already exists");
        } else {
            Table existingTable = (Table) tables.get(tableName);
            existingTable.deleteRowFromRowId(rowId);
        }
    }

    public List<String> getAllTableNames() {
        return tables.keySet().stream().collect(Collectors.toList());
    }

    public List<TableRow> getAllTableRowOfTable(String tableName) throws Exception {
        if (!tables.containsKey(tableName)) {
            throw new Exception("Table dose not exist");
        } else {
            Table existingTable = (Table) tables.get(tableName);
            return existingTable.getRowsList();
        }
    }

}
