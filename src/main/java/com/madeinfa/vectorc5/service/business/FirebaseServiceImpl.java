package com.madeinfa.vectorc5.service.business;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.madeinfa.vectorc5.service.interfaces.IFirebaseService;
import org.springframework.stereotype.Service;

@Service
public class FirebaseServiceImpl implements IFirebaseService {

    @Override
    public void enviarNotificacion(String tokenDestino, String titulo, String cuerpo) {
        Notification notification = Notification.builder()
                .setTitle(titulo)
                .setBody(cuerpo)
                .build();

        Message message = Message.builder()
                .setToken(tokenDestino)
                .setNotification(notification)
                .build();

        try {
            String response = FirebaseMessaging.getInstance().send(message);
            System.out.println("Mensaje enviado exitosamente:");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
