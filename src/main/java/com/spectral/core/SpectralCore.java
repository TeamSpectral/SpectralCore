package com.spectral.core;

import com.spectral.core.chat.ChatMessageFancifier;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.io.IOException;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
public class SpectralCore {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(this);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        try {
            VersionCheck.verCheck();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        String k = "";
        try {
            if (VersionCheck.messages.size() > 0)
                for (String s : VersionCheck.messages.keySet()) {
                    k = s;
                    VersionCheck.messages.remove(s);
                    event.player.addChatMessage(new ChatMessageFancifier().fancifyUpdateMessage(s));
                    // event.player.addChatMessage(new ChatMessageFancifier().makeURL(new ChatMessageFancifier().fancifyUpdateMessage("Update HERE!"), new URL(VersionCheck.modnametourl.get(VersionCheck.messages.get(s)))));
                }
        }
        //  catch(MalformedURLException e) {
        //  System.out.println(VersionCheck.messages.get(k));
        // }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
