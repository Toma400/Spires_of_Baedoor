
package net.mcreator.sobr.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.sobr.itemgroup.SpiresofBaedoorItemGroup;
import net.mcreator.sobr.SobrModElements;

import java.util.List;
import java.util.Collections;

@SobrModElements.ModElement.Tag
public class RottenFleshBlockBlock extends SobrModElements.ModElement {
	@ObjectHolder("sobr:rotten_flesh_block")
	public static final Block block = null;
	public RottenFleshBlockBlock(SobrModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(SpiresofBaedoorItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(0.5f, 1f).lightValue(0).harvestLevel(0)
					.harvestTool(ToolType.SHOVEL));
			setRegistryName("rotten_flesh_block");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
