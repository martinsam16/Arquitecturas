import yagmail

from correo.mensaje_dto import MensajeDto


class GmailService(MensajeDto):
    def __init__(self):
        super().__init__()
        self.yag = yagmail.SMTP(user='mdnisoft2019@gmail.com', password='vallegrande2018')

    def enviar_email(self):
        self.yag.send(to=self._to,
                      subject=self._subject,
                      contents=self._content)
        self.yag.close()


if __name__ == '__main__':
    gmail = GmailService()
    gmail.to = 'martin.saman@vallegrande.edu.pe'
    gmail.enviar_email()
