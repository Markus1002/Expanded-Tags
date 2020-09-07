package com.markus1002.expandedtags.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.markus1002.expandedtags.core.tags.ETItemTags;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;

@Mixin(CatEntity.class)
public abstract class MixinCatEntity extends Entity
{
	public MixinCatEntity(EntityType<?> entityTypeIn, World worldIn)
	{
		super(entityTypeIn, worldIn);
	}

	@Inject(at = @At("TAIL"), method = "registerGoals")
	protected void registerTemptGoal(CallbackInfo info)
	{
		CatEntity cat = (CatEntity) this.getEntity();
		cat.temptGoal = new CatEntity.TemptGoal(cat, 0.6D, Ingredient.fromTag(ETItemTags.CAT_BREEDING_ITEMS), true);
	}
}
