package com.loiy.athkar.model;

public class AthkarModel {

    public String statement, ajer, numberOfRep;


    public AthkarModel(String statement) {
        this.statement = statement;
    }


    public AthkarModel(String statement, String ajer) {

        this.statement = statement;
        this.ajer = ajer;
    }

    public AthkarModel(String statement, String ajer, String numberOfRep) {

        this.statement = statement;
        this.ajer = ajer;
        this.numberOfRep = numberOfRep;
    }


    public String getStatement() {
        return statement;
    }

    public String getNumberOfRep() {
        return numberOfRep;
    }

    public String getAjer() {
        return ajer;
    }

    public void setNumberOfRep(String numberOfRep) {
        this.numberOfRep = numberOfRep;
    }
}
