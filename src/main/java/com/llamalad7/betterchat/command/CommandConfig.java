package com.llamalad7.betterchat.command;

import com.llamalad7.betterchat.gui.GuiConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
//#if MC==11202
//$$ import net.minecraft.command.CommandException;
//$$ import net.minecraft.server.MinecraftServer;
//#endif
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class CommandConfig extends CommandBase {

    //#if MC==10809
    @Override
    public String getCommandName() {
        return "betterchat";
    }
    //#else
    //$$ @Override
    //$$ public String getName() {
    //$$     return "betterchat";
    //$$ }
    //#endif

    //#if MC==10809
    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/betterchat";
    }
    //#else
    //$$ @Override
    //$$ public String getUsage(ICommandSender sender) {
    //$$     return "/betterchat";
    //$$ }
    //#endif

    //#if MC==10809
    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
    //#else
    //$$ @Override
    //$$ public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
    //$$     return true;
    //$$ }
    //#endif

    //#if MC==10809
    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        MinecraftForge.EVENT_BUS.register(this);
    }
    //#else
    //$$ @Override
    //$$ public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
    //$$     MinecraftForge.EVENT_BUS.register(this);
    //$$ }
    //#endif

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        MinecraftForge.EVENT_BUS.unregister(this);
        Minecraft.getMinecraft().displayGuiScreen(new GuiConfig());
    }
}
