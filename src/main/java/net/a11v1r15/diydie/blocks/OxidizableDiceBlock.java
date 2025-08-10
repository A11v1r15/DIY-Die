package net.a11v1r15.diydie.blocks;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class OxidizableDiceBlock extends DiceBlock implements Oxidizable {
	public static final MapCodec<OxidizableDiceBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(OxidationLevel.CODEC.fieldOf("weathering_state").forGetter(Degradable::getDegradationLevel), createSettingsCodec()).apply(instance, OxidizableDiceBlock::new));
	private final Oxidizable.OxidationLevel oxidationLevel;

	public MapCodec<OxidizableDiceBlock> getCodec() {
		return CODEC;
	}

	public OxidizableDiceBlock(Oxidizable.OxidationLevel oxidationLevel, AbstractBlock.Settings settings) {
		super(settings);
		this.oxidationLevel = oxidationLevel;
	}

	protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		this.tickDegradation(state, world, pos, random);
	}

	protected boolean hasRandomTicks(BlockState state) {
		return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
	}

	public Oxidizable.OxidationLevel getDegradationLevel() {
		return this.oxidationLevel;
	}
}