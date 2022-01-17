package net.mcreator.sobr.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.sobr.potion.SpellPotionLumioPotionEffect;
import net.mcreator.sobr.item.ScrollLumioFieldIItem;
import net.mcreator.sobr.item.ScrollLumioFieldIIItem;
import net.mcreator.sobr.item.ScrollLumioFieldIIIItem;
import net.mcreator.sobr.SobrMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class ScrollUseLumioFieldProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SobrMod.LOGGER.warn("Failed to load dependency entity for procedure ScrollUseLumioField!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				SobrMod.LOGGER.warn("Failed to load dependency itemstack for procedure ScrollUseLumioField!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SobrMod.LOGGER.warn("Failed to load dependency x for procedure ScrollUseLumioField!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SobrMod.LOGGER.warn("Failed to load dependency y for procedure ScrollUseLumioField!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SobrMod.LOGGER.warn("Failed to load dependency z for procedure ScrollUseLumioField!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SobrMod.LOGGER.warn("Failed to load dependency world for procedure ScrollUseLumioField!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double personal_level = 0;
		if (world instanceof World && !world.isRemote()) {
			((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.ambient.short")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1);
		} else {
			((World) world).playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.ambient.short")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
		}
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(SpellPotionLumioPotionEffect.potion, (int) 10, (int) 0, (false), (false)));
		if (((itemstack).getItem() == ScrollLumioFieldIItem.block)) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (3 / 2d), y - (3 / 2d), z - (3 / 2d), x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity)
						((LivingEntity) entityiterator)
								.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 300, (int) 1, (false), (false)));
				}
			}
		} else if (((itemstack).getItem() == ScrollLumioFieldIIItem.block)) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (6 / 2d), y - (6 / 2d), z - (6 / 2d), x + (6 / 2d), y + (6 / 2d), z + (6 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity)
						((LivingEntity) entityiterator)
								.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 600, (int) 1, (false), (false)));
				}
			}
		} else if (((itemstack).getItem() == ScrollLumioFieldIIIItem.block)) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (9 / 2d), y - (9 / 2d), z - (9 / 2d), x + (9 / 2d), y + (9 / 2d), z + (9 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity)
						((LivingEntity) entityiterator)
								.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 1200, (int) 1, (false), (false)));
				}
			}
		}
		((itemstack)).shrink((int) 1);
	}
}
