# API Documentation

## User API

### Register User

Endpoint : POST /api/users

Request Body : 

```json
{
  "username": "johndoe",
  "password": "johndoe",
  "name": "John Doe"
}
```

Response Body (Success) :

```json
{
  "data": "OK"
}
```

Response Body (Failed) :

```json
{
  "errors": "Username must not blank, ???"
}
```

### Login User

Endpoint : POST /api/auth/login

Request Body :

```json
{
  "username": "johndoe",
  "password": "johndoe"
}
```

Response Body (Success) :

```json
{
  "data": {
    "token": "TOKEN",
    "expiredAt": 23423423423432 //millisecond
  }
}
```

Response Body (Failed, 401) :

```json
{
  "errors": "Username or Password wrong"
}
```

### Get User

Endpoint :GET /api/users/current

Request Header : 

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": {
    "username": "johndoe",
    "name": "John Doe"
  }
}
```

Response Body (Failed, 401) :

```json
{
  "errors": "Unauthorized"
}
```

### Update User

Endpoint : PATCH /api/users/current

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "name": "John", // put if only want to ypdate name
  "password": "new password" // put if only want to update password
}
```

Response Body (Success) :

```json
{
  "data": {
    "username": "johndoe",
    "name": "John Doe"
  }
}
```

Response Body (Failed, 401) :

```json
{
  "errors": "Unauthorized"
}
```

### Logout User

Endpoint : DELETE /api/auth/logout

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": "OK"
}
```

-------------------------------------------------------------------------------

## Contact API

### Create Contact

Endpoint : POST api/contacts

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "firstname": "John",
  "lastname": "Doe",
  "email": "johndoe@example.com",
  "phone": "08xxxxxxxxxxx"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "random-string",
    "firstname": "John",
    "lastname": "Doe",
    "email": "johndoe@example.com",
    "phone": "08xxxxxxxxxxx"
  }
}
```

Response Body (Failed) :

```json
{
  "errors": "Email format invalid, phone format invalid, ..."
}
```

### Update Contact

Endpoint : PUT api/contacts/{idContact}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "firstname": "John",
  "lastname": "Doe",
  "email": "johndoe@example.com",
  "phone": "0813234453234"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "random-string",
    "firstname": "John",
    "lastname": "Doe",
    "email": "johndoe@example.com",
    "phone": "0813234453234"
  }
}
```

Response Body (Failed) :

```json
{
  "errors": "Email format invalid, phone format invalid, ..."
}
```

### Get Contact

Endpoint : GET api/contacts/{idContact}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": {
    "id": "random-string",
    "firstname": "John",
    "lastname": "Doe",
    "email": "johndoe@example.com",
    "phone": "08xxxxxxxxxxx"
  }
}
```

Response Body (Failed, 404) :

```json
{
  "errors": "Contact is not found!"
}
```

### Search Contact

Endpoint : GET api/contacts

Query Param :

- name : String, contact firstname or lastname, using like query, optional
- phone : String, contact phone, using like query, optional
- email : String, contact email, using like query, optional
- page : Integer, start from 0
- size : Integer, default 10

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": [
    {
      "id": "random-string",
      "firstname": "John",
      "lastname": "Doe",
      "email": "johndoe@example.com",
      "phone": "08xxxxxxxxxxx"
    }
  ],
  "paging": {
    "currentPage": 0,
    "totalPage": 10,
    "size": 10
  }
}
```

Response Body (Failed) :

```json
{
  "errors": "Unauthorized"
}
```

### Remove Contact

Endpoint : DELETE api/contacts/{idContact}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": "OK"
}
```

Response Body (Failed) :

```json
{
  "errors": "Contact is not found!"
}
```

-------------------------------------------------------------------------------

## Address API

### Create Address

Endpoint : POST api/contacts/{idContact}/addresses

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "street": "Jalan",
  "city": "Kota",
  "province": "Provinsi",
  "country": "Negara",
  "postalCode": "12312"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "random-string",
    "street": "Jalan",
    "city": "Kota",
    "province": "Provinsi",
    "country": "Negara",
    "postalCode": "12312"
  }
}
```

Response Body (Failed) :

```json
{
  "errors": "Address is not found!"
}
```

### Update Address

Endpoint : PUT api/contacts/{idContact}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "street": "Jalan",
  "city": "Kota",
  "province": "Provinsi",
  "country": "Negara",
  "postalCode": "12312"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "random-string",
    "street": "Jalan",
    "city": "Kota",
    "province": "Provinsi",
    "country": "Negara",
    "postalCode": "12312"
  }
}
```

Response Body (Failed) :

```json
{
  "errors": "Address is not found!"
}
```

### Get Address

Endpoint : GET api/contacts/{idContact}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": {
    "id": "random-string",
    "street": "Jalan",
    "city": "Kota",
    "province": "Provinsi",
    "country": "Negara",
    "postalCode": "12312"
  }
}
```

Response Body (Failed) :

```json
{
  "errors": "Address is not found!"
}
```

### Remove Address

Endpoint : DELETE api/contacts/{idContact}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": "OK"
}
```

Response Body (Failed) :

```json
{
  "errors": "Address is not found!"
}
```

### List Address

Endpoint : GET api/contacts/{idContact}/addresses

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": [
    {
      "id": "random-string",
      "street": "Jalan",
      "city": "Kota",
      "province": "Provinsi",
      "country": "Negara",
      "postalCode": "12312"
    }
  ]
}
```

Response Body (Failed) :

```json
{
  "errors": "Contact is not found!"
}
```

### Credit

[Programmer Zaman Now](https://youtu.be/eFIBOVXilK4?si=hhIk-Cb6qCsZbv9d).
