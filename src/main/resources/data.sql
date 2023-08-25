/*
    user -> password
    rrhh -> rrhh
    healthPersonnel -> healthPersonnel
    admin -> admin
    patient -> patient
*/
INSERT INTO user (user,password,rol) VALUES
    ("rrhh", "$2a$10$gKlrb5pX4zyXbO.may9CZeYqyMHrqgRdVjk.0A8hI8nfJenMNd9By", "ROLE_RRHH"),
    ("healthPersonnel", "$2a$10$y69N3nQpTXwydOWpNo/eiuEMaVfCwQH.ET8DTxYBaHkrBVoQxb5Cq", "ROLE_HEALTH_PERSONNEL"),
    ("admin", "$2a$10$0XJN/wfeBHyJnAkURNMJNeyu5E62SIYEQH6ABd5ubvUGBFZxw1EDS", "ROLE_ADMIN"),
    ("patient", "$2a$10$uw5WwlWRT4TVZNefUuaH5.D89zwJ5URF5Yuv.w2hj89xiEq72cfUW", "ROLE_PATIENT");