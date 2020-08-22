package com.markus1002.expandedtags.core;

import com.markus1002.expandedtags.core.events.EntityEvents;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(ExpandedTags.MOD_ID)
public class ExpandedTags
{
	public static final String MOD_ID = "expanded_tags";

    public ExpandedTags()
    {
		MinecraftForge.EVENT_BUS.register(new EntityEvents());
		MinecraftForge.EVENT_BUS.register(this);
    }
}
