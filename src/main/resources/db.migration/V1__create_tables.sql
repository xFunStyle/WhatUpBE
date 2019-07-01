create table users (
  id varchar(255) primary key,
  name varchar(255) UNIQUE,
  password varchar(255),
  email varchar(255) UNIQUE
);

create table messageQueue (
  receiverId varchar(255),
  senderId varchar(255),
  id varchar(1023) UNIQUE PRIMARY KEY,
  text varchar(511)
);

create table userAuth (
  userId varchar(255),
  authKey varchar(512)
);

create table messageBlocks (
  blockId varchar(255),
  messageId varchar(255)
);