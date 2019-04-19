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
public interface Analyzable {

    String FILEAA
            = "C:\\Users\\Admin\\OneDrive\\Documents\\NetBeansProjects\\Exam2Simplified\\src\\DataFiles\\AnalyzedA";
    String FILEAB
            = "C:\\Users\\Admin\\OneDrive\\Documents\\NetBeansProjects\\Exam2Simplified\\src\\DataFiles\\AnalyzedB";
    String FILEAC
            = "C:\\Users\\Admin\\OneDrive\\Documents\\NetBeansProjects\\Exam2Simplified\\src\\DataFiles\\AnalyzedC";

    public void readFusedData();

    public void AnalyzeFusedData();

    public void writeDataToFile();
}
