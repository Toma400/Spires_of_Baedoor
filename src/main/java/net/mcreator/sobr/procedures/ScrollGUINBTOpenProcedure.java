package net.mcreator.sobr.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.sobr.SobrModElements;

import java.util.Map;

@SobrModElements.ModElement.Tag
public class ScrollGUINBTOpenProcedure extends SobrModElements.ModElement {
	public ScrollGUINBTOpenProcedure(SobrModElements instance) {
		super(instance, 48);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ScrollGUINBTOpen!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("scroll_creating", (true));
	}
}
