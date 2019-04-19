/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analysis;

import GeoLocation.Location;
import Globals.Analyzable;
import Globals.NodeStatus;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public abstract class DataAnalysis implements Analyzable {

    private String NodeID;
    //private NodeStatus sensorStatus;
    private Location location;
    private ArrayList<Integer> filebuffer = new ArrayList<>();
    public double[] analysisValues = new double[4];

    public DataAnalysis(String NodeID, Location location) {
        this.NodeID = NodeID;
        this.location = location;
    }

    public String getNodeID() {
        return NodeID;
    }

    public void setNodeID(String NodeID) {
        this.NodeID = NodeID;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<Integer> getFilebuffer() {
        return filebuffer;
    }

    public void setFilebuffer(ArrayList<Integer> filebuffer) {
        this.filebuffer = filebuffer;
    }

    public double[] getAnalysisValues() {
        return analysisValues;
    }

    public void setAnalysisValues(double[] analysisValues) {
        this.analysisValues = analysisValues;
    }

}
