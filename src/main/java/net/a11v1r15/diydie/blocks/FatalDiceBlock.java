package net.a11v1r15.diydie.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FatalDiceBlock extends DiceBlock {
	public FatalDiceBlock(RegistryKey<DamageType> damageType, Settings settings) {
		super(settings);
		this.damageType = damageType;
	}

	private final RegistryKey<DamageType> damageType;

	public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
		if (placer != null) {
			if (world instanceof ServerWorld serverWorld) {
				if (getComparatorOutput(state, world, pos) == 1) {
					try {
						placer.damage(serverWorld, new DamageSource(serverWorld.getRegistryManager().getEntryOrThrow(damageType)), Float.POSITIVE_INFINITY);
					} catch (IllegalStateException ignored) {
					}
				}
			}
		}
	}
}