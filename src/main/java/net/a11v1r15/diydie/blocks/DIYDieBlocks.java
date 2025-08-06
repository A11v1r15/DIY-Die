package net.a11v1r15.diydie.blocks;

import net.a11v1r15.diydie.DIYDie;
import net.a11v1r15.diydie.DIYDieUtil;
import net.minecraft.block.Block;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.BlockPlacementDispenserBehavior;
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
	public static final Block FATAL_D6 = DIYDieUtil.register(
			"fatal_d6",
			FatalDiceBlock::new,
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
		DispenserBlock.registerBehavior(DIYDieBlocks.FATAL_D6, diceBlockPlacementDispenserBehavior);
	}
}
