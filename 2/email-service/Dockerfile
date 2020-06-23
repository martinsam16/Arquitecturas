FROM python:3.7-alpine

ADD . /

RUN pip install --upgrade pip \
    && pip install -r requirements.txt

ENTRYPOINT ["python3","./app.py"]