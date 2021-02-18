package fr.shawntv.neptune;

import fr.shawntv.neptune.init.ModItems;
import fr.shawntv.neptune.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import fr.shawntv.neptune.utils.infos;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = infos.MODID , name = infos.NAME,version = infos.VERSION)
public class Neptune {

    public static final CreativeTabs neptuneTab = new CreativeTabs("Neptune") {
        @Override
        public Item getTabIconItem(){
            return ModItems.neptuneIngot;
        }
    };

    @SidedProxy(clientSide = infos.CLIENT_PROXY, serverSide = infos.SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.Instance(infos.MODID)
    public static Neptune instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){
        proxy.preInit();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e){
        proxy.init();

    }
}
