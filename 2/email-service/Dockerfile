FROM python:3.7-alpine

ADD . /email-service

RUN pip install -r requirements.txt

ENTRYPOINT ["python3","./email-service/app.py"]