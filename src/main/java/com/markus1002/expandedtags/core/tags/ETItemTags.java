package com.markus1002.expandedtags.core.tags;

import com.markus1002.expandedtags.core.ExpandedTags;

import net.minecraft.item.Item;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraft.tags.ItemTags;

public class ETItemTags
{
	// Breeding
	public static final INamedTag<Item> BEE_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/bee/breeding_items");
	public static final INamedTag<Item> CAT_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/cat/breeding_items");
	public static final INamedTag<Item> CHICKEN_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/chicken/breeding_items");
	public static final INamedTag<Item> COW_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/cow/breeding_items");
	public static final INamedTag<Item> FOX_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/fox/breeding_items");
	public static final INamedTag<Item> HOGLIN_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/hoglin/breeding_items");
	public static final INamedTag<Item> HORSE_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/horse/breeding_items");
	public static final INamedTag<Item> LLAMA_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/llama/breeding_items");
	public static final INamedTag<Item> PANDA_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/panda/breeding_items");
	public static final INamedTag<Item> PIG_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/pig/breeding_items");
	public static final INamedTag<Item> RABBIT_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/rabbit/breeding_items");
	public static final INamedTag<Item> SHEEP_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/sheep/breeding_items");
	public static final INamedTag<Item> STRIDER_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/strider/breeding_items");
	public static final INamedTag<Item> WOLF_BREEDING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/wolf/breeding_items");
	
	// Taming
	public static final INamedTag<Item> PARROT_TAMING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/parrot/taming_items");
	public static final INamedTag<Item> WOLF_TAMING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/wolf/taming_items");
	
	// Other
	public static final INamedTag<Item> DOLPHIN_TRUSTING_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/dolphin/trusting_items");
	public static final INamedTag<Item> PANDA_FOODS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/panda/foods");
	public static final INamedTag<Item> PARROT_POISONOUS_ITEMS = ItemTags.makeWrapperTag(ExpandedTags.MOD_ID + ":entity_interaction_items/parrot/poisonous_items");
}