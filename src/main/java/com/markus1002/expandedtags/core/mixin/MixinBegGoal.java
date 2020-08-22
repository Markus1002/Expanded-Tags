package com.markus1002.expandedtags.core.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.markus1002.expandedtags.core.tags.ETItemTags;

import net.minecraft.entity.ai.goal.BegGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.Hand;

@Mixin(BegGoal.class)
public abstract class MixinBegGoal extends Goal
{
	@Shadow
	@Final
	private WolfEntity wolf;
	
	@Inject(at = @At("TAIL"), method = "hasTemptationItemInHand", cancellable = true)
	private void hasTemptationItemInHand(PlayerEntity player, CallbackInfoReturnable<Boolean> info)
	{
		for(Hand hand : Hand.values())
		{
			ItemStack itemstack = player.getHeldItem(hand);
			if (this.wolf.isTamed() && Ingredient.fromTag(ETItemTags.WOLF_TAMING_ITEMS).test(itemstack))
			{
				info.setReturnValue(true);
			}
		}
	}
}
