from kafka import KafkaConsumer

from correo.gmail.gmail_service import GmailService

import json


class ConsumerService:
    def __init__(self):
        self._consumer = KafkaConsumer('email_topic',
                                       bootstrap_servers='23.102.156.137:9092',
                                       group_id='group_email',
                                       enable_auto_commit=False,
                                       api_version=(0, 10))
        self._gmail = GmailService()

    def escuchar(self):
        print('Escuchando :D')
        for mensaje in self._consumer:
            try:
                dto: dict = json.loads(mensaje.value)
                print("Preparando envio mail")
                self._gmail.to = dto['email']
                self._gmail.subject = dto['subject']
                self._gmail.content = dto['content']
                self._gmail.enviar_email()
                self._consumer.commit()
            except Exception as e:
                print(e)


if __name__ == '__main__':
    demo = ConsumerService()
    demo.escuchar()
