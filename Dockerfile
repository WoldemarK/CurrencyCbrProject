FROM bellsoft/liberica-openjdk-alpine-musl
COPY ./target/CurrencyCbrProject-1.0.0-SNAPSHOT.jar .
CMD ["java","-jar","CurrencyCbrProject-1.0.0-SNAPSHOT.jar"]