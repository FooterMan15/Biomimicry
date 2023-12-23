package tm.wither.biomimicry.block.custom.basin;

import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.content.processing.basin.BasinBlock;
import com.simibubi.create.foundation.item.ItemHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BrassBasinBlock extends BasinBlock {

    public BrassBasinBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    @Override
    public int getAnalogOutputSignal(BlockState blockState, Level worldIn, BlockPos pos) {
        return (Integer) this.getBlockEntityOptional(worldIn, pos)
                .map(entity -> ((BrassBasinBlockEntity) entity).getInputInventory())
                .map(ItemHelper::calcRedstoneFromInventory).orElse(0);
    }

    @Override
    public BlockEntityType<? extends BrassBasinBlockEntity> getBlockEntityType() {
        return (BlockEntityType) AllBlockEntityTypes.BASIN.get();
    }
}
