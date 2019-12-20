package com.pam.simplystrawberries.block.growables;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.item.Item;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.IPlantable;

public class BlockSimplyCrop extends CropsBlock implements IGrowable, IPlantable {

	public static final IntegerProperty CROP_AGE = BlockStateProperties.AGE_0_7;
	
	private final String registerName;
	public final String name;
	
	public BlockSimplyCrop(Properties builder, String registerName, String name) {
		super(builder);
		this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), Integer.valueOf(0)));
		this.registerName = registerName;
		this.name = name;
	}

	private static final int MATURE_AGE = 7;

	private String BASE_STAGE_ID;

	private Item seed;
	private Item food;

	public void setSeed(Item seed) {
		
		this.seed = food;
	}

	public void setFood(Item food) {
		this.food = food;
	}

	@Override
	 protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
	      return state.getBlock() == Blocks.FARMLAND;
	   }



	public String getStageId(int state) {
		if(BASE_STAGE_ID == null) {
			BASE_STAGE_ID = registerName.replaceFirst("crop", "") + "_stage";
		}

		return BASE_STAGE_ID + state;
	}





	public int getMatureAge() {
		return MATURE_AGE;
	}



	
	@OnlyIn(Dist.CLIENT)
    protected IItemProvider getSeed()
    {
       return seed;
    }
	

	@OnlyIn(Dist.CLIENT)
    protected IItemProvider getCrop() {

		return food;
	}


	
	@Override
	protected void fillStateContainer (Builder<Block, BlockState> builder)
	{
		builder.add(CROP_AGE);
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
		grow(worldIn, pos, state);
	}

	@Override
	public int hashCode() {
		return registerName.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof BlockSimplyCrop && registerName.equals(((BlockSimplyCrop) obj).registerName));
	}

	


	@Override
	public int getMaxAge() {
		return getMatureAge();
	}

	@Override
	 protected int getAge(BlockState state) {
	      return state.get(this.getAgeProperty());
	   }

	
	public BlockState withAge(int state) {
	      return this.getDefaultState().with(this.getAgeProperty(), Integer.valueOf(state));
	   }

	@Override
	public boolean isMaxAge(BlockState state) {
		return getAge(state) >= getMaxAge();
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return getAge(state) < getMaxAge();
	}

	public boolean isMature(BlockState state) {
		return false;
	}


}