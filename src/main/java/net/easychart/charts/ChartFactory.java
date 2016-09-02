/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.easychart.charts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.easychart.charts.datahandlers.DynamicDataSheet;

/**
 *
 * @author SShadow
 */
public class ChartFactory {

    private final static Logger LOGGER = Logger.getLogger(ChartFactory.class.getName());

    static {
        LOGGER.setLevel(Level.INFO);
    }

    public static Chart horizontalBar(String chartID, ArrayList colData, ArrayList<String> categories) {
        Chart chart = null;
        try {
            ClassLoader classLoader = Chart.class.getClassLoader();
            String c3s = new Scanner(new File(classLoader.getResource("net/easychart/charts/models/C3HorizontalBar.js").getFile())).useDelimiter("\\Z").next();

            // encerrar las categorías entre comillas para poder usarlas
            categories.replaceAll((String t) -> "\"" + t + "\"");

            String c3script = c3s
                    .replace("chartId", chartID)
                    .replace("colData", colData.toString())
                    .replace("catData", categories.toString().replace("[", "").replace("]", ""));

            chart = new Chart(chartID, c3script);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Chart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chart;
    }

    /**
     * chartId: identificador del chart a generar. Debe ser agredado con addStyle
     * data: DymanicDatasheet con los datos ordenados en filas. Cada fila corresponde a una serie.
     *       las columnas deben tener los labels para el eje x con el siguiente formato: '20130101'
     * 
     * timeFormat: formato a mostrar en el eje x: '%Y-%m-%d'
     */
    public static Chart c3TimeSeries(String chartID, DynamicDataSheet data, String timeFormat) {
        Chart chart = null;
        try {
            ClassLoader classLoader = Chart.class.getClassLoader();
            String c3s = new Scanner(new File(classLoader.getResource("net/easychart/charts/models/C3TimeSeries.js").getFile())).useDelimiter("\\Z").next();

            // ['x', '20130101', '20130102', '20130103', '20130104', '20130105', '20130106'],
            StringBuffer sb = new StringBuffer();
            for (Object string : data.getColumns()) {
                sb.append("\'").append(string).append("\',");
            }
            String labels = sb.deleteCharAt(sb.length() - 1).toString();
            LOGGER.log(Level.FINER, "lables: "+labels);
            
            // Preparar los datos
            // ['data1', 30, 200, 100, 400, 150, 250],
            // ['data2', 130, 340, 200, 500, 250, 350]
            StringBuffer sbData = new StringBuffer();
            
            for (Object row : data.getRows()) {
                String serie = data.getRow(row).toString().replace("\"", "'");
                String sData = serie.toString().replace("[", "['"+row+"',");
                sbData.append(sData).append(",");
            }
            String sData = sbData.deleteCharAt(sbData.length() - 1).toString();
            LOGGER.log(Level.FINER, "datos: "+sData);
            
            String script = c3s
                    .replace("chartId", chartID)
                    .replace("xlabel",labels)
                    .replace("colData", sData)
                    .replace("timeFormat", timeFormat);

            chart = new Chart(chartID, script);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Chart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chart;
    }
}
