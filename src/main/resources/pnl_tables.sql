create table current_position (
  portfolio varchar2(30) not null,
  ticker    varchar2(20) not null,
  exch      varchar2(20) not null,
  pos       number(30,0),
  CONSTRAINT PK_current_position primary key(portfolio,ticker)
);

create table stock_price(
  ticker    varchar2(20) not null,
  pre_close number(9,2) not null, 
  tod_close number(9,2) not null, 
  trade_date date,
  primary key(ticker)
);


---populate the table---

--US region
insert into current_position(portfolio,ticker,exch,pos) values('US','IBM','ndaq',200);
insert into current_position (portfolio,ticker,exch,pos) values('US','MSFT','ndaq',300);

insert into current_position (portfolio,ticker,exch,pos) values('US','AAPL','ndaq', 100);

insert into stock_price (ticker,pre_close,tod_close) values('IBM',22.3,24);
insert into stock_price (ticker,pre_close,tod_close) values('AAPL',430.0, 431.2);

insert into stock_price (ticker,pre_close,tod_close) values('MSFT',30,31);


insert into current_position(portfolio,ticker,exch,pos) values('EU','NKE','ndaq',400);
insert into current_position (portfolio,ticker,exch,pos) values('EU','MSFT','ndaq',300);

insert into stock_price (ticker,pre_close,tod_close) values('NKE',32.3,34);

commit;