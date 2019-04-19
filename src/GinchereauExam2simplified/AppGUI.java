/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GinchereauExam2simplified;

import Analysis.DataAnalysis;
import Analysis.DataAnalysis_A;
import Environment.Particle;
import Factory.DataAnalysisNodeFactory;
import static Factory.DataAnalysisNodeFactory.createDBAnalysisNodes;
import Factory.DataFusionNodeFactory;
import static Factory.DataFusionNodeFactory.createDBFusionNodes;
import Factory.ParticleFactory;
import static Factory.ParticleFactory.createDBParticles;
import Factory.SensorFactory;
import static Factory.SensorFactory.createDBSensors;
import Fusion.DataFusion;
import static Globals.Predictions.Prediction1;
import Prediction.DataPrediction;
import Sensor.Sensor;
import Sensor.Sensor_A;
import Sensor.Sensor_B;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class AppGUI {

    public static void AppGUI() throws SQLException, ClassNotFoundException {

        Particle[] particles = createDBParticles();
        Sensor[] sensors = createDBSensors();
        DataFusion[] dataFusionNodes = createDBFusionNodes();
        DataAnalysis[] dataAnalysisNodes = createDBAnalysisNodes();

        JFrame jfrm = new JFrame("SENSOR NETWORK");

        jfrm.getContentPane().setLayout(new FlowLayout());
        jfrm.setSize(1300, 100);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnDisplaySensors = new JButton("Display Sensors");
        JButton btnDisplayParticles = new JButton("Display Particles");
        JButton btnDisplayFusionNodes = new JButton("Display Fusion Nodes");
        JButton btnDisplayAnalysisNodes = new JButton("Display Analysis Nodes");
        JButton btnDetectParticles = new JButton("Detect Particles");
        JButton btnTransmitSensorData = new JButton("Transmit Sensor Data");
        JButton btnFuseSensorData = new JButton("Fuse Sensor Data");
        JButton btnAnalyzeSensorData = new JButton("Analyze Sensor Data");
        JButton btnPredict = new JButton("PREDICT");

        jfrm.getContentPane().add(btnDisplaySensors);
        jfrm.getContentPane().add(btnDisplayParticles);
        jfrm.getContentPane().add(btnDisplayFusionNodes);
        jfrm.getContentPane().add(btnDisplayAnalysisNodes);
        jfrm.getContentPane().add(btnDetectParticles);
        jfrm.getContentPane().add(btnTransmitSensorData);
        jfrm.getContentPane().add(btnFuseSensorData);
        jfrm.getContentPane().add(btnAnalyzeSensorData);
        jfrm.getContentPane().add(btnPredict);
        jfrm.setVisible(true);

        btnDisplaySensors.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    SensorFactory.displaySensors();
                }
                catch (SQLException ex) {
                    Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        btnDisplayParticles.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ParticleFactory.displayParticles();
                }
                catch (SQLException ex) {
                    Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        btnDisplayFusionNodes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    DataFusionNodeFactory.displayFusionNodes();
                }
                catch (SQLException ex) {
                    Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        btnDisplayAnalysisNodes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    DataAnalysisNodeFactory.displayAnalysisNodes();
                }
                catch (SQLException ex) {
                    Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        btnDetectParticles.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                for (int j = 0; j < sensors.length; j++) {

                    sensors[j].detectParticle(particles);
                    sensors[j].decodeParticle();
                    sensors[j].displayDetectedParticles();
                }

            }

        });
        btnTransmitSensorData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < sensors.length; i++) {
                    if (sensors[i].getClass() == Sensor_A.class) {
                        sensors[i].sendDataToFusionNode(dataFusionNodes[0]);
                    }
                    else if (sensors[i].getClass() == Sensor_B.class) {
                        sensors[i].sendDataToFusionNode(dataFusionNodes[1]);
                    }

                    else {
                        sensors[i].sendDataToFusionNode(dataFusionNodes[2]);
                    }
                }
            }

        });
        btnFuseSensorData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < dataFusionNodes.length; i++) {
                    dataFusionNodes[i].processSensorData();
                    dataFusionNodes[i].writeDataToFile();
                    System.out.println();
                    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^DATA FUSION^^^^^^^^^^^^^^^^^^^^^^^^^");
                    System.out.println("Data Fusion Process Beginning at Data Fusion Node " + dataFusionNodes[i].getNodeID());
                    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                }
            }

        });
        btnAnalyzeSensorData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < dataAnalysisNodes.length; i++) {
                    dataAnalysisNodes[i].readFusedData();

                }
                for (int i = 0; i < dataAnalysisNodes.length; i++) {

                    dataAnalysisNodes[i].AnalyzeFusedData();

                }
                for (int i = 0; i < dataAnalysisNodes.length; i++) {
                    dataAnalysisNodes[i].writeDataToFile();

                }
            }

        });
        btnPredict.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < dataAnalysisNodes.length; i++) {
                    DataPrediction.predictParticleAggregation(dataAnalysisNodes[i]);

                }
            }

        }
        );
    }
}
