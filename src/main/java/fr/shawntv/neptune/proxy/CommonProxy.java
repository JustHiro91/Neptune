package fr.shawntv.neptune.proxy;

import fr.shawntv.neptune.init.ModBlocks;
import fr.shawntv.neptune.init.ModItems;

public class CommonProxy {

    public void preInit()
    {
        new ModItems();
        new ModBlocks();

    }

    public void init(){


    }
}
