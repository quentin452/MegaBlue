package com.thesparkmods.mega;

import com.thesparkmods.mega.item.BluestoneAxe;
import com.thesparkmods.mega.item.BluestonePickaxe;
import com.thesparkmods.mega.item.BluestoneSpade;
import com.thesparkmods.mega.item.BluestoneSword;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = "megablue", name = "Mega Mod", version = "1.0")
public class MegaMod {

	public static Item bluestoneDust;
	public static Item bluestoneIngot;
	public static Item bluestoneSword;
	public static Item bluestonePickaxe;
	public static Item bluestoneSpade;
	public static Item bluestoneAxe;
	public static Block bluestoneBlock;

	public static Item.ToolMaterial blueToolMaterial = EnumHelper.addToolMaterial("blueToolMaterial", 30, 5000, 15.0F, 10.0F, 45);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		bluestoneDust = new BluestoneDust().setUnlocalizedName("BluestoneDust").setCreativeTab(tabBluestoneMod).setTextureName("mm:bluedust");
		GameRegistry.registerItem(bluestoneDust, bluestoneDust.getUnlocalizedName().substring(5));
		bluestoneIngot = new BluestoneIngot().setUnlocalizedName("BluestoneIngot").setCreativeTab(tabBluestoneMod).setTextureName("mm:blueingot");
		GameRegistry.registerItem(bluestoneIngot, bluestoneIngot.getUnlocalizedName().substring(5));
		bluestoneSword = new BluestoneSword(blueToolMaterial).setUnlocalizedName("BluestoneSword").setCreativeTab(tabBluestoneMod).setTextureName("mm:bluesword");
		GameRegistry.registerItem(bluestoneSword, bluestoneSword.getUnlocalizedName().substring(5));
		bluestonePickaxe = new BluestonePickaxe(blueToolMaterial).setUnlocalizedName("BluestonePickaxe").setCreativeTab(tabBluestoneMod).setTextureName("mm:bluepickaxe");
		GameRegistry.registerItem(bluestonePickaxe, bluestonePickaxe.getUnlocalizedName().substring(5));
		bluestoneSpade = new BluestoneSpade(blueToolMaterial).setUnlocalizedName("BluestoneSpade").setCreativeTab(tabBluestoneMod).setTextureName("mm:bluespade");
		GameRegistry.registerItem(bluestoneSpade, bluestoneSpade.getUnlocalizedName().substring(5));
		bluestoneAxe = new BluestoneAxe(blueToolMaterial).setUnlocalizedName("BluestoneAxe").setCreativeTab(tabBluestoneMod).setTextureName("mm:blueaxe");
		GameRegistry.registerItem(bluestoneAxe, bluestoneAxe.getUnlocalizedName().substring(5));
		bluestoneBlock = new BluestoneBlock(Material.iron).setBlockName("BluestoneBlock").setCreativeTab(tabBluestoneMod).setBlockTextureName("mm:bluestoneblock");
		GameRegistry.registerBlock(bluestoneBlock, bluestoneBlock.getUnlocalizedName().substring(5));
	}

	@EventHandler
	public void inti(FMLInitializationEvent event){
		GameRegistry.addRecipe(new ItemStack(bluestoneDust),new Object[]{"LLL",
				                                                         "LRL",
				                                                         "LLL", 'L',Blocks.lapis_block, 'R',Items.redstone});
		GameRegistry.addSmelting(bluestoneDust, new ItemStack(bluestoneIngot), 25f);

		GameRegistry.addRecipe(new ItemStack(bluestonePickaxe),new Object[]{"KKK",
                                                                            " S ",
                                                                            " S ", 'K',bluestoneBlock, 'S',Items.stick});
		GameRegistry.addRecipe(new ItemStack(bluestoneSword),new Object[]{"K",
                                                                          "K",
                                                                          "S", 'K',bluestoneBlock, 'S',Items.stick});
		GameRegistry.addRecipe(new ItemStack(bluestoneSpade),new Object[]{"K",
                                                                          "S",
                                                                          "S", 'K',bluestoneBlock, 'S',Items.stick});
		GameRegistry.addRecipe(new ItemStack(bluestoneAxe),new Object[]{"KK",
                                                                        "KS",
                                                                        " S", 'K',bluestoneBlock, 'S',Items.stick});
		GameRegistry.addRecipe(new ItemStack(bluestoneBlock), new Object[]{"BBB",
				                                                           "BBB",
				                                                           "BBB", 'B',bluestoneIngot});
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event){

	}
	public static CreativeTabs tabBluestoneMod = new CreativeTabs("tabBluestoneMod"){
		@Override
		public Item getTabIconItem(){
			return new ItemStack(bluestoneDust).getItem();
		}
	};
}
