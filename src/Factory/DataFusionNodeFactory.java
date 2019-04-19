/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import DBSupport.DBConnection;

import Fusion.DataFusion;
import Fusion.DataFusion_A;
import Fusion.DataFusion_B;
import Fusion.DataFusion_C;
import GeoLocation.Location;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class DataFusionNodeFactory {

    public static DataFusion[] createDBFusionNodes() throws SQLException,
            ClassNotFoundException {

        DataFusion[] dataFusionNodes = new DataFusion[3];

        String query
                = "SELECT * FROM "
                + "tachyon.fusionnodes";
        DBConnection db = new DBConnection();
        Connection conn = db.establishDBConnection();
        Statement useStatement = conn.createStatement();
        useStatement.executeQuery("USE tachyon");
        Statement qStatement = conn.createStatement();
        ResultSet rs = qStatement.executeQuery(query);
        rs.next();
        // while (rs.next()) {
        dataFusionNodes[0]
                = new DataFusion_A(rs.getString("FNode"),
                        new Location(rs.getInt("XCoord"), rs.
                                getInt("YCoord"), rs.getInt("ZCoord")));
        rs.next();
        dataFusionNodes[1]
                = new DataFusion_B(rs.getString("FNode"),
                        new Location(rs.getInt("XCoord"), rs.
                                getInt("YCoord"), rs.getInt("ZCoord")));
        rs.next();
        dataFusionNodes[2]
                = new DataFusion_C(rs.getString("FNode"),
                        new Location(rs.getInt("XCoord"), rs.
                                getInt("YCoord"), rs.getInt("ZCoord")));
        //  }
        rs.close();

        return dataFusionNodes;
    }

    public static void displayFusionNodes() throws ClassNotFoundException,
            SQLException {
        DataFusion[] DataFusion = createDBFusionNodes();
        System.out.println("^^^FUSION NODES^^^");
        System.out.println("ID\t\tLOCATION");
        System.out.
                println("_________________________________________");
        for (int i = 0; i < DataFusion.length; i++) {
            System.out.println("NodeID: " + DataFusion[i].getNodeID()
                    + "\tLocation: ["
                    + DataFusion[i].getLocation().getX() + ","
                    + DataFusion[i].
                            getLocation().getY() + "," + DataFusion[i].
                            getLocation().getZ()
                    + "]");

        }
        System.out.println();
    }
}
