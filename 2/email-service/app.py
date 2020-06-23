from kafka_service.kafka_consumer import ConsumerService
from flask import Flask
import threading

app = Flask(__name__)


@app.route("/")
def index():
    return "Email service corriendo :D"


def listen_kafka():
    try:
        listener_kafka = ConsumerService()
        listener_kafka.escuchar()
    except Exception as e:
        print('reintentando kafka')
        listen_kafka()


if __name__ == '__main__':
    listener_kafka_hilo = threading.Thread(target=listen_kafka)
    listener_kafka_hilo.daemon = True
    listener_kafka_hilo.start()
    print(":DDD")
    app.run(host='0.0.0.0', port=3009, threaded=True, debug=False)
