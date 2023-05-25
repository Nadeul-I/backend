-- ----------------------------------------
-- 데이터 베이스 만들기
-- ----------------------------------------
-- enjoytrip 이 있는 경우 데이터베이스 삭제
-- DROP SCHEMA IF EXISTS enjoytrip;

-- enjoytrip 이 없는 경우 데이터베이스 만들기
CREATE SCHEMA IF NOT EXISTS enjoytrip DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;

-- enjoytrip 데이터베이스 사용
USE enjoytrip;

-- 원할한 테이블 삭제를 위해 foreign key set = 0
 SET foreign_key_checks = 0;
 
 
-- ----------------------------------------
-- user table 만들기
-- ----------------------------------------
-- enjoytrip.user 이 있는 경우 테이블 삭제
DROP TABLE IF EXISTS enjoytrip.user;

-- enjoytrip.user 이 없는 경우 테이블 만들기
CREATE TABLE IF NOT EXISTS enjoytrip.user(
    userId VARCHAR(20) NOT NULL,
    userPwd VARCHAR(100) NOT NULL,
    userName VARCHAR(20) NOT NULL,
    userEmail VARCHAR(50) NOT NULL,
    userGender VARCHAR(50) NOT NULL,
    userToken varchar(200),
    userState INT NOT NULL,
    userDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (userId)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- enjoytrip.user 테이블에 더미 값 집어넣기
INSERT INTO enjoytrip.user (userId, userPwd, userName, userEmail, userGender, userState)
VALUES ('admin', '1234', '유승민', 'admin@ssafy.com', 'female', 0),
        ('ssafy', '1234', '유승민', 'ssafy@ssafy.com', 'male', 1),
        ('none', '1234', '유승민', 'none@ssafy.com', 'male', 2);

-- enjoytrip.user 테이블 값 확인
SELECT * FROM user;


-- ----------------------------------------
-- board table 만들기
-- ----------------------------------------
-- enjoytrip.board 가 있는 경우 테이블 삭제
DROP TABLE IF EXISTS enjoytrip.board;

-- enjoytrip.board 가 없는 경우 테이블 만들기
CREATE TABLE IF NOT EXISTS enjoytrip.board(
    boardNo INT NOT NULL AUTO_INCREMENT,
    boardTitle VARCHAR(100) NOT NULL,
    boardContent VARCHAR(2000) NOT NULL,
    boardHit INT NOT NULL DEFAULT 0,
    boardDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    boardId VARCHAR(20) NOT NULL,
    PRIMARY KEY(boardNo),
    FOREIGN KEY(boardId) REFERENCES enjoytrip.user(userId) ON DELETE CASCADE
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- UNLOCK TABLES;

select * from attraction_info;

-- enjoytrip.board 테이블에 더미 값 집어넣기
INSERT INTO enjoytrip.board (boardTitle, boardContent, boardId)
VALUES ('중요한것은 꺾이지 않는 마음', '제곧내', 'admin'),
        ('임포트 이즈 언브레이커블 마인드', '제곧내', 'ssafy');

-- enjoytrip.board 테이블의 foreign key 연결 확인
/*
UPDATE board
set boardId = 'asdf'
where boardId = 'admin';
*/

-- enjoytrip.board 테이블 값 확인
SELECT * FROM board;


-- ----------------------------------------
-- plan table 만들기
-- ----------------------------------------
-- enjoytrip.plan 가 있는 경우 테이블 삭제
DROP TABLE IF EXISTS enjoytrip.plan;

-- enjoytrip.plan 가 없는 경우 테이블 만들기
CREATE TABLE IF NOT EXISTS enjoytrip.plan(
    planNo INT NOT NULL AUTO_INCREMENT,
    planTitle VARCHAR(100) NOT NULL,
    planStartTitle VARCHAR(100) NOT NULL,
    planStartLat INT NOT NULL,
    planStartLng INT NOT NULL,
    planStart INT NOT NULL,
    planEndTitle VARCHAR(100) NOT NULL,
    planEndLat INT NOT NULL,
    planEndLng INT NOT NULL,
    planEnd INT NOT NULL,
    planImg VARCHAR(1000) NOT NULL,
    planId VARCHAR(20) NOT NULL,
    PRIMARY KEY(planNo),
    FOREIGN KEY(planId) REFERENCES enjoytrip.user(userId) ON DELETE CASCADE
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- enjoytrip.plan 테이블에 더미 값 집어넣기
-- INSERT INTO enjoytrip.plan (planTitle, planImg, planStart, planEnd, planId)
-- VALUES ('중요한것은 꺾이지 않는 마음', '', 1, 2, 'admin'),
--         ('임포트 이즈 언브레이커블 마인드', '', 1, 2, 'ssafy');

-- enjoytrip.board 테이블의 foreign key 연결 확인
/*
UPDATE board
set planId = 'asdf'
where planId = 'admin';
*/

-- enjoytrip.plan 테이블 값 확인
SELECT * FROM plan;



-- 테이블 삭제 끝! foreign key set = 1 되돌리기
SET foreign_key_checks = 1;



