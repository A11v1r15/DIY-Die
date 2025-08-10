package net.a11v1r15.diydie;

import net.a11v1r15.diydie.blocks.DIYDieBlocks;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.util.Identifier;

import java.util.Random;

public class DIYDie implements ModInitializer {
	public static final String MOD_ID = "diy-die";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final RegistryKey<ItemGroup> DIY_DIE = RegistryKey.of(Registries.ITEM_GROUP.getKey(), id("item_group"));
	public static final ItemGroup DIY_DIE_ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(DIYDieBlocks.D6))
			.displayName(Text.translatable("diy-die.diy-die"))
			.build();


	@Override
	public void onInitialize() {
		DIYDieBlocks.onInitialize();

		Registry.register(Registries.ITEM_GROUP, DIY_DIE, DIY_DIE_ITEM_GROUP);
		ItemGroupEvents.modifyEntriesEvent(DIY_DIE).register(itemGroup -> {
			itemGroup.add(DIYDieBlocks.D6);
			itemGroup.add(DIYDieBlocks.WHITE_D6);
			itemGroup.add(DIYDieBlocks.LIGHT_GRAY_D6);
			itemGroup.add(DIYDieBlocks.BLACK_D6);
			itemGroup.add(DIYDieBlocks.BROWN_D6);
			itemGroup.add(DIYDieBlocks.RED_D6);
			itemGroup.add(DIYDieBlocks.ORANGE_D6);
			itemGroup.add(DIYDieBlocks.YELLOW_D6);
			itemGroup.add(DIYDieBlocks.LIME_D6);
			itemGroup.add(DIYDieBlocks.GREEN_D6);
			itemGroup.add(DIYDieBlocks.CYAN_D6);
			itemGroup.add(DIYDieBlocks.LIGHT_BLUE_D6);
			itemGroup.add(DIYDieBlocks.BLUE_D6);
			itemGroup.add(DIYDieBlocks.PURPLE_D6);
			itemGroup.add(DIYDieBlocks.MAGENTA_D6);
			itemGroup.add(DIYDieBlocks.PINK_D6);
			itemGroup.add(DIYDieBlocks.FATAL_D6);
			itemGroup.add(DIYDieBlocks.NIHILO_D6);
		});

		Random random = new Random();
		int x = random.nextInt(6) + 1;
		LOGGER.info(switch (x){
			case 1 -> "Rolled a Critical Failure!";
			case 6 -> "Rolled a Critical Hit!";
			default -> "Rolled a " + x;
		});
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}