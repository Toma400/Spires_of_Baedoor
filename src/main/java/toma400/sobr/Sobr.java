package toma400.sobr;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import toma400.sobr.core.SobrItems;

import static toma400.sobr.Sobr.MOD_ID;

@Mod(MOD_ID)
public class Sobr
{
    public static final String MOD_ID = "sobr";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Sobr()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::setup);

        SobrItems.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }
}
