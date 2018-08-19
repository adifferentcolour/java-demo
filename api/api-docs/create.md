## Create Package

**URL:** `/api/package`
**Method:** `POST`
**Data Constraints:**
```json
{
    "name": "[100 character limit]",
    "description": "[250 character limit]",
    "products": [
        {
            "id": "[64 character limit]",
            "name": "[100 character limit]",
            "usdPrice": [integer]
        }
    ]
}
```

**Payload Example:**
```json
{
    "name": "test",
    "description": "desc",
    "products": [{
        "id": "VqKb4tyj9V6i",
        "name": "Shield",
        "usdPrice": 1149
    }]
}

```

### Success

Will return the created object with the total price calculated.

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

**Condition:** If price submitted is different than price from Product API

**Code:** `400 BAD REQUEST`

**Content:** `Price submitted does not match price on record`
