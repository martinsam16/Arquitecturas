FROM python:3.7-alpine

ADD . /

RUN pip install -r requirements.txt

EXPOSE 3009

ENTRYPOINT ["python3","./app.py"]