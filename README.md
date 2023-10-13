Ddroidd Autumn-Winter Dev Bootcamp 2023 - Backend  
Requirements  
https://github.com/Ddroidd-Limited/autumn-winter-bootcamp-2023-be#ddroidd-autumn-winter-dev-bootcamp-2023---backend  
Structura de date

Address contine date despre:
    - strada, nr, aparatament, etc (address)
    - tara
    - regiune
    - oras

Applicant
    - prenume
    - nume
    - nr de telefon
    - email
    - addresa
    - joburi la care a aplicat
Employer
    - nume
    - nr. de telefon
    - email
    - adresa

JobListing
    - titlul jobului
    - tipul
    - descriere
    - deadline ul pentru aplicare
    - angajator

Intre Address si Applicant este o relatie de One-to-Many
Intre Address si Employer este o relatie de One-to-Many
Intre Employer si JobListing este o relatie de One-to-Many
intre Applicant si JobLsting este o relatie de Many-to-Many (tabela applications)
![alt text](https://github.com/Stoian256/Ddroidd_Autumn_Bootcamp/blob/main/ApplicationPortalDatabase.png)
            
