# Java-demo

A java demo written in Java using SpringBoot. Offers a RESTful for managing packages of products - it integrates with two down stream APIs to provide products and exchange rates.

## Requirements

* Java8

## Running

* Clone the repo
* Navigate to `java-demo/api`
* Run `./gradlew bootRun`

# API

* [Create Package](api-docs/create.md): `POST /api/package`
* [Update Package](api-docs/update.md): `PUT /api/package`
* [Delete Package](api-docs/delete.md): `DELETE /api/package?id=:id`
* [View Package](api-docs/view.md): `GET /api/package?id=:id`
* [List All Packages](api-docs/list-all.md): `GET /api/package/all`



