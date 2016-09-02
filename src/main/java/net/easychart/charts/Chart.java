/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.easychart.charts;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SShadow
 */
//@StyleSheet("vaadin://addons/c3wrapper/c3.min.css")
// "c3component.js",
@StyleSheet("c3.min.css")
@JavaScript({"c3.min.js", "d3.356.min.js", "chart-component-connector.js"})
public class Chart extends AbstractJavaScriptComponent {

    private final static Logger LOGGER = Logger.getLogger(Chart.class.getName());
    private static final long serialVersionUID = 1L;

    static {
        LOGGER.setLevel(Level.INFO);
    }

    public Chart(String domId, String c3script) {
        getState().domId = domId;
        getState().c3Script = c3script;

        //-- Client to server communication
//        addFunction("C3Script", new JavaScriptFunction() {
//            @Override
//            public void call(JsonArray arguments) {
//                getState().setC3Script(arguments.getString(0));
//                Notification.show("Script cambiado...", Notification.Type.TRAY_NOTIFICATION);
//            }
//        });
    }

    @Override
    final protected ChartState getState() {
        return (ChartState) super.getState();
    }

    public interface ValueChangeListener
            extends Serializable {

        void valueChange();
    }
    
}
