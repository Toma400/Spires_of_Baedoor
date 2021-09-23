package net.mcreator.sobr.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.sobr.potion.SpellPotionLumioPotion;
import net.mcreator.sobr.item.ScrollLumioTargetVItem;
import net.mcreator.sobr.item.ScrollLumioTargetIVItem;
import net.mcreator.sobr.item.ScrollLumioTargetIItem;
import net.mcreator.sobr.item.ScrollLumioTargetIIItem;
import net.mcreator.sobr.item.ScrollLumioTargetIIIItem;
import net.mcreator.sobr.item.LumioTargetItem;
import net.mcreator.sobr.SobrModElements;

import java.util.Random;
import java.util.Map;

@SobrModElements.ModElement.Tag
public class ScrollUseLumioTargetProcedure extends SobrModElements.ModElement {
	public ScrollUseLumioTargetProcedure(SobrModElements instance) {
		super(instance, 66);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ScrollUseLumioTarget!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure ScrollUseLumioTarget!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ScrollUseLumioTarget!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");
		entity.getPersistentData().putDouble("lumio_level", 0);
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(SpellPotionLumioPotion.potion, (int) 10, (int) 0, (false), (false)));
		if (((itemstack).getItem() == new ItemStack(ScrollLumioTargetIItem.block, (int) (1)).getItem())) {
			entity.getPersistentData().putDouble("lumio_level", 1);
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				LumioTargetItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 10, (float) 0, (int) 0);
			}
		} else if (((itemstack).getItem() == new ItemStack(ScrollLumioTargetIIItem.block, (int) (1)).getItem())) {
			entity.getPersistentData().putDouble("lumio_level", 2);
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				LumioTargetItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 10, (float) 0, (int) 0);
			}
		} else if (((itemstack).getItem() == new ItemStack(ScrollLumioTargetIIIItem.block, (int) (1)).getItem())) {
			entity.getPersistentData().putDouble("lumio_level", 3);
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				LumioTargetItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 10, (float) 0, (int) 0);
			}
		} else if (((itemstack).getItem() == new ItemStack(ScrollLumioTargetIVItem.block, (int) (1)).getItem())) {
			entity.getPersistentData().putDouble("lumio_level", 4);
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				LumioTargetItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 10, (float) 0, (int) 0);
			}
		} else if (((itemstack).getItem() == new ItemStack(ScrollLumioTargetVItem.block, (int) (1)).getItem())) {
			entity.getPersistentData().putDouble("lumio_level", 5);
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				LumioTargetItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 10, (float) 0, (int) 0);
			}
		}
		((itemstack)).shrink((int) 1);
	}
}
