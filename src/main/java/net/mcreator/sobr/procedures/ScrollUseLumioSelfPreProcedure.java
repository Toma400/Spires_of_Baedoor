package net.mcreator.sobr.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.sobr.potion.SpellPotionLumioPotion;
import net.mcreator.sobr.item.ScrollLumioSelfVItem;
import net.mcreator.sobr.item.ScrollLumioSelfIVItem;
import net.mcreator.sobr.item.ScrollLumioSelfIItem;
import net.mcreator.sobr.item.ScrollLumioSelfIIItem;
import net.mcreator.sobr.item.ScrollLumioSelfIIIItem;
import net.mcreator.sobr.SobrModElements;

import java.util.Map;

@SobrModElements.ModElement.Tag
public class ScrollUseLumioSelfPreProcedure extends SobrModElements.ModElement {
	public ScrollUseLumioSelfPreProcedure(SobrModElements instance) {
		super(instance, 61);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ScrollUseLumioSelfPre!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure ScrollUseLumioSelfPre!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure ScrollUseLumioSelfPre!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure ScrollUseLumioSelfPre!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure ScrollUseLumioSelfPre!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ScrollUseLumioSelfPre!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((itemstack).getItem() == new ItemStack(ScrollLumioSelfIItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(SpellPotionLumioPotion.potion, (int) 60, (int) 1, (false), (false)));
		} else if (((itemstack).getItem() == new ItemStack(ScrollLumioSelfIIItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(SpellPotionLumioPotion.potion, (int) 60, (int) 2, (false), (false)));
		} else if (((itemstack).getItem() == new ItemStack(ScrollLumioSelfIIIItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(SpellPotionLumioPotion.potion, (int) 60, (int) 3, (false), (false)));
		} else if (((itemstack).getItem() == new ItemStack(ScrollLumioSelfIVItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(SpellPotionLumioPotion.potion, (int) 40, (int) 4, (false), (false)));
		} else if (((itemstack).getItem() == new ItemStack(ScrollLumioSelfVItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(SpellPotionLumioPotion.potion, (int) 20, (int) 5, (false), (false)));
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
