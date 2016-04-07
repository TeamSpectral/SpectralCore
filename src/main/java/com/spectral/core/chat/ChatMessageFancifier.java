package com.spectral.core.chat;

import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

import java.net.URL;

public class ChatMessageFancifier {

    final String UPDATE_MESSAGE = "[Update Avaliable] ";

    public ChatComponentText fancifyUpdateMessage(String msg) {
        return (ChatComponentText) new ChatComponentText(UPDATE_MESSAGE + msg).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN));
    }

    public ChatComponentText makeURL(ChatComponentText original, URL url) {
        return (ChatComponentText) original.setChatStyle(new ChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url.toString())));
    }
}
