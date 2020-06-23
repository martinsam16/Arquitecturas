from kafka_service.kafka_consumer import ConsumerService

if __name__ == '__main__':
    print(":DDD")
    listener_kafka = ConsumerService()
    listener_kafka.escuchar()
