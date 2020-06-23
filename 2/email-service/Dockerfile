FROM python:3.7-alpine

ADD . /

RUN pip install --upgrade pip \
    && pip install google-api-python-client google-auth-httplib2 google-auth-oauthlib oauth2client \
    && pip install -r requirements.txt

ENTRYPOINT ["python3","./app.py"]