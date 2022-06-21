package toma400.sobr.core;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class SobrTab {
    public static final CreativeModeTab SOBR_TAB = new CreativeModeTab ("sobr_tab") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(SobrItems.BLANK_SCROLL.get());
        }
    };
}