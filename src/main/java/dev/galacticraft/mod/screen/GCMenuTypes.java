/*
 * Copyright (c) 2019-2023 Team Galacticraft
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.galacticraft.mod.screen;

import dev.galacticraft.machinelib.api.screen.RecipeMachineMenu;
import dev.galacticraft.machinelib.api.screen.SimpleMachineMenu;
import dev.galacticraft.mod.Constant;
import dev.galacticraft.mod.recipe.CompressingRecipe;
import dev.galacticraft.mod.recipe.FabricationRecipe;
import dev.galacticraft.mod.content.block.entity.*;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.SmeltingRecipe;

/**
 * @author <a href="https://github.com/TeamGalacticraft">TeamGalacticraft</a>
 */
public class GCMenuTypes {

    public static final ExtendedScreenHandlerType<CoalGeneratorMenu> COAL_GENERATOR_HANDLER = new ExtendedScreenHandlerType<>(CoalGeneratorMenu::new);

    public static final MenuType<SimpleMachineMenu<BasicSolarPanelBlockEntity>> BASIC_SOLAR_PANEL_HANDLER = new ExtendedScreenHandlerType<>(
            SimpleMachineMenu.createFactory(() -> GCMenuTypes.BASIC_SOLAR_PANEL_HANDLER)
    );

    public static final MenuType<SimpleMachineMenu<AdvancedSolarPanelBlockEntity>> ADVANCED_SOLAR_PANEL_HANDLER = new ExtendedScreenHandlerType<>(
            SimpleMachineMenu.createFactory(() -> GCMenuTypes.ADVANCED_SOLAR_PANEL_HANDLER)
    );

    public static final ExtendedScreenHandlerType<RecipeMachineMenu<Container, FabricationRecipe, CircuitFabricatorBlockEntity>> CIRCUIT_FABRICATOR_HANDLER = new ExtendedScreenHandlerType<>(
            RecipeMachineMenu.createFactory(() -> GCMenuTypes.CIRCUIT_FABRICATOR_HANDLER, 94)
    );

    public static final ExtendedScreenHandlerType<CompressorMenu> COMPRESSOR_HANDLER = new ExtendedScreenHandlerType<>(CompressorMenu::new);

    public static final ExtendedScreenHandlerType<RecipeMachineMenu<Container, CompressingRecipe, ElectricCompressorBlockEntity>> ELECTRIC_COMPRESSOR_HANDLER = new ExtendedScreenHandlerType<>(
            RecipeMachineMenu.createFactory(() -> GCMenuTypes.ELECTRIC_COMPRESSOR_HANDLER)
    );

    public static final ExtendedScreenHandlerType<RecipeMachineMenu<Container, SmeltingRecipe, ElectricFurnaceBlockEntity>> ELECTRIC_FURNACE_HANDLER = new ExtendedScreenHandlerType<>(
            RecipeMachineMenu.createFactory(() -> GCMenuTypes.ELECTRIC_FURNACE_HANDLER)
    );

    public static final ExtendedScreenHandlerType<RecipeMachineMenu<Container, BlastingRecipe, ElectricArcFurnaceBlockEntity>> ELECTRIC_ARC_FURNACE_HANDLER = new ExtendedScreenHandlerType<>(
            RecipeMachineMenu.createFactory(() -> GCMenuTypes.ELECTRIC_ARC_FURNACE_HANDLER)
    );

    public static final MenuType<SimpleMachineMenu<RefineryBlockEntity>> REFINERY_HANDLER = new ExtendedScreenHandlerType<>(
            SimpleMachineMenu.createFactory(() -> GCMenuTypes.REFINERY_HANDLER, 86)
    );

    public static final MenuType<OxygenCollectorMenu> OXYGEN_COLLECTOR_HANDLER = new ExtendedScreenHandlerType<>(OxygenCollectorMenu::new);

    public static final MenuType<SimpleMachineMenu<OxygenCompressorBlockEntity>> OXYGEN_COMPRESSOR_HANDLER = new ExtendedScreenHandlerType<>(
            SimpleMachineMenu.createFactory(() -> GCMenuTypes.OXYGEN_COMPRESSOR_HANDLER)
    );

    public static final MenuType<SimpleMachineMenu<OxygenDecompressorBlockEntity>> OXYGEN_DECOMPRESSOR_HANDLER = new ExtendedScreenHandlerType<>(
            SimpleMachineMenu.createFactory(() -> GCMenuTypes.OXYGEN_DECOMPRESSOR_HANDLER)
    );

    public static final MenuType<SimpleMachineMenu<OxygenSealerBlockEntity>> OXYGEN_SEALER_HANDLER = new ExtendedScreenHandlerType<>(
            SimpleMachineMenu.createFactory(() -> GCMenuTypes.OXYGEN_SEALER_HANDLER)
    );

    public static final MenuType<BubbleDistributorMenu> BUBBLE_DISTRIBUTOR_HANDLER = new ExtendedScreenHandlerType<>(BubbleDistributorMenu::new);

    public static final MenuType<SimpleMachineMenu<OxygenStorageModuleBlockEntity>> OXYGEN_STORAGE_MODULE_HANDLER = new ExtendedScreenHandlerType<>(
            SimpleMachineMenu.createFactory(() -> GCMenuTypes.OXYGEN_STORAGE_MODULE_HANDLER)
    );

