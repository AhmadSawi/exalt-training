# Please view this document in RAW mode for the desired look


# exalt-training

This is the Cisco Log Parser project worked on during training at Exalt in the summer of 2018


# Log Files

The logs in the log files have the structure of:
TIMESTAMP | TYPE | THREAD | | CLASS | MESSAGE |
in two log files named "spf-device-manager" and "spf-service-manager"



# Database

The data base in this project has one table called 'info' with the following structure:
+-------------+---------------+------+-----+---------+----------------+
| Field       | Type          | Null | Key | Default | Extra       |
+-------------+---------------+------+-----+---------+----------------+
| id          | int(11)       | NO   | PRI | NULL    | auto_increment |
| time        | datetime      | YES  |     | NULL    |                |
| ms          | int(11)       | YES  |     | NULL    |                |
| type        | varchar(30)   | YES  |     | NULL    |                |
| threadname  | varchar(100)  | YES  |     | NULL    |                |
| classname   | varchar(100)  | YES  |     | NULL    |                |
| message     | longtext      | YES  |     | NULL    |                |
| exception   | text          | YES  |     | NULL    |                |
| servicename | varchar(50)   | YES  |     | NULL    |                |
+-------------+---------------+------+-----+---------+----------------+


# UI
usinh HTML, CSS, and JS we created a simple website to view and interact with the logs
you can see a screenshot of it in the UI-screenshot file
\\


