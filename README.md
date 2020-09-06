# cognizant-microservices
- Step 1: Start the Eureka Server
- Step 2: Start the zuul API gateway
- Step 3: Start the Address Service
- Step 4: Start the Customer Service
## Architecture Flow for Customer Management

![Image of Microservices](https://github.com/mrkachary/cognizant-microservices/blob/master/Cognizant.jpg)

Once you start servers and services in the above order your [Eureka Server](http://localhost:8761/) should look like this 

![Image of Eureka Registration](https://github.com/mrkachary/cognizant-microservices/blob/master/EurekaConfig.JPG)

## Operations
Swagger is enabled for customer. You can create Customer and call to Address will create an address and appends to customer. Similarly, you call a get customer it first picks the address and appends to Customer and show
