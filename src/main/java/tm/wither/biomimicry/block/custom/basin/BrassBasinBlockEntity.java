package tm.wither.biomimicry.block.custom.basin;

import java.util.List;
import com.simibubi.create.content.processing.basin.BasinBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.fluid.SmartFluidTankBehaviour;
import com.simibubi.create.foundation.item.SmartInventory;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;

public class BrassBasinBlockEntity extends BasinBlockEntity {

    private boolean contentsChanged;

    public BrassBasinBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.contentsChanged = true;
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        super.addBehaviours(behaviours);

        this.inputTank = (new SmartFluidTankBehaviour(SmartFluidTankBehaviour.INPUT, this, 8, 16000, true))
                .whenFluidUpdates(() -> {
                    this.contentsChanged = true;
                });
        this.outputTank = (new SmartFluidTankBehaviour(SmartFluidTankBehaviour.OUTPUT, this, 8, 16000, true))
                .whenFluidUpdates(() -> {
                    this.contentsChanged = true;
                }).forbidExtraction();
    }

    public LazyOptional<IItemHandlerModifiable> getItemCapability() {
        return this.itemCapability;
    }

    @Override
    public SmartInventory getInputInventory() {
        return super.getInputInventory();
    }
}
