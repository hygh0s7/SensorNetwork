/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Analysis.DataAnalysis;
import Analysis.DataAnalysis_A;
import Analysis.DataAnalysis_B;
import Analysis.DataAnalysis_C;
import DBSupport.DBConnection;
import GeoLocation.Location;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class DataAnalysisNodeFactory {

    public static DataAnalysis[] createDBAnalysisNodes() throws SQLException,
            ClassNotFoundException {
        DataAnalysis[] dataAnalysisNodes = new DataAnalysis[3];
        String query
                = "SELECT * FROM "
                + "tachyon.analysisnodes";
        DBConnection db = new DBConnection();
        Connection conn = db.establishDBConnection();
        Statement useStatement = conn.createStatement();
        useStatement.executeQuery("USE tachyon");
        Statement qStatement = conn.createStatement();
        ResultSet rs = qStatement.executeQuery(query);
        rs.next();
        //while (rs.next()) {
        dataAnalysisNodes[0]
                = new DataAnalysis_A(rs.getString("ANode"),
                        new Location(rs.getInt("XCoord"), rs.
                                getInt("YCoord"), rs.getInt("ZCoord")));
        rs.next();
        dataAnalysisNodes[1]
                = new DataAnalysis_B(rs.getString("ANode"),
                        new Location(rs.getInt("XCoord"), rs.
                                getInt("YCoord"), rs.getInt("ZCoord")));
        rs.next();
        dataAnalysisNodes[2]
                = new DataAnalysis_C(rs.getString("ANode"),
                        new Location(rs.getInt("XCoord"), rs.
                                getInt("YCoord"), rs.getInt("ZCoord")));
        // }
        rs.close();
        return dataAnalysisNodes;
    }

    public static void displayAnalysisNodes() throws SQLException,
            ClassNotFoundException {
        DataAnalysis[] dataAnalysisNodes = createDBAnalysisNodes();
        System.out.println("^^^ANALYSIS NODES^^^");
        System.out.println("ID\t\tLOCATION");
        System.out.
                println("_________________________________________");
        for (int i = 0; i < dataAnalysisNodes.length; i++) {
            System.out.println("NodeID: " + dataAnalysisNodes[i].getNodeID()
                    + "\tLocation: ["
                    + dataAnalysisNodes[i].getLocation().getX() + ","
                    + dataAnalysisNodes[i].
                            getLocation().getY() + "," + dataAnalysisNodes[i].
                            getLocation().getZ()
                    + "]");
        }
        System.out.println();
    }
}
