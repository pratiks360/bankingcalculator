DROP TABLE IF EXISTS FIELD_MASTER;
  
CREATE TABLE FIELD_MASTER (
  field_id INT   PRIMARY KEY,
  product_id INT NOT NULL,
  field_name VARCHAR(250) NOT NULL,
  minval VARCHAR(250) NOT NULL,
  maxval VARCHAR(250) NOT NULL 
  
  
);