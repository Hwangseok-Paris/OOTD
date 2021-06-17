--------------------------------------------------------
--  파일이 생성됨 - 목요일-6월-17-2021   
--------------------------------------------------------
DROP SEQUENCE "OOTD"."SEQ_ATT_NO";
DROP SEQUENCE "OOTD"."SEQ_CART_NO";
DROP SEQUENCE "OOTD"."SEQ_MEMBER_NO";
DROP SEQUENCE "OOTD"."SEQ_ORDER_NO";
DROP SEQUENCE "OOTD"."SEQ_PRODUCT_NO";
DROP SEQUENCE "OOTD"."SEQ_REVIEW_NO";
--------------------------------------------------------
--  DDL for Sequence SEQ_ATT_NO
--------------------------------------------------------

   CREATE SEQUENCE  "OOTD"."SEQ_ATT_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_CART_NO
--------------------------------------------------------

   CREATE SEQUENCE  "OOTD"."SEQ_CART_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 141 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_MEMBER_NO
--------------------------------------------------------

   CREATE SEQUENCE  "OOTD"."SEQ_MEMBER_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_ORDER_NO
--------------------------------------------------------

   CREATE SEQUENCE  "OOTD"."SEQ_ORDER_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 367 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_PRODUCT_NO
--------------------------------------------------------

   CREATE SEQUENCE  "OOTD"."SEQ_PRODUCT_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_REVIEW_NO
--------------------------------------------------------

   CREATE SEQUENCE  "OOTD"."SEQ_REVIEW_NO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
