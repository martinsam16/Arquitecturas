FROM python:3.7-alpine

ADD . /

RUN pip install -r requirements.txt

ENTRYPOINT ["python3","./app.py"]