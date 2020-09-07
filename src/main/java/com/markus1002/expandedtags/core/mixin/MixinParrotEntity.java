package com.markus1002.expandedtags.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.markus1002.expandedtags.core.tags.ETItemTags;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

@Mixin(ParrotEntity.class)
public abstract class MixinParrotEntity extends Entity
{
	public MixinParrotEntity(EntityType<?> entityType, World worldIn)
	{
		super(entityType, worldIn);
	}

	@Inject(at = @At("HEAD"), method = "func_230254_b_", cancellable = true)
	private void addTamingItems(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResultType> info)
	{
		ItemStack itemstack = player.getHeldItem(hand);
		ParrotEntity parrot = (ParrotEntity) this.getEntity();

		if (!parrot.isTamed() && Ingredient.fromTag(ETItemTags.PARROT_TAMING_ITEMS).test(itemstack))
		{
			if (!player.abilities.isCreativeMode)
			{
				itemstack.shrink(1);
			}

			if (!parrot.isSilent())
			{
				parrot.world.playSound((PlayerEntity)null, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_PARROT_EAT, this.getSoundCategory(), 1.0F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
			}

			if (!this.world.isRemote)
			{
				if (this.rand.nextInt(10) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(parrot, player))
				{
					parrot.setTamedBy(player);
					parrot.world.setEntityState(this, (byte)7);
				}
				else
				{
					parrot.world.setEntityState(this, (byte)6);
				}
			}

			info.setReturnValue(ActionResultType.func_233537_a_(parrot.world.isRemote));
		}
		else if (Ingredient.fromTag(ETItemTags.PARROT_POISONOUS_ITEMS).test(itemstack))
		{
			if (!player.abilities.isCreativeMode)
			{
				itemstack.shrink(1);
			}

			parrot.addPotionEffect(new EffectInstance(Effects.POISON, 900));
			if (player.isCreative() || !this.isInvulnerable())
			{
				parrot.attackEntityFrom(DamageSource.causePlayerDamage(player), Float.MAX_VALUE);
			}

			info.setReturnValue(ActionResultType.func_233537_a_(parrot.world.isRemote));
		}
	}
}