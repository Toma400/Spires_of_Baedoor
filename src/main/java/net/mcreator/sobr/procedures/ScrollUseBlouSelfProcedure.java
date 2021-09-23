package net.mcreator.sobr.procedures;

import net.minecraftforge.registries.ForgeRegistries;

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
import net.mcreator.sobr.SobrModElements;

import java.util.Map;

@SobrModElements.ModElement.Tag
public class ScrollUseBlouSelfProcedure extends SobrModElements.ModElement {
	public ScrollUseBlouSelfProcedure(SobrModElements instance) {
		super(instance, 69);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ScrollUseBlouSelf!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure ScrollUseBlouSelf!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure ScrollUseBlouSelf!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure ScrollUseBlouSelf!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure ScrollUseBlouSelf!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ScrollUseBlouSelf!");
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
		if (((itemstack).getItem() == new ItemStack(ScrollBlouSelfIItem.block, (int) (1)).getItem())) {
			hiperpower = (double) 1;
		} else if (((itemstack).getItem() == new ItemStack(ScrollBlouSelfIIItem.block, (int) (1)).getItem())) {
			hiperpower = (double) 2;
		} else if (((itemstack).getItem() == new ItemStack(ScrollBlouSelfIIIItem.block, (int) (1)).getItem())) {
			hiperpower = (double) 3;
		}
		if (((entity.getHorizontalFacing()) == Direction.NORTH)) {
			entity.setMotion((entity.getMotion().getX()), ((entity.getMotion().getY()) + (hiperpower)), ((entity.posZ) + ((hiperpower) * 2)));
		} else if (((entity.getHorizontalFacing()) == Direction.SOUTH)) {
			entity.setMotion((entity.getMotion().getX()), ((entity.getMotion().getY()) + (hiperpower)), ((entity.posZ) - ((hiperpower) * 2)));
		} else if (((entity.getHorizontalFacing()) == Direction.WEST)) {
			entity.setMotion(((entity.getMotion().getX()) - ((hiperpower) * 2)), ((entity.getMotion().getY()) + (hiperpower)), (entity.posZ));
		} else if (((entity.getHorizontalFacing()) == Direction.EAST)) {
			entity.setMotion(((entity.getMotion().getX()) + ((hiperpower) * 2)), ((entity.getMotion().getY()) + (hiperpower)), (entity.posZ));
		}
		if (!world.getWorld().isRemote) {
			world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.ambient")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1);
		} else {
			world.getWorld().playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.ambient")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
		}
		((itemstack)).shrink((int) 1);
	}
}
