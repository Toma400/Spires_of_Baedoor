package net.mcreator.sobr.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.sobr.potion.SpellPotionLumioPotion;
import net.mcreator.sobr.SobrModElements;

import java.util.Map;
import java.util.Collection;

@SobrModElements.ModElement.Tag
public class OverlaySpellConditionLumioProcedure extends SobrModElements.ModElement {
	public OverlaySpellConditionLumioProcedure(SobrModElements instance) {
		super(instance, 51);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure OverlaySpellConditionLumio!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == SpellPotionLumioPotion.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity));
	}
}
