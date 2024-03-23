package com.scherba.telegrambot.bot;

import com.scherba.telegrambot.config.TelegramBotConfig;
import com.scherba.telegrambot.model.Currency;
import com.scherba.telegrambot.service.CryptoExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;


@Component
@AllArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    private final TelegramBotConfig botConfig;
    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }
    @Override
    public void onUpdateReceived(Update update) {
        Currency currencyModel = new Currency();
        String currency = "";

        if(update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            switch (messageText){
                case "/start":
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;
                default:
                    try {
                        currency = CryptoExchangeService.getCurrencyRate(messageText, currencyModel);

                    } catch (IOException e) {
                        sendMessage(chatId, "We have not found such a currency.");
                    } catch (ParseException e) {
                        throw new RuntimeException("Unable to parse date");
                    }
                    sendMessage(chatId, currency);
            }
        }

    }

    private void startCommandReceived(Long chatId, String name) {
        String answer = "Hi, " + name + ", nice to meet you!" + "\n" +
                "Enter the crypto";
        sendMessage(chatId, answer);
    }

    private void sendMessage(Long chatId, String textToSend){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(textToSend);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {

        }
    }
//    public TelegramBot(DefaultBotOptions botOptions) {
//        super(botOptions);
//    }
//
//    public TelegramBot() {
//
//    }
//
//    @Override
//    public String getBotToken() {
//        return "6790264231:AAHB2PezNupQluvYzLrpmC2z-L2PUqs5tH0";
//    }
//
//    @Override
//    public void onUpdateReceived(Update update) {
//        if (update.hasMessage() && update.getMessage().hasText()) {
//            String messageText = update.getMessage().getText();
//            Long chatId = update.getMessage().getChatId();
//
//            if ("/start".equals(messageText)) {
//                sendMessage(chatId, "Hello! I'm the bot CryptoCurrency");
//            } else {
//                sendMessage(chatId, "Sorry");
//            }
//        }
//
//    }
//
//    private void sendMessage(Long chatId, String message) {
//        SendMessage sendMessage = new SendMessage(chatId, message);
//        try {
//            execute(sendMessage);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public String getBotUsername() {
//        return "CryptocurrencyInnoHackatonBot";
//    }
}
