USE spr1;

DESC tbl_board;

CREATE TABLE tbl_board_file (
	id INT PRIMARY KEY AUTO_INCREMENT,
    bno INT NOT NULL,
    fileName VARCHAR(200) NOT NULL,
    FOREIGN KEY (bno) REFERENCES tbl_board(bno)
);

ALTER TABLE tbl_board_file
MODIFY bno INT NOT NULL;

ALTER TABLE tbl_board_file
ADD FOREIGN KEY (bno) REFERENCES tbl_board(bno);

DESC tbl_board_file;

SELECT * FROM tbl_board_file;