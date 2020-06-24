package com.martinsaman.kafka_listener.service;

import com.google.gson.Gson;
import com.martinsaman.kafka_listener.clients.ICategoriaProducto;
import com.martinsaman.kafka_listener.dto.DataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ListenerService {

    @Autowired
    private ICategoriaProducto categoriaProductoClient;

    @KafkaListener(topics = "DatabaseTopic", groupId = "com.martinsaman")
    public void consume(String message) {
        try {
            DataDto data = new Gson().fromJson(message, DataDto.class);
            action(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object action(DataDto data) {
        switch (data.getCollectionDatabase()){
            case CATEGORIA:
                switch (data.getAction()){
                    case SAVE:
                        categoriaProductoClient.saveCategoria(data.getData());
                    break;
                    case UPDATE:
                        categoriaProductoClient.updateCategoria(data.getData());
                    break;
                    case DELETE:
                        categoriaProductoClient.deleteCategoria(data.getData());
                    break;
                    default:
                        break;
                }
                break;

            case PRODUCTO:
                switch (data.getAction()){
                    case SAVE:
                        categoriaProductoClient.saveProducto(data.getData());
                        break;
                    case UPDATE:
                        categoriaProductoClient.updateProducto(data.getData());
                        break;
                    case DELETE:
                        categoriaProductoClient.deleteProducto(data.getData());
                        break;
                    default:
                        break;
                }
                break;

            default:
                break;
        }
        return null;
    }
}
