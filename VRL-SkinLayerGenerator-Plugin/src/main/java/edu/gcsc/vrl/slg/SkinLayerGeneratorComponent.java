package edu.gcsc.vrl.slg;

import edu.gcsc.vrl.ug.api.I_SkinLayerGenerator;
import edu.gcsc.vrl.ug.api.SkinLayerGenerator;
import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import java.io.Serializable;

/**
 * @brief SkinLayerGeneratorComponent
 * @author stephanmg <stephan@syntaktischer-zucker.de>
 */
@ComponentInfo(name="SkinLayerGeneratorComponent", category="Neuro/")
public class SkinLayerGeneratorComponent implements Serializable {
    private static final long serialVersionUID = 1L;
    private final I_SkinLayerGenerator slg = new SkinLayerGenerator();

    /**
     * @brief add layer
     * @param name
     * @param height
     * @param res
     */
    public void add_layer(
	    @ParamInfo(name="Name") 
	    String name,
	    @ParamInfo(name="Height")
	    Double height,
	    @ParamInfo(name="Resolution")
	    Double res
    ) {
	    slg.add_layer(height, res, name);
    }

    /**
     * @brief add layer with depot
     * @param name
     * @param height
     * @param res
     * @param depotName
     * @param depotPos
     * @param depotRes
     * @param depotWidth
     * @param depotHeight
     */
    public void add_layer_with_depot(
	    @ParamInfo(name="Name") 
	    String name,
	    @ParamInfo(name="Height")
	    Double height,
	    @ParamInfo(name="Resolution")
	    Double res,
	    @ParamInfo(name="Depot's name")
	    String depotName,
	    @ParamInfo(name="Depot's position")
	    Double depotPos,
	    @ParamInfo(name="Depot's resolution")
	    Double depotRes,
	    @ParamInfo(name="Depot's width")
	    Double depotWidth,
	    @ParamInfo(name="Depot's height")
	    Double depotHeight
    ) {
	slg.add_layer_with_injection(height, res, name, depotName, depotHeight, depotWidth, depotPos);
    }
    
    /**
     * @brief generate mesh
     */
    public void generate() {
	    slg.generate();
    }
}
