package com.example

import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.contact.PermissionDeniedException
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content
import net.mamoe.mirai.utils.info

object PSTC : KotlinPlugin(
    JvmPluginDescription(
        id = "com.RTH.PSTC",
        name = "PSTC",
        version = "0.1.0",
    ) {
        author("Administrator")
    }
) {
    override fun onEnable() {
        logger.info { "PSTC Plugin loaded" }
        GlobalEventChannel.subscribeAlways<GroupMessageEvent> {event ->
            if (event.message.content.contains("陪睡套餐"))
                try {
                    event.sender.mute(3600)
                    event.group.sendMessage("进小黑屋罢")
                } catch(e:PermissionDeniedException){
                    event.group.sendMessage("可惜我没有权限")
                }
        }
    }
}