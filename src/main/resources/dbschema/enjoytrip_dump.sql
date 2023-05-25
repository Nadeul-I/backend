INSERT INTO enjoytrip.user (userId, userPwd, userName, userEmail, userGender, userState)
VALUES 	('ssafy0', '1234', '유승민', 'ssafy@ssafy.com', 'male', 1),
		('ssafy1', '1234', '유승민', 'ssafy@ssafy.com', 'male', 1),
		('ssafy2', '1234', '유승민', 'ssafy@ssafy.com', 'male', 1),
		('ssafy3', '1234', '유승민', 'ssafy@ssafy.com', 'male', 1),
		('ssafy4', '1234', '유승민', 'ssafy@ssafy.com', 'male', 1),
		('ssafy5', '1234', '유승민', 'ssafy@ssafy.com', 'male', 1),
		('ssafy6', '1234', '유승민', 'ssafy@ssafy	.com', 'male', 1),
		('ssafy7', '1234', '유승민', 'ssafy@ssafy.com', 'male', 1);
        
        
-- enjoytrip.board 테이블에 더미 값 집어넣기
INSERT INTO enjoytrip.board (boardTitle, boardContent, boardId)
VALUES ('중요한것은 꺾이지 않는 마음', '제곧내', 'admin'),
        ('임포트 이즈 언브레이커블 마인드', '제곧내', 'ssafy'),
        ('중요한것은 꺾이지 않는 마음', '제곧내', 'admin'),
        ('임포트 이즈 언브레이커블 마인드', '제곧내', 'ssafy'),
        ('중요한것은 꺾이지 않는 마음', '제곧내', 'admin'),
        ('임포트 이즈 언브레이커블 마인드', '제곧내', 'ssafy'),
        ('중요한것은 꺾이지 않는 마음', '제곧내', 'admin'),
        ('임포트 이즈 언브레이커블 마인드', '제곧내', 'ssafy'),
        ('중요한것은 꺾이지 않는 마음', '제곧내', 'admin'),
        ('임포트 이즈 언브레이커블 마인드', '제곧내', 'ssafy'),
        ('중요한것은 꺾이지 않는 마음', '제곧내', 'admin'),
        ('임포트 이즈 언브레이커블 마인드', '제곧내', 'ssafy'),
        ('중요한것은 꺾이지 않는 마음', '제곧내', 'admin'),
        ('임포트 이즈 언브레이커블 마인드', '제곧내', 'ssafy'),
        ('중요한것은 꺾이지 않는 마음', '제곧내', 'admin'),
        ('임포트 이즈 언브레이커블 마인드', '제곧내', 'ssafy'),
        ('중요한것은 꺾이지 않는 마음', '제곧내', 'admin'),
        ('임포트 이즈 언브레이커블 마인드', '제곧내', 'ssafy'),
        ('중요한것은 꺾이지 않는 마음', '제곧내', 'admin'),
        ('임포트 이즈 언브레이커블 마인드', '제곧내', 'ssafy'),
        ('중요한것은 꺾이지 않는 마음', '제곧내', 'admin');
-- ---------------------------        

-- enjoytrip.plan 테이블에 더미 값 집어넣기
INSERT INTO enjoytrip.plan (planTitle, planStartTitle, planStartLat, planStartLng, planStart, planEndTitle, planEndLat, planEndLng, planEnd, planImg, planId)
VALUES ('TITLE', 'StartTitle', 0, 0, 1, 'EndTitle', 0, 0, 2, 'http://tong.visitkorea.or.kr/cms/resource/62/219162_image3_1.jpg', 'ssafy'),
		('TITLE', 'StartTitle', 0, 0, 1, 'EndTitle', 0, 0, 2, 'http://tong.visitkorea.or.kr/cms/resource/48/2533748_image2_1.jpg', 'admin'),
        ('TITLE', 'StartTitle', 0, 0, 1, 'EndTitle', 0, 0, 2, 'http://tong.visitkorea.or.kr/cms/resource/62/219162_image3_1.jpg', 'ssafy'),
		('TITLE', 'StartTitle', 0, 0, 1, 'EndTitle', 0, 0, 2, 'http://tong.visitkorea.or.kr/cms/resource/48/2533748_image2_1.jpg', 'admin'),
        ('TITLE', 'StartTitle', 0, 0, 1, 'EndTitle', 0, 0, 2, 'http://tong.visitkorea.or.kr/cms/resource/62/219162_image3_1.jpg', 'ssafy'),
		('TITLE', 'StartTitle', 0, 0, 1, 'EndTitle', 0, 0, 2, 'http://tong.visitkorea.or.kr/cms/resource/48/2533748_image2_1.jpg', 'admin'),
        ('TITLE', 'StartTitle', 0, 0, 1, 'EndTitle', 0, 0, 2, 'http://tong.visitkorea.or.kr/cms/resource/62/219162_image3_1.jpg', 'ssafy'),
		('TITLE', 'StartTitle', 0, 0, 1, 'EndTitle', 0, 0, 2, 'http://tong.visitkorea.or.kr/cms/resource/48/2533748_image2_1.jpg', 'admin'),
        ('TITLE', 'StartTitle', 0, 0, 1, 'EndTitle', 0, 0, 2, 'http://tong.visitkorea.or.kr/cms/resource/62/219162_image3_1.jpg', 'ssafy'),
		('TITLE', 'StartTitle', 0, 0, 1, 'EndTitle', 0, 0, 2, 'http://tong.visitkorea.or.kr/cms/resource/48/2533748_image2_1.jpg', 'admin'),
        ('TITLE', 'StartTitle', 0, 0, 1, 'EndTitle', 0, 0, 2, 'http://tong.visitkorea.or.kr/cms/resource/62/219162_image3_1.jpg', 'ssafy'),
		('TITLE', 'StartTitle', 0, 0, 1, 'EndTitle', 0, 0, 2, 'http://tong.visitkorea.or.kr/cms/resource/48/2533748_image2_1.jpg', 'admin');
-- ---------------------------        
        
select * from user;

select * from board;

select * from plan;

select * from attraction_info;

