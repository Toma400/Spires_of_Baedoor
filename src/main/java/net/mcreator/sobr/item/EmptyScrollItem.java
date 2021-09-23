
package net.mcreator.sobr.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.sobr.itemgroup.SpiresofBaedoorItemGroup;
import net.mcreator.sobr.SobrModElements;

import java.util.List;

@SobrModElements.ModElement.Tag
public class EmptyScrollItem extends SobrModElements.ModElement {
	@ObjectHolder("sobr:empty_scroll")
	public static final Item block = null;
	public EmptyScrollItem(SobrModElements instance) {
		super(instance, 17);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SpiresofBaedoorItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("empty_scroll");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Scroll without anything written in it"));
		}
	}
}
