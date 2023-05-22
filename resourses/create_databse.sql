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
-- follower table 만들기
-- ----------------------------------------
-- enjoytrip.follow 가 있는 경우 테이블 삭제
DROP TABLE IF EXISTS enjoytrip.follow;

-- enjoytrip.follow 가 없는 경우 테이블 만들기
CREATE TABLE IF NOT EXISTS enjoytrip.follow(
    follower VARCHAR(20) NOT NULL,
    following VARCHAR(20) NOT NULL,
    PRIMARY KEY (follower, following),
    FOREIGN KEY (follower) REFERENCES enjoytrip.user(userId) ON DELETE CASCADE,
    FOREIGN KEY (following) REFERENCES enjoytrip.user(userId) ON DELETE CASCADE
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- enjoytrip.follow 테이블에 더미 값 집어넣기
INSERT INTO enjoytrip.follow (follower, following)
VALUES ('admin', 'ssafy'),
        ('ssafy', 'admin');

-- enjoytrip.follow 테이블의 PRIMARY KEY 설정 테스트
/*
INSERT INTO enjoytrip.follow (follower, following)
VALUES ('admin', 'ssafy');
*/

-- enjoytrip.follow 테이블의 FOREIGN KEY 연결 테스트
/*
UPDATE follow
SET following = 'asdf'
WHERE follower = 'admin';
*/

-- enjoytrip.follow 테이블 값 확인
SELECT * FROM follow;


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
    FOREIGN KEY(boardId) REFERENCES enjoytrip.user(userId)
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

-- 테이블 삭제 끝! foreign key set = 1 되돌리기
SET foreign_key_checks = 1;





-- ----------------------------------------
-- notice table 만들기
-- ----------------------------------------
-- enjoytrip.notice 이 있는 경우 테이블 삭제
DROP TABLE IF EXISTS enjoytrip.notice;

-- enjoytrip.notice 이 없는 경우 테이블 만들기
CREATE TABLE IF NOT EXISTS enjoytrip.notice(
    noticeNo int auto_increment not null,
    noticeTitle VARCHAR(100) NOT NULL,
    noticeContent VARCHAR(1000) NOT NULL,
    noticeId VARCHAR(50) NOT NULL,
    noticeHit INT NOT NULL DEFAULT 0,
    noticeDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (noticeNo),
	FOREIGN KEY(noticeId) REFERENCES enjoytrip.user(userId)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- enjoytrip.notice 테이블에 더미 값 집어넣기
INSERT INTO enjoytrip.notice (noticeTitle, noticeContent, noticeId)
VALUES ('첫 글', '첫 글 내용', 'ssafy');

-- enjoytrip.notice 테이블 값 확인
SELECT * FROM notice;

update notice set noticeContent = '수정된 글2', noticeTitle = '수정2' where noticeNo = 1;

-- ----------------------------------------
-- review table 만들기
-- ----------------------------------------
-- enjoytrip.review 이 있는 경우 테이블 삭제
DROP TABLE IF EXISTS enjoytrip.review;

-- enjoytrip.review 이 없는 경우 테이블 만들기
CREATE TABLE IF NOT EXISTS enjoytrip.review(
    reviewNo INT AUTO_INCREMENT NOT NULL,
    reviewTitle VARCHAR(100) NOT NULL,
    reviewContent VARCHAR(1000) NOT NULL,
    reviewId VARCHAR(50) NOT NULL,
    reviewHit INT NOT NULL DEFAULT 0,
    reviewDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    attractionId INT NOT NULL,
    reviewGrade INT DEFAULT 0,
    PRIMARY KEY (reviewNo),
	FOREIGN KEY(reviewId) REFERENCES enjoytrip.user(userId) ON DELETE CASCADE,
    FOREIGN KEY(attractionId) REFERENCES enjoytrip.attraction_info(content_id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- enjoytrip.notice 테이블에 더미 값 집어넣기
INSERT INTO enjoytrip.review (reviewTitle, reviewContent, reviewId, reviewHit, reviewDate, attractionId)
VALUES ('공지1', '공지내용', 'admin', 1, now(), 125266);

-- enjoytrip.notice 테이블 값 확인
SELECT * FROM review;




-- ------------------------------
-- 실제 프로젝트에서 사용할 쿼리문.
-- ------------------------------
-- 사용자 등록 쿼리
INSERT INTO user (userId, userPwd, userEmail, userGender, userState) VALUES ('test', 'test', 'test@gmail.com', 'male', 1);

-- 로그인 시 일치 비교 쿼리 ( 임의의 사용자 id = test )
SELECT * FROM user WHERE userId='test';

-- 공지사항 호출 쿼리
SELECT userId, boardNo, boardTitle, boardContent, boardHit, boardDate FROM board b JOIN user u ON b.boardId = u.userId WHERE u.userId = 'admin';

-- 공지사항 등록 쿼리
INSERT INTO notice ( noticeTitle, noticeContent, noticeId) VALUES ('공지입니다.', '공지 내용.', 'admin');

-- 게시판 호출 쿼리
SELECT userId, boardNo, boardTitle, boardContent, boardHit, boardDate FROM board b JOIN user u ON b.boardId = u.userId WHERE u.userId != 'admin';

-- 게시판 등록 쿼리
INSERT INTO board (boardTitle, boardContent, boardId) VALUES ( '게시판1', '게시판 1 내용', 'ssafy');

-- 관광지 정보 호출 쿼리 ( 임의의 관광지 아이디 125266 호출 )
SELECT content_id, content_type_id, title, addr1, first_image, tel, sido_code, gugun_code, latitude, longitude FROM attraction_info WHERE content_id=125266;

-- 리뷰 호출 쿼리. 관광지 정보와 유저 정보 호출.
SELECT reviewNo, reviewTitle, reviewContent, reviewHit, reviewDate, attractionId, reviewGrade, content_id, title, addr1, first_image,
	sido_code, gugun_code, latitude, longitude FROM review r JOIN attraction_info a ON r.attractionId=a.content_id;
    
-- 리뷰 등록 쿼리
INSERT INTO review (reviewTitle, reviewContent, attractionId, reviewId) VALUES ('1지역 방문 후기', '좋네요.', 125266, 'ssafy');

-- Hot Place 산출 쿼리
SELECT reviewNo, reviewTitle, reviewContent, reviewHit, reviewDate, attractionId, reviewGrade, content_id, title, addr1, first_image,
	sido_code, gugun_code, latitude, longitude FROM review r JOIN attraction_info a ON r.attractionId=a.content_id
    WHERE reviewGrade > 4 AND reviewHit>100;
    
-- 팔로워 호출 쿼리 ( 임의의 사용자 id = ssafy. 팔로잉하는 사용자의 정보도 가져옴. )
SELECT * FROM follow f JOIN user u ON f.following = u.userId WHERE follower='ssafy';

