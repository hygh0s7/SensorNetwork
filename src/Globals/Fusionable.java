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
public interface Fusionable {

    String FILEA
            = "C:\\Users\\Admin\\OneDrive\\Documents\\NetBeansProjects\\Exam2Simplified\\src\\DataFiles\\FusedA";
    String FILEB
            = "C:\\Users\\Admin\\OneDrive\\Documents\\NetBeansProjects\\Exam2Simplified\\src\\DataFiles\\FusedB";
    String FILEC
            = "C:\\Users\\Admin\\OneDrive\\Documents\\NetBeansProjects\\Exam2Simplified\\src\\DataFiles\\FusedC";

    public void processSensorData();

    public void writeDataToFile();
}