    public static final MenuType<SimpleMachineMenu<EnergyStorageModuleBlockEntity>> ENERGY_STORAGE_MODULE_HANDLER = new ExtendedScreenHandlerType<>(
            SimpleMachineMenu.createFactory(() -> GCMenuTypes.ENERGY_STORAGE_MODULE_HANDLER)
    );

    public static final MenuType<GCPlayerInventoryMenu> PLAYER_INV_GC_HANDLER = new MenuType<>(GCPlayerInventoryMenu::new);

    public static final ExtendedScreenHandlerType<FuelLoaderMenu> FUEL_LOADER_HANDLER = new ExtendedScreenHandlerType<>(FuelLoaderMenu::new);

    public static final MenuType<AirlockControllerMenu> AIRLOCK_CONTROLLER_MENU = new MenuType<>(AirlockControllerMenu::new);

    public static void register() {
        Registry.register(Registry.MENU, new ResourceLocation(Constant.MOD_ID, Constant.ScreenHandler.PLAYER_INVENTORY_SCREEN_HANDLER), PLAYER_INV_GC_HANDLER);

        Registry.register(Registry.MENU, new ResourceLocation(Constant.MOD_ID, Constant.ScreenHandler.COAL_GENERATOR_SCREEN_HANDLER), COAL_GENERATOR_HANDLER);
        Registry.register(Registry.MENU, new ResourceLocation(Constant.MOD_ID, Constant.ScreenHandler.BASIC_SOLAR_PANEL_SCREEN_HANDLER), BASIC_SOLAR_PANEL_HANDLER);
        Registry.register(Registry.MENU, new ResourceLocation(Constant.MOD_ID, Constant.ScreenHandler.ADVANCED_SOLAR_PANEL_SCREEN_HANDLER), ADVANCED_SOLAR_PANEL_HANDLER);

        Registry.register(Registry.MENU, new ResourceLocation(Constant.MOD_ID, Constant.ScreenHandler.CIRCUIT_FABRICATOR_SCREEN_HANDLER), CIRCUIT_FABRICATOR_HANDLER);
        Registry.register(Registry.MENU, new ResourceLocation(Constant.MOD_ID, Constant.ScreenHandler.COMPRESSOR_SCREEN_HANDLER), COMPRESSOR_HANDLER);
        Registry.register(Registry.MENU, new ResourceLocation(Constant.MOD_ID, Constant.ScreenHandler.ELECTRIC_COMPRESSOR_SCREEN_HANDLER), ELECTRIC_COMPRESSOR_HANDLER);
        Registry.register(Registry.MENU, new ResourceLocation(Constant.MOD_ID, Constant.ScreenHandler.ELECTRIC_FURNACE_SCREEN_HANDLER), ELECTRIC_FURNACE_HANDLER);
        Registry.register(Registry.MENU, new ResourceLocation(Constant.MOD_ID, Constant.ScreenHandler.ELECTRIC_ARC_FURNACE_SCREEN_HANDLER), ELECTRIC_ARC_FURNACE_HANDLER);
        Registry.register(Registry.MENU, new ResourceLocation(Constant.MOD_ID, Constant.ScreenHandler.REFINERY_SCREEN_HANDLER), REFINERY_HANDLER);

        Registry.register(Registry.MENU, new ResourceLocation(Constant.MOD_ID, Constant.ScreenHandler.OXYGEN_COLLECTOR_SCREEN_HANDLER), OXYGEN_COLLECTOR_HANDLER);
        Registry.register(Registry.MENU, new ResourceLocation(Constant.MOD_ID, Constant.ScreenHandler.OXYGEN_COMPRESSOR_SCREEN_HANDLER), OXYGEN_COMPRESSOR_HANDLER);
        Registry.register(Registry.MENU, new ResourceLocation(Constant.MOD_ID, Constant.ScreenHandler.OXYGEN_DECOMPRESSOR_SCREEN_HANDLER), OXYGEN_DECOMPRESSOR_HANDLER);
        Registry.register(Registry.MENU, new ResourceLocation(Constant.MOD_ID, Constant.ScreenHandler.BUBBLE_DISTRIBUTOR_SCREEN_HANDLER), BUBBLE_DISTRIBUTOR_HANDLER);
        Registry.register(Registry.MENU, new ResourceLocation(Constant.MOD_ID, Constant.ScreenHandler.OXYGEN_SEALER_SCREEN_HANDLER), OXYGEN_SEALER_HANDLER);

        Registry.register(Registry.MENU, new ResourceLocation(Constant.MOD_ID, Constant.ScreenHandler.ENERGY_STORAGE_MODULE_SCREEN_HANDLER), ENERGY_STORAGE_MODULE_HANDLER);
        Registry.register(Registry.MENU, new ResourceLocation(Constant.MOD_ID, Constant.ScreenHandler.OXYGEN_STORAGE_MODULE_SCREEN_HANDLER), OXYGEN_STORAGE_MODULE_HANDLER);

        Registry.register(Registry.MENU, Constant.id(Constant.ScreenHandler.FUEL_LOADER_SCREEN_HANDLER), FUEL_LOADER_HANDLER);

        Registry.register(Registry.MENU, Constant.id(Constant.ScreenHandler.AIR_LOCK_CONTROLLER_MENU), AIRLOCK_CONTROLLER_MENU);
    }
}
