package com.markus1002.expandedtags.common.entity.ai;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag.INamedTag;

public class TagTemptGoal extends TemptGoal
{
	private final INamedTag<Item> tag;

	public TagTemptGoal(CreatureEntity creatureIn, double speedIn, boolean scaredByPlayerMovementIn, INamedTag<Item> tagIn)
	{
		super(creatureIn, speedIn, scaredByPlayerMovementIn, Ingredient.EMPTY);
		this.tag = tagIn;
	}

	protected boolean isTempting(ItemStack stack)
	{
		return Ingredient.fromTag(tag).test(stack);
	}
}