# Spring cloud microservices examples

## Microservices examples using spring cloud netflix integration with spring boot apps

#
#
### Case Study:

Building a microservice application to track investment portfolio of an user like ET-Portfolio or Money Control.  This should track the investments of a user and could show return of investment over a period of time.

Scope this case study is to only track investments of type stock and mutual funds. 
#
#

#### Solution:

| Micro-Services | Description |
| --- | --- |
| [Portfolio Tracker DB Service](https://github.com/anilpatro83/spring-cloud-microservices-examples/tree/master/portfolio-tracker-db-service) | Stores user quotes information. Quotes can be of type Stock or Mutual Fund|
| [Portfolio Tracker Pricing Service](https://github.com/anilpatro83/spring-cloud-microservices-examples/tree/master/portfolio-tracker-pricing-service) | Talks to an external finance api application [World Trading Data](https://www.worldtradingdata.com/) like yahoo finance apis to fetch fresh price quotes|
| [Portfolio Tracker Aggregator Service](https://github.com/anilpatro83/spring-cloud-microservices-examples/tree/master/portfolio-tracker-app-service) | Interacts with both db service and pricing service to process the user portfolio data and fetch investment returns|
| [Portfolio Tracker Registry Service](https://github.com/anilpatro83/spring-cloud-microservices-examples/tree/master/portfolio-tracker-registry-service) | Acts as a service registry and api gateway|

#
#
![micro-service-update](https://user-images.githubusercontent.com/10323216/54940620-14b71980-4f51-11e9-8d3a-3645281803b5.jpg)
