package net.mcreator.sobr.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.sobr.SobrModElements;

import java.util.Map;

@SobrModElements.ModElement.Tag
public class ScrollGUINBTClosedProcedure extends SobrModElements.ModElement {
	public ScrollGUINBTClosedProcedure(SobrModElements instance) {
		super(instance, 49);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ScrollGUINBTClosed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("scroll_creating", (false));
	}
}
