package com.markus1002.expandedtags.core.events;

import com.markus1002.expandedtags.core.tags.ETItemTags;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityEvents
{
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if (!event.getWorld().isRemote && event.getEntity() instanceof CreatureEntity)
		{
			CreatureEntity animal = (CreatureEntity) event.getEntity();

			if (animal instanceof BeeEntity)
			{
				animal.targetSelector.addGoal(3, new TemptGoal(animal, 1.25D, Ingredient.fromTag(ETItemTags.BEE_BREEDING_ITEMS), false));
			}
			else if (animal instanceof ChickenEntity)
			{
				animal.targetSelector.addGoal(3, new TemptGoal(animal, 1.0D, false, Ingredient.fromTag(ETItemTags.CHICKEN_BREEDING_ITEMS)));
			}
			else if (animal instanceof CowEntity)
			{
				animal.targetSelector.addGoal(3, new TemptGoal(animal, 1.25D, Ingredient.fromTag(ETItemTags.COW_BREEDING_ITEMS), false));
			}
			else if (animal instanceof PandaEntity)
			{
				animal.targetSelector.addGoal(4, new TemptGoal(animal, 1.0D, Ingredient.fromTag(ETItemTags.PANDA_BREEDING_ITEMS), false));
			}
			else if (animal instanceof PigEntity)
			{
				animal.targetSelector.addGoal(4, new TemptGoal(animal, 1.2D, false, Ingredient.fromTag(ETItemTags.PIG_BREEDING_ITEMS)));
			}
			else if (animal instanceof RabbitEntity)
			{
				animal.targetSelector.addGoal(3, new TemptGoal(animal, 1.0D, Ingredient.fromTag(ETItemTags.RABBIT_BREEDING_ITEMS), false));
			}
			else if (animal instanceof SheepEntity)
			{
				animal.targetSelector.addGoal(3, new TemptGoal(animal, 1.1D, Ingredient.fromTag(ETItemTags.SHEEP_BREEDING_ITEMS), false));
			}
			else if (animal instanceof TurtleEntity)
			{
				// animal.targetSelector.addGoal(2, new TurtleEntity.PlayerTemptGoal(animal, 1.1D, Ingredient.fromTag(ETItemTags.TURTLE_BREEDING_ITEMS)));
			}
		}
	}
}