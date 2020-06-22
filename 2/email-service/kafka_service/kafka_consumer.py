from kafka import KafkaConsumer

from correo.gmail_service import GmailService

import json


class ConsumerService:
    def __init__(self):
        self._consumer = KafkaConsumer('email_topic',
                                       bootstrap_servers='23.102.156.137',
                                       group_id='group_email',
                                       enable_auto_commit=False)
        self._gmail = GmailService()

    def escuchar(self):
        print('Escuchando :D')
        for mensaje in self._consumer:
            try:
                dto: dict = json.loads(mensaje.value)
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
