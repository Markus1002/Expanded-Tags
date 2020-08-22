package com.markus1002.expandedtags.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.markus1002.expandedtags.core.tags.ETItemTags;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;

@Mixin(TurtleEntity.class)
public abstract class MixinTurtleEntity extends Entity
{
	public MixinTurtleEntity(EntityType<?> entityType, World worldIn)
	{
		super(entityType, worldIn);
	}

	@Inject(at = @At("TAIL"), method = "isBreedingItem", cancellable = true)
	private void addBreedingItems(ItemStack stack, CallbackInfoReturnable<Boolean> info)
	{
		if (Ingredient.fromTag(ETItemTags.TURTLE_BREEDING_ITEMS).test(stack))
			info.setReturnValue(true);
	}
}