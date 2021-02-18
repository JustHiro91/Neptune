package fr.shawntv.neptune.init;

import fr.shawntv.neptune.Neptune;
import fr.shawntv.neptune.utils.infos;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    public ModBlocks(){
        initBlocks();
        registerBlocks();
        registerItemBlocks();
        registerBlockRenders();

    }

    public static Block neptuneBlock;


    private static void initBlocks() {
        neptuneBlock = new Block(Material.IRON).setHardness(2.0f).setResistance(1.5f ).setRegistryName("neptuneBlock").setUnlocalizedName("neptuneBlock").setCreativeTab(Neptune.neptuneTab);

    }

    public static void registerBlocks() {
        registerBlock(neptuneBlock);


    }
    @SideOnly(Side.CLIENT)
    public static void registerBlockRenders() {
        registerBlockRender(neptuneBlock, 0);

    }

    private void registerItemBlocks(){
        registerItemBlock(neptuneBlock);

    }
    /*--------------------------------------------------------------------------------------*/

    private static void registerBlock(Block block) {
        GameRegistry.register(block);

    }

    private static void registerBlockRender(Block block, int meta) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(infos.MODID, block.getUnlocalizedName().substring(5)), "inventory"));

    }

    private void registerItemBlock(Block block){
        ItemBlock ib = new ItemBlock(block);
        ib.setRegistryName(block.getRegistryName());
        GameRegistry.register(ib);

    }
}
