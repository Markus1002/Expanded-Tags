package com.markus1002.expandedtags.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.markus1002.expandedtags.core.tags.ETItemTags;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;

@Mixin(AnimalEntity.class)
public abstract class MixinAnimalEntity extends Entity
{
	public MixinAnimalEntity(EntityType<?> entityType, World worldIn)
	{
		super(entityType, worldIn);
	}

	@Inject(at = @At("TAIL"), method = "isBreedingItem", cancellable = true)
	private void addBreedingItems(ItemStack stack, CallbackInfoReturnable<Boolean> info)
	{
		if (this.getEntity() instanceof CowEntity && Ingredient.fromTag(ETItemTags.COW_BREEDING_ITEMS).test(stack))
			info.setReturnValue(true);
		else if (this.getEntity() instanceof SheepEntity && Ingredient.fromTag(ETItemTags.SHEEP_BREEDING_ITEMS).test(stack))
			info.setReturnValue(true);
	}
}