create table user (
    id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username varchar(100),
    hashedPassword varchar(100),
    email varchar(100),
    imageUrl varchar(100),
    githubUrl varchar(100),
    summary varchar(100)
)
