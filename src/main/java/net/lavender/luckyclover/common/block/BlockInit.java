package net.lavender.luckyclover.common.block;

import net.lavender.luckyclover.LuckyClover;
import net.lavender.luckyclover.common.item.ItemInit;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LuckyClover.MOD_ID);

    //crops and flowers
    // A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

    public static final RegistryObject<Block> CLOVER_PLANT = registerBlock("clover_plant",
            () -> new FlowerBlock(MobEffects.LUCK, 300, BlockBehaviour.Properties.of().offsetType(BlockBehaviour.OffsetType.XZ)
                    .lightLevel(s -> 4).ignitedByLava().instabreak().sound(SoundType.GRASS).noCollission().mapColor(MapColor.COLOR_LIGHT_GREEN)));

    public static final RegistryObject<Block> CLOVER_SACK = registerBlock("clover_sack",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.GUITAR)
                    .strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));

    public static final RegistryObject<Block> POTTED_CLOVER = BLOCKS.register("potted_clover",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), BlockInit.CLOVER_PLANT, BlockBehaviour.Properties.of()
                    .lightLevel(s -> 5).noOcclusion().instabreak().mapColor(MapColor.COLOR_GREEN).pushReaction(PushReaction.DESTROY)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemInit.EDIBLE.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
