/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import DBSupport.DBConnection;
import Environment.Particle;
import GeoLocation.Location;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class ParticleFactory {

    public static Particle[] createDBParticles() throws SQLException,
            ClassNotFoundException {
        Particle[] particles = new Particle[300];

        String query
                = "SELECT * FROM "
                + "tachyon.particles"
                + " JOIN particle_location ON particles.IDNumber = particle_location.IDNumber";
        DBConnection db = new DBConnection();
        Connection conn = db.establishDBConnection();
        Statement useStatement = conn.createStatement();
        useStatement.executeQuery("USE tachyon");
        Statement qStatement = conn.createStatement();
        ResultSet rs = qStatement.executeQuery(query);

        while (rs.next()) {
            particles[rs.getRow() - 1]
                    = new Particle(rs.getString("IDNumber"), rs.getString(
                            "PCode"), new Location(rs.getInt("XCoord"), rs.
                                    getInt("YCoord"), rs.getInt("ZCoord")));
        }
        return particles;
    }

    public static void displayParticles() throws SQLException,
            ClassNotFoundException {

        Particle[] particles = createDBParticles();
        System.out.println("^^^PARTICLES^^^");
        System.out.println("ID\tPCODE\tLOCATION");
        System.out.
                println("_________________________________________");
        for (int i = 0; i < particles.length; i++) {
            System.out.print(particles[i].getIDNumber() + "\t"
                    + particles[i].
                            getPCode()
                    + "\t["
                    + particles[i].getLocation().getX() + ","
                    + particles[i].
                            getLocation().getY() + "," + particles[i].
                            getLocation().getZ()
                    + "]\t");
            if (i % 5 == 4) {
                System.out.println();
                System.out.println();
            }
        }
        System.out.println();
    }

}
