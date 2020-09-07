package com.markus1002.expandedtags.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.markus1002.expandedtags.core.tags.ETItemTags;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

@Mixin(DolphinEntity.class)
public abstract class MixinDolphinEntity extends Entity
{
	public MixinDolphinEntity(EntityType<?> entityType, World worldIn)
	{
		super(entityType, worldIn);
	}

	@Inject(at = @At("HEAD"), method = "func_230254_b_", cancellable = true)
	private void addTrustingItems(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResultType> info)
	{
		ItemStack itemstack = player.getHeldItem(hand);
		DolphinEntity dolphin = (DolphinEntity) this.getEntity();

		if (!itemstack.isEmpty() && Ingredient.fromTag(ETItemTags.DOLPHIN_TRUSTING_ITEMS).test(itemstack))
		{
			if (!dolphin.world.isRemote)
			{
				dolphin.playSound(SoundEvents.ENTITY_DOLPHIN_EAT, 1.0F, 1.0F);
			}

			dolphin.setGotFish(true);
			
			if (!player.abilities.isCreativeMode)
			{
				itemstack.shrink(1);
			}

			info.setReturnValue(ActionResultType.func_233537_a_(this.world.isRemote));
		}
	}
}