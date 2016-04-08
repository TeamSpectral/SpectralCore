package com.spectral.core.chat;

import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

import java.net.URL;

public class ChatMessageFancifier {

    final String UPDATE_MESSAGE = "[Update Avaliable] ";

    public ChatComponentText fancifyUpdateMessage(String msg) {
        try {
            return (ChatComponentText) new ChatComponentText(UPDATE_MESSAGE + msg).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN));
        } catch (NoSuchMethodError e) {
            return new ChatComponentText(msg);
        } catch (Exception e) {
            e.printStackTrace();
            return new ChatComponentText(msg);

        }

    }

    public ChatComponentText makeURL(ChatComponentText original, URL url) {
        return (ChatComponentText) original.setChatStyle(new ChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url.toString())));
    }
}
