from correo.mensaje_dto import MensajeDto
import httplib2
import os
import oauth2client
from oauth2client import client, tools, file
import base64
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from apiclient import errors, discovery


class GmailService(MensajeDto):
    def __init__(self):
        super().__init__()

    def enviar_email(self):
        print("Preparando para enviar")
        credentials = self.__obtener_credenciales()
        http = credentials.authorize(httplib2.Http())
        service = discovery.build('gmail', 'v1', http=http)
        result = self.__enviar_mensaje_internal(service, "me", self.__crear_mensaje())
        print("mail enviado :D " + str(result))

    def __obtener_credenciales(self):
        ruta_credencial = os.path.join(os.path.dirname(os.path.abspath(__file__)), '.credentials',
                                       'gmail-python-email-send.json')
        store = oauth2client.file.Storage(ruta_credencial)
        credenciales = store.get()
        if not credenciales or credenciales.invalid:
            flow = client.flow_from_clientsecrets('credentials.json', 'https://www.googleapis.com/auth/gmail.send')
            flow.user_agent = 'Gmail API Python Send Email'
            credenciales = tools.run_flow(flow, store)
            print('Credencial guardada: ' + ruta_credencial)
        return credenciales

    def __enviar_mensaje_internal(self, service, user_id, mensaje):
        try:
            mensaje = (service.users().messages().send(userId=user_id, body=mensaje).execute())
            return mensaje
        except errors.HttpError as error:
            print('Error: %s' % error)
            return "Error"

    def __crear_mensaje(self):
        mensaje = MIMEMultipart('alternative')
        mensaje['Subject'] = self.subject
        mensaje['From'] = 'martin.saman@vallegrande.edu.pe'
        mensaje['To'] = self.to
        mensaje.attach(MIMEText(self.content, 'plain'))
        return {'raw': base64.urlsafe_b64encode(mensaje.as_string().encode()).decode()}




if __name__ == '__main__':
    gmail = GmailService()
    gmail.to = 'martin.saman@vallegrande.edu.pe'
    gmail.enviar_email()
