package com.markus1002.expandedtags.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.markus1002.expandedtags.core.tags.ETItemTags;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

@Mixin(RabbitEntity.class)
public abstract class MixinRabbitEntity extends Entity
{
	public MixinRabbitEntity(EntityType<?> entityType, World worldIn)
	{
		super(entityType, worldIn);
	}

	@Inject(at = @At("TAIL"), method = "isRabbitBreedingItem", cancellable = true)
	private void addBreedingItems(Item itemIn, CallbackInfoReturnable<Boolean> info)
	{
		if (itemIn.isIn(ETItemTags.RABBIT_BREEDING_ITEMS))
			info.setReturnValue(true);
	}
}