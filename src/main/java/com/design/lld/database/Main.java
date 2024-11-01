package com.design.lld.database;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DatabaseManagementService dbService = new DatabaseManagementService();

        System.out.println("In Memory Database Started ......");
        try {
            dbService.createTable("Employee", Arrays.asList(
                    new TableHeader("Name", DataTypes.STRING, false, Constraint.STRING_LENGTH_20),
                    new TableHeader("Age", DataTypes.INT, false, Constraint.INT_RANGE_1024)
            ));

            dbService.insertEntryInTable("Employee", Arrays.asList("Umang", 24));

            System.out.println(dbService.getAllTableNames());
            System.out.println(dbService.getAllTableRowOfTable("Employee"));
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
