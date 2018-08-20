## Create Package

**URL:** `/api/package`
**Method:** `PUT`
**Data Constraints:**
```json
{
    "id": [integer]
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
    "id": 1,
    "name": "test",
    "description": "updated description of package",
    "products": [{
        "id": "VqKb4tyj9V6i",
        "name": "Shield",
        "usdPrice": 1149
    }]
}

```

### Success

Will return the updated object with the total price recalculated.

**Code:** 200

**Content Example:**
```json
{
    "id": 1,
    "name": "test",
    "description": "updated description of package",
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

---------------------------------------

**Condition:** If `id` is not found

**Code:** `400 BAD REQUEST`

**Content:** `Unknown package identifier`

