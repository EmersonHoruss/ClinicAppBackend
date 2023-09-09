# ClinicAppBackend

## About
The main requirements for this project is take control of appointments and schedules of the health personnel of my friend's neighborhood clinic.

## Test it for your own
If you want to test the deployed backend you can use two urls. The first is **https://clinicapp-ut28.onrender.com/docs** where is the backend in JSON format. The second is **https://clinicapp-ut28.onrender.com/docs_ui** which give you an interface with all endpoints and schemas to interact with the backend.

You can also test locally using **http://localhost:8080/docs** for the first and **http://localhost:8080/docs_ui** for the second.

### Roles
This project uses four roles.
| # | Role | Description |
| :- | :- | :- |
| 1 | RRHH | It's a person who belong to human resource department. |
| 2 | HEALTH_PERSONNEL | It's a doctor, a nurse or specialist in charge of treating patients. |
| 3 | ADMIN | It's the manager of the system, these man have all priviles to access the system. |
| 4 | PATIENT | It's a sick person. |

You can consult roles throw **https://clinicapp-ut28.onrender.com/roles** if you want to access to live project or in your local machine with the downloaded project throw **http://localhost/roles**.

### Secured Resources
The next section describes how each role is associated with some specific resources.
| # | Resource | Endpoint | GET | POST | PUT | DELETE |
| :- | :- | :- |:- | :- | :- | :- |
| 1 | Shifts | /shifts | RRHH <br> HEALTH_PERSONNEL <br> ADMIN <br> PATIENT | ADMIN | ADMIN | ADMIN |
| 2 | Services Health | /services_health | RRHH <br> HEALTH_PERSONNEL <br> ADMIN <br> PATIENT | ADMIN | ADMIN | ADMIN |
| 3 | Health Personnel | /health_personnel | RRHH <br> HEALTH_PERSONNEL <br> ADMIN <br> PATIENT | ADMIN | ADMIN | ADMIN |
| 4 | Schedules | /schedules | RRHH <br> HEALTH_PERSONNEL <br> ADMIN <br> PATIENT | RRHH <br> ADMIN | RRHH <br> ADMIN | RRHH <br> ADMIN |
| 5 | Consulting Rooms | /consulting_rooms | RRHH <br> HEALTH_PERSONNEL <br> ADMIN <br> PATIENT | ADMIN | ADMIN | ADMIN |
| 6 | Appointments | /appointments | HEALTH_PERSONNEL <br> ADMIN <br> PATIENT | HEALTH_PERSONNEL <br> ADMIN <br> PATIENT | HEALTH_PERSONNEL <br> ADMIN <br> PATIENT | HEALTH_PERSONNEL <br> ADMIN <br> PATIENT |
| 7 | Patients | /patients | HEALTH_PERSONNEL <br> ADMIN <br> PATIENT | HEALTH_PERSONNEL <br> ADMIN <br> PATIENT | HEALTH_PERSONNEL <br> ADMIN <br> PATIENT | ADMIN |
| 8 | Users | /users | RRHH <br> HEALTH_PERSONNEL <br> ADMIN <br> PATIENT | ADMIN | RRHH <br> HEALTH_PERSONNEL <br> ADMIN <br> PATIENT | ADMIN |
| 9 | Clinics | /clinics | ADMIN | ADMIN | ADMIN | ADMIN |

### Free Access Resources
The next part shows what resources are free.
| # | Resource | Endpoint | HTTP |
| :- | :- | :- |:- |
| 1 | Documentation in JSON format | /docs | GET |
| 2 | Documentation to interact throw graphic interface | /docs_ui | GET |
| 3 | Signup | /signup | POST |
| 4 | Confirm user to signup | /validate | POST |
| 5 | Login | /login | POST |
| 6 | Appointments States | /appointment_states | GET |
| 7 | Roles | /roles | GET |

### Credentials
This project started with four credentials.
| # | User | Password | Role
| :- | :- | :- | :- |
| 1 | rrhh | rrhh | RRHH
| 2 | healthPersonnel | healthPersonnel |
| 3 | admin | admin |
| 4 | patient | patient |

You can check started credential in data.sql file.
You can also add more accesing throught user with **ADMIN** role.

## Warning!!!
The project was deployed on **render** thanks free plan. However it the server spin down when no activity there is, so it will take about 2 or 3 minutes to spin up and start using it.
