FROM ubuntu:22.04
WORKDIR /docker
COPY ./pom.xml /docker
RUN apt update -y && \
    apt install -y wget unzip && \
    apt-get install -y sudo && \
    wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb && \
    sudo apt-get install -y ./google-chrome-stable_current_amd64.deb && \
    sudo apt-get -y install maven 
RUN mvn clean verify
