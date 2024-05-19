package hammersr.Items;

import net.minecraft.core.block.Block;

import java.util.Arrays;
import java.util.List;

public class BlockLists {
	List<Integer> BlockHammersBlacklist = Arrays.asList(
	Block.bedrock.id, Block.sand.id, Block.dirt.id,
	Block.grass.id, Block.gravel.id, Block.dirtScorched.id,
	Block.dirtScorchedRich.id, Block.farmlandDirt.id, Block.pathDirt.id,
	Block.mobspawner.id, Block.mobspawnerDeactivated.id, Block.chestLegacy.id,
	Block.chestLegacyPainted.id, Block.chestPlanksOak.id, Block.chestPlanksOakPainted.id,Block.grassScorched.id,
		Block.blockClay.id,Block.grassRetro.id,Block.mud.id
	);

	List<Integer> BlockExcavatorsWhiteList = Arrays.asList(
		Block.sand.id, Block.dirt.id,
		Block.grass.id, Block.gravel.id, Block.dirtScorched.id,
		Block.dirtScorchedRich.id, Block.farmlandDirt.id, Block.pathDirt.id,
		Block.blockClay.id,Block.grassScorched.id,Block.grassRetro.id,Block.mud.id
	);

}
