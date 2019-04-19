/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fusion;

import GeoLocation.Location;
import Globals.NodeStatus;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DataFusion_A extends DataFusion {

    public DataFusion_A(String NodeID,
            Location location) {
        super(NodeID, location);
    }

    @Override
    public void writeDataToFile() {
        BufferedWriter bw = null;

        try {

            bw = new BufferedWriter(new FileWriter(FILEA));
            for (int k = 0; k < this.getFusedBuffer().size(); k++) {
                bw.write(String.valueOf(this.getFusedBuffer().get(k)) + " ");
                if (k % 10 == 9) {
                    bw.write("\n");
                }

            }
            bw.close();
        }
        catch (IOException ex) {
            Logger.getLogger(DataFusion_A.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
