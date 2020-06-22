class MensajeDto:

    def __init__(self):
        self._subject = 'subject defecto'
        self._content = 'content defectoo'

    @property
    def to(self):
        return self._to

    @to.setter
    def to(self, value: str):
        self._to = value

    @property
    def subject(self):
        return self._subject

    @subject.setter
    def subject(self, value: str):
        self._subject = value

    @property
    def content(self):
        return self._content

    @content.setter
    def content(self, value: str):
        self._content = value
