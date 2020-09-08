# cognizant-microservices
- Step 1: Start the Eureka Server - This starts at port 8761
- Step 2: Start the zuul API gateway - This starts at 8765
- Step 3: Start the Address Service - This starts at assigned port 8081. You can have multiples deployments on different ports
- Step 4: Start the Customer Service - This starts on default port 8080
## Architecture Flow for Customer Management

![Image of Microservices](https://github.com/mrkachary/cognizant-microservices/blob/master/Cognizant.jpg)

Once you start servers and services in the above order your [Eureka Server](http://localhost:8761/) should look like this 

![Image of Eureka Registration](https://github.com/mrkachary/cognizant-microservices/blob/master/EurekaConfig.JPG)

## Operations
Swagger is enabled for customer. You can create Customer and that calls to Address Service and will create an address and appends back to customer. Similarly, you call to get a customer that it would first picks the address by address id and appends to Customer and show
