package com.loiy.athkar.model;

public class AthkarModel {

    public String statement;
    public String ajer;
    public String numberOfRep;


    public String sanad;



    public AthkarModel(String statement, String ajer, String numberOfRep) {

        this.statement = statement;
        this.ajer = ajer;
        this.numberOfRep = numberOfRep;
    }

    public AthkarModel(String statement, String ajer, String numberOfRep, String sanad) {

        this.statement = statement;
        this.ajer = ajer;
        this.numberOfRep = numberOfRep;
        this.sanad = sanad;
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


    public String getSanad() {
        return sanad;
    }
}
