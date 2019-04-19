/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensor;

import Environment.Particle;
import Fusion.DataFusion;
import GeoLocation.Location;
import Globals.NodeStatus;
import static Globals.SensorRanges.SemsorRange_A;
import Globals.SensorTypes;

/**
 *
 * @author Admin
 */
public class Sensor_A extends Sensor {

    public Sensor_A(String IDNumber, SensorTypes sensorType,
            NodeStatus sensorStatus, Location location) {
        super(IDNumber, sensorType, sensorStatus, location);
    }

    @Override
    public void detectParticle(Particle[] p) {
        for (int i = 0; i < p.length; i++) {
            if ((p[i].getPCode().charAt(0) == 'A') && (p[i].getLocation().euclidean(this.getLocation()) <= SemsorRange_A)) {
                this.detectedParticles.add(p[i]);
            }
        }

    }

    @Override
    public void decodeParticle() {
        for (int i = 0; i < detectedParticles.size(); i++) {
            if (this.detectedParticles.get(i).getPCode().contains("X")) {
                this.decodedParticles.add(this.detectedParticles.get(i).getPCode().indexOf("X"));
            }
            else {
                this.decodedParticles.add(4);
            }
        }

    }

}
