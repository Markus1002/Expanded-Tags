package com.markus1002.expandedtags.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.markus1002.expandedtags.core.tags.ETItemTags;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

@Mixin(WolfEntity.class)
public abstract class MixinWolfEntity extends Entity
{
	public MixinWolfEntity(EntityType<?> entityType, World worldIn)
	{
		super(entityType, worldIn);
	}

	@Inject(at = @At("RETURN"), method = "isBreedingItem", cancellable = true)
	private void addBreedingItems(ItemStack stack, CallbackInfoReturnable<Boolean> info)
	{
		if (Ingredient.fromTag(ETItemTags.WOLF_BREEDING_ITEMS).test(stack))
			info.setReturnValue(true);
	}

	@Inject(at = @At(value = "RETURN", ordinal = 0), method = "func_230254_b_", cancellable = true)
	private void addTamingItemsClient(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResultType> info)
	{
		ItemStack itemstack = player.getHeldItem(hand);
		WolfEntity wolf = (WolfEntity) this.getEntity();
		
		if (Ingredient.fromTag(ETItemTags.WOLF_TAMING_ITEMS).test(itemstack) && !wolf.isTamed() && !wolf.func_233678_J__())
			info.setReturnValue(ActionResultType.CONSUME);
	}
	
	@Inject(at = @At("TAIL"), method = "func_230254_b_", cancellable = true)
	private void addTamingItems(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResultType> info)
	{
		ItemStack itemstack = player.getHeldItem(hand);
		WolfEntity wolf = (WolfEntity) this.getEntity();

		if (Ingredient.fromTag(ETItemTags.WOLF_TAMING_ITEMS).test(itemstack) && !wolf.func_233678_J__())
		{
			if (!player.abilities.isCreativeMode)
			{
				itemstack.shrink(1);
			}

			if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(wolf, player))
			{
				wolf.setTamedBy(player);
				wolf.getNavigator().clearPath();
				wolf.setAttackTarget((LivingEntity)null);
				wolf.func_233687_w_(true);
				wolf.world.setEntityState(this, (byte)7);
			}
			else
			{
				wolf.world.setEntityState(this, (byte)6);
			}

			info.setReturnValue(ActionResultType.SUCCESS);
		}
	}
}