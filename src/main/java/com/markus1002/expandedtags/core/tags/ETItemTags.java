package com.markus1002.expandedtags.core.tags;

import com.markus1002.expandedtags.core.ExpandedTags;

import net.minecraft.item.Item;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraft.tags.ItemTags;

public class ETItemTags
{
	// Breeding
	public static final INamedTag<Item> BEE_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":mob_interaction_items/bee/bee_breeding_items");
	public static final INamedTag<Item> CAT_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":mob_interaction_items/cat/cat_breeding_items");
	public static final INamedTag<Item> CHICKEN_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":mob_interaction_items/chicken/chicken_breeding_items");
	public static final INamedTag<Item> COW_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":mob_interaction_items/cow/cow_breeding_items");
	public static final INamedTag<Item> FOX_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":mob_interaction_items/fox/fox_breeding_items");
	public static final INamedTag<Item> HOGLIN_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":mob_interaction_items/hoglin/hoglin_breeding_items");
	public static final INamedTag<Item> HORSE_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":mob_interaction_items/horse/horse_breeding_items");
	public static final INamedTag<Item> LLAMA_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":mob_interaction_items/llama/llama_breeding_items");
	public static final INamedTag<Item> PANDA_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":mob_interaction_items/panda/panda_breeding_items");
	public static final INamedTag<Item> PIG_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":mob_interaction_items/pig/pig_breeding_items");
	public static final INamedTag<Item> RABBIT_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":mob_interaction_items/rabbit/rabbit_breeding_items");
	public static final INamedTag<Item> SHEEP_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":mob_interaction_items/sheep/sheep_breeding_items");
	public static final INamedTag<Item> STRIDER_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":mob_interaction_items/strider/strider_breeding_items");
	public static final INamedTag<Item> TURTLE_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":mob_interaction_items/turtle/turtle_breeding_items");
	public static final INamedTag<Item> WOLF_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":mob_interaction_items/wolf/wolf_breeding_items");
	
	// Other Entity Interaction
	public static final INamedTag<Item> PANDA_FOODS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":mob_interaction_items/panda/panda_foods");
	public static final INamedTag<Item> WOLF_TAMING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":mob_interaction_items/wolf/wolf_taming_items");
}