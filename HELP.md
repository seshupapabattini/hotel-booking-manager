# HELP

# Run the appliation

java -jar booking-0.0.1.jar --booking.rooms.count=12 --booking.available.days=50

# Create booking

POST http://localhost:8088/booking-manager/booking/create

# Get rooms available for a given date

GET http://localhost:8088/booking-manager/rooms/getAvailableRooms?date=17-03-2023

# Get all bookings for a given customer

GET http://localhost:8088/booking-manager/booking/getAllBookings?guestName=seshu

#To Verify the H2 Data

http://localhost:8088/h2-console