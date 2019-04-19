/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Globals;

/**
 *
 * @author Admin
 */
public enum Predictions {

    Prediction1("Category 1-Level Aggregation", 2000),
    Prediction2("Category 2-Level Aggregation", 4000),
    Prediction3("Category 3-Level Aggregation", 6000);

    String classification;
    double values;

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public double getValues() {
        return values;
    }

    public void setValues(double values) {
        this.values = values;
    }

    private Predictions(String classification, double values) {
        this.classification = classification;
        this.values = values;
    }

    String displayClassifications() {
        return classification;
    }

    String displayValue() {
        return String.valueOf(values);
    }
}
