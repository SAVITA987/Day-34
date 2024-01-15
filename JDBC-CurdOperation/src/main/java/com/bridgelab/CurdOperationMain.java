package com.bridgelab;

public class CurdOperationMain {

    public static void main(String[] args) {
   
        CurdOperation curdOperation = new CurdOperation();
        AlterOperation alterOperation = new AlterOperation();

        curdOperation.createTable();
        alterOperation.alterTableAddAddressColumn();
        
        curdOperation.createRecord(9, "vishu", 50000.0);
        curdOperation.readRecord(1);

        curdOperation.updateRecord(2, "Savita", 60000.0);
        curdOperation.readRecord(1);

        curdOperation.deleteRecord(3);
        curdOperation.readRecord(1); 
    }
}
