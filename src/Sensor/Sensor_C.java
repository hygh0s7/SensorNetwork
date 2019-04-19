/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensor;

import Environment.Particle;
import GeoLocation.Location;
import Globals.NodeStatus;
import static Globals.SensorRanges.SemsorRange_B;
import Globals.SensorTypes;

/**
 *
 * @author Admin
 */
public class Sensor_C extends Sensor {

    public Sensor_C(String IDNumber, SensorTypes sensorType,
            NodeStatus sensorStatus, Location location) {
        super(IDNumber, sensorType, sensorStatus, location);
    }

    @Override
    public void detectParticle(Particle[] p) {
        for (int i = 0; i < p.length; i++) {
            if ((p[i].getPCode().charAt(0) == 'C') && (p[i].getLocation().euclidean(this.getLocation()) <= SemsorRange_B)) {
                detectedParticles.add(p[i]);
            }
        }
    }

    @Override
    public void decodeParticle() {
        for (int i = 0; i < detectedParticles.size(); i++) {
            if (detectedParticles.get(i).getPCode().contains("X")) {
                decodedParticles.add(detectedParticles.get(i).getPCode().indexOf("X"));
            }
            else {
                decodedParticles.add(4);
            }
        }
    }

}
