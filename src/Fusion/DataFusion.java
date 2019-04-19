/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fusion;

import GeoLocation.Location;
import Globals.Fusionable;
import Globals.NodeStatus;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public abstract class DataFusion implements Fusionable {

    private String NodeID;
    //private NodeStatus sensorStatus;
    private Location location;
    private ArrayList<ArrayList<Integer>> codeBuffer = new ArrayList<>();
    private ArrayList<Integer> fusedBuffer = new ArrayList<>();

    public DataFusion(String NodeID, Location location) {
        this.NodeID = NodeID;
        //this.sensorStatus = sensorStatus;
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

    public ArrayList<ArrayList<Integer>> getCodeBuffer() {
        return codeBuffer;
    }

    public void setCodeBuffer(ArrayList<ArrayList<Integer>> codeBuffer) {
        this.codeBuffer = codeBuffer;
    }

    public ArrayList<Integer> getFusedBuffer() {
        return fusedBuffer;
    }

    public void setFusedBuffer(ArrayList<Integer> fusedBuffer) {
        this.fusedBuffer = fusedBuffer;
    }

    @Override
    public void processSensorData() {
        for (int i = 0; i < this.getCodeBuffer().size(); i++) {
            for (int j = 0; j < this.getCodeBuffer().get(i).size(); j++) {
                this.fusedBuffer.add(this.getCodeBuffer().get(i).get(j));
            }

        }
    }

}
