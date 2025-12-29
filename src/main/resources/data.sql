INSERT INTO patient(name, gender, birth_date, email, blood_group)
VALUES
    ('Atakan1','MALE','2001-10-02','aa1@gmail.com','O_POSITIVE'),
        ('Atakan2','MALE','2001-10-02','aa2@gmail.com','A_POSITIVE'),
        ('Atakan3','MALE','2001-10-04','aa3@gmail.com','A_POSITIVE'),
        ('Atakan4','MALE','2001-10-05','aa4@gmail.com','B_POSITIVE'),
        ('Atakan5','MALE','2001-10-06','aa5@gmail.com','B_NEGATIVE');


INSERT INTO doctor(name, specialization, email)
VALUES
    ('Dr. Atakan', 'Cardiology', 'atakan1@gmail.com'),
    ('Dr. Atakan2', 'Dermatology', 'atakan2@gmail.com'),
    ('Dr. Atakan3', 'Orthopedics', 'atakan3@gmail.com');

INSERT INTO appointment(appointment_time, reason, doctor_id,patient_id)
VALUES
    ('2025-12-29 10:30:00', 'General Checkup',1,2),
    ('2025-12-29 11:30:00', 'Skin Rash',2,2),
    ('2025-12-29 12:30:00', 'Knee Pain ',3,3),
    ('2025-12-29 13:30:00', 'Follow-up Visit ',1,1),
    ('2025-12-29 14:30:00', 'Consultation ',1,4),
    ('2025-12-29 15:30:00', 'Allergy Treatment ',2,5);