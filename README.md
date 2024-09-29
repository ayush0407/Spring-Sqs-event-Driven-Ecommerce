It contains the code to demonstrate how we can do event driven programming using AWS-SQS and Spring-Boot and for this instance I used dummy order processing based on payment clearing event.

#Sample Curl request:
curl -X GET "http://localhost:8080/payment-status/Payment%20completed" -H "Content-Type: application/json"
