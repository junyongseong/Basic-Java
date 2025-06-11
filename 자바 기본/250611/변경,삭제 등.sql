   create table membert(
	m_idx bigint(6) auto_increment,
    m_name varchar(4) NOT NULL,
    m_email varchar(35),
    m_phone int(11),
    constraint member_t primary key(m_idx)
);

SELECT * FROM my_db.membert;

INSERT INTO membert(m_name, m_email, m_phone)
	VALUES('마루치','maru@korea.com',01012345678);
    
INSERT INTO membert(m_name, m_email, m_phone)
	VALUES('아라치','maru@kores.com','010-1244-5678');
   commit; 
INSERT INTO membert(m_name)
	VALUES('이도');

-- 회원등록 날짜를 저장하는 컬럼을 추가하려면...
	ALTER TABLE membert
	ADD write_date DATE null;

-- membert에서 write_date라는 컬럼을 reg_date로 변경하시오
	ALTER TABLE membert
	RENAME COLUMN write_date to reg_date;
    
UPDATE membert
	SET m_email = 'ara@korea.com'
    WHERE m_idx =2;
    
    UPDATE membert
	SET m_phone = '010-1111-2222'
    WHERE m_idx =2;
    
    UPDATE membert
	SET m_name = '을불'
    WHERE m_idx =3;
    
    -- Ex) membert 테이블에서 m_idx값이 2번인 자원을 삭제하자!
	
	DELETE FROM membert
	WHERE m_idx=2;