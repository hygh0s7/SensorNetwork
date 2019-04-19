/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analysis;

import GeoLocation.Location;
import static Globals.Fusionable.FILEA;
import static StatsSupport.JStats.muArrayList;
import static StatsSupport.JStats.sigma2ArrayList;
import static StatsSupport.JStats.sigmaArrayList;
import static StatsSupport.JStats.sumArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DataAnalysis_A extends DataAnalysis {

    public DataAnalysis_A(String NodeID, Location location) {
        super(NodeID, location);
    }

    @Override
    public void readFusedData() {
        String line;
        String[] nums;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(FILEA));
            while (((line = br.readLine()) != null)) {
                nums = line.split(" ");
                int[] numbers = new int[nums.length];
                for (int i = 0; i < nums.length; i++) {

                    numbers[i] = Integer.valueOf(nums[i]);
                }

                for (int i = 0; i < numbers.length; i++) {

                    this.getFilebuffer().add((numbers[i]));
                }
            }
            br.close();

        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(DataAnalysis_A.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(DataAnalysis_A.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void AnalyzeFusedData() {
        this.analysisValues[0] = sumArrayList(this.getFilebuffer());
        this.analysisValues[1] = muArrayList(this.getFilebuffer());
        this.analysisValues[2] = sigma2ArrayList(this.getFilebuffer());
        this.analysisValues[3] = sigmaArrayList(this.getFilebuffer());

    }

    @Override
    public void writeDataToFile() {
        try {
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(3);
            BufferedWriter bw;
            bw = new BufferedWriter(new FileWriter(FILEAA));
            bw.write("SENSOR A ANALYSIS");
            bw.write("\n");
            bw.write("SENSOR SUM: " + df.format(this.analysisValues[0]) + "\n");
            bw.write("SENSOR AVERAGE: " + df.format(this.analysisValues[1]) + "\n");
            bw.write("SENSOR VARIANCE: " + df.format(this.analysisValues[2]) + "\n");
            bw.write("SENSOR STANDARD DEVIATION: " + df.format(this.analysisValues[3]) + "\n");

            bw.close();
        }
        catch (IOException ex) {
            Logger.getLogger(DataAnalysis_A.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
