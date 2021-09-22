package net.mcreator.sobr.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.sobr.potion.SpellPotionBlouPotion;
import net.mcreator.sobr.item.ScrollBlouTargetIItem;
import net.mcreator.sobr.item.ScrollBlouTargetIIItem;
import net.mcreator.sobr.item.ScrollBlouTargetIIIItem;
import net.mcreator.sobr.item.BlouTargetItem;
import net.mcreator.sobr.SobrModElements;

import java.util.Random;
import java.util.Map;

@SobrModElements.ModElement.Tag
public class ScrollUseBlouTargetProcedure extends SobrModElements.ModElement {
	public ScrollUseBlouTargetProcedure(SobrModElements instance) {
		super(instance, 55);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ScrollUseBlouTarget!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure ScrollUseBlouTarget!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure ScrollUseBlouTarget!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure ScrollUseBlouTarget!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure ScrollUseBlouTarget!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ScrollUseBlouTarget!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.getWorld().isRemote) {
			world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.activate")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1);
		} else {
			world.getWorld().playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.activate")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
		}
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(SpellPotionBlouPotion.potion, (int) 20, (int) 1, (false), (false)));
		if (((itemstack).getItem() == new ItemStack(ScrollBlouTargetIItem.block, (int) (1)).getItem())) {
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				BlouTargetItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 2, (float) 0, (int) 5);
			}
		} else if (((itemstack).getItem() == new ItemStack(ScrollBlouTargetIIItem.block, (int) (1)).getItem())) {
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				BlouTargetItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 2, (float) 0, (int) 7);
			}
		} else if (((itemstack).getItem() == new ItemStack(ScrollBlouTargetIIIItem.block, (int) (1)).getItem())) {
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				BlouTargetItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 4, (float) 0, (int) 7);
			}
		}
		((itemstack)).shrink((int) 1);
	}
}
