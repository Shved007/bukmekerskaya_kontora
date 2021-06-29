package com.example.bukmekerskaya_kontora.controller;

import com.example.bukmekerskaya_kontora.telegramBot.Bot;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class BotController {
    private final Bot bot;

    public BotController(Bot bot) {
        this.bot = bot;
    }

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update){
        return bot.onWebhookUpdateReceived(update);
    }
}
