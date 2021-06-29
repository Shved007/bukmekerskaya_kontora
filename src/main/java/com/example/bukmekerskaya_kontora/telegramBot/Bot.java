package com.example.bukmekerskaya_kontora.telegramBot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramWebhookBot {
    @Value("${telegram.bot.userName}")
    private String userName;

    @Value("${telegram.bot.token}")
    private String token;

    @Value("${telegram.bot.webHookPath}")
    private String webHookPath;

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()){
            sendMsg(message, "hi");
        }

        return null;
    }

    public void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(false);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);

        try {
            execute(sendMessage);
        } catch (TelegramApiException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return token;
    }



    @Override
    public String getBotPath() {
        return webHookPath;
    }
}
