package hammersr.Items;

import hammersr.HammersAndExcavators;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.world.World;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class HammerItem extends ItemTool {
	public static Map<Block, Integer> miningLevels;


	public HammerItem(String name, int id, ToolMaterial enumtoolmaterial) {
		super(name, id, 2, enumtoolmaterial, BlockTags.MINEABLE_BY_PICKAXE);
	}

	static {
		miningLevels = ItemToolPickaxe.miningLevels;
	}

	public boolean canHarvestBlock(Block block) {
		Integer mininglevel = miningLevels.get(block);
		if (mininglevel != null) {
			return this.material.getMiningLevel() >= mininglevel;
		} else {
			return block.hasTag(BlockTags.MINEABLE_BY_PICKAXE);
		}
	}

	protected void MineBlock(int x, int y, int z, World world, EntityLiving player) {
		Item GoldItem = HammersAndExcavators.hammerGold;
		Item heldItem = player.getHeldItem().getItem();
		if (!world.isClientSide) {
			if (world.getBlock(x, y, z) != null && !isBlockMatchToBlacklist(world.getBlock(x, y, z).id, new BlockLists().BlockHammersBlacklist))
				if (heldItem != GoldItem) {
					ItemStack[] itemToDrop = world.getBlock(x, y, z).getBreakResult(world, EnumDropCause.PROPER_TOOL, x, y, z, world.getBlockMetadata(x, y, z), world.getBlockTileEntity(x, y, z));
					world.setBlockWithNotify(x, y, z, 0);
					if (itemToDrop != null) {
						Arrays.stream(itemToDrop).filter(Objects::nonNull).forEach(expDrop -> world.dropItem(x, y, z, expDrop));
					}
				} else {
					ItemStack[] itemToDrop = world.getBlock(x, y, z).getBreakResult(world, EnumDropCause.SILK_TOUCH, x, y, z, world.getBlockMetadata(x, y, z), world.getBlockTileEntity(x, y, z));
					world.setBlockWithNotify(x, y, z, 0);
					if (itemToDrop != null) {
						Arrays.stream(itemToDrop).filter(Objects::nonNull).forEach(expDrop -> world.dropItem(x, y, z, expDrop));
					}
				}
		}
	}

	private static boolean isBlockMatchToBlacklist(int BlockId, List<Integer> list) {
		boolean BlockMatchToBlacklist;
		BlockMatchToBlacklist = list.contains(BlockId);
		return BlockMatchToBlacklist;
	}

	public boolean onBlockDestroyed(World world, ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving) {
		super.onBlockDestroyed(world, itemstack, i, j, k, l, entityliving);
		int x, y, z;
		int Squ = 0;
		int Cu = 0 ;
		Item heldItem = entityliving.getHeldItem().getItem();
		if(heldItem == HammersAndExcavators.hammerWooden ||heldItem == HammersAndExcavators.hammerStone||heldItem == HammersAndExcavators.hammerGold){
			Squ = 1;
			Cu = 0;
		} else if (heldItem == HammersAndExcavators.hammerIron) {
			Squ = 1;
			Cu = 2;
		}else if(heldItem == HammersAndExcavators.hammerSteel){
			Squ = 2;
			Cu = 3;
		} else if (heldItem == HammersAndExcavators.hammerDiamond) {
			Squ = 2;
			Cu = 5;
		}
		switch(Direction.getDirection(entityliving)){
			case NORTH :
				for (x = -Squ; x <= Squ; x++) {
					for (y = -Squ; y <= Squ; y++) {
						for (z = 0; z <= Cu; z++) {
							this.MineBlock(j + x, k + y, l - z , entityliving.world,entityliving);
					}
				}
			}
				break;
			case SOUTH:
				for (x = -Squ; x <= Squ; x++) {
					for (y = -Squ; y <= Squ; y++) {
						for (z = 0; z <= Cu; z++) {
							this.MineBlock(j + x, k + y, l+ z , entityliving.world,entityliving);
						}
					}
				}
				break;
			case WEST:
				for (x = -Squ; x <= Squ; x++) {
					for (y = -Squ; y <= Squ; y++) {
						for (z = 0; z <= Cu; z++) {
							this.MineBlock(j - z, k + y, l + x, entityliving.world,entityliving);
						}
					}
				}
				break;
			case EAST:
				for (x = -Squ; x <= Squ; x++) {
					for (y = -Squ; y <= Squ; y++) {
						for (z = 0; z <= Cu; z++) {
							this.MineBlock(j + z, k + y, l + x, entityliving.world,entityliving);
						}
					}
				}
				break;
			case UP:
			for (x = -Squ; x <= Squ; x++) {
				for (y = -Squ; y <= Squ; y++) {
					for (z = 0; z <= Cu; z++) {
						this.MineBlock(j + x , k +z, l + y, entityliving.world,entityliving);
					}
				}
			}
				break;
			case DOWN:
			for (x = -Squ; x <= Squ; x++) {
				for (y = -Squ; y <= Squ; y++) {
					for (z = 0; z <= Cu; z++) {
						this.MineBlock(j + x, k -z, l + y, entityliving.world,entityliving);
					}
				}
			}
				break;
		}
		return true;
	}
}



