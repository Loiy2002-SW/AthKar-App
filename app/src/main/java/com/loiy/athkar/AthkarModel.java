package com.loiy.athkar;

public class AthkarModel {

    String statement;
    String numberOfRep;


    public AthkarModel(String statement, String numberOfRep) {
        this.statement = statement;
        this.numberOfRep = numberOfRep;
    }

    public AthkarModel(String statement) {
        this.statement = statement;
    }

    public String getStatement() {
        return statement;
    }

    public String getNumberOfRep() {
        return numberOfRep;
    }

}
