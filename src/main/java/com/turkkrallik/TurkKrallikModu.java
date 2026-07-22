package com.turkkrallik;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TurkKrallikModu implements ModInitializer {
    public static final String MOD_ID = "turkkrallik";

    // 1. KRALLIK MERKEZİ VE BİNALAR
    public static final Block KRALLIK_SANCAK_TASI = new Block(FabricBlockSettings.of(Material.STONE).hardness(3.0f));
    public static final Block KRALLIK_KISLA_BLOGU = new Block(FabricBlockSettings.of(Material.STONE).hardness(3.0f)); // Sınırsız Kışla!

    // 2. EKONOMİ VE MATERYALLER
    public static final Item KRALLIK_ALTINI = new Item(new FabricItemSettings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {
        // Blokları Oyuna Kaydet
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "krallik_sancak_tasi"), KRALLIK_SANCAK_TASI);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "krallik_sancak_tasi"), 
                new BlockItem(KRALLIK_SANCAK_TASI, new FabricItemSettings().group(ItemGroup.MISC)));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "krallik_kisla_blogu"), KRALLIK_KISLA_BLOGU);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "krallik_kisla_blogu"), 
                new BlockItem(KRALLIK_KISLA_BLOGU, new FabricItemSettings().group(ItemGroup.MISC)));

        // Parayı Kaydet
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "krallik_altini"), KRALLIK_ALTINI);

        System.out.println("Türk Krallık Modu (Fabric 1.16.5) - Sınırsız Nüfus & Binalar Hazır!");
    }
}