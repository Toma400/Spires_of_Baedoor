
package net.mcreator.sobr.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.sobr.itemgroup.SpiresofBaedoorItemGroup;
import net.mcreator.sobr.SobrModElements;

@SobrModElements.ModElement.Tag
public class SacrificeKnifeItem extends SobrModElements.ModElement {
	@ObjectHolder("sobr:sacrifice_knife")
	public static final Item block = null;
	public SacrificeKnifeItem(SobrModElements instance) {
		super(instance, 79);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 199;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 7f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3.8f, new Item.Properties().group(SpiresofBaedoorItemGroup.tab)) {
		}.setRegistryName("sacrifice_knife"));
	}
}
