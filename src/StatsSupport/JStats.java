/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StatsSupport;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class JStats {

    public static double sumArrayList(ArrayList<Integer> a) {
        double sum = 0;
        for (Integer a1 : a) {

            sum += a1;
        }
        return sum;
    }

    public static double muArrayList(ArrayList<Integer> a) {
        double sum = 0;
        for (Integer a1 : a) {

            sum += a1;
        }
        return sum / a.size();
    }

    public static double sigma2ArrayList(ArrayList<Integer> a) {
        double sum = 0;
        for (Integer a1 : a) {

            sum += Math.pow((Math.abs(a1 - muArrayList(a))), 2);

        }
        return Math.sqrt(sum) / a.size();
    }

    public static double sigmaArrayList(ArrayList<Integer> a) {
        return Math.sqrt(sigma2ArrayList(a));
    }
}
