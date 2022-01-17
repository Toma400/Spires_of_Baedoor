package net.mcreator.sobr.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.sobr.item.ScrollBlouSelfIItem;
import net.mcreator.sobr.item.ScrollBlouSelfIIItem;
import net.mcreator.sobr.item.ScrollBlouSelfIIIItem;
import net.mcreator.sobr.SobrMod;

import java.util.Map;

public class ScrollUseBlouSelfProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SobrMod.LOGGER.warn("Failed to load dependency entity for procedure ScrollUseBlouSelf!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				SobrMod.LOGGER.warn("Failed to load dependency itemstack for procedure ScrollUseBlouSelf!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SobrMod.LOGGER.warn("Failed to load dependency x for procedure ScrollUseBlouSelf!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SobrMod.LOGGER.warn("Failed to load dependency y for procedure ScrollUseBlouSelf!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SobrMod.LOGGER.warn("Failed to load dependency z for procedure ScrollUseBlouSelf!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SobrMod.LOGGER.warn("Failed to load dependency world for procedure ScrollUseBlouSelf!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double hiperpower = 0;
		hiperpower = (double) 0;
		if (((itemstack).getItem() == ScrollBlouSelfIItem.block)) {
			hiperpower = (double) 1;
		} else if (((itemstack).getItem() == ScrollBlouSelfIIItem.block)) {
			hiperpower = (double) 2;
		} else if (((itemstack).getItem() == ScrollBlouSelfIIIItem.block)) {
			hiperpower = (double) 3;
		}
		if (((entity.getHorizontalFacing()) == Direction.NORTH)) {
			entity.setMotion((entity.getMotion().getX()), ((entity.getMotion().getY()) + hiperpower), ((entity.getPosZ()) + (hiperpower * 2)));
		} else if (((entity.getHorizontalFacing()) == Direction.SOUTH)) {
			entity.setMotion((entity.getMotion().getX()), ((entity.getMotion().getY()) + hiperpower), ((entity.getPosZ()) - (hiperpower * 2)));
		} else if (((entity.getHorizontalFacing()) == Direction.WEST)) {
			entity.setMotion(((entity.getMotion().getX()) - (hiperpower * 2)), ((entity.getMotion().getY()) + hiperpower), (entity.getPosZ()));
		} else if (((entity.getHorizontalFacing()) == Direction.EAST)) {
			entity.setMotion(((entity.getMotion().getX()) + (hiperpower * 2)), ((entity.getMotion().getY()) + hiperpower), (entity.getPosZ()));
		}
		if (world instanceof World && !world.isRemote()) {
			((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.ambient")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1);
		} else {
			((World) world).playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.ambient")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
		}
		((itemstack)).shrink((int) 1);
	}
}
