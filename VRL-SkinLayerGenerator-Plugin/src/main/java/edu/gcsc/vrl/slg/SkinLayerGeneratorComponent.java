package edu.gcsc.vrl.slg;

import edu.gcsc.vrl.ug.api.I_SkinLayerGenerator;
import edu.gcsc.vrl.ug.api.SkinLayerGenerator;
import eu.mihosoft.vrl.annotation.ComponentInfo;
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
     */
    public void add_layer() {
	    
    }

    /**
     * @brief add layer with depot
     */
    public void add_layer_with_depot() {
	    
    }
    
    /**
     * @brief generate mesh
     */
    public void generate() {
	    slg.generate();
    }
}
