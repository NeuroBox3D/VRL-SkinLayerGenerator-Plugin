package edu.gcsc.vrl.slg;

import eu.mihosoft.vrl.system.InitPluginAPI;
import eu.mihosoft.vrl.system.PluginAPI;
import eu.mihosoft.vrl.system.PluginDependency;
import eu.mihosoft.vrl.system.PluginIdentifier;
import eu.mihosoft.vrl.system.VPluginAPI;
import eu.mihosoft.vrl.system.VPluginConfigurator;
import eu.mihosoft.vrl.visual.VFilter;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @brief SkinLayerGeneratorPluginConfigurator
 * @author stephanmg <stephan@syntaktischer-zucker.de>
 */
public class SkinLayerGeneratorPluginConfigurator extends VPluginConfigurator {

	public SkinLayerGeneratorPluginConfigurator() {
		setIdentifier(new PluginIdentifier("VRL-SkinLayerGenerator-Plugin", "0.1"));
		setDescription("Generates vertical skin sections");
		setCopyrightInfo("VRL-SkinLayerGenerator-Plugin",
			"(c) stephanmg",
			"http://neurobox.eu", "LGPLv3", "");

		addDependency(new PluginDependency("VRL", "0.4.3", "0.4.3"));
		addDependency(new PluginDependency("VRL-UG", "0.2", "0.2"));
		addDependency(new PluginDependency("VRL-UG-API", "0.2", "0.2"));
	}

	@Override
	public void register(PluginAPI api) {

		// register plugin with canvas
		if (api instanceof VPluginAPI) {
			VPluginAPI vapi = (VPluginAPI) api;
			vapi.addComponent(SkinLayerGeneratorComponent.class);
			vapi.addComponentSearchFilter(new HideComponentFilter());
		}
	}

	@Override
	public void unregister(PluginAPI api) {
	}

	@Override
	public void init(InitPluginAPI iApi) {
	}

	class HideComponentFilter implements VFilter {
		@Override
		public boolean matches(Object o) {

			if (!(o instanceof DefaultMutableTreeNode)) {
				return false;
			}

			DefaultMutableTreeNode node = (DefaultMutableTreeNode) o;

			if (node.getUserObject() == null
				|| !(node.getUserObject() instanceof Class<?>)) {
				return false;
			}

			Class<?> cls = (Class<?>) node.getUserObject();

			return cls.getName().equalsIgnoreCase("SkinLayerGenerator");
		}

		@Override
		public String getName() {
			return "SkinLayerGenerator's hide filter";
		}

		@Override
		public boolean hideWhenMatching() {
			return true;
		}
	}
}
