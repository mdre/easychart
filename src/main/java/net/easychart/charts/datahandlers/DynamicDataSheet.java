/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.easychart.charts.datahandlers;

import com.oracle.jrockit.jfr.DataType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Datasheet provee una estructura de planilla para insetar los datos referenciados por fila/columna.
 * 
 * @author SShadow
 */
public class DynamicDataSheet <R,C,O> {
    private final static Logger LOGGER = Logger.getLogger(DynamicDataSheet.class .getName());
    static {
        LOGGER.setLevel(Level.INFO);
    }
    
    ArrayList<C> columns;
    ArrayList<R> rows;
    
    HashMap<R,HashMap<C,O>> datasheet;
    
    public DynamicDataSheet() {
        
        this.columns = new ArrayList<>();
        this.rows = new ArrayList<>();
        this.datasheet = new HashMap<>();
    }
    
    public void  put(R row, C col, O data) {
        
        HashMap<C,O> rowhm = this.datasheet.get(row);
        // si no se recupera la fila, se debe insertar
        if (rowhm == null) {
            rowhm = new HashMap<>();
            this.datasheet.put(row, rowhm);
            
        }
        // la fila ya existe, insertar el dato
        rowhm.put(col, data);
        
        // verificar que la fila y columna esten declaradas
        if (!columns.contains(col)) columns.add(col);
        if (!rows.contains(row)) rows.add(row);
        
    }
    
    /**
     * Devuelve las referencias de todas las filas
     * @return 
     */
    public ArrayList<R> getRows(){
        return this.rows;
    }
    
    /**
     * Devuelve los referencias de todas las columnas
     * @return 
     */
    public ArrayList<C> getColumns(){
        return this.columns;
    }
      
    /**
     * Devuelve un dato a partir de una referencia de fila/columna
     * @param row fila a acceder
     * @param col columna a acceder
     * @return objeto almancenado en la fila/columna
     */
    public O getData(R row, C col) {
        HashMap<C,O> rowhm = this.datasheet.get(row);
        if (rowhm != null) {
            return rowhm.get(col);
        }
        return null;
    }
    
    /**
     * Devolver los datos de una fila determinada
     * @param row
     * @return 
     */
    public ArrayList<O> getRow(R row) {
        ArrayList<O> data = new ArrayList<>();
        HashMap<C,O> rowhm = this.datasheet.get(row);
        // recorrer toda la fila buscando los datos para cada columna declarada.
        // si un dato no está se devuelve null.
        for (C c : columns) {
            data.add(rowhm.get(c));
        }
        return data;
    }
    
    /**
     * Devolver los datos de una columna determinada
     * @param row
     * @return 
     */
    public ArrayList<O> getCol(C col) {
        ArrayList<O> data = new ArrayList<>();
        
        // recorrer toda la columna buscando los datos para cada fila de clarada.
        // si un dato no está se devuelve null.
        for (Map.Entry<R, HashMap<C, O>> entry : datasheet.entrySet()) {
            R key = entry.getKey();
            HashMap<C, O> rowhm = entry.getValue();
            
            data.add(rowhm.get(col));
        }
        
        return data;
    }
    
}
