package ws.l10n.rest.client.impl;

import ws.l10n.rest.client.MessagePack;

import java.util.Locale;
import java.util.Map;

/**
 * @author Serhii Bohutskyi
 */
public class MessagePackImpl implements MessagePack {
    private final Map<String, String> messages;
    private final Locale locale;

    MessagePackImpl(Map<String, String> messages, Locale locale) {
        this.messages = messages;
        this.locale = locale;
    }

    public Map<String, String> getMessages() {
        return messages;
    }

    public String getMessage(String code) {
        return messages.get(code);
    }

    public Locale getLocale() {
        return locale;
    }
}