FROM java:8
EXPOSE 8088
ADD /target/Reservation-voitures-1.0.jar Reservation-voitures.jar
ENTRYPOINT ["java","-jar","Reservation-voitures.jar"]