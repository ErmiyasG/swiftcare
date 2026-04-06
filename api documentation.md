API DOCUMENTATION


**Base URL**: http://localhost:9000/api/v1/clinics

**1. Create a Clinic**

    Method: POST
    url: http://localhost:9000/api/v1/clinics
    Body: {
            "name": "DownTown"
            }

    Expected Response : {
                            "id": "f4ae2d5b-03ce-4451-bf6c-d648f8dda39e",
                            "name": "West-End",
                            "minorCount": 0,
                            "standardCount": 0,
                            "acuteCount": 0
                        }

**2. GET Clinic**

    Method: GET
    url: http://localhost:9000/api/v1/clinics/{CLINIC_ID}
    Example: http://localhost:9000/api/v1/clinics/f4ae2d5b-03ce-4451-bf6c-d648f8dda39e
    Expected Response: {
                        "id": "f4ae2d5b-03ce-4451-bf6c-d648f8dda39e",
                        "name": "West-End",
                        "minorCount": 0,
                        "standardCount": 0,
                        "acuteCount": 0
                    }

**3. Check wait-time**

    Method: GET
    url: http://localhost:9000/api/v1/clinics/{CLINIC_ID}/wait-time
    Example: http://localhost:9000/api/v1/clinics/f4ae2d5b-03ce-4451-bf6c-d648f8dda39e/wait-time
    Expected Response: {
                        "clinicId": "f4ae2d5b-03ce-4451-bf6c-d648f8dda39e",
                        "estimatedMinutes": 0
                        }

**4. Add Patient**

    Method: PATCH
    url: http://localhost:9000/api/v1/clinics/{CLINIC_ID}/patients
    Example: http://localhost:9000/api/v1/clinics/f4ae2d5b-03ce-4451-bf6c-d648f8dda39e/patients
    Body: {
            "severity":"MINOR",
            "operation":"INCREMENT"
         }
    Expected Response: 200 OK