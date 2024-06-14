FROM gcr.io/distroless/java:11

MAINTAINER Komponentes "kcomponents@ec.krugercorp.com"

ENV TZ ${TZ}

# Default to UTF-8 file.encoding
ENV LANG C.UTF-8

EXPOSE 8080

WORKDIR /api

COPY kodex-root-services/build/libs/*.jar /api/app.jar

CMD ["app.jar"]
