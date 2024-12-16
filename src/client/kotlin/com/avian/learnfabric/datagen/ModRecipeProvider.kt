package com.avian.learnfabric.datagen

import com.avian.learnfabric.Learnfabric.MOD_ID
import com.avian.learnfabric.block.ModBlocks
import com.avian.learnfabric.item.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.recipe.RecipeExporter
import net.minecraft.data.recipe.RecipeGenerator
import net.minecraft.item.Items
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.registry.RegistryWrapper
import net.minecraft.util.Identifier
import java.util.concurrent.CompletableFuture

class ModRecipeProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>) :
    FabricRecipeProvider(output, registriesFuture) {
    override fun getRecipeGenerator(
        wrapperLookup: RegistryWrapper.WrapperLookup,
        recipeExporter: RecipeExporter
    ): RecipeGenerator {
        return object : RecipeGenerator(wrapperLookup, recipeExporter) {
            override fun generate() {
                val PINK_GARNET_SMELTABLES =
                    listOf(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE, ModBlocks.PINK_GARNET_DEEPSLATE_ORE)

                offerSmelting(
                    PINK_GARNET_SMELTABLES,
                    RecipeCategory.MISC,
                    ModItems.PINK_GARNET,
                    .25f,
                    200,
                    "pink_garnet"
                )
                offerBlasting(
                    PINK_GARNET_SMELTABLES,
                    RecipeCategory.MISC,
                    ModItems.PINK_GARNET,
                    .25f,
                    100,
                    "pink_garnet"
                )

                offerReversibleCompactingRecipes(
                    RecipeCategory.BUILDING_BLOCKS,
                    ModItems.PINK_GARNET,
                    RecipeCategory.DECORATIONS,
                    ModBlocks.PINK_GARNET_BLOCK
                )

                offerReversibleCompactingRecipes(
                    RecipeCategory.BUILDING_BLOCKS,
                    ModItems.RAW_PINK_GARNET,
                    RecipeCategory.DECORATIONS,
                    ModBlocks.RAW_PINK_GARNET_BLOCK
                )

                createShaped(RecipeCategory.MISC, ModItems.CHISEL)
                    .pattern("SSS")
                    .pattern(" W ")
                    .pattern(" W ")
                    .input('S', Items.STONE)
                    .input('W', Items.STICK)
                    .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                    .offerTo(recipeExporter, Identifier.of(MOD_ID, "custom_recipe_name").toString())

                createStairsRecipe(
                    ModBlocks.PINK_GARNET_STAIRS,
                    Ingredient.ofItem(ModBlocks.PINK_GARNET_BLOCK)
                ).criterion(
                    hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK)
                ).offerTo(recipeExporter)

                offerSlabRecipe(RecipeCategory.MISC, ModBlocks.PINK_GARNET_SLAB, ModBlocks.PINK_GARNET_BLOCK)

                createButtonRecipe(ModBlocks.PINK_GARNET_BUTTON, Ingredient.ofItem(ModItems.PINK_GARNET)).criterion(
                    hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK)
                ).offerTo(recipeExporter)

                offerPressurePlateRecipe(ModBlocks.PINK_GARNET_PRESSURE_PLATE, ModBlocks.PINK_GARNET_BLOCK)

                createFenceRecipe(
                    ModBlocks.PINK_GARNET_FENCE,
                    Ingredient.ofItem(ModBlocks.PINK_GARNET_BLOCK)
                ).criterion(
                    hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK)
                ).offerTo(recipeExporter)

                createFenceGateRecipe(
                    ModBlocks.PINK_GARNET_FENCE_GATE,
                    Ingredient.ofItem(ModBlocks.PINK_GARNET_BLOCK)
                ).criterion(
                    hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK)
                ).offerTo(recipeExporter)

                offerWallRecipe(RecipeCategory.MISC, ModBlocks.PINK_GARNET_WALL, ModBlocks.PINK_GARNET_BLOCK)

                createDoorRecipe(ModBlocks.PINK_GARNET_DOOR, Ingredient.ofItem(ModBlocks.PINK_GARNET_BLOCK)).criterion(
                    hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK)
                ).offerTo(recipeExporter)

                createTrapdoorRecipe(
                    ModBlocks.PINK_GARNET_TRAP_DOOR,
                    Ingredient.ofItem(ModBlocks.PINK_GARNET_BLOCK)
                ).criterion(
                    hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK)
                ).offerTo(recipeExporter)

            }
        }
    }

    override fun getName(): String {
        return Identifier.of(MOD_ID, "recipe_provider").toString()
    }
}