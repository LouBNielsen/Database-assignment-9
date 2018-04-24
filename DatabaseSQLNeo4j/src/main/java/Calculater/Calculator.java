/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculater;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author louis
 */
public class Calculator {

    public static double average(List<Double> times) {
        double total_time = 0;
        for (double time : times) {
            total_time += time;
        }
        return total_time / times.size();
    }

    public static double median(List<Double> times) {
        Collections.sort(times);
        int middle = times.size() / 2;
        if (times.size() % 2 == 1) {
            return times.get(middle);
        } else {
            return times.get(middle - 1) + times.get(middle + 1) / 2.0;
        }
    }
}
