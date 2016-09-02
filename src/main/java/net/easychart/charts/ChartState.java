/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.easychart.charts;

import com.vaadin.shared.ui.JavaScriptComponentState;

/**
 *
 * @author SShadow
 */
public class ChartState  extends JavaScriptComponentState {
    private static final long serialVersionUID = -818917911954398338L;
//    private final static Logger LOGGER = Logger.getLogger(ChartState.class .getName());
//    static {
//        LOGGER.setLevel(Level.INFO);
//    }
    
    public String domId;

    public String c3Script;
    
    public void setScript(String script) {
        this.c3Script = script;
    }
}
