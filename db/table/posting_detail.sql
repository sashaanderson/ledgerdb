CREATE TABLE posting_detail (
  posting_detail_id SERIAL,
  posting_header_id INTEGER       NOT NULL,
  account_id        INTEGER       NOT NULL,
  amount            DECIMAL(12,2) NOT NULL, -- debit positive, credit negative
  statement_id      INTEGER,

  CONSTRAINT posting_detail_pk PRIMARY KEY (posting_detail_id),
  CONSTRAINT posting_detail_fk_ph FOREIGN KEY (posting_header_id)
    REFERENCES posting_header(posting_header_id),
  CONSTRAINT posting_detail_fk_a FOREIGN KEY (account_id)
    REFERENCES account(account_id),
  CONSTRAINT posting_detail_fk_s FOREIGN KEY (statement_id)
    REFERENCES statement(statement_id),
  CONSTRAINT posting_detail_ck_a CHECK (amount <> 0)
);

ALTER TABLE posting_detail OWNER TO ledgerdb;
