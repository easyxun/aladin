USE aladin;
-- 회원 등급 테이블
CREATE TABLE p_grade (
                         grade_id BIGINT PRIMARY KEY,
                         grade_name VARCHAR(20) NOT NULL,

                         is_deleted BOOLEAN DEFAULT FALSE,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         created_by VARCHAR(100),
                         updated_at TIMESTAMP,
                         updated_by VARCHAR(100),
                         deleted_at TIMESTAMP,
                         deleted_by VARCHAR(100)
);

-- 회원 구분 테이블
CREATE TABLE p_division (
                            division_id BIGINT PRIMARY KEY,
                            division_name VARCHAR(20) NOT NULL,

                            is_deleted BOOLEAN DEFAULT FALSE,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            created_by VARCHAR(100),
                            updated_at TIMESTAMP,
                            updated_by VARCHAR(100),
                            deleted_at TIMESTAMP,
                            deleted_by VARCHAR(100)
);

-- 회원 테이블
CREATE TABLE p_member (
                          member_id BIGINT PRIMARY KEY,
                          login_id VARCHAR(10) NOT NULL UNIQUE,
                          pwd VARCHAR(255) NOT NULL,
                          name VARCHAR(20) NOT NULL,
                          gender VARCHAR(1) NOT NULL CHECK (gender IN ('M', 'F')),
                          birth DATE NOT NULL,
                          email VARCHAR(50) NOT NULL UNIQUE,
                          address VARCHAR(50) NOT NULL,
                          grade_id BIGINT NOT NULL,
                          division_id BIGINT NOT NULL,
                          FOREIGN KEY (grade_id) REFERENCES p_grade(grade_id),
                          FOREIGN KEY (division_id) REFERENCES p_division(division_id),

                          is_deleted BOOLEAN DEFAULT FALSE,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          created_by VARCHAR(100),
                          updated_at TIMESTAMP,
                          updated_by VARCHAR(100),
                          deleted_at TIMESTAMP,
                          deleted_by VARCHAR(100)
);

-- 카테고리 테이블
CREATE TABLE p_categories (
                              category_id BIGINT PRIMARY KEY,
                              category_name VARCHAR(50) NOT NULL,
                              category_depth TINYINT NOT NULL CHECK (category_depth IN (0,1,2)),
                              parent_id BIGINT DEFAULT NULL,
                              FOREIGN KEY (parent_id) REFERENCES p_categories(category_id),

                              is_deleted BOOLEAN DEFAULT FALSE,
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              created_by VARCHAR(100),
                              updated_at TIMESTAMP,
                              updated_by VARCHAR(100),
                              deleted_at TIMESTAMP,
                              deleted_by VARCHAR(100)
);

-- 도서 테이블
CREATE TABLE p_book (
                        book_id BIGINT PRIMARY KEY,
                        book_title VARCHAR(50) NOT NULL,
                        book_author VARCHAR(50) NOT NULL,
                        book_publisher VARCHAR(50) NOT NULL,
                        book_desc TEXT NOT NULL,
                        book_price DECIMAL(10,2) NOT NULL,
                        book_thumbnail VARCHAR(255),
                        category_id BIGINT NOT NULL,
                        FOREIGN KEY (category_id) REFERENCES p_categories(category_id),

                        is_deleted BOOLEAN DEFAULT FALSE,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        created_by VARCHAR(100),
                        updated_at TIMESTAMP,
                        updated_by VARCHAR(100),
                        deleted_at TIMESTAMP,
                        deleted_by VARCHAR(100)
);

-- 주문 테이블
CREATE TABLE p_order (
                         order_id BIGINT PRIMARY KEY,
                         order_status VARCHAR(20) NOT NULL,
                         member_id BIGINT NOT NULL,
                         FOREIGN KEY (member_id) REFERENCES p_member(member_id),

                         is_deleted BOOLEAN DEFAULT FALSE,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         created_by VARCHAR(100),
                         updated_at TIMESTAMP,
                         updated_by VARCHAR(100),
                         deleted_at TIMESTAMP,
                         deleted_by VARCHAR(100)
);

-- 주문 상품 테이블
CREATE TABLE p_order_item (
                              order_item_id BIGINT PRIMARY KEY,
                              order_quantity BIGINT NOT NULL,
                              order_price BIGINT NOT NULL,
                              order_id BIGINT NOT NULL,
                              book_id BIGINT NOT NULL,
                              FOREIGN KEY (order_id) REFERENCES p_order(order_id),
                              FOREIGN KEY (book_id) REFERENCES p_book(book_id),

                              is_deleted BOOLEAN DEFAULT FALSE,
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              created_by VARCHAR(100),
                              updated_at TIMESTAMP,
                              updated_by VARCHAR(100),
                              deleted_at TIMESTAMP,
                              deleted_by VARCHAR(100)
);

-- 결제 테이블
CREATE TABLE p_payments (
                            payment_id BIGINT PRIMARY KEY,
                            payment_amount DECIMAL(10,2) NOT NULL,
                            payment_method VARCHAR(20) NOT NULL,
                            payment_status VARCHAR(20) NOT NULL,
                            payment_key VARCHAR(100) NOT NULL,
                            member_id BIGINT NOT NULL,
                            order_id BIGINT NOT NULL,
                            FOREIGN KEY (member_id) REFERENCES p_member(member_id),
                            FOREIGN KEY (order_id) REFERENCES p_order(order_id),

                            is_deleted BOOLEAN DEFAULT FALSE,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            created_by VARCHAR(100),
                            updated_at TIMESTAMP,
                            updated_by VARCHAR(100),
                            deleted_at TIMESTAMP,
                            deleted_by VARCHAR(100)
);

-- 태그 테이블
CREATE TABLE p_tags (
                        tag_id BIGINT PRIMARY KEY,
                        tag_name VARCHAR(50) NOT NULL,

                        is_deleted BOOLEAN DEFAULT FALSE,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        created_by VARCHAR(100),
                        updated_at TIMESTAMP,
                        updated_by VARCHAR(100),
                        deleted_at TIMESTAMP,
                        deleted_by VARCHAR(100)
);

-- 도서-태그 테이블
CREATE TABLE p_book_tags (
                             tag_id BIGINT NOT NULL,
                             book_id BIGINT NOT NULL,
                             PRIMARY KEY (tag_id, book_id),
                             FOREIGN KEY (tag_id) REFERENCES p_tags(tag_id),
                             FOREIGN KEY (book_id) REFERENCES p_book(book_id),

                             is_deleted BOOLEAN DEFAULT FALSE,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             created_by VARCHAR(100),
                             updated_at TIMESTAMP,
                             updated_by VARCHAR(100),
                             deleted_at TIMESTAMP,
                             deleted_by VARCHAR(100)
);
