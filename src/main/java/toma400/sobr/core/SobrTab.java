package toma400.sobr.core;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class SobrTab {
    public static final ItemGroup SOBR_TAB = new ItemGroup ("sobr_tab") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(SobrItems.BLANK_SCROLL.get());
        }
    };
}
