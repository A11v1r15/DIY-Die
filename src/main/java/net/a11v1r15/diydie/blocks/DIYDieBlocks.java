package net.a11v1r15.diydie.blocks;

import net.a11v1r15.diydie.DIYDie;
import net.a11v1r15.diydie.DIYDieUtil;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.dispenser.BlockPlacementDispenserBehavior;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.item.AutomaticItemPlacementContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class DIYDieBlocks {
	public static final Block D6 = DIYDieUtil.register(
			"d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.PALE_YELLOW),
			true
	);
	public static final Block WHITE_D6 = DIYDieUtil.register(
			"white_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.WHITE),
			true
	);
	public static final Block LIGHT_GRAY_D6 = DIYDieUtil.register(
			"light_gray_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.LIGHT_GRAY),
			true
	);
	public static final Block GRAY_D6 = DIYDieUtil.register(
			"gray_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.GRAY),
			true
	);
	public static final Block BLACK_D6 = DIYDieUtil.register(
			"black_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.BLACK),
			true
	);
	public static final Block BROWN_D6 = DIYDieUtil.register(
			"brown_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.BROWN),
			true
	);
	public static final Block RED_D6 = DIYDieUtil.register(
			"red_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.RED),
			true
	);
	public static final Block ORANGE_D6 = DIYDieUtil.register(
			"orange_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.ORANGE),
			true
	);
	public static final Block YELLOW_D6 = DIYDieUtil.register(
			"yellow_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.YELLOW),
			true
	);
	public static final Block LIME_D6 = DIYDieUtil.register(
			"lime_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.LIME),
			true
	);
	public static final Block GREEN_D6 = DIYDieUtil.register(
			"green_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.GREEN),
			true
	);
	public static final Block CYAN_D6 = DIYDieUtil.register(
			"cyan_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.CYAN),
			true
	);
	public static final Block LIGHT_BLUE_D6 = DIYDieUtil.register(
			"light_blue_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.LIGHT_BLUE),
			true
	);
	public static final Block BLUE_D6 = DIYDieUtil.register(
			"blue_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.BLUE),
			true
	);
	public static final Block PURPLE_D6 = DIYDieUtil.register(
			"purple_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.PURPLE),
			true
	);
	public static final Block MAGENTA_D6 = DIYDieUtil.register(
			"magenta_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.MAGENTA),
			true
	);
	public static final Block PINK_D6 = DIYDieUtil.register(
			"pink_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.PINK),
			true
	);

	public static final Block COPPER_D6 = DIYDieUtil.register(
			"copper_d6",
			settings -> new OxidizableDiceBlock(Oxidizable.OxidationLevel.UNAFFECTED, settings),
			DiceBlock.defaultSettings().mapColor(MapColor.ORANGE).sounds(BlockSoundGroup.COPPER),
			true
	);
	public static final Block EXPOSED_COPPER_D6 = DIYDieUtil.register(
			"exposed_copper_d6",
			settings -> new OxidizableDiceBlock(Oxidizable.OxidationLevel.EXPOSED, settings),
			DiceBlock.defaultSettings().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).sounds(BlockSoundGroup.COPPER),
			true
	);
	public static final Block WEATHERED_COPPER_D6 = DIYDieUtil.register(
			"weathered_copper_d6",
			settings -> new OxidizableDiceBlock(Oxidizable.OxidationLevel.WEATHERED, settings),
			DiceBlock.defaultSettings().mapColor(MapColor.DARK_AQUA).sounds(BlockSoundGroup.COPPER),
			true
	);
	public static final Block OXIDIZED_COPPER_D6 = DIYDieUtil.register(
			"oxidized_copper_d6",
			settings -> new OxidizableDiceBlock(Oxidizable.OxidationLevel.OXIDIZED, settings),
			DiceBlock.defaultSettings().mapColor(MapColor.TEAL).sounds(BlockSoundGroup.COPPER),
			true
	);
	public static final Block WAXED_COPPER_D6 = DIYDieUtil.register(
			"waxed_copper_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.ORANGE).sounds(BlockSoundGroup.COPPER),
			true
	);
	public static final Block WAXED_EXPOSED_COPPER_D6 = DIYDieUtil.register(
			"waxed_exposed_copper_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).sounds(BlockSoundGroup.COPPER),
			true
	);
	public static final Block WAXED_WEATHERED_COPPER_D6 = DIYDieUtil.register(
			"waxed_weathered_copper_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.DARK_AQUA).sounds(BlockSoundGroup.COPPER),
			true
	);
	public static final Block WAXED_OXIDIZED_COPPER_D6 = DIYDieUtil.register(
			"waxed_oxidized_copper_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings().mapColor(MapColor.TEAL).sounds(BlockSoundGroup.COPPER),
			true
	);

	public static final Block FATAL_D6 = DIYDieUtil.register(
			"fatal_d6",
			settings -> new FatalDiceBlock(DamageTypes.WITHER, settings),
			DiceBlock.defaultSettings().mapColor(MapColor.BLACK),
			true
	);
	public static final Block NIHILO_D6 = DIYDieUtil.register(
			"nihilo_d6",
			settings -> new FatalDiceBlock(DamageTypes.OUT_OF_WORLD, settings),
			DiceBlock.defaultSettings().mapColor(MapColor.CLEAR).sounds(BlockSoundGroup.INTENTIONALLY_EMPTY),
			true
	);

	public static void onInitialize() {
		BlockPlacementDispenserBehavior diceBlockPlacementDispenserBehavior = new BlockPlacementDispenserBehavior() {
			protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
				this.setSuccess(false);
				Item item = stack.getItem();
				if (item instanceof BlockItem) {
					Direction direction = pointer.state().get(DispenserBlock.FACING);
					BlockPos blockPos = pointer.pos().offset(direction);
					try {
						this.setSuccess(((BlockItem) item).place(new AutomaticItemPlacementContext(pointer.world(), blockPos, direction, stack, Direction.UP)).isAccepted());
					} catch (Exception exception) {
						DIYDie.LOGGER.error("Error trying to place die at {}", blockPos, exception);
					}
				}
				return stack;
			}

			;
		};

		DispenserBlock.registerBehavior(DIYDieBlocks.D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.WHITE_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.LIGHT_GRAY_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.GRAY_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.BLACK_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.BROWN_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.RED_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.ORANGE_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.YELLOW_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.LIME_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.GREEN_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.CYAN_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.LIGHT_BLUE_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.BLUE_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.PURPLE_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.MAGENTA_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.PINK_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.COPPER_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.EXPOSED_COPPER_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.WEATHERED_COPPER_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.OXIDIZED_COPPER_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.WAXED_COPPER_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.WAXED_EXPOSED_COPPER_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.WAXED_WEATHERED_COPPER_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.WAXED_OXIDIZED_COPPER_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.FATAL_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.NIHILO_D6, diceBlockPlacementDispenserBehavior);

		OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_D6, EXPOSED_COPPER_D6);
		OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_D6, WEATHERED_COPPER_D6);
		OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_D6, OXIDIZED_COPPER_D6);
		OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_D6, WAXED_COPPER_D6);
		OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_D6, WAXED_EXPOSED_COPPER_D6);
		OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_D6, WAXED_WEATHERED_COPPER_D6);
		OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_D6, WAXED_OXIDIZED_COPPER_D6);
	}
}
