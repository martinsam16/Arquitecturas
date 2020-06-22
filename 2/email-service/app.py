from kafka_service.kafka_consumer import ConsumerService


def listen_kafka():
    try:
        listener_kafka = ConsumerService()
        listener_kafka.escuchar()
    except Exception as e:
        print('reintentando kafka')
        listen_kafka()


if __name__ == '__main__':
    print("Inicializado :D.")
    listen_kafka()
