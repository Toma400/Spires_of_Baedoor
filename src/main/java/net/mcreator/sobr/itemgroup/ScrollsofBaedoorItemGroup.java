
package net.mcreator.sobr.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.sobr.item.EmptyScrollItem;
import net.mcreator.sobr.SobrModElements;

@SobrModElements.ModElement.Tag
public class ScrollsofBaedoorItemGroup extends SobrModElements.ModElement {
	public ScrollsofBaedoorItemGroup(SobrModElements instance) {
		super(instance, 78);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabscrollsof_baedoor") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(EmptyScrollItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
