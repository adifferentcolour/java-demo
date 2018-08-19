## Create Package

**URL:** `/api/package/all`
**Method:** `GET`

**Url Example:**
```json
http://localhost:8080/api/package/all
```

### Success

Will return a list of all packages

**Code:** 200

**Content Example:**
```json
[
    {
        "id": 2,
        "name": "name-2",
        "description": "description",
        "totalPrice": 1149,
        "products": [
            {
                "id": "VqKb4tyj9V6i",
                "name": "Shield",
                "usdPrice": 1149
            }
        ]
    },
    {
        "id": 3,
        "name": "name-3",
        "description": "description",
        "totalPrice": 1149,
        "products": [
            {
                "id": "VqKb4tyj9V6i",
                "name": "Shield",
                "usdPrice": 1149
            }
        ]
    }
]
```

