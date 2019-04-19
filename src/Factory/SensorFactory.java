/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import DBSupport.DBConnection;
import GeoLocation.Location;
import Globals.NodeStatus;
import Globals.SensorTypes;
import Sensor.Sensor;
import Sensor.Sensor_A;
import Sensor.Sensor_B;
import Sensor.Sensor_C;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class SensorFactory {

    public static Sensor[] createDBSensors() throws SQLException,
            ClassNotFoundException {
        Sensor[] sensors = new Sensor[99];

        String query
                = "SELECT * FROM "
                + "tachyon.sensors"
                + " JOIN sensor_location ON sensors.SID = sensor_location.SID where sensors.SType = \"Sensor_A\"";
        DBConnection db = new DBConnection();
        Connection conn = db.establishDBConnection();
        Statement useStatement = conn.createStatement();
        useStatement.executeQuery("USE tachyon");
        Statement qStatement = conn.createStatement();
        ResultSet rs = qStatement.executeQuery(query);

        while (rs.next()) {

            sensors[rs.getRow() - 1]
                    = new Sensor_A(rs.getString("SID"), SensorTypes.valueOf(rs.
                            getString("SType").toUpperCase()),
                            NodeStatus.valueOf(rs.getString("Status").
                                    toUpperCase()),
                            new Location(rs.getInt("XCoord"), rs.
                                    getInt("YCoord"), rs.getInt("ZCoord")));
        }
        rs.close();

        query
                = "SELECT * FROM "
                + "tachyon.sensors"
                + " JOIN sensor_location ON sensors.SID = sensor_location.SID where sensors.SType = \"Sensor_B\"";

        ResultSet rs1 = qStatement.executeQuery(query);
        while (rs1.next()) {
            sensors[rs1.getRow() + 32]
                    = new Sensor_B(rs1.getString("SID"), SensorTypes.valueOf(
                            rs1.getString("SType").toUpperCase()),
                            NodeStatus.valueOf(rs1.getString("Status").
                                    toUpperCase()),
                            new Location(rs1.getInt("XCoord"), rs1.getInt(
                                    "YCoord"), rs1.getInt("ZCoord")));
        }
        rs1.close();

        query
                = "SELECT * FROM "
                + "tachyon.sensors"
                + " JOIN sensor_location ON sensors.SID = sensor_location.SID where sensors.SType = \"Sensor_C\"";

        ResultSet rs2 = qStatement.executeQuery(query);
        while (rs2.next()) {
            sensors[rs2.getRow() + 65]
                    = new Sensor_C(rs2.getString("SID"), SensorTypes.valueOf(
                            rs2.getString("SType").toUpperCase()),
                            NodeStatus.valueOf(rs2.getString("Status").
                                    toUpperCase()),
                            new Location(rs2.getInt("XCoord"), rs2.getInt(
                                    "YCoord"), rs2.getInt("ZCoord")));
        }
        rs2.close();

        return sensors;
    }

    public static void displaySensors() throws SQLException,
            ClassNotFoundException {
        Sensor[] sensors = createDBSensors();
        System.out.println("^^^SENSORS^^^");
        System.out.println("ID\tTYPE\t\tSTATUS\tLOCATION");
        System.out.
                println("_________________________________________");
        for (int i = 0; i < sensors.length; i++) {
            System.out.print(sensors[i].getIDNumber() + "\t"
                    + sensors[i].
                            getSensorType() + "\t" + sensors[i].
                            getSensorStatus()
                    + "\t["
                    + sensors[i].getLocation().getX() + ","
                    + sensors[i].
                            getLocation().getY() + "," + sensors[i].
                            getLocation().getZ()
                    + "]\t");
            if (i % 3 == 2) {
                System.out.println();
                System.out.println();
            }
        }
        System.out.println();
    }

}
