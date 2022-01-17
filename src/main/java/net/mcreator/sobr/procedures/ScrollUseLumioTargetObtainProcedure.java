package net.mcreator.sobr.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.sobr.potion.SpellPotionLumioPotionEffect;
import net.mcreator.sobr.SobrMod;

import java.util.Map;

public class ScrollUseLumioTargetObtainProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SobrMod.LOGGER.warn("Failed to load dependency entity for procedure ScrollUseLumioTargetObtain!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				SobrMod.LOGGER.warn("Failed to load dependency sourceentity for procedure ScrollUseLumioTargetObtain!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (((sourceentity.getPersistentData().getDouble("lumio_level")) == 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(SpellPotionLumioPotionEffect.potion, (int) 20, (int) 1, (false), (false)));
		} else if (((sourceentity.getPersistentData().getDouble("lumio_level")) == 2)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(SpellPotionLumioPotionEffect.potion, (int) 20, (int) 2, (false), (false)));
		} else if (((sourceentity.getPersistentData().getDouble("lumio_level")) == 3)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(SpellPotionLumioPotionEffect.potion, (int) 20, (int) 3, (false), (false)));
		} else if (((sourceentity.getPersistentData().getDouble("lumio_level")) == 4)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(SpellPotionLumioPotionEffect.potion, (int) 20, (int) 4, (false), (false)));
		} else if (((sourceentity.getPersistentData().getDouble("lumio_level")) == 5)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(SpellPotionLumioPotionEffect.potion, (int) 20, (int) 5, (false), (false)));
		}
	}
}
