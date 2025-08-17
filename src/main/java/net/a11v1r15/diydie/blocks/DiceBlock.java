package net.a11v1r15.diydie.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import org.jetbrains.annotations.NotNull;

public class DiceBlock extends FacingBlock implements Waterloggable {
	public DiceBlock(Settings settings) { super(settings); }
	public static final MapCodec<? extends DiceBlock> CODEC = createCodec(DiceBlock::new);
	private static final VoxelShape SHAPE = Block.createCubeShape(8.0F);
	public MapCodec<? extends DiceBlock> getCodec() { return CODEC; }
	public static final IntProperty ROTATION = IntProperty.of("rotation", 0, 3);
	public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

	public BlockState getPlacementState(ItemPlacementContext ctx) {
		FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
		return this.getDefaultState()
				.with(FACING, Direction.random(ctx.getWorld().random))
				.with(ROTATION, ctx.getWorld().random.nextInt(4))
				.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
	}

	public FluidState getFluidState(@NotNull BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
	}

	protected BlockState getStateForNeighborUpdate(@NotNull BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
		if (state.get(WATERLOGGED)) {
			tickView.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
		}
		return super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
	}

	protected boolean hasComparatorOutput(BlockState state) {
		return true;
	}

	protected int getComparatorOutput(@NotNull BlockState state, World world, BlockPos pos) {
		return switch (state.get(FACING)) {
			case DOWN -> 1;
			case SOUTH -> 2;
			case WEST -> 3;
			case EAST -> 4;
			case NORTH -> 5;
			case UP -> 6;
		};
	}

	protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return SHAPE;
	}

	protected boolean canPathfindThrough(BlockState state, NavigationType type) {
		return false;
	}

	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(new Property[]{FACING});
		builder.add(new Property[]{ROTATION});
		builder.add(new Property[]{WATERLOGGED});
	}

	public static AbstractBlock.Settings defaultSettings() {
		return AbstractBlock.Settings.create()
				.nonOpaque()
				.breakInstantly()
				.pistonBehavior(PistonBehavior.DESTROY)
				.sounds(BlockSoundGroup.BONE);
	}
}
