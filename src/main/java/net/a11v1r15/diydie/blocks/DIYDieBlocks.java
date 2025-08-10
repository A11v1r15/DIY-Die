package net.a11v1r15.diydie.blocks;

import net.a11v1r15.diydie.DIYDie;
import net.a11v1r15.diydie.DIYDieUtil;
import net.minecraft.block.Block;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.BlockPlacementDispenserBehavior;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.item.AutomaticItemPlacementContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class DIYDieBlocks {
	public static final Block D6 = DIYDieUtil.register(
			"d6",
			DiceBlock::new,
			DiceBlock.defaultSettings(),
			true
	);
	public static final Block WHITE_D6 = DIYDieUtil.register(
			"white_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings(),
			true
	);
	public static final Block LIGHT_GRAY_D6 = DIYDieUtil.register(
			"light_gray_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings(),
			true
	);
	public static final Block GRAY_D6 = DIYDieUtil.register(
			"gray_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings(),
			true
	);
	public static final Block BLACK_D6 = DIYDieUtil.register(
			"black_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings(),
			true
	);
	public static final Block BROWN_D6 = DIYDieUtil.register(
			"brown_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings(),
			true
	);
	public static final Block RED_D6 = DIYDieUtil.register(
			"red_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings(),
			true
	);
	public static final Block ORANGE_D6 = DIYDieUtil.register(
			"orange_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings(),
			true
	);
	public static final Block YELLOW_D6 = DIYDieUtil.register(
			"yellow_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings(),
			true
	);
	public static final Block LIME_D6 = DIYDieUtil.register(
			"lime_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings(),
			true
	);
	public static final Block GREEN_D6 = DIYDieUtil.register(
			"green_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings(),
			true
	);
	public static final Block CYAN_D6 = DIYDieUtil.register(
			"cyan_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings(),
			true
	);
	public static final Block LIGHT_BLUE_D6 = DIYDieUtil.register(
			"light_blue_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings(),
			true
	);
	public static final Block BLUE_D6 = DIYDieUtil.register(
			"blue_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings(),
			true
	);
	public static final Block PURPLE_D6 = DIYDieUtil.register(
			"purple_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings(),
			true
	);
	public static final Block MAGENTA_D6 = DIYDieUtil.register(
			"magenta_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings(),
			true
	);
	public static final Block PINK_D6 = DIYDieUtil.register(
			"pink_d6",
			DiceBlock::new,
			DiceBlock.defaultSettings(),
			true
	);

	public static final Block FATAL_D6 = DIYDieUtil.register(
			"fatal_d6",
			settings -> new FatalDiceBlock(settings, DamageTypes.WITHER),
			DiceBlock.defaultSettings(),
			true
	);
	public static final Block NIHILO_D6 = DIYDieUtil.register(
			"nihilo_d6",
			settings -> new FatalDiceBlock(settings, DamageTypes.OUT_OF_WORLD),
			DiceBlock.defaultSettings(),
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
		DispenserBlock.registerBehavior(DIYDieBlocks.FATAL_D6, diceBlockPlacementDispenserBehavior);
		DispenserBlock.registerBehavior(DIYDieBlocks.NIHILO_D6, diceBlockPlacementDispenserBehavior);
	}
}
