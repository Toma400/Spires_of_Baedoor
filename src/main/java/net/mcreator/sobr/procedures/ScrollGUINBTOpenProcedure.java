package net.mcreator.sobr.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.sobr.SobrMod;

import java.util.Map;

public class ScrollGUINBTOpenProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SobrMod.LOGGER.warn("Failed to load dependency entity for procedure ScrollGUINBTOpen!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("scroll_creating", (true));
	}
}
