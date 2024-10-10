CREATE TABLE IF NOT EXISTS User(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    role ENUM('ADM','SIGNATARIO') NOT NULL
);

CREATE TABLE IF NOT EXISTS Comment (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_user INTEGER,
    conteudo TEXT NOT NULL,
    allow_replies BOOLEAN,
    comment_visibility ENUM('TODOS', 'ADM', 'SIGNATARIOS') NOT NULL,
    allow_notifications BOOLEAN,
    max_comments INT,
    created_at DATETIME,
    answer_of INTEGER,
    FOREIGN KEY (id_user) REFERENCES User(Id),
    FOREIGN KEY (answer_of) REFERENCES Comment(id)
);