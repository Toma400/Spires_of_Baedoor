
package net.mcreator.sobr.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.sobr.block.RunicStoneFireBlock;
import net.mcreator.sobr.SobrModElements;

@SobrModElements.ModElement.Tag
public class SpiresofBaedoorItemGroup extends SobrModElements.ModElement {
	public SpiresofBaedoorItemGroup(SobrModElements instance) {
		super(instance, 43);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabspiresof_baedoor") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(RunicStoneFireBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
