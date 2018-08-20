## Create Package

**URL:** `/api/package?id=:id`
**Method:** `DELETE`

**Url Example:**
```json
http://localhost:8080/api/package?id=1
```

### Success

Will return 200 if the object was successfully deleted

**Code:** 200

### Failure

**Condition:** If `id` is not found

**Code:** `400 BAD REQUEST`

**Content:** `Unknown package identifier`

