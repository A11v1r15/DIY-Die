package net.a11v1r15.diydie;

import net.a11v1r15.diydie.blocks.DIYDieBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.EndGatewayBlockEntityRenderer;
import net.minecraft.client.render.block.entity.EndPortalBlockEntityRenderer;

public class DIYDieClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT,
				DIYDieBlocks.D6,
				DIYDieBlocks.WHITE_D6,
				DIYDieBlocks.LIGHT_GRAY_D6,
				DIYDieBlocks.BLACK_D6,
				DIYDieBlocks.BROWN_D6,
				DIYDieBlocks.RED_D6,
				DIYDieBlocks.ORANGE_D6,
				DIYDieBlocks.YELLOW_D6,
				DIYDieBlocks.LIME_D6,
				DIYDieBlocks.GREEN_D6,
				DIYDieBlocks.CYAN_D6,
				DIYDieBlocks.LIGHT_BLUE_D6,
				DIYDieBlocks.BLUE_D6,
				DIYDieBlocks.PURPLE_D6,
				DIYDieBlocks.MAGENTA_D6,
				DIYDieBlocks.PINK_D6,
				DIYDieBlocks.FATAL_D6,
				DIYDieBlocks.NIHILO_D6
		);
	}
}