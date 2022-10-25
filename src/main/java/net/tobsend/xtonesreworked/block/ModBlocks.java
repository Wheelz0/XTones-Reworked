package net.tobsend.xtonesreworked.block;

import com.google.common.base.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tobsend.xtonesreworked.XtonesReworkedMod;
import net.tobsend.xtonesreworked.item.ModCreativeModeTab;
import net.tobsend.xtonesreworked.item.ModItems;

public class ModBlocks {

  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
    ForgeRegistries.BLOCKS,
    XtonesReworkedMod.MOD_ID
  );

  // Register Block Area.
  public static final RegistryObject<Block> AGON_BLOCK = registerBlock(
    "agon_block",
    () ->
      new Block(
        BlockBehaviour.Properties
          .of(Material.STONE)
          .strength(6f)
          .requiresCorrectToolForDrops()
      ),
    ModCreativeModeTab.XTONE_REWORK_TAB
  );

  public static final RegistryObject<Block> XTONE_TILE = registerBlock(
    "xtone_tile",
    () ->
      new Block(
        BlockBehaviour.Properties
          .of(Material.STONE)
          .strength(3f)
          .requiresCorrectToolForDrops()
      ),
    ModCreativeModeTab.XTONE_REWORK_TAB
  );

  // Support Methods
  private static <T extends Block> RegistryObject<T> registerBlock(
    String name,
    Supplier<T> block,
    CreativeModeTab tab
  ) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn, tab);
    return toReturn;
  }

  private static <T extends Block> RegistryObject<Item> registerBlockItem(
    String name,
    RegistryObject<T> block,
    CreativeModeTab tab
  ) {
    return ModItems.ITEMS.register(
      name,
      () -> new BlockItem(block.get(), new Item.Properties().tab(tab))
    );
  }

  public static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }
}
