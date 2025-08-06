package net.a11v1r15.diydie.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FatalDiceBlock extends DiceBlock {
	public FatalDiceBlock(Settings settings) {
		super(settings);
	}

	public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
		if (placer != null) {
			if (world instanceof ServerWorld serverWorld) {
				if (getComparatorOutput(state, world, pos) == 1) {
					try {
						placer.damage(serverWorld, new DamageSource(serverWorld.getRegistryManager().getEntryOrThrow(DamageTypes.WITHER)), Float.POSITIVE_INFINITY);
					} catch (IllegalStateException ignored) {
					}
				}
			}
		}
	}
}