package com.martinsaman.websocket.canales;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Frontend extends TextWebSocketHandler {
    ConcurrentHashMap<String, WebSocketSession> sesiones = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession sesion) {
        if (!sesiones.containsKey(sesion.getId())) {
            sesiones.put(sesion.getId(), sesion);
            System.out.println("Sesion agregada: " + sesion);
        }
    }

    @Override
    public void handleTextMessage(WebSocketSession sesion, TextMessage message) throws Exception {
        broadcast(sesion.getId(), message);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession sesion, CloseStatus status) {
        sesiones.remove(sesion.getId());
    }

    public void broadcast(String sesionIgnored, TextMessage mensaje) throws Exception {
        System.out.println("Haciendo broadcast");
        sesiones.forEach((key, value) -> {
            if (!key.equals(sesionIgnored)) {
                try {
                    value.sendMessage(mensaje);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
