FROM ubuntu:22.04
WORKDIR /docker
COPY . /docker
RUN apt update -y && \
    apt install -y wget unzip && \
    apt-get install -y sudo && \
    wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb && \
    sudo apt-get install -y ./google-chrome-stable_current_amd64.deb && \
    sudo apt-get -y install maven 
    wget https://chromedriver.storage.googleapis.com/92.0.4515.107/chromedriver_linux64.zip && \
    unzip chromedriver_linux64.zip
RUN mvn clean test
