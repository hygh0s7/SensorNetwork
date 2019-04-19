/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fusion;

import GeoLocation.Location;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DataFusion_C extends DataFusion {

    public DataFusion_C(String NodeID,
            Location location) {
        super(NodeID, location);
    }

    @Override
    public void writeDataToFile() {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(FILEC));
            for (int k = 0; k < this.getFusedBuffer().size(); k++) {
                if (k == (this.getFusedBuffer().size() - 1)) {
                    bw.write(String.valueOf(this.getFusedBuffer().get(k)) + "\n");
                }
                else if (k % 10 == 9) {
                    bw.write(String.valueOf(this.getFusedBuffer().get(k)) + "\n");
                }
                else {
                    bw.write(String.valueOf(this.getFusedBuffer().get(k) + " "));
                }
            }
            bw.close();
        }
        catch (IOException ex) {
            Logger.getLogger(DataFusion_A.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
