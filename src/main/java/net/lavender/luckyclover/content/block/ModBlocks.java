package net.lavender.luckyclover.content.block;

import net.lavender.luckyclover.LuckyClover;
import net.lavender.luckyclover.content.block.common.FuelBlock;
import net.lavender.luckyclover.content.block.custom.CloverBlock;
import net.lavender.luckyclover.content.block.common.SackBlock;
import net.lavender.luckyclover.content.block.custom.DreamCatcherBlock;
import net.lavender.luckyclover.content.block.custom.PottedCloverBlock;
import net.lavender.luckyclover.content.item.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LuckyClover.MOD_ID);

    //crops and flowers
    // A B C D E F G H I J K L M N O P Q R S T U V W X Y Z


    public static final RegistryObject<Block> OAK_SIDING;
    public static final RegistryObject<Block> SPRUCE_SIDING;
    public static final RegistryObject<Block> DARK_OAK_SIDING;


    public static final RegistryObject<Block> CLOVER_SACK;
    public static final RegistryObject<Block> GOLDEN_CLOVER_SACK;
    public static final RegistryObject<Block> DREAM_CATCHER;
    public static final RegistryObject<Block> CLOVER;


    public static final RegistryObject<Block> POTTED_CLOVER;


    static {
        OAK_SIDING = registerBlock("oak_siding", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
        SPRUCE_SIDING = registerBlock("spruce_siding", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
        DARK_OAK_SIDING = registerBlock("dark_oak_siding", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
        CLOVER_SACK = registerBlock("clover_sack", () -> new SackBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_WOOL)
        .mapColor(MapColor.TERRACOTTA_BROWN).instrument(NoteBlockInstrument.GUITAR).sound(SoundType.WOOL).ignitedByLava()));
        GOLDEN_CLOVER_SACK = registerBlock("golden_clover_sack", () -> new SackBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_WOOL)
        .mapColor(MapColor.TERRACOTTA_BROWN).instrument(NoteBlockInstrument.GUITAR).sound(SoundType.WOOL).ignitedByLava()));
        DREAM_CATCHER = registerBlock("dream_catcher", () -> new DreamCatcherBlock(BlockBehaviour.Properties.of()
        .instabreak().mapColor(MapColor.NONE).pushReaction(PushReaction.DESTROY)));
        CLOVER = registerBlock("clover", () -> new CloverBlock(MobEffects.LUCK, 5, BlockBehaviour.Properties.of()
        .lightLevel(s -> 5).ignitedByLava().instabreak().sound(SoundType.GRASS).noCollission().mapColor(MapColor.PLANT).offsetType(BlockBehaviour.OffsetType.XZ).dynamicShape()));








        POTTED_CLOVER = BLOCKS.register("potted_clover", () -> new PottedCloverBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),
        ModBlocks.CLOVER, BlockBehaviour.Properties.of().lightLevel(s -> 5).noOcclusion().instabreak()
        .mapColor(MapColor.NONE).pushReaction(PushReaction.DESTROY)));

    }


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
