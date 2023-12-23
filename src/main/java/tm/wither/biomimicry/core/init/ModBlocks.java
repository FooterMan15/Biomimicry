package tm.wither.biomimicry.core.init;

import com.simibubi.create.AllBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tm.wither.biomimicry.Biomimicry;
import tm.wither.biomimicry.block.custom.basin.BrassBasinBlock;
import tm.wither.biomimicry.block.custom.basin.BrassBasinBlockEntity;
import tm.wither.biomimicry.block.CheeseWheelBlock;
import tm.wither.biomimicry.block.WashedCactusBlock;
import tm.wither.biomimicry.block.WheatGrassBlock;

import java.util.function.Supplier;

public class ModBlocks {
        //Deferred Register

        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
                        Biomimicry.MOD_ID);

        //Blocks

        public static final RegistryObject<Block> WASHED_CACTUS = registerBlock("washed_cactus",
                        () -> new WashedCactusBlock(BlockBehaviour.Properties.copy(Blocks.CACTUS)));
        public static final RegistryObject<Block> WHEAT_GRASS = registerBlock("wheat_grass",
                        () -> new WheatGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS)));
        public static final RegistryObject<Block> CHEESE_WHEEL = registerBlock("cheese_wheel",
                        () -> new CheeseWheelBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)));
        public static final RegistryObject<BrassBasinBlock> BRASS_BASIN = registerBlock("brass_basin",
                        () -> new BrassBasinBlock(BlockBehaviour.Properties.copy(AllBlocks.BASIN.get())));

        private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
                RegistryObject<T> toReturn = BLOCKS.register(name, block);
                return toReturn;
        }

        public static void register(IEventBus eventBus) {
                BLOCKS.register(eventBus);
        }
}
