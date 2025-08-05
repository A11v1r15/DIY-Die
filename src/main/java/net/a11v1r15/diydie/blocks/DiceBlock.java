package net.a11v1r15.diydie.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class DiceBlock extends FacingBlock {
	public DiceBlock(Settings settings) { super(settings);	}
	public static final MapCodec<DiceBlock> CODEC = createCodec(DiceBlock::new);
	private static final VoxelShape SHAPE = Block.createCubeShape(8.0F);
	public MapCodec<DiceBlock> getCodec() {	return CODEC; }

	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return this.getDefaultState().with(FACING, Direction.random(ctx.getWorld().random));
	}

	protected boolean hasComparatorOutput(BlockState state) {
		return true;
	}

	protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
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
	}
}
