package net.mcreator.sobr.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.sobr.potion.SpellPotionLumioPotionEffect;
import net.mcreator.sobr.item.ScrollLumioTargetVItem;
import net.mcreator.sobr.item.ScrollLumioTargetIVItem;
import net.mcreator.sobr.item.ScrollLumioTargetIItem;
import net.mcreator.sobr.item.ScrollLumioTargetIIItem;
import net.mcreator.sobr.item.ScrollLumioTargetIIIItem;
import net.mcreator.sobr.item.LumioTargetItem;
import net.mcreator.sobr.SobrMod;

import java.util.Random;
import java.util.Map;

public class ScrollUseLumioTargetProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SobrMod.LOGGER.warn("Failed to load dependency entity for procedure ScrollUseLumioTarget!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				SobrMod.LOGGER.warn("Failed to load dependency itemstack for procedure ScrollUseLumioTarget!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		entity.getPersistentData().putDouble("lumio_level", 0);
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(SpellPotionLumioPotionEffect.potion, (int) 10, (int) 0, (false), (false)));
		if (((itemstack).getItem() == ScrollLumioTargetIItem.block)) {
			entity.getPersistentData().putDouble("lumio_level", 1);
			if (entity instanceof LivingEntity) {
				Entity _ent = entity;
				if (!_ent.world.isRemote()) {
					LumioTargetItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 10, (float) 0, (int) 0);
				}
			}
		} else if (((itemstack).getItem() == ScrollLumioTargetIIItem.block)) {
			entity.getPersistentData().putDouble("lumio_level", 2);
			if (entity instanceof LivingEntity) {
				Entity _ent = entity;
				if (!_ent.world.isRemote()) {
					LumioTargetItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 10, (float) 0, (int) 0);
				}
			}
		} else if (((itemstack).getItem() == ScrollLumioTargetIIIItem.block)) {
			entity.getPersistentData().putDouble("lumio_level", 3);
			if (entity instanceof LivingEntity) {
				Entity _ent = entity;
				if (!_ent.world.isRemote()) {
					LumioTargetItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 10, (float) 0, (int) 0);
				}
			}
		} else if (((itemstack).getItem() == ScrollLumioTargetIVItem.block)) {
			entity.getPersistentData().putDouble("lumio_level", 4);
			if (entity instanceof LivingEntity) {
				Entity _ent = entity;
				if (!_ent.world.isRemote()) {
					LumioTargetItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 10, (float) 0, (int) 0);
				}
			}
		} else if (((itemstack).getItem() == ScrollLumioTargetVItem.block)) {
			entity.getPersistentData().putDouble("lumio_level", 5);
			if (entity instanceof LivingEntity) {
				Entity _ent = entity;
				if (!_ent.world.isRemote()) {
					LumioTargetItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 10, (float) 0, (int) 0);
				}
			}
		}
		((itemstack)).shrink((int) 1);
	}
}
