USE spr1;

CREATE TABLE persistent_logins (
    username VARCHAR(64) NOT NULL,
    series VARCHAR(64) PRIMARY KEY,
    token VARCHAR(64) NOT NULL,
    last_used TIMESTAMP NOT NULL
);

DESC persistent_logins;

SELECT * FROM persistent_logins;
SELECT * FROM tbl_board;
SELECT * FROM tbl_reply;
SELECT * FROM tbl_member;

UPDATE tbl_board
SET writer = 'member';

UPDATE tbl_reply
SET replyer = 'member';

ALTER TABLE tbl_board
ADD FOREIGN KEY (writer) REFERENCES tbl_member (userid);

ALTER TABLE tbl_reply
ADD FOREIGN KEY (replyer) REFERENCES tbl_member (userid);