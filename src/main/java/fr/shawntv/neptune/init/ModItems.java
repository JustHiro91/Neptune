package fr.shawntv.neptune.init;

import fr.shawntv.neptune.Neptune;
import fr.shawntv.neptune.items.*;
import fr.shawntv.neptune.utils.infos;
import javafx.scene.paint.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
    public ModItems(){
        initItem();
        registerItems();
        registerRenders();

    }

    public static Item neptuneIngot, neptune_helmet, neptune_chestplate, neptune_leggings, neptune_boots;
    public static final Item neptune_sword = new NeptuneSword("neptune_sword", ToolMaterials.neptuneMat);



    private Item[]items;

    public ModItems(Item[] items) {
        this.items = items;
    }

    public void initItem(){
        neptuneIngot = new Item().setRegistryName("neptuneIngot").setUnlocalizedName("neptuneIngot").setCreativeTab(Neptune.neptuneTab);
        neptune_helmet = new NeptuneHelmet ("neptune_helmet", ArmorMaterials.neptuneMat, 2, EntityEquipmentSlot.HEAD);
        neptune_chestplate = new NeptuneChestplate("neptune_chestplate", ArmorMaterials.neptuneMat, 2, EntityEquipmentSlot.CHEST);
        neptune_leggings = new NeptuneLeggings("neptune_leggings", ArmorMaterials.neptuneMat, 2, EntityEquipmentSlot.LEGS);
        neptune_boots = new NeptuneBoots("neptune_boots", ArmorMaterials.neptuneMat, 2, EntityEquipmentSlot.FEET);

    }

    public void registerItems(){
        registerItem(neptuneIngot);
        registerItem(neptune_helmet);
        registerItem(neptune_chestplate);
        registerItem(neptune_leggings);
        registerItem(neptune_boots);
        registerItem(neptune_sword);

    }

    @SideOnly(Side.CLIENT)
    public void registerRenders(){
        registerRender(neptuneIngot, 0);
        registerRender(neptune_helmet, 0);
        registerRender(neptune_chestplate, 0);
        registerRender(neptune_leggings, 0);
        registerRender(neptune_boots, 0);
        registerRender(neptune_sword, 0);

    }
    private void registerItem(Item item) {
        GameRegistry.register(item);
    }

    private void registerRender(Item item, int meta){
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(infos.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
    }

    public static class ArmorMaterials{

        public static final ItemArmor.ArmorMaterial neptuneMat = EnumHelper.addArmorMaterial("neptuneMat", infos.MODID + ":neptuneArmor", 550, new int[]{2, 4, 3, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);
    }

    public static class ToolMaterials{
        public static final Item.ToolMaterial neptuneMat = EnumHelper.addToolMaterial("neptuneMat", 0, 100, 2.0f, 10.1f, 1);
    }


}
