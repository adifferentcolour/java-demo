## Create Package

**URL:** `/api/package?id=:id`
**Method:** `GET`

**Url Example:**
```json
http://localhost:8080/api/package?id=1
```

### Success

Will return the object relating to the id supplied

**Code:** 200

**Content Example:**
```json
{
    "id": 2,
    "name": "test",
    "description": "desc",
    "totalPrice": 1149,
    "products": [
        {
            "id": "VqKb4tyj9V6i",
            "name": "Shield",
            "usdPrice": 1149
        }
    ]
}
```

### Failure

**Condition:** If `id` is not found

**Code:** `400 BAD REQUEST`

**Content:** `Unknown bundle identifier`

