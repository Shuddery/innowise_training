FROM ubuntu:22.04
RUN apt update -y
RUN apt install -y wget unzip
RUN apt-get install -y sudo
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN sudo apt-get install -q ./google-chrome-stable_current_amd64.deb
