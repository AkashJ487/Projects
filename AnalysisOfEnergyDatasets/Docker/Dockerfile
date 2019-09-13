FROM python:latest

WORKDIR /usr/local/bin

ADD Final_pipeline.py .
ADD energydata_complete.csv .


RUN pip install pandas
RUN pip install boto3
RUN pip install sklearn
RUN pip install scipy


CMD ["python3", "./Final_pipeline.py"] 
