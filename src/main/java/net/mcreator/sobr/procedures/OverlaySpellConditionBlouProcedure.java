package net.mcreator.sobr.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.sobr.potion.SpellPotionBlouPotion;
import net.mcreator.sobr.SobrModElements;

import java.util.Map;
import java.util.Collection;

@SobrModElements.ModElement.Tag
public class OverlaySpellConditionBlouProcedure extends SobrModElements.ModElement {
	public OverlaySpellConditionBlouProcedure(SobrModElements instance) {
		super(instance, 52);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure OverlaySpellConditionBlou!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == SpellPotionBlouPotion.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity));
	}
}
