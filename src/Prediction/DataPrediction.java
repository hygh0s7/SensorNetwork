/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prediction;

import Analysis.DataAnalysis;
import static Globals.Predictions.Prediction1;
import static Globals.Predictions.Prediction2;
import static Globals.Predictions.Prediction3;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class DataPrediction {

    public static void predictParticleAggregation(DataAnalysis da) {
        JLabel LABEL1 = new JLabel("Detected Particles are expected to have " + Prediction1.getClassification() + " " + Prediction1.getValues() + "particle aggregate per cubic meter");
        JLabel LABEL2 = new JLabel("Detected Particles are expected to have " + Prediction2.getClassification() + " " + Prediction2.getValues() + "particle aggregate per cubic meter");
        JLabel LABEL3 = new JLabel("Detected Particles are expected to have " + Prediction3.getClassification() + " " + Prediction3.getValues() + "particle aggregate per cubic meter");

        if (da.analysisValues[0] > 0 && da.analysisValues[0] <= 1000) {
            JFrame jfrmDP = new JFrame("PARTICLE PREDICTION");
            jfrmDP.getContentPane().add(LABEL1);
            jfrmDP.getContentPane().setLayout(new FlowLayout());
            jfrmDP.setBounds(0, 200, 900, 100);
            jfrmDP.setVisible(true);
        }
        else if (da.analysisValues[0] > 1000 && da.analysisValues[0] <= 2000) {
            JFrame jfrmDP = new JFrame("PARTICLE PREDICTION");
            jfrmDP.getContentPane().add(LABEL2);
            jfrmDP.setVisible(true);
            jfrmDP.setBounds(0, 400, 900, 100);
            jfrmDP.setVisible(true);
        }
        if (da.analysisValues[0] > 2000) {
            JFrame jfrmDP = new JFrame("PARTICLE PREDICTION");
            jfrmDP.getContentPane().add(LABEL3);
            jfrmDP.setVisible(true);
            jfrmDP.setBounds(0, 600, 900, 100);
            jfrmDP.setVisible(true);
        }

    }

}
